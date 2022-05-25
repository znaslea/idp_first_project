package br.inatel.quotationmanagement.model;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="stock_quotation")
public class StockQuotation {
	@Id
	@GeneratedValue(generator = "UUID")
    @GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator"
    )
	@Column(name="id", columnDefinition="BINARY(16)", updatable = false, nullable = false)
	private UUID id;
	
	@Column(name="stockId")
	private String stockId;
	
	@ElementCollection
	@CollectionTable(name="quote")
	@MapKeyJoinColumn(name="quote_key")
	@Column(name="quotes")
	private Map<LocalDate, Double> quotes;

	public StockQuotation() {
		this.quotes = new HashMap<>();		
	}
	
	public StockQuotation(String stockId) {
		this();
		this.stockId = stockId;
	}
	
	public UUID getId() {
		return id;
	}
	
	public String getStockId() {
		return stockId;
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

	@Override
	public String toString() {
		return "StockQuotation [id=" + id + ", StockId=" + stockId + ", #Quotes: " + quotes.size() + "]";
	}
	@Override
    public int hashCode() {
        return getClass().hashCode();
    }
	
}
