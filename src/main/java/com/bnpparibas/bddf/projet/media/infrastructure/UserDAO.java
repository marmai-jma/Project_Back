package com.bnpparibas.bddf.projet.media.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDAO extends JpaRepository<UserJPA, String> {
    Optional<UserJPA> findByLogin(String login);
}
