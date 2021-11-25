package me.skiincraft.ichirin.util;

import me.skiincraft.ichirin.service.MangaRelationshipService;
import me.skiincraft.ichirin.service.MangaService;
import me.skiincraft.ichirin.service.UserHistoryService;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class ApplicationServices {

    private final ApplicationContext context;

    public ApplicationServices(ApplicationContext context) {
        this.context = context;
    }

    public MangaService getMangaService() {
        return context.getBean(MangaService.class);
    }

    public UserHistoryService getHistoryService() {
        return context.getBean(UserHistoryService.class);
    }

    public MangaRelationshipService getMangaRelationshipService() {
        return context.getBean(MangaRelationshipService.class);
    }

}
