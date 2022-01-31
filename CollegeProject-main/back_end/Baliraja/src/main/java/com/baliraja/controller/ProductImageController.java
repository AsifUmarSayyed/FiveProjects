package com.baliraja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.baliraja.entity.ProductImage;
import com.baliraja.services.ProductImageServices;

@RestController
@RequestMapping(value = "productImage")
public class ProductImageController {

	@Autowired
	ProductImageServices productImageServices;
	
	@PostMapping("uploadImage")
	public StringBuilder saveProductImage(@RequestParam("image") MultipartFile image,@RequestParam("productId") String productId) {
		return productImageServices.saveImage(image, productId);
	}
	
	@GetMapping("getImage/{productId}")
	public ProductImage retriveImage(@PathVariable("productId") Integer productId) {
		return productImageServices.retriveImage(productId);
	}
}
