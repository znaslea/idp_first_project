package br.inatel.quotationmanagement.controller.form;

import java.time.LocalDate;
import java.util.Map;
import java.util.UUID;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.inatel.quotationmanagement.model.StockQuotation;

public class StockQuotationForm {


	private UUID id;
	@NotEmpty @NotNull @Length(min=3, max=5)
	private String stockId;
	private Map<@NotNull LocalDate, @NotNull Double> quotes;

	public StockQuotationForm() {
	}

	public void setId(UUID id) {
		this.id = id;
	}
	
	public void setStockId(String stockId) {
		this.stockId = stockId;
	}
	
	public void setQuotes(Map<LocalDate, Double> quotes) {
		this.quotes = quotes;
	}
	
	public StockQuotation coverter() {
		return new StockQuotation(stockId, quotes);
	}
	
	@Override
	public String toString() {
		return "StockQuotation [id=" + id + ", StockId=" + stockId + ", #Quotes: " + quotes.size() + "]";
	}

}
