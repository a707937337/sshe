package sy.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;

import sy.model.SyGoods;
import sy.pageModel.Goods;
import sy.service.GoodsServiceI;
import sy.util.BaseAction;

/**
 * 创建人:WangHuifeng 创建时间:2012-11-2 下午2:07:08
 */
@Action(value="goodsAction",results={@Result(name="goods",location="/admin/goods.jsp")})
public class GoodsAction extends BaseAction implements ModelDriven<Goods> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Goods getModel() {
		return goods;
	}

	@Autowired
	private GoodsServiceI goodsService;

	public GoodsServiceI getGoodsService() {
		return goodsService;
	}

	public void setGoodsService(GoodsServiceI goodsService) {
		this.goodsService = goodsService;
	}

	private Goods goods = new Goods();

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String goods(){
		return "goods";
	}
	
	public void dataGrid(){
		super.writeJson(goodsService.find(goods));
	}
}
