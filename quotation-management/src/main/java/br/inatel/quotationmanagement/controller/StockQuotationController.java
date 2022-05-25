package br.inatel.quotationmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.inatel.quotationmanagement.model.StockQuotation;
import br.inatel.quotationmanagement.service.StockQuotationService;

@RestController
@RequestMapping("/quote")
public class StockQuotationController {
	@Autowired
	private StockQuotationService quoteService;

	@GetMapping
	public List<StockQuotation> list() {
		return quoteService.searchQuotes();
	}

//	 @GetMapping("/{id}")
//	 public StockQuotation search(@PathVariable("id") String stockId) {
//		 return quoteService.creatQuote(new StockQuotation(stockId));
//	 }
	 
	@PostMapping
	public ResponseEntity<?> creat(@RequestBody StockQuotation quote) {
		return ResponseEntity.status(quoteService.creatQuote(quote)).build();
	}

}
