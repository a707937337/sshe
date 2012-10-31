package sy.action;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;

import sy.model.Tuser;
import sy.pageModel.User;
import sy.service.UserServiceI;
import sy.util.BaseAction;

@ParentPackage("basePackage")// 这里是package的name
@Namespace("/")//命名空间
@Action(value = "userAction")//这里是action的name,放这里得支持动态方法调用  例如:xxxAction!add.action
public class UserAction extends BaseAction implements ModelDriven<User>{
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(UserAction.class);
	User user=new User();
	@Override
	public User getModel() {
		return user;
	}
	@Autowired
	private UserServiceI userService;
	public void reg(){
		Map<String,Object> json=new HashMap<String,Object>();
		Tuser u=new Tuser();
		u.setId(UUID.randomUUID().toString());
		u.setName(user.getName());
		u.setPassword(user.getPassword());
		try {
			userService.save(u);
			json.put("success", true);
			json.put("msg", "注册成功");
		} catch (Exception e) {
			json.put("success", false);
			json.put("msg", "注册失败");
			e.printStackTrace();
		}
		super.writeJson(json);
	}
	public UserServiceI getUserService() {
		return userService;
	}
	public void setUserService(UserServiceI userService) {
		this.userService = userService;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public static Logger getLogger() {
		return logger;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	

}
