package tn.mine.banque.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import tn.mine.banque.dao.EmployeRepository;
import tn.mine.banque.entites.Employe;

@Service
public class EmployerMetierImpl implements IEmployerMetier{

	
	@Autowired
	private EmployeRepository employeRepository;
	
	
	
	
	
	@Override
	public Employe saveEmploye(Employe e) {
		return employeRepository.save(e);
	}

	@Override
	public List<Employe> listeEmployes() {
		
		return employeRepository.findAll();
	}

}
