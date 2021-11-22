package me.skiincraft.ichirin.service;

import me.skiincraft.ichirin.data.UserCommentaryDTO;
import me.skiincraft.ichirin.exception.IchirinNotFoundException;
import me.skiincraft.ichirin.models.manga.Manga;
import me.skiincraft.ichirin.models.manga.MangaComments;
import me.skiincraft.ichirin.models.user.IchirinUser;
import me.skiincraft.ichirin.models.user.UserCommentary;
import me.skiincraft.ichirin.repository.manga.MangaCommentsRepository;
import me.skiincraft.ichirin.repository.user.UserCommentaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;

@Service
public class CommentaryService {

    @Autowired
    private MessageSource source;
    private final UserService userService;
    private final MangaService mangaService;
    private final UserCommentaryRepository userCommentaryRepository;
    private final MangaCommentsRepository mangaCommentsRepository;

    @Autowired
    public CommentaryService(UserService userService,
                             MangaService mangaService,
                             UserCommentaryRepository userCommentaryRepository,
                             MangaCommentsRepository mangaCommentsRepository) {
        this.userService = userService;
        this.mangaService = mangaService;
        this.userCommentaryRepository = userCommentaryRepository;
        this.mangaCommentsRepository = mangaCommentsRepository;
    }

    public MangaComments getMangaComments(long mangaId) {
        return mangaCommentsRepository.findByMangaAndFetch(mangaService.getManga(mangaId));
    }

    public UserCommentary getMangaComment(long mangaId, long commentId) {
        return getMangaComments(mangaId).getUserCommentaries()
                .stream()
                .filter(comment -> comment.getId() == commentId).findFirst()
                .orElseThrow(() -> new IchirinNotFoundException("exception.comments.not-found", source));
    }

    public Collection<UserCommentary> getUserComments(long userId) {
        IchirinUser user = userService.getUser(userId);
        return userCommentaryRepository.findAllByUser(user);
    }

    public Collection<UserCommentary> getUserComments(long userId, long mangaId) {
        IchirinUser user = userService.getUser(userId);
        Manga manga = mangaService.getManga(mangaId);
        return userCommentaryRepository.findAllByUser(user)
                .stream()
                .filter(commentary -> commentary.getManga().getId().equals(manga.getId()))
                .collect(Collectors.toList());
    }

    public UserCommentary getUserCommentary(long userId, long mangaId, long commentId) {
        return getUserComments(userId, mangaId).stream()
                .filter((comment) -> comment.getManga().getId() == mangaId && comment.getId() == commentId)
                .findFirst()
                .orElseThrow(() -> new IchirinNotFoundException("exception.comments.not-found", source));
    }

    public UserCommentary createUserCommentary(long userId, UserCommentaryDTO dto) {
        IchirinUser user = userService.getUser(userId);
        Manga manga = mangaService.getManga(dto.getMangaId());
        var comments = mangaCommentsRepository.findByMangaAndFetch(manga);
        var commentary = new UserCommentary(user, comments, dto.getContent());

        comments.getUserCommentaries().add(commentary);
        mangaCommentsRepository.save(comments);

        return comments.getUserCommentaries().stream()
                .filter((a) -> a.getUser().getId() == userId)
                .max(Comparator.comparing(UserCommentary::getCreatedDate))
                .orElseThrow(() -> new RuntimeException("Ocorreu um problema ao salvar um comentario."));
    }

    public void deleteUserCommentary(long userId, long mangaId, long commentId) {
        UserCommentary userCommentary = getUserComments(userId, mangaId).stream()
                .filter((comment) -> comment.getManga().getId() == mangaId && comment.getId() == commentId)
                .findFirst()
                .orElseThrow(() -> new IchirinNotFoundException("exception.comments.not-found", source));

        userCommentaryRepository.delete(userCommentary);
    }
}
