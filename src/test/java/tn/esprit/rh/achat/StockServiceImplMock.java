package tn.esprit.rh.achat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.repositories.StockRepository;
import tn.esprit.rh.achat.services.StockServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class StockServiceImplMock {
    @Mock
    StockRepository Repo;

    @InjectMocks
    StockServiceImpl Service;

    Stock s= Stock.builder().libelleStock("stock test").qte(100).qteMin(10).build();
    List<Stock> listStocks = new ArrayList<Stock>() {
        {
            add(Stock.builder().libelleStock("stock test1").qte(100).qteMin(10).build());
            add(Stock.builder().libelleStock("stock test2").qte(200).qteMin(20).build());
        }
    };

    @Test
    public void testRetrieveStock() {
        Mockito.when(Repo.findById(Mockito.anyLong())).thenReturn(Optional.of(s));
        @SuppressWarnings("removal")
		Stock s1 = Service.retrieveStock(new Long(2));
        Assertions.assertNotNull(s1);
    }

    @Test
    public void testAllRetrieveStock() {
        Mockito.when(Repo.findAll()).thenReturn(listStocks);
        List<Stock> lStocks = Service.retrieveAllStocks();
        Assertions.assertNotNull(lStocks);
    }

    @Test
    public void testAddstock() {
        Mockito.when(Repo.save(s)).thenReturn(s);
        Stock s1 = Service.addStock(s);
        Assertions.assertNotNull(s1);

    }
    @Test
    public void testUpdatestock() {
        s.setQteMin(5);
        Mockito.when(Repo.save(s)).thenReturn(s);
        Stock s1 = Service.updateStock(s);
        Assertions.assertEquals(s,s1);

    }

    @Test
    public void testDeletestock() {
    	Service.deleteStock(s.getIdStock());
        Mockito.verify(Repo, Mockito.times(1)).deleteById(s.getIdStock());
    }
    
    /*
    @Test
	 public void TestupdateStock()
	{
		//Stock stock = new Stock(1L,"addStock",100,50);
		Mockito.when(Repo.save(s)).thenReturn(s);
		s.setLibelleStock("updatestok");
		s.setQte(90);
		assertEquals(s, Service.updateStock(s));
	}
    */
    /*
    @Test
	public void whenGivenId_shouldDeletestock_ifFound()
	{
		Mockito.when(Repo.findById(s.getIdStock())).thenReturn(Optional.of(s));
		Service.deleteStock(s.getIdStock());
		verify(Repo).deleteById(s.getIdStock());
	}*/
    
    

    
    
    
    
    
    
}
