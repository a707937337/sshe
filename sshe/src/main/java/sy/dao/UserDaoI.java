package sy.dao;

import sy.model.Tuser;
import sy.pageModel.User;

public interface UserDaoI extends BaseDaoI<Tuser>{

	/**
	 * 创建人:WangHuifeng
	 * 创建时间:2012-10-31 下午2:39:53
	 * @param user
	 * @return
	 * @return User
	 * @information
	 */
	public User login(User user);
	
}
