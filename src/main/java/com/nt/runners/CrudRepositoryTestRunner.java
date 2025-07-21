package com.nt.runners;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Customer;
import com.nt.service.ICustomerMgmtService;

@Component
public class CrudRepositoryTestRunner implements CommandLineRunner {

	@Autowired
	private ICustomerMgmtService custService;

	@Override
	public void run(String... args) throws Exception {

		try {
			
			  Customer cust = new Customer();
			  cust.setName("Surya");
			  cust.setCadd("Manohara");
			  cust.setBillAmt(20.0f);
			  
			  String result = custService.registerCustomer(cust);
			  System.out.println("Result Message : "+result);
			  System.out.println("Record with Id available or not : "+custService.isCustomerAvailable(3));
			  System.out.println("Total Count Of Records : "+custService.showCustomerCount());
			  Iterable<Customer> c = custService.showAllCustomers();
			  for(Customer o :c)
			  { 
				  System.out.println(o);
			  }
			  
			  Iterable<Customer> list = custService.showAllCustomersByIds(List.of(1, 4)) ;
			  for(Customer c1 : list)
			  { 
				  System.out.println(c1);
			  }
			  
			  Customer customer1 = new Customer("Sures", "Munmai", 56.0f);
			  Customer customer2 = new Customer("Rajesh", "Munmai", 56.0f);
			  Customer customer3 = new Customer("Mahesh", "Munmai", 56.0f);
			  List<Customer> l1 = List.of(customer1, customer2, customer3);
			  String registerGroupCustomer = custService.registerGroupCustomer(l1);
			  System.out.println(registerGroupCustomer);
			  
			  Customer c2 = custService.showCustomerById(100);
			  System.out.println(c2);
			  
			 
			  Customer cust1 = new Customer(100, "Manohara", "Odisha c", 890.0f);

			  String resultMessage = custService.registerOrUpdateCustomer(cust);
			  System.out.println(resultMessage);
			  
			  String resultMessage1 = custService.updateCustomerAddress(5, "NewYork");
			  System.out.println(resultMessage1);
			  
			  String removeCustomer = custService.removeCustomerById(3);
			  System.out.println(removeCustomer);

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}

}
