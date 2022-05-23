package br.inatel.quotationmanagement.model;

import java.time.LocalDate;
import java.util.UUID;

public class Quote {
	private UUID id;
	private LocalDate date;
	private Double price;
	private String StockId;

	public Quote(String stockId, LocalDate date, Double price) {
		StockId = stockId;
		this.date = date;
		this.price = price;
	}
	
	public UUID getId() {
		return id;
	}
	public String getStockId() {
		return StockId;
	}
	public LocalDate getDate() {
		return date;
	}
	public Double getPrice() {
		return price;
	}
	
}
