package tn.esprit.rh.achat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.rh.achat.entities.Operateur;
import tn.esprit.rh.achat.repositories.OperateurRepository;
import tn.esprit.rh.achat.services.OperateurServiceImpl;

@SpringBootTest
@ExtendWith(MockitoExtension.class)


public class OperateurServiceMockTest {
	@Mock
	OperateurRepository oprep;
	
	@InjectMocks
	OperateurServiceImpl opservice;
	
	Operateur operateur = new Operateur("Amine","Chibeni","123");
	
	List <Operateur> listoperateur = new ArrayList<Operateur>() {
		{
			add (new Operateur("Damino","Chibeni","456"));
			add (new Operateur("Chibeni","Amine","789"));
		}
	};
	
	
	@Test
	public void TestRetrieveOperateur() {
		Mockito.when(oprep.findById(Mockito.anyLong())).thenReturn(Optional.of(operateur));
		Operateur operateur1 = opservice.retrieveOperateur((long) 2);
		Assertions.assertNotNull(operateur1);
		
	}
	

}
