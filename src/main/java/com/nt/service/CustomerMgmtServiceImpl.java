package com.nt.service;

import java.util.List;     
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Customer;
import com.nt.repository.ICustomerRepository;


@Service
public class CustomerMgmtServiceImpl implements ICustomerMgmtService {
	
	@Autowired
	private ICustomerRepository custRepo;

	@Override
	public String registerCustomer(Customer cust) {

		System.out.println("CustRepo proxy class Name : "+custRepo.getClass());
		Customer cust1 = custRepo.save(cust);//1......................................
		return "Customer is saved with Id Valiue : "+cust1.getCno();
	}

	@Override
	public Boolean isCustomerAvailable(int id) {

		return custRepo.existsById(id);//2...........................................
	}

	@Override
	public long showCustomerCount() {

		return custRepo.count();//3....................................................
	}

	@Override
	public Iterable<Customer> showAllCustomers() {

		
		return custRepo.findAll();//4....................................................
	}

	@Override
	public Iterable<Customer> showAllCustomersByIds(Iterable<Integer> ids) {

		return custRepo.findAllById(ids);//5...............................................
	}

	@Override
	public String registerGroupCustomer(List<Customer> custList) {

		Iterable<Customer> saveAll = custRepo.saveAll(custList);//6...............................
		return custList.size()+" Records are inserted";
	}
	
	  @Override 
	  public Customer showCustomerById(int id) {
	  
	  Optional<Customer> opt = custRepo.findById(id);//6..........................................
	  Customer c = new Customer("inHouseCustomer", "delhi", 0.0f);
	  
	  if(opt.isPresent())
	  { 
	     return opt.get();
	  } 
	  else 
	  { 
	     // throw new IllegalArgumentException("Invalid Id.");
		  return c;
	  }
	 }
	 



	@Override
	//Full Object Updation.   //7...........................................................
	public String registerOrUpdateCustomer(Customer cust) {

		Optional<Customer> opt = custRepo.findById(cust.getCno());
		if(opt.isPresent())
		{
			custRepo.save(cust);
			return cust.getCno()+"CUstomer is updated";
		}
		else
		{
			Customer save = custRepo.save(cust);
			return save.getCno()+"Customer is saved.";
		}

	}

	@Override
	//Partial Object updation.    //8..........................................................
	public String updateCustomerAddress(int cno, String newAddress) {
		
		Optional<Customer> opt = custRepo.findById(cno);
		if(opt.isPresent())
		{
			Customer cust = opt.get();
			cust.setCadd(newAddress);
			custRepo.save(cust);
			return cno+" Customer Address Is Updated.";
		}

		return cno+" Customer is not found for updation.";
	}

	@Override
	//deleteById()
	public String removeCustomerById(int cno) {
		
		Optional<Customer> opt = custRepo.findById(cno);
		if(opt.isPresent())
		{
			custRepo.deleteById(cno);//9..............................................................
			return cno+" Customer Is Deleted.";
		}
		
		return cno+" Customer Is Not Found For Deletion.";
	}

	@Override
	public String removeCustomer(Customer cust) {
		
		Optional<Customer> opt = custRepo.findById(cust.getCno());
		if(opt.isPresent())
		{
			custRepo.delete(cust);//10..........................................................
			return cust.getCno()+" Customer Is Deleted.";
		}

		return cust.getCno()+" Customer Is Not Found For Deletion.";
	}
	

}
