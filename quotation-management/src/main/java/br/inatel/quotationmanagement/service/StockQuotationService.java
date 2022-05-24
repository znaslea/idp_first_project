package br.inatel.quotationmanagement.service;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientException;

import br.inatel.quotationmanagement.controller.dto.StockDto;
import br.inatel.quotationmanagement.controller.exception.StockNotFoundException;
import br.inatel.quotationmanagement.model.StockQuotation;
import reactor.core.publisher.Mono;

@Service
public class StockQuotationService {

	public List<StockQuotation> searchQuotes() {
		return Collections.emptyList();
	}

	public StockQuotation creatQuote(StockQuotation quote) throws WebClientException{
		StockDto stock = this.verifyStock(quote.getStockId());
		quote.setStockId(stock.getId());
		return quote;
	}

	private StockDto verifyStock(String stockId) throws WebClientException, StockNotFoundException {
		Mono<StockDto> monoStock = WebClient.create("http://localhost:8080")
		.get()
		.uri("/stock/"+stockId)
		.retrieve()
		.bodyToMono(StockDto.class);
		monoStock.subscribe();
		StockDto stock = monoStock.block();
		if(stock!= null) {
			return stock;
		}
		throw new StockNotFoundException('"'+ stockId + '"' + " stock does not exist in stock-manager API.");
	}
}
