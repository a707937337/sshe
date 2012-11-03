package sy.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sy.dao.MenuDaoI;
import sy.pageModel.Menu;
import sy.pageModel.util.TreeNode;
import sy.service.MenuServiceI;

@Service("menuService")
public class MenuServiceImpl implements MenuServiceI{
	@Autowired
	private MenuDaoI menuDao;
	public MenuDaoI getMenuDao() {
		return menuDao;
	}
	public void setMenuDao(MenuDaoI menuDao) {
		this.menuDao = menuDao;
	}
	@Override
	public List<TreeNode> tree(Menu mu, Boolean b) {
		return menuDao.tree(mu, b);
	}

}
