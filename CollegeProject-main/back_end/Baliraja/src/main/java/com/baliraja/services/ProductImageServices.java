package com.baliraja.services;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.baliraja.dao.ProductDao;
import com.baliraja.dao.ProductImageDao;
import com.baliraja.entity.Product;
import com.baliraja.entity.ProductImage;

@Service
public class ProductImageServices {

	@Autowired
	ProductImageDao productImageDao;
	
	@Autowired
	ProductDao productDao;
	
	String response = "";
	ProductImage productImage;
	Optional<Product> product;
	
	public StringBuilder saveImage(MultipartFile file, String productID) {
		StringBuilder response = new StringBuilder();
		try {
			productImage = new ProductImage();
			product = productDao.findById(Integer.parseInt(productID));
			productImage.setProduct(product.get());
//			productImage.setImage(compressBytes(file.getBytes()));
			productImage.setImage(file.getBytes());
			System.out.println(productImage);
			productImageDao.save(productImage);
			response.insert(0, true);
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
			response.insert(0, false);
			response.insert(1, "Imange size");
		}
		
		return response;
	}
	
	public ProductImage retriveImage(Integer productId) {
		productImage = productImageDao.findByProductId(productId);
//		productImage.setImage(decompressBytes(productImage.getImage()));
		System.out.println("Product Image -> "+ productImage.getImage());
		productImage.setImage(productImage.getImage());
		return productImage;
	}
	
	
	//Compress image
	public static byte[] compressBytes(byte[] data) {
		Deflater deflater = new Deflater();
		deflater.setInput(data);
		deflater.finish();

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		while (!deflater.finished()) {
			int count = deflater.deflate(buffer);
			outputStream.write(buffer, 0, count);
		}
		try {
			outputStream.close();
		} catch (IOException e) {
		}
		System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);
		return outputStream.toByteArray();
	}
	
	// Uncompress image
		public static byte[] decompressBytes(byte[] data) {
			Inflater inflater = new Inflater();
			inflater.setInput(data);
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
			byte[] buffer = new byte[1024];
			try {
				while (!inflater.finished()) {
					int count = inflater.inflate(buffer);
					outputStream.write(buffer, 0, count);
				}
				outputStream.close();
			} catch (IOException ioe) {
			} catch (DataFormatException e) {
			}
			return outputStream.toByteArray();
		}
	
}
