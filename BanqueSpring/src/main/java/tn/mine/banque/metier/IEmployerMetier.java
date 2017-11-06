package tn.mine.banque.metier;

import java.util.List;

import tn.mine.banque.entites.Employe;

public interface IEmployerMetier {

	public Employe saveEmploye(Employe e);
	public List<Employe> listeEmployes();
	
	
}
