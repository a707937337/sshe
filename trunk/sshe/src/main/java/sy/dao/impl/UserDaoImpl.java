package sy.dao.impl;

import org.springframework.stereotype.Service;

import sy.dao.UserDaoI;
import sy.model.SyUser;
import sy.pageModel.User;

@Service("userDao")
public class UserDaoImpl extends BaseDaoImpl<SyUser> implements UserDaoI {
	@Override
	public User login(User user) {
		String hql = "from SyUser u where u.name=? and u.password=?";
		SyUser tuser = this.get(hql, new Object[] { user.getName(), user.getPassword() });
		if(tuser!=null){
			User u=new User();
			u.setId(tuser.getId());
			u.setPassword(tuser.getPassword());
			u.setName(tuser.getName());
			return u;
		}
		return null;
	}

}
