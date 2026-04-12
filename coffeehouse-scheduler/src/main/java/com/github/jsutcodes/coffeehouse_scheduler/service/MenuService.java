package com.github.jsutcodes.coffeehouse_scheduler.service;

import java.util.List;
import java.util.Optional;

import com.github.jsutcodes.coffeehouse_scheduler.entity.Menu;

public interface MenuService {
	
    public List<Menu> getAllMenuItems();
    
    public Optional<Menu> getMenuItemById(Long id);
    
    public Menu saveMenuItem(Menu menu);
    
    public void deleteMenuItem(Long id);
}
