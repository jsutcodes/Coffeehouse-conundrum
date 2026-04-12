package com.github.jsutcodes.coffeehouse_scheduler.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.jsutcodes.coffeehouse_scheduler.entity.Menu;

public interface MenuRepository extends JpaRepository<Menu, Long>  {

}
