package me.skiincraft.ichirin.service;

import me.skiincraft.ichirin.entity.user.IchirinUser;
import me.skiincraft.ichirin.exception.IchirinNotFoundException;
import me.skiincraft.ichirin.models.data.DataType;
import me.skiincraft.ichirin.models.data.manga.MangaShort;
import me.skiincraft.ichirin.models.data.user.UserData;
import me.skiincraft.ichirin.models.data.user.UserShort;
import me.skiincraft.ichirin.models.dto.IchirinUserDTO;
import me.skiincraft.ichirin.repository.user.IchirinUserRepository;
import me.skiincraft.ichirin.repository.user.UserFavoriteRepository;
import me.skiincraft.ichirin.repository.user.UserHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private MessageSource source;

    private final IchirinUserRepository repository;
    private final UserFavoriteRepository favoriteRepository;
    private final UserHistoryRepository historyRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    private final RoleService roleService;

    @Autowired
    public UserService(IchirinUserRepository repository,
                       UserFavoriteRepository favoriteRepository,
                       UserHistoryRepository historyRepository,
                       BCryptPasswordEncoder passwordEncoder,
                       RoleService roleService) {
        this.repository = repository;
        this.favoriteRepository = favoriteRepository;
        this.historyRepository = historyRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleService = roleService;
    }

    @Transactional
    public UserData createUser(IchirinUserDTO dto) {
        var user = new IchirinUser(dto);
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setRoles(Set.of(roleService.getRole("ROLE_USER")));

        return UserData.of(repository.save(user));
    }

    public void removeUser(long userId) {
        repository.delete(getUser(userId));
    }

    public IchirinUser getUser(long userId) {
        return repository.findById(userId)
                .orElseThrow(() -> new IchirinNotFoundException("exception.user.not-found", source));
    }

    public UserShort getUser(DataType type, long userId) {
        return getFunctionByType(type).apply(getUser(userId));
    }

    public Page<UserShort> getAllUsers(DataType type, Pageable pageable) {
        return repository.findAll(pageable).map(getFunctionByType(type));
    }

    public Function<IchirinUser, ? extends UserShort> getFunctionByType(DataType type) {
        return getFunctionByType(type, UserShort::of, getLimitedOrFullFunction(true),
                getLimitedOrFullFunction(false));
    }

    public Function<IchirinUser, ? extends UserShort> getFunctionByType(DataType type,
                                                                        Function<IchirinUser, UserShort> ifShort,
                                                                        Function<IchirinUser, UserShort> ifLimited,
                                                                        Function<IchirinUser, UserShort> ifFull) {
        return type == DataType.FULL ? ifFull : type == DataType.SHORT ? ifShort : ifLimited;
    }

    public Function<IchirinUser, UserShort> getLimitedOrFullFunction(boolean isLimited) {
        return ((user) -> {
            var favorites = favoriteRepository.findByUser(user)
                    .getMangas()
                    .stream()
                    .map(MangaShort::of);

            var history = historyRepository.findByUser(user)
                    .getMangas()
                    .stream()
                    .map(MangaShort::of);

            if (isLimited) {
                return UserData.of(user, favorites.limit(10).collect(Collectors.toList()),
                        history.limit(10).collect(Collectors.toList()));
            }
            return UserData.of(user, favorites.collect(Collectors.toList()),
                    history.collect(Collectors.toList()));
        });
    }
}
