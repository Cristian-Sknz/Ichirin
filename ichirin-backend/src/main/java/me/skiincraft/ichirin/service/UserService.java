package me.skiincraft.ichirin.service;

import me.skiincraft.ichirin.data.IchirinUserDTO;
import me.skiincraft.ichirin.models.user.IchirinUser;
import me.skiincraft.ichirin.repository.user.IchirinUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final IchirinUserRepository repository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserService(IchirinUserRepository repository,
                       BCryptPasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    public IchirinUser createUser(IchirinUserDTO dto) {
        dto.setPassword(passwordEncoder.encode(dto.getPassword()));
        return repository.save(new IchirinUser(dto));
    }

    public IchirinUser getUser(long userId) {
        return repository.findById(userId).get();
    }

    public Page<IchirinUser> getAllUsers(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
