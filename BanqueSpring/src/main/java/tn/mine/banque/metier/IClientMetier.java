package tn.mine.banque.metier;

import java.util.List;

import tn.mine.banque.entites.Client;

public interface IClientMetier {

	public Client saveClient(Client c );
	public List<Client> listeClients();
	
	
	
	
	
}
