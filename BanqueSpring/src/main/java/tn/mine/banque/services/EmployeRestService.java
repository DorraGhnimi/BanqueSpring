package tn.mine.banque.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tn.mine.banque.entites.Employe;
import tn.mine.banque.metier.IEmployerMetier;



@RestController
public class EmployeRestService {
	
	@Autowired
	private IEmployerMetier employerMetier;

	
	
	
	
	@RequestMapping(value="/employes", method=RequestMethod.POST)
	public Employe saveEmploye(@RequestBody Employe e) {
		return employerMetier.saveEmploye(e);
	}

	
	@RequestMapping(value="/employes", method=RequestMethod.GET)
	public List<Employe> listeEmployes() {
		return employerMetier.listeEmployes();
	}
	
	

	
	
	

}
