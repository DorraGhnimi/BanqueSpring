package tn.mine.banque.metier;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import tn.mine.banque.dao.CompteRepository;
import tn.mine.banque.dao.EmployeRepository;
import tn.mine.banque.dao.OperationRepository;
import tn.mine.banque.entites.Compte;
import tn.mine.banque.entites.Employe;
import tn.mine.banque.entites.Operation;
import tn.mine.banque.entites.Retrait;
import tn.mine.banque.entites.Versement;

@Service
public class OperationMetierImpl implements IOperationMetier{

	
	@Autowired
	private OperationRepository operationRepository;
	
	@Autowired
	private CompteRepository compteRepository;
	
	@Autowired
	private EmployeRepository employeRepository;
	
	
	
	@Override
	@Transactional
	public boolean verser(String codeCompte, double montant, Long codeEmploye) {
		
		//pour plus .. : on peut ajouter des RuntimeException : majanech el Compte par exemple..
		Compte compte = compteRepository.findOne(codeCompte);
				
		Employe employe = employeRepository.findOne(codeEmploye);
		
		
		Operation versement = new Versement();
		versement.setDateOperation(new Date());
		versement.setMontant(montant);
		versement.setCompte(compte);
		versement.setEmploye(employe);
		
		operationRepository.save(versement);
		
		compte.setSolde(compte.getSolde()+montant);
		
		
		return true;
	}

	@Override
	@Transactional //on peut l'ajouter 3al classe ki toutes mes meths sont transct
	public boolean retirer(String codeCompte, double montant, Long codeEmploye) {
		
		
		Compte compte = compteRepository.findOne(codeCompte);
		if(compte.getSolde() < montant) throw new RuntimeException("Solde insuffisant !!");
		
		
		Employe employe = employeRepository.findOne(codeEmploye);
		
		
		Operation retrait = new Retrait();
		retrait.setDateOperation(new Date());
		retrait.setMontant(montant);
		retrait.setCompte(compte);
		retrait.setEmploye(employe);
		
		operationRepository.save(retrait);
		
		compte.setSolde(compte.getSolde()-montant);
		
		
		
		
		
		return true;
	}

	@Override
	@Transactional
	public boolean virement(String compte1, String compte2, double montant, Long codeEmploye) {
		
		retirer(compte1, montant, codeEmploye);
		verser(compte2, montant, codeEmploye);
		return true;
	}

	
	
	@Override
	public PageOperations getOperations(String codeCompte, int page, int size) {
	
		Page<Operation> operations1 = operationRepository.getOperations(codeCompte, new PageRequest(page, size));
		
		/*
		Compte compte = compteRepository.findOne(codeCompte);
		Page<Operation> operations2 = operationRepository.findByCompte(compte, new PageRequest(page, size));
		*/
		
		PageOperations pageOperations = new PageOperations();
		pageOperations.setOperations(operations1.getContent());
		pageOperations.setNombreOperations(operations1.getNumberOfElements());
		pageOperations.setPage(operations1.getNumber());
		pageOperations.setTotalPages(operations1.getTotalPages());
		pageOperations.setTotalOperations( (int) operations1.getTotalElements());
		
		
		return pageOperations; 
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
