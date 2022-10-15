package tn.esprit.rh.achat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.text.ParseException;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.services.IProduitService;


//@RunWith(SpringRunner.class)
@SpringBootTest

public class ProduitServiceImplTest {
	@Autowired
	IProduitService produitService;
	
	@Test
	public void testAddProduit()  throws ParseException{
		List<Produit> produits = produitService.retrieveAllProduits();
		Produit produitADD = new Produit().builder()
				.codeProduit("Stock B")
				.libelleProduit("toto")
				.prix(7)
				.build();
		int expected = produits.size();
		Produit savedProduit= produitService.addProduit(produitADD);
		assertEquals(expected + 1, produitService.retrieveAllProduits().size());
		assertNotNull(savedProduit.getCodeProduit());
	
	} 
}
