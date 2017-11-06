package tn.mine.banque.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tn.mine.banque.entites.Compte;
import tn.mine.banque.metier.ICompteMetier;



@RestController
public class CompteRestService {
	
	@Autowired
	private ICompteMetier compteMetier;

	
	@RequestMapping(value="/comptes",method=RequestMethod.POST)
	public Compte saveCompte(@RequestBody Compte c) {
		return compteMetier.saveCompte(c);
	}

	@RequestMapping(value="/comptes/{code}",method=RequestMethod.GET)
	public Compte getCompte(@PathVariable String code) {
		return compteMetier.getCompte(code);
	}
	
	
	@RequestMapping(value="/comptes",method=RequestMethod.GET)
	public List<Compte> listeComptes() {
		return compteMetier.listeComptes();
	}
	
	
	
	
	
	
	
	
	
	

}
