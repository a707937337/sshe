package sy.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;

import sy.model.Tuser;
import sy.service.UserServiceI;
import sy.util.BaseAction;

@ParentPackage("basePackage")// 这里是package的name
@Namespace("/")//命名空间
@Action(value = "userAction",results={@Result(name="test",type="redirectAction", location="userAction!save.action")})//这里是action的name,放这里得支持动态方法调用  例如:xxxAction!add.action
public class UserAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(UserAction.class);
	private String name;
	private String password;
	private String json;
	@Autowired
	private UserServiceI userService;
	public void reg(){
		Map<String,Object> json=new HashMap<String,Object>();
		Tuser u=new Tuser();
		u.setName(name);
		u.setPassword(password);
		try {
			userService.save(u);
			json.put("success", true);
			json.put("msg", "注册成功");
		} catch (Exception e) {
			json.put("success", false);
			json.put("msg", "注册失败");
			e.printStackTrace();
		}
		writeJson(json);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getJson() {
		return json;
	}
	public void setJson(String json) {
		this.json = json;
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

}
