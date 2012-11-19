package sy.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;

import sy.pageModel.Menu;
import sy.pageModel.util.TreeNode;
import sy.service.MenuServiceI;
import sy.util.BaseAction;

/**
 * 创建人： 王汇丰 创建时间：2012-10-31 下午7:56:26
 */

@Action(value = "menuAction")
public class MenuAction extends BaseAction implements ModelDriven<Menu> {
	private Menu menu=new Menu();

	@Autowired
	private MenuServiceI menuService;

	public MenuServiceI getMenuService() {
		return menuService;
	}

	public void setMenuService(MenuServiceI menuService) {
		this.menuService = menuService;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	@Override
	public Menu getModel() {
		return menu;
	}

	public void tree() {
		List<TreeNode> tree=menuService.tree(menu, false);
		writeJson(tree);
	}
}
