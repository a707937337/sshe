package sy.dao;

import java.util.List;

import sy.model.SyMenu;
import sy.pageModel.Menu;
import sy.pageModel.util.TreeNode;

public interface MenuDaoI extends BaseDaoI<SyMenu> {
	public List<TreeNode> tree(Menu m,Boolean b);
}
