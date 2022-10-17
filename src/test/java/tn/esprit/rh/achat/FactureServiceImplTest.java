package tn.esprit.rh.achat;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.rh.achat.entities.Facture;
import tn.esprit.rh.achat.repositories.FactureRepository;
import tn.esprit.rh.achat.services.FactureServiceImpl;


@SpringBootTest
public class FactureServiceImplTest {
    
   
    @Mock
    private FactureRepository repo;
    
    @InjectMocks
    private FactureServiceImpl factureService;
    
    @SuppressWarnings("deprecation")
    @org.junit.Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    
    @Test
    @Rollback(false)
    public void testAddFacture() {
        Facture addFacture = repo.save(new Facture(null, 1542, 0, null, null, null, null, null, null));
        assertThat(addFacture.getIdFacture()).isPositive();
    }
    
    
    
    
    
}
