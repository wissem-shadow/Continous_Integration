
/*package tn.esprit.rh.achat.services.produit;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.CategorieFournisseur;
import tn.esprit.rh.achat.entities.Fournisseur;
import tn.esprit.rh.achat.services.IFournisseurService;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest

public class FournisseurServiceTest {

    @Autowired
    IFournisseurService fournisseurService;

    @Test
    @Order(1)
    public void testSaveFournisseur(){
        CategorieFournisseur cat = CategorieFournisseur.ORDINAIRE;
        Fournisseur f= fournisseurService.addFournisseur(Fournisseur.builder().code("192JMT0915").libelle("Wissem_BH").categorieFournisseur(cat).build());
        Assertions.assertNotNull(f);
    }

    @Test
    @Order(2)
    public void testRetrieveAllFournisseurs() {
        int listFournisseurs = fournisseurService.retrieveAllFournisseurs().size();
        CategorieFournisseur cat = CategorieFournisseur.ORDINAIRE;
        fournisseurService.addFournisseur(fournisseurService.addFournisseur(Fournisseur.builder().code("192JMT0916").libelle("AHMED_TBH").categorieFournisseur(cat).build()));
        Assertions.assertEquals(listFournisseurs+1, fournisseurService.retrieveAllFournisseurs().size());
    }

    @Test
    @Order(3)
    public void testRetrieveOneFournisseur() {
        CategorieFournisseur cat = CategorieFournisseur.ORDINAIRE;
        Fournisseur f= fournisseurService.addFournisseur(Fournisseur.builder().code("100JMT0912").libelle("Chibeni").categorieFournisseur(cat).build());
        Assertions.assertEquals(f.getIdFournisseur(),fournisseurService.retrieveFournisseur(f.getIdFournisseur()).getIdFournisseur());
    }

    @Test
    @Order(4)
    public void testUpdateFournisseur() {
        CategorieFournisseur cat = CategorieFournisseur.ORDINAIRE;
        Fournisseur f= fournisseurService.addFournisseur(Fournisseur.builder().code("100JMT0912").libelle("Chibeni").categorieFournisseur(cat).build());
        f.setLibelle("Alaa_Smeeti");
        Assertions.assertEquals("Alaa_Smeeti",fournisseurService.updateFournisseur(f).getLibelle());
    }

    @Test
    @Order(5)
    public void testDeleteFournisseur(){

        CategorieFournisseur cat = CategorieFournisseur.ORDINAIRE;
        Fournisseur f= fournisseurService.addFournisseur(Fournisseur.builder().code("100JMT0912").libelle("Chibeni").categorieFournisseur(cat).build());
        fournisseurService.deleteFournisseur(f.getIdFournisseur());
        Assertions.assertNull(fournisseurService.retrieveFournisseur(f.getIdFournisseur()));
    }



}
*/