package com.baliraja.services;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

import com.baliraja.dao.ProductDao;
import com.baliraja.dto.ProductDto;
import com.baliraja.dto.SearchedProductDto;
import com.baliraja.entity.Product;
import com.baliraja.entity.Suppliers;

@Transactional
@Service
@CacheConfig(cacheNames = {"Prodcut"})
public class ProductServices {
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	SupplierServices supplierService;
	
	
	public List<ProductDto> getAllProductBySeesionId(Integer businessId) {
		List<Product> productList = productDao.findByBusinessId(businessId);
		List<ProductDto> productDtoList = new ArrayList<ProductDto>();
		for(int i = 0; i < productList.size(); i++) {
			Product p = productList.get(i);
			productDtoList.add(new ProductDto(p.getName(), p.getId(),
					p.getCode(), p.getBrand(), p.getPrice(), p.getArrival(),
					p.getUnit(), p.getCreated_date(), p.getClicks(), p.getOffer()));
		}
		
		return productDtoList;
	}
	
	
	public Optional<Product> getById(Integer id) {
		Optional<Product> optionalProduct = productDao.findById(id);
		Product product = optionalProduct.get();
		product.setClicks(product.getClicks() + 1);
		productDao.save(product);
;		return productDao.findById(id);
	}
	
	public Iterable<Product> getAllProducts(Product product) {
		return productDao.findAll();
	}
	
	public Integer createProduct(String sessionId, Product product) {
		Integer id = 0;
		try {
			Suppliers supplier = supplierService.getSupplierBySession(sessionId);
			Integer businessId = supplier.getBusiness().get(0).getId();
			product.setBusinessId(businessId);
			product.setCreated_date(new Date(System.currentTimeMillis()));
			product.setUpdated_date(new Date(System.currentTimeMillis()));
			id = productDao.save(product).getId();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}
	
	public Product updateProduct(Product product) {
		Optional<Product> p=productDao.findById(product.getId());
		Product p1=p.get();
		p1=product;
		return productDao.save(p1);
	}
	
	@Cacheable("productName")
	public List<Product> getListOfSearchedProduct(String productName) {
		System.out.println("Product Name" + productName);
		List<Product> productList = productDao.findByNameContainingIgnoreCase(productName);
		return productList;
	}
	
	@Cacheable("productName")
	public List<SearchedProductDto> sliceSearchedProductList(String productName, Integer counter){
		int startIndex= counter * 4;
		int endIndex = startIndex + 4;
		List<Product> productList =  getListOfSearchedProduct(productName);
		List<SearchedProductDto> searchedProductDtoList = new ArrayList<SearchedProductDto>();
		
		if(endIndex > productList.size()) {
			System.out.println("Inside if ");
			endIndex = productList.size();
		}
		
		for(int i = startIndex; i < endIndex; i++) {
			System.out.println("adding element");
			Product p = productList.get(i);
			System.out.println(p.getProductImages().get(0).getImage());
			searchedProductDtoList.add(new SearchedProductDto(p.getId(), p.getName(),
					p.getSpecification_1(), p.getSpecification_2(), p.getSpecification_3(), p.getSpecification_4(), 
					p.getDescription_1(), p.getDescription_2(), p.getDescription_3(), p.getDescription_4(), 
					p.getCategoryId(), p.getProductImages().get(0).getImage(), p.getBusinessId(), p.getAdditional_information()));
		}
		
		if(counter == 0) {
			int length = productList.size() % 4;
			int remaining = productList.size() -  length*4;
			if(remaining > 0) {
				length++;
			}
			searchedProductDtoList.get(0).setLength(length);
		}
		
		return searchedProductDtoList;
	}
	
	
}
