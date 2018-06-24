package service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.Customer;
import mapper.ICustomerMapper;
@Service
public class CustomerService {
	private ICustomerMapper cuMapper;
	
	@Autowired
	public CustomerService(ICustomerMapper cuMapper) {
		this.cuMapper=cuMapper;
	}
	
	public boolean add(Customer customer) {
		int cnt=cuMapper.addCustomer(customer);
		if(cnt>0) {
			return  true;
		}
		else
		{
			return false;
		}
	}
	public List<Customer> select(){
		List<Customer> list=new ArrayList<Customer>();
		list=cuMapper.Record();
		if(list!=null) {
			return list;
		}
		else {
			System.out.println("Customer¼ÇÂ¼·µ»Ø´íÎó");
			return null;
		}
	}
	
	public boolean Delete(int id) {
		int cnt=cuMapper.deleteCustomer(id);
		if(cnt>0) return true;
		else return false;
	}
	
	public boolean Check(int id) {
		int cnt=cuMapper.check(id);
		if(cnt>0) return true;
		else return false;
	}
}
