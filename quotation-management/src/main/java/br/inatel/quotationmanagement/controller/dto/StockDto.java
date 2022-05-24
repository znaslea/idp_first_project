package br.inatel.quotationmanagement.controller.dto;

public class StockDto {
	private String id;
	private String description;
	
	public StockDto() {
	}
	
	public StockDto(String id, String description) {
		this.id = id;
		this.description = description;
	}
	
	public String getId() {
		return id;
	}
	public String getDescription() {
		return description;
	}
	
	@Override
	public String toString() {
		return "Stock [stockId=" + id + ", description=" + description + "]";
	}
	
}
