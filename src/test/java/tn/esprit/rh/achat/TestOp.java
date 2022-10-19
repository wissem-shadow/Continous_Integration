/*
package tn.esprit.rh.achat;


import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.rh.achat.entities.Operateur;
import tn.esprit.rh.achat.repositories.OperateurRepository;
import tn.esprit.rh.achat.services.OperateurServiceImpl;




@SpringBootTest
@ExtendWith(MockitoExtension.class)
 class TestOp {
	
	@Mock
    private OperateurRepository repo;
    
    @InjectMocks
    private OperateurServiceImpl OpService;
    
    
	
    @Test
    @Rollback(false)
     void testAddFacture() {
        Operateur addOp = repo.save(new Operateur("Amine","Chibeni","123"));
        OpService.addOperateur(addOp);
        assertEquals(addOp, OpService.addOperateur(addOp));
    }
    
    @Test
     void getAllFacturesTest()
    {
        List<Operateur> list = new ArrayList<Operateur>();
        Operateur Op1 = new Operateur("damino","Chibeni","123");
        Operateur Op2 = new Operateur("dama","Chibeni","123");
       

        list.add(Op1);
        list.add(Op2);

        when(repo.findAll()).thenReturn(list);

        //test
        List<Operateur> OpList = OpService.retrieveAllOperateurs();

        assertEquals(2, OpList.size());
        verify(repo, times(1)).findAll();
    }
    
    
    
}


*/