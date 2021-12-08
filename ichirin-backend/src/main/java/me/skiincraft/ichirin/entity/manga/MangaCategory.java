package me.skiincraft.ichirin.entity.manga;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@SequenceGenerator(name = "manga_category", sequenceName = "seq_manga_category")
public class MangaCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "manga_category")
    private Long id;
    private String name;

    public MangaCategory(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        MangaCategory that = (MangaCategory) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}