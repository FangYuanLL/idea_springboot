package service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import entity.User;
import mapper.IUserMapper;

@Service
public class UserService{
	private IUserMapper iUserMapper;
	
	@Autowired
	public UserService(IUserMapper iUserMapper) {
		this.iUserMapper=iUserMapper;
	}
	
	public boolean login(User user){
		User u=iUserMapper.findUser(user);
		if(u!=null) return true;
		else return false;
	}
	
	@Transactional
	public boolean register(User user) {
		int cnt=iUserMapper.addUser(user);
		if(cnt!=0) return true;
		else return false;
	}
	
	public boolean findUser(String username) {
		User u=iUserMapper.findUserByUserName(username);
		if(u!=null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean Update(User user) {
		int cnt=iUserMapper.updateUser(user);
		if(cnt>0) {
			return true;
		}
		else {
			return false;
		}
	}
	public List<User> getAllUser(){
		List<User> list=new ArrayList<User>();
		list=iUserMapper.getAllUsers();
		return list;
	}
}
