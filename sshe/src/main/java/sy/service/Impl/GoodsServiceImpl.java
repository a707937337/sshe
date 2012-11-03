/**
 * 创建人:WangHuifeng
 * 创建时间:2012-11-2 下午2:05:54
 */
package sy.service.Impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sy.dao.GoodsDaoI;
import sy.dao.impl.BaseDaoImpl;
import sy.model.SyGoods;
import sy.pageModel.Goods;
import sy.pageModel.util.DataGrid;
import sy.service.GoodsServiceI;

/**
 * 创建人:WangHuifeng
 * 创建时间:2012-11-2 下午2:05:54
 */
@Service("goodsService")
public class GoodsServiceImpl extends BaseDaoImpl<SyGoods> implements GoodsServiceI {
	
	@Autowired
	private GoodsDaoI goodsDao;
	public GoodsDaoI getGoodsDao() {
		return goodsDao;
	}
	public void setGoodsDao(GoodsDaoI goodsDao) {
		this.goodsDao = goodsDao;
	}
	@Override
	public DataGrid find(Goods goods) {
		DataGrid j=new DataGrid();
		String hql="from SyGoods sy where 1=1";
		Map<String,Object> map=new HashMap<String,Object>();
		hql=addWhereSql(hql,goods,map);
		if (goods.getSort() != null && goods.getOrder() != null) {
			hql += " order by " + goods.getSort() + " " + goods.getOrder();
		}
		j.setRows(changeModel(goodsDao.find(hql,map,goods.getPage(),goods.getRows())));
		j.setTotal(this.total(goods));
		return j;
	}
	
	/**
	 * 创建hql语句
	 */
	private String addWhereSql(String hql,Goods goods,Map<String,Object> map){
		if(goods.getName()!=null&&!goods.getName().trim().equals("")){
			hql+=" and sy.name like '%%" + goods.getName().trim() + "%%' ";
		}
		if(goods.getCreatetimeEnd()!=null){
			hql+=" and sy.createtime<=:createtimeEnd";
			map.put("createtimeEnd", goods.getCreatetimeEnd());
		}
		if(goods.getCreatetimeStart()!=null){
			hql+=" and sy.createtime>=:createtimeStart";
			map.put("createtimeStart", goods.getCreatetimeStart());
		}
		if(goods.getModifytimeStart()!=null){
			hql+=" and sy.modifytime>=:modifytimeStart";
			map.put("modifytimeStart", goods.getModifytimeStart());
		}
		if(goods.getModifytimeEnd()!=null){
			hql+=" and sy.modifytime<:modifytimeEnd";
			map.put("modifytimeEnd", goods.getModifytimeEnd());
		}
		if(goods.getBn()!=null &&!goods.getBn().trim().equals("")){
			hql+=" and sy.bn=:bn";
			map.put("bn", goods.getBn().trim());
		}
		return hql;
	}
	private List<Goods> changeModel(List<SyGoods> syGoods) {
		List<Goods> goods = new ArrayList<Goods>();
		if (syGoods != null && syGoods.size() > 0) {
			for (SyGoods sy : syGoods) {
				Goods g=new Goods();
				BeanUtils.copyProperties(sy, g);
				goods.add(g);
			}
		}
		return goods;
	}
	
	public Long total(Goods goods){
		String hql="select count(*) from SyGoods sy where 1=1";
		Map<String,Object> map=new HashMap<String,Object>();
		hql=addWhereSql(hql, goods, map);
		return goodsDao.count(hql, map);
	}
	
	public static void main(String[] args) throws SecurityException, NoSuchFieldException {
		Goods goods=new Goods();
		for (int i = 0; i < goods.getClass().getMethods().length; i++) {
			System.out.println(goods.getClass().getMethods()[i]);
		}
	}
}
