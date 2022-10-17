package tn.esprit.rh.achat.services.produit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.CategorieFournisseur;
import tn.esprit.rh.achat.entities.Fournisseur;
import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.repositories.FournisseurRepository;
import tn.esprit.rh.achat.services.FournisseurServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class FournisseurServiceImplMock {

    @Mock
    FournisseurRepository fournisseurRepository;

    @InjectMocks
    FournisseurServiceImpl fournisseurService;
    CategorieFournisseur cat = CategorieFournisseur.ORDINAIRE;
    Fournisseur f= fournisseurService.addFournisseur(Fournisseur.builder().code("192JMT0915").libelle("Wissem_BH").categorieFournisseur(cat).build());
    List<Fournisseur> listFournisseur = new ArrayList<Fournisseur>() {
        {
            add(Fournisseur.builder().code("192JMT0915").libelle("Wissem_BH").categorieFournisseur(cat).build());
            add(Fournisseur.builder().code("100JMT0912").libelle("Chibeni").categorieFournisseur(cat).build());
        }
    };

    @Test
    public void FindAllFournisseurs(){
        Mockito.when(fournisseurRepository.findAll()).thenReturn(listFournisseur);
        List<Fournisseur> listFournisseurs = fournisseurService.retrieveAllFournisseurs();
        Assertions.assertNotNull(listFournisseurs);

    }

    @Test
    public void testRetrieveFournisseur() {
        Mockito.when(fournisseurRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(f));
        Fournisseur f1 = fournisseurService.retrieveFournisseur(new Long(2));
        Assertions.assertNotNull(f1);
    }

    @Test
    public void testAddFournisseur() {
        Mockito.when(fournisseurRepository.save(f)).thenReturn(f);
        Fournisseur f1 = fournisseurService.addFournisseur(f);
        Assertions.assertNotNull(f1);

    }




}
