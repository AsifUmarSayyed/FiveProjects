package com.baliraja.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baliraja.entity.Quotes;
import com.baliraja.services.QuotesServices;


@RestController
@RequestMapping(value = "quotes")
public class QuotesController {
	
	@Autowired
	QuotesServices quotesServices;
	
	@GetMapping("getAllQuotes")
	public Iterable<Quotes> getAllQuotes(Quotes quotes) {
		return quotesServices.getAllQuotes(quotes);
	}
	
	@GetMapping("getQuotesById/{id}")
	public Optional<Quotes> getQuotesById(@PathVariable ("id") Integer id){
		return quotesServices.getQuoteById(id);
	}
	
	@PostMapping("saveQuotes")
	public Quotes saveQuotes(@RequestBody Quotes quotes) {
		return quotesServices.saveQuotes(quotes);
	}
	
	@PutMapping("updateQuotes")
	public Quotes updateQuotes(@RequestBody Quotes quotes) {
		return quotesServices.updateQuotes(quotes);
	}
	
	@GetMapping("getQuotes/{sessionId}")
	public List<Quotes> getQuotesBySession(@PathVariable(value="sessionId") String sessionId) {
			return quotesServices.findBySuppliers(sessionId);
	}
}
