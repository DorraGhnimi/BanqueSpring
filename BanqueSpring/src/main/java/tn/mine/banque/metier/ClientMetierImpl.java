package tn.mine.banque.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.mine.banque.dao.ClientRepository;
import tn.mine.banque.entites.Client;


@Service
public class ClientMetierImpl implements IClientMetier{

	@Autowired
	private ClientRepository clientRepository;
	

	@Override
	public Client saveClient(Client c) {
		
		return clientRepository.save(c);
	}

	@Override
	public List<Client> listeClients() {
		
		return clientRepository.findAll()	;
	}

	
	
	
	
	
	
	
	
	
	
	
	
}
