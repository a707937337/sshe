package sy.service.Impl;

import javax.management.RuntimeErrorException;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sy.dao.UserDaoI;
import sy.model.Tuser;
import sy.service.UserServiceI;
@Service("userService")
public class UserServiceImpl implements UserServiceI{
	private static final Logger logger = Logger.getLogger(UserServiceImpl.class);
	@Autowired
	private UserDaoI userDao;
	@Override
	public void test() {
		logger.info("测试!");
	}
	public void save(Tuser u){
		userDao.save(u);
	}
	public UserDaoI getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDaoI userDao) {
		this.userDao = userDao;
	}
	
}
