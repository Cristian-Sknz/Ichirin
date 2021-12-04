package me.skiincraft.ichirin.repository;

import me.skiincraft.ichirin.entity.IchirinImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ImageRepository extends JpaRepository<IchirinImage, Long> {

    Optional<IchirinImage> findByName(String name);
}