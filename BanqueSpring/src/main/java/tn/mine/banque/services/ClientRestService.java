package tn.mine.banque.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.mine.banque.entites.Client;
import tn.mine.banque.metier.IClientMetier;

@RestController
public class ClientRestService {

	@Autowired
	private IClientMetier clientMetier;

	
	
	
	@RequestMapping(value="/clients",method=RequestMethod.POST)
	//@ResponseBody : implicite ici, parceque "RestController"
	public Client saveClient(@RequestBody Client c) {
		return clientMetier.saveClient(c);
	}


	@RequestMapping(value="/clients",method=RequestMethod.GET)
	public List<Client> listeClient() {
		return clientMetier.listeClients();
	}
	
	 
	
	
	
}
