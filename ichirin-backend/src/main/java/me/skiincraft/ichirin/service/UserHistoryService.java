package me.skiincraft.ichirin.service;

import me.skiincraft.ichirin.models.manga.Manga;
import me.skiincraft.ichirin.models.user.UserHistory;
import me.skiincraft.ichirin.repository.UserHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserHistoryService {

    private final UserService userService;
    private final MangaService mangaService;
    private final UserHistoryRepository repository;

    @Autowired
    public UserHistoryService(UserService userService,
                              MangaService mangaService,
                              UserHistoryRepository repository) {
        this.userService = userService;
        this.mangaService = mangaService;
        this.repository = repository;
    }

    public Collection<UserHistory> getAllUserHistory() {
        return this.repository.findAll();
    }

    public UserHistory getUserHistory(long userId) {
        return repository.findById(userId).get();
    }

    public UserHistory addToUserHistory(long userId, long mangaId) {
        UserHistory history = repository.findById(userId).get();
        Manga manga = mangaService.getManga(mangaId);
        history.getMangas().add(manga);

        return repository.save(history);
    }

}
