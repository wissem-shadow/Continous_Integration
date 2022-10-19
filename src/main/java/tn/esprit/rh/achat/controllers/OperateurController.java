package tn.esprit.rh.achat.controllers;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import tn.esprit.rh.achat.Dto.OperateurDto;
import tn.esprit.rh.achat.entities.Operateur;
import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.services.IOperateurService;

import java.util.List;

@RestController
@Api(tags = "Gestion des opérateurs")
@RequestMapping("/operateur")
@CrossOrigin("*")
public class OperateurController {

	@Autowired
	IOperateurService operateurService;
	
	
	@GetMapping("/retrieve-all-operateurs")
	@ResponseBody
	public List<Operateur> getOperateurs() {
		return operateurService.retrieveAllOperateurs();
		
	}

	
	@GetMapping("/retrieve-operateur/{operateur-id}")
	@ResponseBody
	public Operateur retrieveOperateur(@PathVariable("operateur-id") Long operateurId) {
		return operateurService.retrieveOperateur(operateurId);
	}

	
	@PostMapping("/add-operateur")
	@ResponseBody
	public Operateur addOperateur(@RequestBody OperateurDto op) {
		Operateur o = new Operateur(op.getNom(),op.getPrenom());
		return operateurService.addOperateur(o);
		
	}

	@DeleteMapping("/remove-operateur/{operateur-id}")
	@ResponseBody
	public void removeOperateur(@PathVariable("operateur-id") Long operateurId) {
		operateurService.deleteOperateur(operateurId);
	}

	
	@PutMapping("/modify-operateur")
	@ResponseBody
	public Operateur modifyOperateur(@RequestBody OperateurDto op) {
		Operateur o = new Operateur(op.getNom(),op.getPrenom());
		return operateurService.updateOperateur(o);
	}

	
}
