package tn.mine.banque.entites;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


@Entity

//BD : Mapping Objet Relationnel
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
//puisque  y a heritage=> DisciminatorColumn indique la collone indique le type de compte


@DiscriminatorColumn(name="Type_Compte",
	discriminatorType=DiscriminatorType.STRING,
	length=2)


//Rest :Mapping Objet JSON
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME,include=JsonTypeInfo.As.PROPERTY,property="type")
@JsonSubTypes({
	@Type(name="CC",value=CompteCourant.class),
	@Type(name="CE",value=CompteEpargne.class)	
})


//SOAP :Mapping Objet xml
@XmlSeeAlso({CompteCourant.class,CompteEpargne.class})


public abstract class Compte implements Serializable{
	
	
	
	
	//private static final long serialVersionUID = 1L;
	
	@Id
	private String codeCompte;
	private Date dateCreation;
	private double solde;
	
	@ManyToOne
	@JoinColumn(name="CODE_CLIENT")//cle etrangere
	private  Client client;
	
	@ManyToOne
	@JoinColumn(name="CODE_EMPLOYE")//cle etrangere
	private Employe employe;
	
	@OneToMany(mappedBy="compte")
	private Collection<Operation> operations;
	
	
	
	
	public Compte() {
		super();
	}
	public Compte(String codeCompte, Date dateCreation, double solde) {
		super();
		this.codeCompte = codeCompte;
		this.dateCreation = dateCreation;
		this.solde = solde;
	}
	public String getCodeCompte() {
		return codeCompte;
	}
	public void setCodeCompte(String codeCompte) {
		this.codeCompte = codeCompte;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Employe getEmploye() {
		return employe;
	}
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	
	@JsonIgnore		//Rest
	@XmlTransient 	//SOAP
	public Collection<Operation> getOperations() {
		return operations;
	}
	public void setOperations(Collection<Operation> operations) {
		this.operations = operations;
	}
	
	

}
