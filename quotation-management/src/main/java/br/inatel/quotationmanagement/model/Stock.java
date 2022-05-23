package br.inatel.quotationmanagement.model;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class Stock {
	private UUID id;
	private String stockId;
	private String description;
	private Set<Quote> quoteSet; //insertion order does not matter.
	
	public Stock(String stockId, String description) {
		this.stockId = stockId;
		this.description = description;
		this.quoteSet = new HashSet<>();
	}
	
	public UUID getId() {
		return id;
	}
	public String getStockId() {
		return stockId;
	}
	public String getDescription() {
		return description;
	}
	public Set<Quote> getQuoteSet() {
		return quoteSet;
	}
}
