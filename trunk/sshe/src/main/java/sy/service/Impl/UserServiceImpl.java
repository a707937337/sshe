package sy.service.Impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sy.dao.UserDaoI;
import sy.model.Tuser;
import sy.pageModel.User;
import sy.service.UserServiceI;

@Service("userService")
public class UserServiceImpl implements UserServiceI {
	private static final Logger logger = Logger.getLogger(UserServiceImpl.class);
	@Autowired
	private UserDaoI userDao;

	@Override
	public void test() {
		logger.info("测试!");
	}

	public UserDaoI getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDaoI userDao) {
		this.userDao = userDao;
	}

	public void save(Tuser u) {
		userDao.save(u);
	}

	@Override
	public User login(User user) {
		return userDao.login(user);
	}
}
