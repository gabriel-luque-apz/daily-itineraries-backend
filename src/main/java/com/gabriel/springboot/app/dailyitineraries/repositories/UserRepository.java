package com.gabriel.springboot.app.dailyitineraries.repositories;

import com.gabriel.springboot.app.dailyitineraries.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
