package tn.mine.banque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.mine.banque.entites.Employe;

public interface EmployeRepository extends JpaRepository<Employe, Long> {

}
