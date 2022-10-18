package tn.esprit.rh.achat;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
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
        Facture addFacture = repo.save(new Facture(1L, 1542, 0, null, null, null, null, null, null));
        factureService.addFacture(addFacture);
        assertEquals(addFacture, factureService.addFacture(addFacture));
    }
    
    @Test
    public void getAllFacturesTest()
    {
        List<Facture> list = new ArrayList<Facture>();
        Facture fac1 = new Facture(3L, 1000, 0, null, null, null, null, null, null);
        Facture fac2 = new Facture(4L, 1001, 0, null, null, null, null, null, null);
       

        list.add(fac1);
        list.add(fac2);

        when(repo.findAll()).thenReturn(list);

        //test
        List<Facture> facList = factureService.retrieveAllFactures();

        assertEquals(2, facList.size());
        verify(repo, times(1)).findAll();
    }
     
    @Test
    public void cancelFactureTest(){
        Facture fac = new Facture();
        fac.setIdFacture(1L);

        when(repo.findById(fac.getIdFacture())).thenReturn(Optional.of(fac));

        factureService.cancelFacture(fac.getIdFacture());
        verify(repo).deleteById(fac.getIdFacture());
        
    }
    
    @Test
    public void retrieveFactureByIdTest() {
        Facture fac = new Facture();
        fac.setIdFacture(3L);

        when(repo.findById(fac.getIdFacture())).thenReturn(Optional.of(fac));

        Facture expected = factureService.retrieveFacture(fac.getIdFacture());

        assertThat(expected).isSameAs(fac);
        verify(repo).findById(fac.getIdFacture());
    }

}
