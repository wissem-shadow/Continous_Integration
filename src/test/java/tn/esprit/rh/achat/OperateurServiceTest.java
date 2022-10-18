package tn.esprit.rh.achat;

import java.util.List;


import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.rh.achat.entities.Operateur;
import tn.esprit.rh.achat.services.IOperateurService;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)

public class OperateurServiceTest {
	
	@Autowired
	IOperateurService operateurservice;
	
	@Test
	public void TestRetrieveOperateur () {
		List <Operateur> ListOperateurs = operateurservice.retrieveAllOperateurs();
		Assertions.assertEquals(0,ListOperateurs.size());
		
	}

}
