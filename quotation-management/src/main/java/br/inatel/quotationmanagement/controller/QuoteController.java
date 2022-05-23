package br.inatel.quotationmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.inatel.quotationmanagement.model.Quote;
import br.inatel.quotationmanagement.service.QuoteService;

@RestController
@RequestMapping("/quote")
public class QuoteController {
	@Autowired
	private QuoteService quoteService;
	
	@GetMapping
	public List<Quote> list() {
		return quoteService.searchQuotes();
	}
	
	/*
	 * @GetMapping("/{id}") public Quote search(@pathVariable("id") String stockId)
	 * { return quoteService.searchQuotes();
	 * 
	 * }
	 */
}
