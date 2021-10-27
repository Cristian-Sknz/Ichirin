package me.skiincraft.ichirin.service;

import me.skiincraft.ichirin.data.IchirinUserDTO;
import me.skiincraft.ichirin.models.user.IchirinUser;
import me.skiincraft.ichirin.repository.IchirinUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    public final IchirinUserRepository repository;
    public final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserService(IchirinUserRepository repository, BCryptPasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    public IchirinUser createUser(IchirinUserDTO dto) {
        dto.setPassword(passwordEncoder.encode(dto.getPassword()));
        return repository.save(new IchirinUser(dto));
    }

    public Optional<IchirinUser> getUser(long id) {
        return repository.findById(id);
    }
}
