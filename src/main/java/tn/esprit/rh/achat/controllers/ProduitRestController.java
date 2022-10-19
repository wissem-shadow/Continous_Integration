package tn.esprit.rh.achat.controllers;

import io.swagger.annotations.Api;
import springfox.documentation.swagger2.mappers.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import tn.esprit.rh.achat.Dto.ProduitDto;
import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.services.IProduitService;

import java.util.List;


@RestController
@CrossOrigin("*")
@Api(tags = "Gestion des produits")
@RequestMapping("/produit")
public class ProduitRestController {

	@Autowired
	IProduitService produitService;
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping("/retrieve-all-produits")
	@ResponseBody
	public List<Produit> getProduits() {
		return produitService.retrieveAllProduits();
	
	}

	
	@GetMapping("/retrieve-produit/{produit-id}")
	@ResponseBody
	public Produit retrieveRayon(@PathVariable("produit-id") Long produitId) {
		return produitService.retrieveProduit(produitId);
	}

	
	@PostMapping("/add-produit")
	@ResponseBody
	public Produit addProduit(@RequestBody ProduitDto p) {

		Produit dt = new Produit(p.getCodeProduit(),p.getLibelleProduit(),p.getPrix());
		
		return produitService.addProduit(dt);
	
	}


	@DeleteMapping("/remove-produit/{produit-id}")
	@ResponseBody
	public void removeProduit(@PathVariable("produit-id") Long produitId) {
		produitService.deleteProduit(produitId);
	}

	
	@PutMapping("/modify-produit")
	@ResponseBody
	public Produit modifyProduit(@RequestBody ProduitDto p) {
		Produit dt = new Produit(p.getCodeProduit(),p.getLibelleProduit(),p.getPrix());
		
		return produitService.updateProduit(dt);
	

	}


	@PutMapping(value = "/assignProduitToStock/{idProduit}/{idStock}")
	public void assignProduitToStock(@PathVariable("idProduit") Long idProduit, @PathVariable("idStock") Long idStock) {
		produitService.assignProduitToStock(idProduit, idStock);
	}


}
