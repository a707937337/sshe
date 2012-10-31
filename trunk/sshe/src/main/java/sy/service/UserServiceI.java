package sy.service;

import java.util.List;

import sy.model.Tuser;
import sy.pageModel.User;

public interface UserServiceI {
	public void test();
	public void reg(User user);
	/**
	 * 创建人:WangHuifeng
	 * 创建时间:2012-10-31 下午2:34:09
	 * @param user
	 * @return
	 * @return User
	 * @information
	 */
	public User login(User user);
}
