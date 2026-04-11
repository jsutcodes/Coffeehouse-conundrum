package com.github.jsutcodes.coffeehouse_scheduler.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.jsutcodes.coffeehouse_scheduler.entity.Menu;
import com.github.jsutcodes.coffeehouse_scheduler.service.MenuServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/menu") // Base URL for all endpoints in this class
@RequiredArgsConstructor
public class MenuController {

    private final MenuServiceImpl menuService;

    // GET: http://localhost:8080/api/menus
    @GetMapping
    public List<Menu> getAllMenus() {
        return menuService.getAllMenuItems();
    }

    // GET: http://localhost:8080/api/menus/1
    @GetMapping("/{id}")
    public ResponseEntity<Menu> getMenuById(@PathVariable Long id) {
        return menuService.getMenuItemById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST: http://localhost:8080/api/menus
    @PostMapping
    public Menu createMenu(@RequestBody Menu menu) {
        return menuService.saveMenuItem(menu);
    }

    // DELETE: http://localhost:8080/api/menus/1
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMenu(@PathVariable Long id) {
        menuService.deleteMenuItem(id);
        return ResponseEntity.noContent().build();
    }
}

