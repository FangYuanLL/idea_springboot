package service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import entity.Flower;
import mapper.IFlowerMapper;



@Service
public class FlowerService {
	private IFlowerMapper iFlowerMapper;
	
	@Autowired
	public FlowerService(IFlowerMapper iFlowerMapper) {
		this.iFlowerMapper=iFlowerMapper;
	}
	
	/*public boolean FindFlower(String name) {
		Flower flower=iFlowerMapper.findFlowerByName(name);
		if(flower != null) {
			return true;
		}
		else {
			return false;
		}
	}*/
	
	public Flower FindFlowerByName(String name) {
		Flower flower=iFlowerMapper.findFlowerByName(name);
		if(flower != null) {
			return flower;
		}
		else {
			return null;
		}
	}
	
	public boolean DeleteFlower(int id) {
		int cnt=iFlowerMapper.deleteFlower(id);
		if(cnt>0) {
			return true;
		}
		else {
			return false;
		}
	}
		
	public Flower FindFlowerById(int id2) {
		Flower f = iFlowerMapper.getFlowerById(id2);
		if(f!=null) {
			return f;
		}
		else {
			return null;
		}
	}
	public List<Flower> FindAllFlower(){
		List<Flower> list=new ArrayList<Flower>();
		list=iFlowerMapper.getAllFlowers();
		if(list!=null) {
			return list;
		}
		else {
			System.out.println("/FlowerService中List容器取值为空");
			return null;
		}		
	}
	
	public boolean UpdateFlower(Flower flower) {
		/*Flower newflower= FindFlowerById(flower.getId());
		int price=newflower.getPrice();
		int number=newflower.getNumber();*/
		int flag=iFlowerMapper.updateFlower(flower);
		if(flag>0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean AddFlower(Flower flower)
	{
		int flag=iFlowerMapper.addFlower(flower);
		if(flag>0) {
			return true;
		}
		else return false;
	}
}
	
	
	

