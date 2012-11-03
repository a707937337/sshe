package sy.service;

import java.util.List;

import sy.model.SyUser;
import sy.pageModel.User;

public interface UserServiceI {
	public void test();
	public void reg(User user);
	/**
	 * @param user
	 * @return
	 * 2012-11-1 下午4:23:17
	 */
	public User login(User user);
	
	/**
	 * @return
	 * 2012-11-1 下午4:23:55
	 */
	public List<SyUser> find();
}
