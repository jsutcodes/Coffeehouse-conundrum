package com.github.jsutcodes.coffeehouse_scheduler.service;

import com.github.jsutcodes.coffeehouse_scheduler.entity.Menu;
import com.github.jsutcodes.coffeehouse_scheduler.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor 
public class MenuServiceImpl implements MenuService {

    private final MenuRepository menuRepository;

    // Get all menu items
    @Override
    public List<Menu> getAllMenuItems() {
        return menuRepository.findAll();
    }

    // Get one menu item by ID
    @Override
    public Optional<Menu> getMenuItemById(Long id) {
        return menuRepository.findById(id);
    }

    // Save a new menu item
    @Override
    public Menu saveMenuItem(Menu menu) {
        return menuRepository.save(menu);
    }

    // Delete a menu item
    @Override
    public void deleteMenuItem(Long id) {
        menuRepository.deleteById(id);
    }
}