package com.baliraja.controller;


import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baliraja.dto.ProductDto;
import com.baliraja.dto.SearchedProductDto;
import com.baliraja.entity.Product;
import com.baliraja.services.ProductServices;

@RestController
@RequestMapping(value = "product")
public class ProductController {
	
	@Autowired
	ProductServices productServices;
	
	@GetMapping("getProductById/{id}")
	public Optional<Product> getProductById(@PathVariable Integer id) {
		return productServices.getById(id);
	}
	
	@GetMapping("getAllProducts")
	public Iterable<Product> getAllProduct(Product product) {
		return productServices.getAllProducts(product);
	}
	
	@PostMapping("createProduct")
	public Integer createProduct(@RequestHeader("sessionId") String sessionId, @RequestBody Product product) throws IOException {
		return productServices.createProduct(sessionId, product);
	}
	
	@PutMapping("updateProduct")
	public Product updateProduct(@RequestBody Product product) {
		return productServices.updateProduct(product);
	}
	
	@GetMapping("getAllProductByBusiness/{businessId}")
	public  List<ProductDto> getAllProductByBusinessId(@PathVariable("businessId") Integer businessId) {
		return productServices.getAllProductBySeesionId(businessId);
	}
	
	@GetMapping("getListSearchedProduct/{productName}/{counter}")
	public List<SearchedProductDto> getListOfSearchedProduct(@PathVariable("productName") String productName,@PathVariable("counter") Integer counter){
		return productServices.sliceSearchedProductList(productName, counter);
	}
}