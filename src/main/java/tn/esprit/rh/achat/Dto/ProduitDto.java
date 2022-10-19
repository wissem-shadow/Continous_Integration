package tn.esprit.rh.achat.Dto;

import java.util.Date;
import java.util.Set;


import lombok.Builder;
import lombok.Data;
import tn.esprit.rh.achat.entities.CategorieProduit;
import tn.esprit.rh.achat.entities.DetailFacture;
import tn.esprit.rh.achat.entities.Stock;

@Data

public class ProduitDto {
	
	private Long idProduit;
	private String codeProduit;
	private String libelleProduit;
	private float prix;
	
	private Date dateCreation;

	private Date dateDerniereModification;

	private Stock stock;

	private Set<DetailFacture> detailFacture;

	private CategorieProduit categorieProduit;

	public ProduitDto(String codeProduit, String libelleProduit, float prix) {
		super();
		this.codeProduit = codeProduit;
		this.libelleProduit = libelleProduit;
		this.prix = prix;
	}
	
	
	
}
