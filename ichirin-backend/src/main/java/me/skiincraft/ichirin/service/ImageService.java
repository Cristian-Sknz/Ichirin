package me.skiincraft.ichirin.service;

import me.skiincraft.ichirin.entity.IchirinImage;
import me.skiincraft.ichirin.exception.IchirinNotFoundException;
import me.skiincraft.ichirin.repository.ImageRepository;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.function.Supplier;

@Service
public class ImageService {

    private final MessageSource source;
    private final ImageRepository imageRepository;

    public ImageService(MessageSource source, ImageRepository imageRepository) {
        this.source = source;
        this.imageRepository = imageRepository;
    }

    public IchirinImage getImage(String name) {
        return imageRepository.findByName(name)
                .orElseThrow(() -> new IchirinNotFoundException("exception.image.not-found", source));
    }

    public IchirinImage getImageOrElse(String name, Supplier<IchirinImage> image) {
        return imageRepository.findByName(name).orElse(image.get());
    }

    public IchirinImage updateImage(String name, MultipartFile file) throws IOException {
        var image = getImage(name);
        image.setData(file.getBytes());
        image.setContentType(file.getContentType());
        image.setSize(file.getSize());
        return imageRepository.save(image);
    }

    public IchirinImage saveImage(String name, MultipartFile file) throws IOException {
        return imageRepository.save(new IchirinImage(name, file));
    }
}
