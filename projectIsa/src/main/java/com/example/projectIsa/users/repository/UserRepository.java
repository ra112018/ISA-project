package com.example.projectIsa.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.projectIsa.users.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	User findByEmail(String username);
}
