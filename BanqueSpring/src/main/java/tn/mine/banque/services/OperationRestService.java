package tn.mine.banque.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tn.mine.banque.metier.IOperationMetier;
import tn.mine.banque.metier.PageOperations;

@RestController
public class OperationRestService {
	
	@Autowired
	private IOperationMetier operationMetier;

	
	
	
	
	
	
	@RequestMapping(value="/operations",method=RequestMethod.GET)
	public PageOperations getOperations(
			@RequestParam String codeCompte, 
			@RequestParam int page, 
			@RequestParam int size) {
		return operationMetier.getOperations(codeCompte, page, size);
	}



	@RequestMapping(value="/versement",method=RequestMethod.PUT)
	public boolean verser(
			@RequestParam String codeCompte,
			@RequestParam double montant,
			@RequestParam Long codeEmploye) {
		return operationMetier.verser(codeCompte, montant, codeEmploye);
	}

	
	
	@RequestMapping(value="/retrait",method=RequestMethod.PUT)
	public boolean retirer(
			@RequestParam String codeCompte, 
			@RequestParam double montant, 
			@RequestParam Long codeEmploye) {
		return operationMetier.retirer(codeCompte, montant, codeEmploye);
	}

	
	
	@RequestMapping(value="/virement",method=RequestMethod.PUT)
	public boolean virement(
			@RequestParam String compte1, 
			@RequestParam String compte2, 
			@RequestParam double montant, 
			@RequestParam Long codeEmploye) {
		return operationMetier.virement(compte1, compte2, montant, codeEmploye);
	}
	
	
	
	
	
	
	
	

}
