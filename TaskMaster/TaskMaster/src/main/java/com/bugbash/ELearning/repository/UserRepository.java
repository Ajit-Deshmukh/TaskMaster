package com.bugbash.ELearning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bugbash.ELearning.model.Users;

@Repository
public interface UserRepository extends JpaRepository<Users,Integer>{

} 