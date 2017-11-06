package com.kuehne.nagel.knvmt.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kuehne.nagel.knvmt.model.CUser;

public interface CUserRepository extends JpaRepository<CUser, Long> {

	CUser findByUsername(String username);
	
}
