package tn.mine.banque.metier;

public interface IOperationMetier {
	
	
	
	public boolean verser(String codeCompte, double montant,Long codeEmploye);
	public boolean retirer(String codeCompte, double montant,Long codeEmploye);
	public boolean virement(String compte1,String compte2,double montant,Long codeEmploye);
	public PageOperations getOperations(String codeCompte, int page, int size);
	
	
}
