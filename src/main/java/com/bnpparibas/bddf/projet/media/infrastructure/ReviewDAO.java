package com.bnpparibas.bddf.projet.media.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewDAO extends JpaRepository<ReviewJPA, String> {
}
