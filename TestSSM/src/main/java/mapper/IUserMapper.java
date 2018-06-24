package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import entity.User;

@Repository
public interface IUserMapper {
	@Insert("insert into users(username,password,phone,adress) value(#{username},#{password},#{phone},#{adress})")
	public int addUser(User user);
	
	@Delete("delete from  users where id=#{id}")
	public int deleteUser(int id);
	
	@Update("update users set username=#{username},password=#{password} where id=#{id}")
	public int updateUser(User user);
	
	@Select("select * from users where id=#{id}")
	public User getUserById(int id);
	
	@Select("select * from users  where username=#{username} and password=#{password}")
	public User findUser(User user);
	
	@Select("select * from users where username=#{username}")
	public User findUserByUserName(String username);
	
	@Select("select * from users")
	public List<User> getAllUsers();
}
