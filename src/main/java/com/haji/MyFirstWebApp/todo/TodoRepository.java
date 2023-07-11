package com.haji.MyFirstWebApp.todo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<todo, Integer> {
public List<todo> findByusername(String username);
}
