package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import entity.Flower;


@Repository
public interface IFlowerMapper {
	@Insert("insert into flowers(name,price,number,introduction) values (#{name},#{price},#{number},#{introduction})")
	public int addFlower(Flower flower);
	
	@Delete("delete from  flowers where id=#{id}")
	public int deleteFlower(int id);
	
	@Update("update flowers set price=#{price},number=#{number} where id=#{id}")
	public int updateFlower(Flower flower);
	
	@Select("select * from flowers where id=#{id}")
	public Flower getFlowerById(int id);
	
	@Select("select * from flowers  where name=#{name}")
	public Flower findFlowerByName(String name);
	
	@Select("select * from flowers")
	public List<Flower> getAllFlowers();

}
