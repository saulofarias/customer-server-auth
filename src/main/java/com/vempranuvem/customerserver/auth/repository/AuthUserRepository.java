package com.vempranuvem.customerserver.auth.repository;

import com.vempranuvem.customerserver.auth.entity.AuthUser;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthUserRepository extends JpaRepository<AuthUser, String> {
}
