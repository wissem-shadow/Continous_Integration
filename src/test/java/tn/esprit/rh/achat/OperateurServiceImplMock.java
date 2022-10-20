package tn.esprit.rh.achat;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.Operateur;
import tn.esprit.rh.achat.repositories.OperateurRepository;
import tn.esprit.rh.achat.services.OperateurServiceImpl;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class OperateurServiceImplMock {
	
	@Mock
    OperateurRepository OpRepository;

    @InjectMocks
    OperateurServiceImpl OpService;
	
Operateur operateur = new Operateur("Amine","Chibeni","123");
	
	List <Operateur> listoperateur = new ArrayList<Operateur>() {
		{
			add (new Operateur("Damino","Chibeni","456"));
			add (new Operateur("Chibeni","Amine","789"));
		}
	};
	
	
	@Test
    public void FindAllOperateur(){
        Mockito.when(OpRepository.findAll()).thenReturn(listoperateur);
        List<Operateur> listOperateur = OpService.retrieveAllOperateurs();
        Assertions.assertNotNull(listOperateur);

    }
	
	@Test
    void RetrieveByIdOperateur() {
 
   	BDDMockito.given(OpRepository.findById(anyLong())).willReturn(Optional.ofNullable(operateur));

   	  Operateur op = OpService.retrieveOperateur(1L);

       ((List<Operateur>) assertThat(op.getIdOperateur())).contains("123");
   }

  
   @Test
    void testAddProduit() {
       Mockito.when(OpRepository.save(operateur)).thenReturn(operateur);
       Operateur op = OpService.addOperateur(operateur);
       assertEquals(1L,op.getIdOperateur());
           }
	
	
   @Test
   void testUpdateProduit(){
	   Operateur input = new Operateur("Amine","Chibeni","123");

      Mockito.when(OpRepository.save(input)).thenReturn(input);
 
      input.setNom("mohamed");
    
       Operateur result = OpService.updateOperateur(input);
      assertEquals(input, result);
  }
   
   
   @Test
   
   void DeleteProduit(){

    
      Mockito.when(OpRepository.findById(1l));
      doNothing().when(OpRepository).delete(operateur);

      OpService.deleteOperateur(1l);;
  }
	

}
