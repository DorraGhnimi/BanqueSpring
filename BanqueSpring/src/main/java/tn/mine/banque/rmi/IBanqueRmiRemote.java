package tn.mine.banque.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

import tn.mine.banque.entites.Compte;

public interface IBanqueRmiRemote extends Remote{

	
	
	
	public Compte saveCompte(Compte compte) throws RemoteException;
	public Compte getCompte(String codeCompte) throws RemoteException;
	
	public boolean verser(String codeCompte, double montant,Long codeEmploye) throws RemoteException;
	public boolean retirer(String codeCompte, double montant,Long codeEmploye) throws RemoteException;
	public boolean virement(String compte1,String compte2,double montant,Long codeEmploye) throws RemoteException;
	
	
	
	
	
	
	
	
	
	
}
