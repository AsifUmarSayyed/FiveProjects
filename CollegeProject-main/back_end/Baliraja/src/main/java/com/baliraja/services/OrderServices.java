package com.baliraja.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baliraja.dao.OrderDao;
import com.baliraja.dto.CustomerOrder;
import com.baliraja.dto.OrderDto;
import com.baliraja.dto.SupplierOrder;
import com.baliraja.entity.Customer;
import com.baliraja.entity.ProductOrder;
import com.baliraja.entity.Product;
import com.baliraja.entity.Suppliers;

@Service
public class OrderServices {

	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private CustomerServices cutomerService;

	@Autowired
	private ProductServices productService;
	
	@Autowired
	private BusinessServices businessService;
	
	@Autowired
	SupplierServices supplierService;
	
	public List<SupplierOrder> getSupplierOrder(String sessionId) {
		Suppliers supplier = supplierService.getSupplierBySession(sessionId);
		List<ProductOrder> productOrder = orderDao.findBySupplierId(supplier.getId());
		List<SupplierOrder> supplierOrderList = new ArrayList<SupplierOrder>();
		
		for(ProductOrder po : productOrder) {
			if(!po.getDeliveryStatus().contains("Delivered")) {
				SupplierOrder supplierOrder = new SupplierOrder();
				Product p = productService.getById(po.getProductId()).get();
				Customer c = cutomerService.getCustomerByID(po.getCustomerId()).get();
				supplierOrder.setQuantity(po.getQuantity());
				supplierOrder.setOrderId(po.getId());
				supplierOrder.setProdcutName(p.getName());
				supplierOrder.setCustomerName(c.getFullName());
				supplierOrder.setCustomerContact(c.getMobileNumber()+"");
				supplierOrder.setDeliveryAddress(c.getAddress());
				supplierOrder.setDeliveryStatus(po.getDeliveryStatus());
				supplierOrder.setProductCode(p.getCode());
				supplierOrderList.add(supplierOrder);
			}
		}
		return supplierOrderList;
	}
	
	public Boolean createOrder(String sessionId, List<OrderDto> order) {
		Customer customer  = cutomerService.getCustomerBySession(sessionId);
		
		for(OrderDto od : order) {
			ProductOrder o = new ProductOrder();
			Optional<Product> product = productService.getById(od.getProductId());
			Product p = product.get();
			o.setCustomerId(customer.getId());
			o.setProductId(p.getId());
			o.setQuantity(od.getQuantity());
			Suppliers s = businessService.getSupplierByBusiness(p.getBusinessId().toString());
			o.setSupplierId(s.getId());
			o.setDeliveryStatus("Placed");
			orderDao.save(o);
		}
		return true;
	}
	
	public Boolean changeDeliveryStatus(ProductOrder order) {
		ProductOrder po = orderDao.findById(order.getId()).get();
		po.setDeliveryStatus(order.getDeliveryStatus());
		orderDao.save(po);
		return true;
	}

	public List<SupplierOrder> getSupplierOrderHistory(String sessionId) {
		Suppliers supplier = supplierService.getSupplierBySession(sessionId);
		List<ProductOrder> productOrder = orderDao.findBySupplierId(supplier.getId());
		List<SupplierOrder> supplierOrderList = new ArrayList<SupplierOrder>();
		
		for(ProductOrder po : productOrder) {
			if(po.getDeliveryStatus().contains("Delivered")) {
				SupplierOrder supplierOrder = new SupplierOrder();
				Product p = productService.getById(po.getProductId()).get();
				Customer c = cutomerService.getCustomerByID(po.getCustomerId()).get();
				supplierOrder.setQuantity(po.getQuantity());
				supplierOrder.setOrderId(po.getId());
				supplierOrder.setProdcutName(p.getName());
				supplierOrder.setCustomerName(c.getFullName());
				supplierOrder.setCustomerContact(c.getMobileNumber()+"");
				supplierOrder.setDeliveryAddress(c.getAddress());
				supplierOrder.setDeliveryStatus(po.getDeliveryStatus());
				supplierOrder.setProductCode(p.getCode());
				supplierOrderList.add(supplierOrder);
			}
		}
		return supplierOrderList;
	}
	
	public List<CustomerOrder> getCustomerOrder(String sessionId){
		Customer customer  = cutomerService.getCustomerBySession(sessionId);
		List<ProductOrder> productOrder = orderDao.findByCustomerId(customer.getId());
		
		List<CustomerOrder> customerOrder = new ArrayList<CustomerOrder>();
		for(ProductOrder po : productOrder) {
			CustomerOrder c =  new CustomerOrder();
			Product p = productService.getById(po.getProductId()).get();
			c.setProdcutName(p.getName());
			c.setQuantity(po.getQuantity());
			c.setDeliveryStatus(po.getDeliveryStatus());
			c.setPrice(po.getQuantity() * p.getPrice());
			c.setPricePerItem(p.getPrice());
			customerOrder.add(c);
		}
		return customerOrder;
	}
	
}
