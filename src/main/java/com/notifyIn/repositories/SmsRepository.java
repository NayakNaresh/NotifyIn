package com.notifyIn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.notifyIn.entities.SmsTemplate;

public interface SmsRepository extends JpaRepository<SmsTemplate, Long> {

}
