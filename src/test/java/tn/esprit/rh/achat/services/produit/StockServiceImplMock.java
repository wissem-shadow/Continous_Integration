package tn.esprit.rh.achat.services.produit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.repositories.StockRepository;
import tn.esprit.rh.achat.services.IStockService;
import tn.esprit.rh.achat.services.StockServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class StockServiceImplMock {
    @Mock
    StockRepository stockRepository;

    @InjectMocks
    StockServiceImpl stockServiceImpl;

    Stock s= Stock.builder().libelleStock("stock test").qte(100).qteMin(10).build();
    List<Stock> listStocks = new ArrayList<Stock>() {
        {
            add(Stock.builder().libelleStock("stock test1").qte(100).qteMin(10).build());
            add(Stock.builder().libelleStock("stock test2").qte(200).qteMin(20).build());
        }
    };

    @Test
    public void testRetrieveStock() {
        Mockito.when(stockRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(s));
        Stock s1 = stockServiceImpl.retrieveStock(new Long(2));
        Assertions.assertNotNull(s1);
    }

    @Test
    public void testAllRetrieveStock() {
        Mockito.when(stockRepository.findAll()).thenReturn(listStocks);
        List<Stock> lStocks = stockServiceImpl.retrieveAllStocks();
        Assertions.assertNotNull(lStocks);
    }

    @Test
    public void testAddstock() {
        Mockito.when(stockRepository.save(s)).thenReturn(s);
        Stock s1 = stockServiceImpl.addStock(s);
        Assertions.assertNotNull(s1);

    }
//somme text for testing
/*

    @Test
    public void DeleteParty() throws Exception{
        Mockito.when(stockRepository).andExpect(MockMvcResultMatchers
                .status().isOk());
    }

    @Test
    public void testDeletestock() {
        Mockito.when(stockRepository.deleteById(Mockito.anyLong())).thenReturn();
        Stock s1 = stockServiceImpl.addStock(s);
        Assertions.assertNotNull(s1);
    }
*/
}
