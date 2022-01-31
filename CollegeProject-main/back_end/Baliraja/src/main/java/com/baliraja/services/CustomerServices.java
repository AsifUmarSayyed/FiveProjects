package com.baliraja.services;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.baliraja.dao.CustomerDao;
import com.baliraja.dao.SessionLoggerDao;
import com.baliraja.entity.Customer;
import com.baliraja.entity.SessionLogger;

@Service
public class CustomerServices {
	
	@Autowired
	CustomerDao customerDao;
	
	@Autowired
	SessionLoggerDao sessionLoggerDao;
	
	SessionLogger sessionLogger;
	
	public Iterable<Customer> getAllCustomers(Customer customer) {
		return customerDao.findAll();
	}
	
	public Optional<Customer> getCustomerByID(Integer id) {
		return customerDao.findById(id);
	}
	
	public Customer createCustomer(Customer customer) {
		Customer c = null;
		try {
			Customer c1 = customerDao.findByMobileNumber(customer.getMobileNumber());
			if(c1.getMobileNumber() != null) {
				
			}
		} catch (Exception e) {
			c = customerDao.save(customer);
		}
		return c;
	}
	
	public Customer updateCustomer(Customer customer) {
		Optional<Customer> s = customerDao.findById(customer.getId());
		Customer s1 = s.get();
		s1 = customer;
		return customerDao.save(s1);
	} 
	
	public Map<String, String> customerLogin(Long mobileNumber) {
	  HashMap<String, String> map = new HashMap<>();
	  Customer c1 = customerDao.findByMobileNumber(mobileNumber);
		
		try {
			HttpSession session;
			HttpServletRequest req= ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
			if(c1.getId() != null) {
				session = req.getSession(true);
				session.setMaxInactiveInterval(7*60);
				session.setAttribute("customer", c1.getMobileNumber());
				sessionLogger = new SessionLogger(session.getId(), c1.getId());
				sessionLoggerDao.save(sessionLogger);
				map.put("response", session.getId());
				
			}
		} catch (Exception e) {
			map.put("response", "No Account Found Or Invalid Number");
		}
		return map;
	}
	
	public Customer getCustomerBySession(String sessionId) {
		Customer customer = new Customer();
		try {
			Optional<SessionLogger> optionalSessionLogger = sessionLoggerDao.findBySessionId(sessionId);
			Integer customerId= optionalSessionLogger.get().getSessionAttribute();
			customer = customerDao.findById(customerId).get();
		}
		catch (Exception e) {
			customer.setFullName("Session Expired");
		}
		return customer;
	}
}
