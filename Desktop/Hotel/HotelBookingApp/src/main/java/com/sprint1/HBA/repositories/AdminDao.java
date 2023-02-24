package com.sprint1.HBA.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprint1.HBA.entities.Admin;


@Repository("ad")
public interface AdminDao extends JpaRepository<Admin , Integer> {


}