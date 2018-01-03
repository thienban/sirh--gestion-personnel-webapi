package dev.sgp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.sgp.entite.BanqueInfo;


public interface BanqueRepository extends JpaRepository<BanqueInfo, Integer> {
}
