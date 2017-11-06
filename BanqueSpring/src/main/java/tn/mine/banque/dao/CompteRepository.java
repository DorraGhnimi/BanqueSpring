package tn.mine.banque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.mine.banque.entites.Compte;

public interface CompteRepository extends JpaRepository<Compte, String>{

}
