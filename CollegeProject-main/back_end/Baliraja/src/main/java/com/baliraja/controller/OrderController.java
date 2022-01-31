package com.baliraja.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baliraja.dto.CustomerOrder;
import com.baliraja.dto.OrderDto;
import com.baliraja.dto.SupplierOrder;
import com.baliraja.entity.ProductOrder;
import com.baliraja.services.OrderServices;

@RestController
@RequestMapping(value = "order")
public class OrderController {

	@Autowired
	OrderServices orderService;
	
	@GetMapping("getSupplierOrder")
	public List<SupplierOrder> getSupplierOrder(@RequestHeader("sessionId") String sessionId){
		return orderService.getSupplierOrder(sessionId);
	}
	
	@PostMapping("createOrder")
	public Boolean createOrder(@RequestHeader("sessionId") String sessionId, @RequestBody List<OrderDto> orderDto) {
		orderService.createOrder(sessionId, orderDto);
		return true;
	}
	
	@PostMapping("changeDeliveryStatus")
	public Boolean changeDeliveryStatus(@RequestBody ProductOrder order) {
		return orderService.changeDeliveryStatus(order);
	}
	
	@GetMapping("getSupplierOrderHistory")
	public List<SupplierOrder> getSupplierOrderHistory(@RequestHeader("sessionId") String sessionId) {
		return orderService.getSupplierOrderHistory(sessionId);
	}
	
	@GetMapping("getCustomerOrder")
	public List<CustomerOrder> getCustomerOrder(@RequestHeader("sessionId") String sessionId) {
		return orderService.getCustomerOrder(sessionId);
	}
	
	
}
