package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import entity.Administrator;
import entity.Customer;
import entity.Flower;
import service.CustomerService;
import service.FlowerService;

@Controller
@RequestMapping("/Flower")
public class FlowerController {
	@Autowired
	private FlowerService flower;
	
	@Autowired
	private CustomerService customerService;
	/*List<Customer> list=new ArrayList<Customer>();
	HttpSession session = null;
	int id=0;*/
	//不能直接跳到显示页面，会出现无数据现象
	@RequestMapping("/")
	public String index() {
		return "flower/administrator";
	}
	
	@RequestMapping("/index")
	public String index1() {
		return "flower/index";
	}
	//地址重定义，定向到控制器AccountController的路径
	@RequestMapping("/Login")
	public String login() {
		return "redirect:/Account/";
	}
	@RequestMapping("/Register")
	public String register() {
		return "redirect:/Account/register";
	}
	//为了跳转到另一个控制器的账单页面
	@RequestMapping("/Bill")
	public String Bill() {
		return "redirect:/Customer/show";
	}
	//查看管理员的后台账单信息
	@RequestMapping("/Boss")
	public String Boss() {
		return "redirect:/Customer/show1";
	}
	@RequestMapping("/AdministratorLogin")
	public String AdministratorLogin() {
		return "flower/administratorLogin";
	}
	@RequestMapping("/addFlower")
	public String AddFlower() {
		return "flower/addflower";
	}
	
	@RequestMapping("/FlowerInformation")
	public String FlowerInformation(Flower flower1,RedirectAttributes redirectAttributes) {
		boolean flag=flower.AddFlower(flower1);
		if(flag) {
			return "redirect:/Flower/FindAll";
		}
		else {
			return "redirect:/Flower/addFlower";
		}
	}
	//修改花的信息
	@RequestMapping("/Revise")
	public String revise() {
		//System.out.println("11111");
		return "flower/update";
	}
	@RequestMapping("/viewmore")
	public String viewmore() {
		return "flower/ViewMore";
	}
	
	@RequestMapping("/Logincheck")
	public String Logincheck(Administrator admini,RedirectAttributes redirectAttributes) {
		System.out.println(admini.getUsername());
		String username=admini.getUsername();
		String password=admini.getPassword();
		if(username.equals("123")&&password.equals("123"))
		{
			return "redirect:/Flower/FindAll";
		}
		else {
			redirectAttributes.addFlashAttribute("errorMsg","输入密码或账号有误");
			System.out.println("Administrator登录有误！");
			return "redirect:/Flower/AdministratorLogin";
		}
	}
	@RequestMapping("/ViewMore")
	public String ViewMore(Flower flower1,RedirectAttributes redirectAttributes) {	
		Flower newflower=flower.FindFlowerById(flower1.getId());
		System.out.println(newflower.getId());
		System.out.println(newflower.getName());
		redirectAttributes.addFlashAttribute("newflower", newflower);
		return "redirect:/Flower/viewmore";
	}
	//根据名字查找花
	@RequestMapping("/Find")
	public String Find(Flower fl,RedirectAttributes redirectAttributes) {
		String name=fl.getName();
		Flower f=flower.FindFlowerByName(name);
		List<Flower> list=new ArrayList<Flower>();
		list.add(f);
		if(f!=null) {
			redirectAttributes.addFlashAttribute("list", list);
			return "redirect:/Flower/index";
		}
		else {
			return "redirect:/Flower/";
		}
	}
	//前台页面显示数据的查找
	@RequestMapping("/ListAllFlower")
	public String ListAllFlower(RedirectAttributes redirectAttributes) {
		
		List<Flower> list=new ArrayList<Flower>();
		list=flower.FindAllFlower();
		redirectAttributes.addFlashAttribute("list", list);
		return "redirect:/Flower/index";
	}
	//添加到购物车
	@RequestMapping("/Customer")
	public String customer(Flower flower1) {
		int check=0;
		Flower newflower=flower.FindFlowerById(flower1.getId());
		Customer customer=new Customer();
		customer.setFlower_id(newflower.getId());
		customer.setFlower_name(newflower.getName());
		customer.setFlower_price(newflower.getPrice());
		customer.setUpdateStatus(check);
		customerService.add(customer);
		
		return "redirect:/Flower/ListAllFlower";
	}
	
	//查找所有的花,后台管理页面的查询
	@RequestMapping("/FindAll")
	public String FindAll(RedirectAttributes redirectAttributes) {
		List<Flower> list=new ArrayList<Flower>();
		list=flower.FindAllFlower();
		redirectAttributes.addFlashAttribute("list", list);
		return "redirect:/Flower/";
	}
	//根据id删除花，然后跳转到显示页面index
	@RequestMapping("/Delete")
	public String Delete(int id,RedirectAttributes redirectAttributes) {
		//int ID=Integer.parseInt(id);
		boolean flag=flower.DeleteFlower(id);
		if(flag) {
			return "redirect:/Flower/FindAll";
		}
		else {
			//没有写错误处理的显示页面，后期加上
			System.out.println("通过id删除错误");
			return "redirect:/Flower/FindAll";
		}
	}
	//更新数据主要更新花的数量和价格，客户买了之后会减少花的数量，直至数量为0，然后就必须删除这一类的花
	@RequestMapping("/Update")
	public String Update(Flower flower1,RedirectAttributes redirectAttributes)
	{
		//flower1只有id一个有数据，其他数据皆为空，从前台传过来然后自动包装到这个类里
		//mapper接口层的UpdateFlower只能传一个类的数据，多个数据需要封装下，一个数据就不需要了
		Flower newflower=flower.FindFlowerById(flower1.getId());
		
		//System.out.println(flower1.getId());
		//System.out.println(newflower.getId()+";"+newflower.getPrice());
	
		redirectAttributes.addFlashAttribute("newflower",newflower);
		return "redirect:/Flower/Revise";
	
	}
	//接受update传来的数据，并修改数据库数据
	@RequestMapping("/newUpdate")
	public String newUpdate(Flower flower1,RedirectAttributes redirectAttributes)
	{
		boolean flag=flower.UpdateFlower(flower1);
		System.out.println(flower1.getPrice()+","+flower1.getNumber());
		if(flag) {
			return "redirect:/Flower/FindAll";
		}
		else {
			System.out.println("newupdate更新错误");
			return "redirect:/Flower/FindAll";
		}
	}
	
	@RequestMapping("/add")
	public String add() {
		return "flower/addflower";
	}

}
