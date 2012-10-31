package sy.dao.impl;

import org.springframework.stereotype.Repository;
import sy.dao.UserDaoI;
import sy.model.Tuser;
import sy.pageModel.User;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<Tuser> implements UserDaoI {
	@Override
	public User login(User user) {
		String hql = "from Tuser u where u.name=? and u.password=?";
		Tuser tuser = this.get(hql, new Object[] { user.getName(), user.getPassword() });
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
