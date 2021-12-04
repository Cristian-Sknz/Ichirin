package me.skiincraft.ichirin.configuration;

import me.skiincraft.ichirin.entity.IchirinImage;
import me.skiincraft.ichirin.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.ClassPathResource;

import javax.transaction.Transactional;
import java.io.IOException;
import java.io.InputStream;

@Configuration
public class DatabaseInitialPersistence {

    @Autowired
    private ImageRepository imageRepository;

    @EventListener(ContextRefreshedEvent.class)
    @Transactional
    public void defaultAvatar() {
        try {
            if (imageRepository.findByName("default_avatar").isPresent()) {
                return;
            }
            var image = new IchirinImage("default_avatar");
            var resource = getResourceStream("/assets/default_avatar.png");

            image.setData(resource.readAllBytes());
            image.setSize(777L);
            image.setContentType("image/png");

            imageRepository.save(image);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
