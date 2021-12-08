package me.skiincraft.ichirin.configuration.setup;

import me.skiincraft.ichirin.entity.permissions.Permission;
import me.skiincraft.ichirin.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Component
public class SetupDefaultRoles implements ApplicationListener<ContextRefreshedEvent> {

    public static final String[] ALL_PERMISSIONS = new String[]{"ADMINISTRATE", "CREATE", "READ", "WRITE"};
    public static final String[] EDITOR_PERMISSIONS = new String[]{"CREATE", "READ", "WRITE"};
    public static final String[] USER_PERMISSIONS = new String[]{"READ", "WRITE"};

    private final RoleService service;

    @Autowired
    public SetupDefaultRoles(RoleService service) {
        this.service = service;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        var permissions = service.createPermission(ALL_PERMISSIONS);
        service.createRole("ROLE_ADMIN", permissions);
        service.createRole("ROLE_EDITOR", copyAndFilter(permissions, EDITOR_PERMISSIONS));
        service.createRole("ROLE_USER", copyAndFilter(permissions, USER_PERMISSIONS));
    }

    Collection<Permission> copyAndFilter(Collection<Permission> permissions, String... permissionNames) {
        return permissions.stream().filter((perm) -> Arrays.stream(permissionNames)
                        .anyMatch((item) -> item.equalsIgnoreCase(perm.getName())))
                .collect(Collectors.toList());
    }
}