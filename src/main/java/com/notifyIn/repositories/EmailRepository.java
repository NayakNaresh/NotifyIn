package com.notifyIn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.notifyIn.entities.EmailTemplate;

public interface EmailRepository extends JpaRepository<EmailTemplate, Long> {

}
