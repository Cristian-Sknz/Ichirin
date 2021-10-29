package me.skiincraft.ichirin.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import me.skiincraft.ichirin.models.manga.MangaCategory;
import me.skiincraft.ichirin.service.MangaCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.Collection;

@RestController
@RequestMapping(path = "/api/category")
public class CategoryController {

    private final MangaCategoryService categoryService;

    @Autowired
    public CategoryController(MangaCategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping(path = "")
    public Collection<MangaCategory> getCategories() {
        return categoryService.getCategories();
    }

    @GetMapping(path = "/{id}")
    public MangaCategory getCategory(@PathVariable Long id) {
        return categoryService.getCategory(id);
    }

    @PostMapping(path = "/{name}")
    public MangaCategory createCategory(@Validated @PathVariable @NotBlank String name) {
        return categoryService.createCategory(name);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Object> deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        ObjectNode node = new ObjectMapper().createObjectNode();
        node.put("status", "Ok");
        return new ResponseEntity<>(node, HttpStatus.OK);
    }
}
