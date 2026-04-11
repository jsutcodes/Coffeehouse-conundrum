package com.github.jsutcodes.coffeehouse_scheduler.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.github.jsutcodes.coffeehouse_scheduler.repository.MenuRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {
	
	private final MenuRepository menuRepo; 

	@Override
	public void run(String... args) throws Exception {
		loadMenuItems();
		
	}

	private void loadMenuItems() {
//		if(menuRepo.count() == 0) {
//			menuRepo.save(null)
//		}
		
	}

}
