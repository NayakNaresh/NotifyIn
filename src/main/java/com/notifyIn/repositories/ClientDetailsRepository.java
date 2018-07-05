package com.notifyIn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.notifyIn.entities.ClientDetail;

@Repository
public interface ClientDetailsRepository extends JpaRepository<ClientDetail, Long> {

}
