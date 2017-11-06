package tn.mine.banque.metier;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.mine.banque.dao.CompteRepository;

import tn.mine.banque.entites.Compte;


@Service
public class CompteMetierImpl implements ICompteMetier {

	
	@Autowired
	private CompteRepository compteRepository;

	
	
	
	@Override
	public Compte saveCompte(Compte c) {
		c.setDateCreation(new Date());
		return compteRepository.save(c);
	}

	@Override
	public Compte getCompte(String code) {
		
		Compte compte = compteRepository.findOne(code);
		
		if(compte==null) throw new RuntimeException("Code Invalide !!");	
		//attt : RuntimeException n'est pas pro,prcq c une exception technique ==> il faut creer une perso: CodeInvalideException...
		
		
		
		
		return compte;
	}
	
	
	
	public List<Compte> listeComptes() {
		return compteRepository.findAll();
	}

	
	
	

}
