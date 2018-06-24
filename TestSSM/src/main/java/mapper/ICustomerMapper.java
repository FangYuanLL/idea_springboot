package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import entity.Customer;

@Repository
public interface ICustomerMapper {
	@Insert("insert into customer(flower_id,flower_name,flower_price,updateStatus) values (#{flower_id},#{flower_name},#{flower_price},#{updateStatus})")
	public int addCustomer(Customer customer);
	
	@Select("select * from customer")
	public List<Customer> Record();
	
	@Delete("delete from  customer where id=#{id}")
	public int deleteCustomer(int id);
	
	@Update("update customer set updateStatus=1 where id=#{id}")
	public int check(int id);
}
