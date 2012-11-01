package sy.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import sy.dao.MenuDaoI;
import sy.model.SyMenu;
import sy.pageModel.Menu;
import sy.pageModel.util.TreeNode;
@Service("menuDao")
public class MenuDaoImpl extends BaseDaoImpl<SyMenu> implements MenuDaoI {

	@Override
	public List<TreeNode> tree(Menu m, Boolean b) {
		List<Object> param=new ArrayList<Object>();
		String hql="from SyMenu sy where sy.syMenu is null order by sy.seq";
		if(m!=null && m.getId()!=null&& !m.getId().trim().equals("")){
			hql="from SyMenu sy where sy.syMenu.id=? order by sy.seq";
			param.add(m.getId());
		}
		List<SyMenu> list=this.find(hql,param);
		List<TreeNode> tree=new ArrayList<TreeNode>();
		for(SyMenu mu:list){
			tree.add(createTreeNode(mu,b));
		}
		return tree;
	}

	private TreeNode createTreeNode(SyMenu mu, Boolean b) {
		TreeNode node=new TreeNode();
		node.setId(mu.getId());
		node.setText(mu.getText());
		Map<String,Object> attributes=new HashMap<String,Object>();
		attributes.put("src", mu.getSrc());
		node.setAttributes(attributes);
		if(mu.getIconcls()!=null){
			node.setIconCls(mu.getIconcls());
		}else{
			node.setIconCls("");
		}
		if(mu.getSyMenus()!=null && mu.getSyMenus().size()>0){
			node.setState("closed");
			if(b){
				List<SyMenu> l = new ArrayList<SyMenu>(mu.getSyMenus());
				List<TreeNode> children=new ArrayList<TreeNode>();
					for (SyMenu e : l ){
						children.add(createTreeNode(e, b));
					}
				node.setChildren(children);
				node.setState("open");
			}
		}
		return node;
	}
	
}
