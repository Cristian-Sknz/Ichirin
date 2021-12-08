package me.skiincraft.ichirin.configuration.setup;

import lombok.SneakyThrows;
import me.skiincraft.ichirin.entity.IchirinImage;
import me.skiincraft.ichirin.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.io.IOException;
import java.io.InputStream;

@Component
public class SetupUserAvatar implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private ImageRepository imageRepository;

    @SneakyThrows
    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (imageRepository.findByName("default_avatar").isPresent()) {
            return;
        }
        var image = new IchirinImage("default_avatar");
        var resource = getResourceStream("/assets/default_avatar.png");

        image.setData(resource.readAllBytes());
        image.setSize(777L);
        image.setContentType("image/png");

        imageRepository.save(image);
    }


    public InputStream getResourceStream(String name) throws IOException {
        try {
            return new ClassPathResource(name).getInputStream();
        } catch (IOException io) {
            InputStream resource = getClass().getResourceAsStream(name);
            if (resource == null) {
                throw io;
            }
            return resource;
        }
    }

}
