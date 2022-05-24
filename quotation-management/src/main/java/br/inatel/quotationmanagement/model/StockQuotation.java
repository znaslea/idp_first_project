package br.inatel.quotationmanagement.model;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class StockQuotation {
	private UUID id;
	private String StockId;
	private Map<LocalDate, Double> quotes;

	public StockQuotation() {
		this.quotes = new HashMap<>();		
	}
	
	public StockQuotation(String stockId) {
		this();
		StockId = stockId;
	}
	
	public UUID getId() {
		return id;
	}
	
	public String getStockId() {
		return StockId;
	}
	
	public void setId(UUID id) {
		this.id = id;
	}

	public void setStockId(String stockId) {
		this.StockId = stockId;
	}

	@Override
	public String toString() {
		return "StockQuotation [id=" + id + ", StockId=" + StockId + ", #Quotes: " + quotes.size() + "]";
	}
	
}
