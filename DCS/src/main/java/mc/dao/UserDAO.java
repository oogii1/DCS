package mc.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import mc.model.User;

public interface UserDAO extends CrudRepository<User, Integer>{
	
	@Query(value = "select * from users b where b.user_name=?1 and b.pwd=?2", 
			nativeQuery = true)
	User findByUserNameAndPwd(String userName, String pwd);
	
	@Query(value = "select * from users b where b.user_name=?1", 
			nativeQuery = true)
	User findByUserName(String userName);

}
