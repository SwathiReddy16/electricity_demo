package com.electricity_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.electricity_demo.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>
{

}
