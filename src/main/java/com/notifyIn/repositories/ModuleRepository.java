package com.notifyIn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.notifyIn.entities.ModuleDetail;

public interface ModuleRepository extends JpaRepository<ModuleDetail, Long> {

}
