package me.skiincraft.ichirin.configuration;

import me.skiincraft.ichirin.models.data.DataType;
import org.hibernate.validator.HibernateValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.validation.beanvalidation.SpringConstraintValidatorFactory;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

@Configuration
public class IchirinApplicationConfiguration implements WebMvcConfigurer {

    private final AutowireCapableBeanFactory autowireCapableBeanFactory;

    @Autowired
    public IchirinApplicationConfiguration(AutowireCapableBeanFactory autowireCapableBeanFactory) {
        this.autowireCapableBeanFactory = autowireCapableBeanFactory;
    }

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();

        messageSource.setBasename("classpath:i18n/messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    @Bean
    public LocalValidatorFactoryBean messageSourceLocalValidatorFactoryBean() {
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource());
        return bean;
    }

    @Bean
    public Validator validator() {
        ValidatorFactory factory = Validation.byProvider(HibernateValidator.class)
                .configure()
                .constraintValidatorFactory(new SpringConstraintValidatorFactory(autowireCapableBeanFactory))
                .buildValidatorFactory();

        return factory.getValidator();
    }

    @Bean
    public Converter<String, DataType> getDataTypeConverter() {
        return DataType::getByName;
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(getDataTypeConverter());
    }
}
