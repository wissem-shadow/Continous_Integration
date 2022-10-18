
package tn.esprit.rh.achat;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;

import java.util.ArrayList;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.repositories.ProduitRepository;
import tn.esprit.rh.achat.services.ProduitServiceImpl;

@SpringBootTest
public class ProduitServiceImplMock {

	
	@MockBean
	ProduitRepository produitRepository;
	@Autowired
	ProduitServiceImpl produitService;
	
	Produit prod= Produit.builder().idProduit(1L).codeProduit("123").libelleProduit("lait").build();
	////
    List<Produit> listProduits= new ArrayList<Produit>() {
        {
            add(Produit.builder().codeProduit("456").libelleProduit("pomme").build());
            add(Produit.builder().codeProduit("789").libelleProduit("banane").build());
        }
    };
    
    @Test
    public void RetrieveProduit() {
        Mockito.when(produitRepository.findAll()).thenReturn(listProduits);
        List<Produit> lProduit = produitService.retrieveAllProduits();
        Assertions.assertNotNull(lProduit);
    }
    
    @Test
    public void RetrieveByIdProduit() {
  
    	BDDMockito.given(produitRepository.findById(anyLong())).willReturn(Optional.ofNullable(prod));

        Produit res = produitService.retrieveProduit(1L);

        assertThat(res.getCodeProduit()).contains("123");
    }

   
    @Test
    public void testAddProduit() {
        Mockito.when(produitRepository.save(prod)).thenReturn(prod);
        Produit produit1 = produitService.addProduit(prod);
        assertEquals(1L,produit1.getIdProduit());
            }
        
 /*
    @Test
    public void testUpdateProduit(){
    	Produit input = new Produit(1L, "riadh", "velo", 100, new Date(), new Date(), null, null, null);

    	Produit returned = new Produit(1L, "Ali", "velo", 100, new Date(), new Date(), null, null, null);

       
        Mockito.when(produitRepository.getById(1L)).thenReturn(input);
        Mockito.when(produitRepository.save(input)).thenReturn(returned);
   
        Produit result = produitService.updateProduit(input);

        assertEquals("Ali", result.getCodeProduit());
    }
*/
    
    @Test
    public void testUpdateProduit(){
    	Produit input = new Produit(1L, "riadh", "velo", 100, new Date(), new Date(), null, null, null);

        Mockito.when(produitRepository.save(input)).thenReturn(input);
   
        input.setCodeProduit("mohamed");
      
        Produit result = produitService.updateProduit(input);
        assertEquals(input, result);
    }
    
    
    @Test
    public void DeleteProduit(){
    	Produit input = new Produit(1L, "riadh", "velo", 100, new Date(), new Date(), null, null, null);

      
        Mockito.when(produitRepository.getById(1L)).thenReturn(input);
        doNothing().when(produitRepository).delete(input);

        produitService.deleteProduit(1L);
    }
	
}