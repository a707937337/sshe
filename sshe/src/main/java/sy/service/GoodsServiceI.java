package sy.service;

import java.util.List;
import java.util.Map;

import sy.dao.BaseDaoI;
import sy.model.SyGoods;
import sy.pageModel.Goods;
import sy.pageModel.util.DataGrid;

/**
 * 创建人:WangHuifeng
 * 创建时间:2012-11-2 下午2:06:55
 */

public interface GoodsServiceI extends BaseDaoI<SyGoods>{
	public DataGrid find(Goods goods);
}
