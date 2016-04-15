package com.wbl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.wbl.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Long> {

	@Query("SELECT u from UserModel u where LOWER(u.email) = :email")
	UserModel findByEmail(@Param("email") String email);

	@Query("SELECT u FROM UserModel u WHERE LOWER(u.username) = :username")
	UserModel findByUsername(@Param("username") String username);
}
