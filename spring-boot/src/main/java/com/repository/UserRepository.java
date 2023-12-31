package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	@Query(value = "SELECT * FROM \"user\" u WHERE u.username = :username AND u.password = :password", nativeQuery = true)
	User login(
		@Param("username") String username,
		@Param("password") String password
	);
	
	@Query(value = "SELECT d.id_dosen FROM dosen d INNER JOIN \"user\" u ON d.id_user = u.id_user WHERE u.id_user = :id_user ", nativeQuery = true)
	String getDosenId(@Param("id_user") String id_user);

}
