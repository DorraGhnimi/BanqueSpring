import java.rmi.Naming;
import java.util.Date;

import tn.mine.banque.entites.Compte;
import tn.mine.banque.entites.CompteCourant;
import tn.mine.banque.rmi.IBanqueRmiRemote;

public class ClientRMI {

	public static void main(String[] args) {
		
		/*
		 * un Client RMI fait un lookup:
		 * je connais le nom , je recupere le reference, je cree un proxy
		 */
		
		
		
			try {
				IBanqueRmiRemote proxy = (IBanqueRmiRemote) Naming.lookup("rmi://localhost:8004/BanqueService");
				
				System.out.println("\n\n\n\n\nTestRMI Client ::: \n\n");
				//Compte compte = proxy.getCompte("CC3");
				//System.out.println(compte.getClient().getNomClient());
				//System.out.println(compte.getSolde());
				//System.out.println(compte.getDateCreation());
				
				proxy.saveCompte(new CompteCourant("CE1", new Date(), 987654, 555));
				
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		
		
		
		
	}

}
