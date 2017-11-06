package tn.mine.banque.services;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import tn.mine.banque.entites.Compte;
import tn.mine.banque.metier.ICompteMetier;
import tn.mine.banque.metier.IOperationMetier;
import tn.mine.banque.metier.PageOperations;

@Component	
@WebService 
public class BanqueSoapService {

	@Autowired
	private ICompteMetier compteMetier;
	@Autowired
	private IOperationMetier operationMetier;
	
	
	
	@WebMethod
	public Compte getCompte(
			@WebParam(name="codeCompte") String code) {
		return compteMetier.getCompte(code);
	}
	
	
	@WebMethod
	public boolean verser(
			@WebParam(name="codeCompte") String codeCompte, 
			@WebParam(name="montant") double montant, 
			@WebParam(name="codeEmploye") Long codeEmploye) {
		return operationMetier.verser(codeCompte, montant, codeEmploye);
	}
	
	
	@WebMethod
	public boolean retirer(
			@WebParam(name="codeCompte") String codeCompte, 
			@WebParam(name="montant") double montant, 
			@WebParam(name="codeEmploye")Long codeEmploye) {
		return operationMetier.retirer(codeCompte, montant, codeEmploye);
	}
	
	
	@WebMethod
	public boolean virement(
			@WebParam(name="codeCompte1") String compte1, 
			@WebParam(name="codeCompte2") String compte2, 
			@WebParam(name="montant") double montant, 
			@WebParam(name="codeEmploye") Long codeEmploye) {
		return operationMetier.virement(compte1, compte2, montant, codeEmploye);
	}
	
	@WebMethod
	public PageOperations getOperations(
			@WebParam(name="codeCompte") String codeCompte, 
			@WebParam(name="page") int page, 
			@WebParam(name="size") int size) {
		return operationMetier.getOperations(codeCompte, page, size);
	}
	
	
	
}
