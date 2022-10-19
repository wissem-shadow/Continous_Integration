package tn.esprit.rh.achat.Dto;

import java.util.Set;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import tn.esprit.rh.achat.entities.Facture;

@Data
public class OperateurDto {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idOperateur;
	private String nom;
	private String prenom;
	
	private String password;
	
	private Set<Facture> factures;

	public OperateurDto(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}
	
	
}
