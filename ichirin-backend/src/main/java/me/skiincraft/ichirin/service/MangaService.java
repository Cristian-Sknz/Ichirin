package me.skiincraft.ichirin.service;

import me.skiincraft.ichirin.data.MangaDTO;
import me.skiincraft.ichirin.models.manga.Manga;
import me.skiincraft.ichirin.repository.MangaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MangaService {

    private final MangaRepository repository;

    @Autowired
    public MangaService(MangaRepository repository) {
        this.repository = repository;
    }

    public Page<Manga> getMangas(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Manga createManga(MangaDTO dto) {
        return repository.save(new Manga(dto));
    }

}
