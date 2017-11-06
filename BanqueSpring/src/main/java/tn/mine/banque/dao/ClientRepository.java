package tn.mine.banque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.mine.banque.entites.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

}
