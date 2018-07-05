package com.notifyIn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.notifyIn.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
