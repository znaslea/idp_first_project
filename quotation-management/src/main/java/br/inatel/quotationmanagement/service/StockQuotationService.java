package br.inatel.quotationmanagement.service;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import br.inatel.quotationmanagement.controller.dto.StockDto;
import br.inatel.quotationmanagement.model.StockQuotation;
import reactor.core.publisher.Mono;

@Service
public class StockQuotationService {

	public List<StockQuotation> searchQuotes() {
		return Collections.emptyList();
	}

	public StockQuotation creatQuote(StockQuotation quote) {
		StockDto stock = this.getExistingStock(quote.getStockId());
		quote.setStockId(stock.getId());
		return quote;
	}

	private StockDto getExistingStock(String stockId) {
		Mono<StockDto> monoStock = WebClient.create("http://localhost:8080")
		.get()
		.uri("/stock/"+stockId)
		.retrieve().
		bodyToMono(StockDto.class);
		monoStock.subscribe();
		StockDto stock = monoStock.block();
		System.out.println(stock.toString());
		return stock;
	}
}
