package tn.esprit.rh.achat;

import static org.assertj.core.api.Assertions.assertThat;
//import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
//import org.junit.jupiter.api.Assertions;
import static org.mockito.Mockito.doNothing;

import java.util.ArrayList;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
//import org.junit.Assert;
//import org.junit.Before;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;


//import static org.junit.Assert.*;
//import org.junit.Assert;
import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.repositories.ProduitRepository;
import tn.esprit.rh.achat.repositories.StockRepository;
import tn.esprit.rh.achat.services.ProduitServiceImpl;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ProduitServiceImplTest {
	
	@Mock
	ProduitRepository produitRepository;
	@Mock
	StockRepository stockRepository;
	
	
	@InjectMocks
	ProduitServiceImpl produitService;
	
	Produit prod= Produit.builder().codeProduit("123").libelleProduit("lait").build();
	
    List<Produit> listProduits= new ArrayList<Produit>() {
        {
            add(Produit.builder().idProduit(1L).codeProduit("456").libelleProduit("pomme").build());
            add(Produit.builder().codeProduit("789").libelleProduit("banane").build());
        }
    };

    
    @Test
    public void testAddProduit() {
        Mockito.when(produitRepository.save(prod)).thenReturn(prod);
        Produit produit1 = produitService.addProduit(prod);
        Assertions.assertNotNull(produit1);
    }
    
  /*  
    @Test
    public void testRetrieveProduit() {
        Mockito.when(produitRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(prod));
        Produit produit1 = produitService.retrieveProduit(1L);
        Assertions.assertNotNull(produit1);
    }
    
    */
    @Test
    public void testAllRetrieveProduit() {
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
    public void testUpdateProduit(){
    	Produit input = new Produit(1L, "riadh", "velo", 100, new Date(), new Date(), null, null, null);

    	//Produit returned = new Produit(1L, "Ali", "velo", 100, new Date(), new Date(), null, null, null);      
        //Mockito.when(produitRepository.getById(1L)).thenReturn(input);
        Mockito.when(produitRepository.save(input)).thenReturn(input);
   
        input.setCodeProduit("mohamed");
        
        Produit result = produitService.updateProduit(input);

       // assertEquals("Ali", result.getCodeProduit());
        assertEquals(input, result);
    }
    
    /*
    @Test
    public void DeleteProduit(){
    	Produit input = new Produit(1L, "riadh", "velo", 100, new Date(), new Date(), null, null, null);

      
        Mockito.when(produitRepository.getById(1L)).thenReturn(input);
        //doNothing().when(produitRepository).deleteById(1L);;

        produitService.deleteProduit(1L);
        Assertions.assertNotNull(input);
    }
	*/
  /*  
    @Test
    public void AssignProduit() {
  
    	Produit pt = new Produit(1L, "riadh", "velo", 100, new Date(), new Date(), null, null, null);
    	Stock st = new Stock(1L, "riadh", 5,6, null);
    	
    	BDDMockito.given(produitRepository.findById(anyLong())).willReturn(Optional.ofNullable(pt));

    	BDDMockito.given(stockRepository.findById(anyLong())).willReturn(Optional.ofNullable(st));
    	
        pt.setStock(st);

        Produit produit1 = produitService.addProduit(pt);
        Assertions.assertNotNull(produit1);
    }
  */  
    
}
