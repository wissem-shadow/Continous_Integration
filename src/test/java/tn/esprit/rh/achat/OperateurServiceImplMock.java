package tn.esprit.rh.achat;


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
	
	
	
	

}
