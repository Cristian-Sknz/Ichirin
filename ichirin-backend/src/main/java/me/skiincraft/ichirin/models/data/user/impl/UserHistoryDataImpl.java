package me.skiincraft.ichirin.models.data.user.impl;

import lombok.Data;
import lombok.EqualsAndHashCode;
import me.skiincraft.ichirin.entity.user.IchirinUser;
import me.skiincraft.ichirin.models.data.manga.MangaCompact;
import me.skiincraft.ichirin.models.data.user.UserHistoryData;
import org.springframework.data.domain.Page;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserHistoryDataImpl extends UserCompactImpl implements UserHistoryData {

    private Page<MangaCompact> mangas;

    public UserHistoryDataImpl(IchirinUser user, Page<MangaCompact> mangas) {
        super(user);
        this.mangas = mangas;
    }
}
