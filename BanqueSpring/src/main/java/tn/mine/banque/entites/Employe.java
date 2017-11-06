package tn.mine.banque.entites;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;


@Entity
public class Employe implements Serializable{
	
	
	
	//private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codeEmploye;
	private String nomEmploye;
	@ManyToOne
	@JoinColumn(name="CODE_EMPLOYE_SUP")
	private Employe emplyeSup;//asso refrexive 
	@ManyToMany
	@JoinTable(name="EMPLOYE_GROUPE")
	private Collection<Employe> groupes;
	
	
	
	public Employe(String nomEmploye) {
		super();
		this.nomEmploye = nomEmploye;
	}

	public Employe() {
		super();
	}
	
	public Long getCodeEmploye() {
		return codeEmploye;
	}
	public void setCodeEmploye(Long codeEmploye) {
		this.codeEmploye = codeEmploye;
	}
	public String getNomEmploye() {
		return nomEmploye;
	}
	public void setNomEmploye(String nomEmploye) {
		this.nomEmploye = nomEmploye;
	}
		
	//qd je consulte un employe(request)=> il va ignoer ce champ(employeSup)
	//mais : 
	//Probleme ==> il ignore en get en set (cd en ajoutant un nv emplye..
	//Solution : @JsonSetter
	@JsonIgnore
	public Employe getEmplyeSup() {
		return emplyeSup;
	}
	@JsonSetter
	public void setEmplyeSup(Employe emplyeSup) {
		this.emplyeSup = emplyeSup;
	}
	
	@JsonIgnore
	public Collection<Employe> getGroupes() {
		return groupes;
	}
	@JsonSetter
	public void setGroupes(Collection<Employe> groupes) {
		this.groupes = groupes;
	}
	
	
	
	

}
