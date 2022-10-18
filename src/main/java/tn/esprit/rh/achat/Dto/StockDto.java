package tn.esprit.rh.achat.Dto;

import org.springframework.beans.BeanUtils;

import lombok.Data;
import tn.esprit.rh.achat.entities.Stock;

@Data
public class StockDto {
	private Long idStock;
	private String libelleStock;

	 public StockDto(Stock stock) {
	        BeanUtils.copyProperties(stock, this);
	    }


}
