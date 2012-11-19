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

import sy.model.SyUser;
import sy.pageModel.User;
import sy.pageModel.util.Json;
import sy.service.UserServiceI;
import sy.util.BaseAction;
 

/**
 * 创建人： 王汇丰
 * 创建时间：2012-10-31 下午5:40:15
 */
/**
 * 创建人:WangHuifeng
 * 创建时间:2012-11-1 下午4:13:43
 */
 
@Action(value = "userAction",results={@Result(name="user",location="/admin/user.jsp")})//这里是action的name,放这里得支持动态方法调用  例如:xxxAction!add.action
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
	/**
	 * 创建人:WangHuifeng
	 * 创建时间:2012-10-31 下午1:49:58
	 * @return void
	 */
	public void reg(){
		Json j=new Json();
		try {
			userService.reg(user);
			j.setSuccess(true);
			j.setMsg("注册成功");
			j.setObj(null);
		} catch (Exception e) {
			j.setMsg("注册失败！");
			e.printStackTrace();
		}
		super.writeJson(j);
	}
	
	/**
	 * 登陆action
	 * @return void
	 * 2012-11-1 下午4:09:53
	 */
	public void login(){
		Json j=new Json();
		User u=userService.login(user);
		if(u!=null){
			j.setSuccess(true);
			j.setMsg("登陆成功");
			j.setObj(null);
			session.put("currentUser", user);
		}else{
			j.setMsg("登陆失败");
		}
		super.writeJson(j);
	}
	
	/**
	 * @return
	 * 2012-11-1 下午4:13:45
	 */
	public String user(){
		return "user";
	}
	/**
	 * 获取用户表格内容
	 * 2012-11-1 下午4:20:18
	 */
	public void datagrid(){
		
	}
	

}
