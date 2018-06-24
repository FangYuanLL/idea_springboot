package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import entity.Customer;
import service.CustomerService;

@Controller
@RequestMapping("/Customer")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/")
	public String index() {
		return "customer/trolley";
	}
	@RequestMapping("/true")
	public String index1() {
		return "customer/check";
	}
	@RequestMapping("/show")
	public String show(RedirectAttributes redirectAttributes) {
		List<Customer> list=new ArrayList<Customer>();
		list=customerService.select();
		if(list!=null) {
			redirectAttributes.addFlashAttribute("list", list);
			return "redirect:/Customer/";
		}
		else {
			System.out.println("Customer跳转到trolley有问题");
			return null;
		}
	}
	
	@RequestMapping("/Delete")
	public String delete(Customer customer,RedirectAttributes redirectAttributes) {
		int id=customer.getId();
		boolean flag= customerService.Delete(id);
		if(flag) {
			return "redirect:/Customer/show";
		}
		else {
			System.out.println("删除失败");
			return null;
		}
	}
	@RequestMapping("/check")
	public String check(int id,RedirectAttributes redirectAttributes) {
		boolean flag=customerService.Check(id);
		if(flag) {
			return "redirect:/Customer/show";
		}
		else {
			System.out.println("check失败");
			return null;
		}
	}
	@RequestMapping("/show1")
	public String show1(RedirectAttributes redirectAttributes) {
		List<Customer> list=new ArrayList<Customer>();
		list=customerService.select();
		if(list!=null) {
			redirectAttributes.addFlashAttribute("list", list);
			return "redirect:/Customer/true";
		}
		else {
			System.out.println("Customer跳转到true有问题");
			return null;
		}
	}
}
