package tn.mine.banque.entites;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class Client implements Serializable{

	
	//private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codeClient;
	private String nomClient;
	
	
	//asso bidirectionnelle=>mappedBy : 
	//'client'== l'obj qui va etre declaré ds la classe Compte
	//=~ cle etrangere
	//LAzy=> lorsque Hibernate charge un obj client 
	//==> il va charger que nom et code et pas la liste des comptes
	//il va les charger que lorsque il ya "getCompes"
	@OneToMany(mappedBy="client",fetch=FetchType.LAZY)
	private Collection<Compte> comptes;
	
	
	
	public Client() {
		super();
	}
	public Client(String nomClient) {
		super();
		this.nomClient = nomClient;
	}
	
	
	
	public Long getCodeClient() {
		return codeClient;
	}
	public void setCodeClient(Long codeClient) {
		this.codeClient = codeClient;
	}
	public String getNomClient() {
		return nomClient;
	}
	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}
	@JsonIgnore
	@XmlTransient
	public Collection<Compte> getComptes() {
		return comptes;
	}
	public void setComptes(Collection<Compte> comptes) {
		this.comptes = comptes;
	}
	
	
	
	
	
	
	
	
	
}
