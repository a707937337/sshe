package sy.service;

import java.util.List;

import sy.pageModel.Menu;
import sy.pageModel.util.TreeNode;

public interface MenuServiceI {
	public List<TreeNode> tree(Menu mu,Boolean b);
}
