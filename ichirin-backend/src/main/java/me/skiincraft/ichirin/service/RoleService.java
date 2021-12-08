package me.skiincraft.ichirin.service;

import me.skiincraft.ichirin.entity.permissions.Permission;
import me.skiincraft.ichirin.entity.permissions.Role;
import me.skiincraft.ichirin.exception.IchirinNotFoundException;
import me.skiincraft.ichirin.repository.roles.PermissionRepository;
import me.skiincraft.ichirin.repository.roles.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class RoleService {

    @Autowired
    private MessageSource source;

    private final RoleRepository roleRepository;
    private final PermissionRepository permissionRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository,
                       PermissionRepository permissionRepository) {
        this.roleRepository = roleRepository;
        this.permissionRepository = permissionRepository;
    }

    @Transactional
    public Collection<Permission> createPermission(String... permissionNames) {
        if (permissionNames.length == 0)
            throw new IllegalArgumentException("Você precisa inserir nomes para criar permissões");

        return Stream.of(permissionNames)
                .map((name) -> permissionRepository.findByName(name)
                    .orElseGet(() -> permissionRepository.save(new Permission(name))))
                .collect(Collectors.toList());
    }

    @Transactional
    public Role createRole(String roleName, Permission... permissions) {
        return this.createRole(roleName, List.of(permissions));
    }

    @Transactional
    public Role createRole(String roleName, Collection<Permission> permissions) {
        return roleRepository.findByName(roleName)
                .orElseGet(() -> roleRepository.save(new Role(roleName, permissions)));
    }

    public Role getRole(String roleName) {
        return roleRepository.findByName(roleName)
                .orElseThrow(() -> new IchirinNotFoundException("exception.role.not-found", source));
    }
}