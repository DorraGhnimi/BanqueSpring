package tn.mine.banque.metier;

import java.util.List;

import tn.mine.banque.entites.Compte;

public interface ICompteMetier {

	public Compte saveCompte(Compte c);
	public Compte getCompte(String code);
	public List<Compte> listeComptes();
	
}
