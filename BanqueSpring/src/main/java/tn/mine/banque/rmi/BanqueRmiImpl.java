package tn.mine.banque.rmi;

import java.rmi.RemoteException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import tn.mine.banque.entites.Compte;
import tn.mine.banque.metier.ICompteMetier;
import tn.mine.banque.metier.IOperationMetier;



@Component("myRmiService")
public class BanqueRmiImpl implements IBanqueRmiRemote {

	
	@Autowired
	private ICompteMetier compteMetier;
	@Autowired
	private IOperationMetier operationMetier;
	
	
	
	
	
	
	@Override
	public Compte saveCompte(Compte compte) throws RemoteException {
		return compteMetier.saveCompte(compte);
	}

	@Override
	public Compte getCompte(String codeCompte) throws RemoteException {
		return compteMetier.getCompte(codeCompte);
	}

	@Override
	public boolean verser(String codeCompte, double montant, Long codeEmploye) throws RemoteException {
		return operationMetier.verser(codeCompte, montant, codeEmploye);
	}

	@Override
	public boolean retirer(String codeCompte, double montant, Long codeEmploye) throws RemoteException {
		return operationMetier.retirer(codeCompte, montant, codeEmploye);
	}

	@Override
	public boolean virement(String compte1, String compte2, double montant, Long codeEmploye) throws RemoteException {
		return operationMetier.virement(compte1, compte2, montant, codeEmploye);
	}
	
	
	
	
	
	
	

}
