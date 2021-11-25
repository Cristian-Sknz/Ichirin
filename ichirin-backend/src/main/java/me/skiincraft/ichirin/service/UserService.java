package me.skiincraft.ichirin.service;

import me.skiincraft.ichirin.data.IchirinUserDTO;
import me.skiincraft.ichirin.exception.IchirinAPIException;
import me.skiincraft.ichirin.exception.IchirinNotFoundException;
import me.skiincraft.ichirin.models.user.IchirinUser;
import me.skiincraft.ichirin.repository.user.IchirinUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private MessageSource source;

    private final IchirinUserRepository repository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserService(IchirinUserRepository repository,
                       BCryptPasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    public IchirinUser createUser(IchirinUserDTO dto) {
        try {
            dto.setPassword(passwordEncoder.encode(dto.getPassword()));
            return repository.save(new IchirinUser(dto));
        } catch (Exception e) {
            throw new IchirinAPIException("exception.user.creation", source, e);
        }
    }

    public void removeUser(long userId) {
        repository.delete(getUser(userId));
    }

    public IchirinUser getUser(long userId) {
        var optional = repository.findById(userId);
        if (optional.isEmpty()) {
            throw new IchirinNotFoundException("exception.user.not-found", source);
        }
        return optional.get();
    }

    public Page<IchirinUser> getAllUsers(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
