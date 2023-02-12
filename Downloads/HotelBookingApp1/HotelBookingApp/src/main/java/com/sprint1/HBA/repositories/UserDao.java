package com.sprint1.HBA.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprint1.HBA.entities.Userss;

@Repository ("ud")
public interface UserDao extends JpaRepository<Userss, Integer> {

}