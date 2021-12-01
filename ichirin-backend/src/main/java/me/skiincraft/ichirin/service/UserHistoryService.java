package me.skiincraft.ichirin.service;

import me.skiincraft.ichirin.entity.manga.Manga;
import me.skiincraft.ichirin.models.data.user.UserHistoryData;
import me.skiincraft.ichirin.repository.user.UserHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
public class UserHistoryService {

    private final UserService userService;
    private final MangaService mangaService;
    private final UserHistoryRepository repository;

    @Autowired
    private MessageSource source;

    @Autowired
    public UserHistoryService(UserService userService,
                              MangaService mangaService,
                              UserHistoryRepository repository) {
        this.userService = userService;
        this.mangaService = mangaService;
        this.repository = repository;
    }

    public Page<UserHistoryData> getAllUserHistory(Pageable pageable) {
        return this.repository.findAll(pageable)
                .map(history -> UserHistoryData.of(history.getUser(), new ArrayList<>(history.getMangas()), Pageable.unpaged()));
    }

    public UserHistoryData getUserHistory(long userId, Pageable pageable) {
        var user = userService.getUser(userId);
        var history = repository.findByUser(user);

        return UserHistoryData.of(user, new ArrayList<>(history.getMangas()), pageable);
    }

    public UserHistoryData addManga(long userId, long mangaId) {
        var user = userService.getUser(userId);
        var history = repository.findByUser(user);
        var manga = mangaService.getManga(mangaId);

        history.addManga(manga);
        repository.save(history);
        return UserHistoryData.of(user, new ArrayList<>(history.getMangas()), Pageable.unpaged());
    }

    public UserHistoryData removeManga(long userId, long mangaId) {
        var user = userService.getUser(userId);
        var history = repository.findByUser(user);
        var manga = mangaService.getManga(mangaId);

        history.removeManga(manga);
        repository.save(history);
        return UserHistoryData.of(user, new ArrayList<>(history.getMangas()), Pageable.unpaged());
    }

    public void removeManga(long mangaId) {
        removeManga(mangaService.getManga(mangaId));
    }

    public void removeManga(Manga manga) {
        var userHistories = repository.findAllByManga(manga);
        repository.saveAll(userHistories.stream()
                .peek((item) -> item.removeManga(manga))
                .collect(Collectors.toList()));
    }
}
