package sy.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 创建人:WangHuifeng
 * 创建时间:2012-10-31 下午2:29:39
 */
 
public interface BaseDaoI<T> {

	/**
	 * 保存一个对象
	 * 
	 * @param o
	 * @return
	 */
	public Serializable save(T o);

	/**
	 * 删除一个对象
	 * 
	 * @param o
	 */
	public void delete(T o);

	/**
	 * 更新一个对象
	 * 
	 * @param o
	 */
	public void update(T o);

	/**
	 * 保存或更新对象
	 * 
	 * @param o
	 */
	public void saveOrUpdate(T o);

	/**
	 * 查询
	 * 
	 * @param hql
	 * @return
	 */
	public List<T> find(String hql);

	/**
	 * 查询集合
	 * 
	 * @param hql
	 * @param param
	 * @return
	 */
	public List<T> find(String hql, Object[] param);

	/**
	 * 查询集合
	 * 
	 * @param hql
	 * @param param
	 * @return
	 */
	public List<T> find(String hql, List<Object> param);
	
	/**
	 * 查询集合
	 * @param hql
	 * @param param
	 * @return
	 * 2012-11-2 上午9:27:54
	 */
	public List<T> find(String hql,Map<String,Object> param); 

	/**
	 * 查询集合(带分页)
	 * 
	 * @param hql
	 * @param param
	 * @param page
	 *            查询第几页
	 * @param rows
	 *            每页显示几条记录
	 * @return
	 */
	public List<T> find(String hql, Object[] param, Integer page, Integer rows);

	/**
	 * 查询集合(带分页)
	 * 
	 * @param hql
	 * @param param
	 * @param page
	 * @param rows
	 * @return
	 */
	public List<T> find(String hql, List<Object> param, Integer page, Integer rows);
	
	
	/**
	 * 查询集合(带分页)
	 * @param hql
	 * @param param
	 * @param page
	 * @param rows
	 * @return
	 * 2012-11-2 上午9:29:20
	 */
	public List<T> find(String hql,Map<String,Object> param ,Integer page,Integer rows);

	/**
	 * 获得一个对象
	 * 
	 * @param c
	 *            对象类型
	 * @param id
	 * @return Object
	 */
	public T get(Class<T> c, Serializable id);

	/**
	 * 获得一个对象
	 * 
	 * @param hql
	 * @param param
	 * @return Object
	 */
	public T get(String hql, Object[] param);

	/**
	 * 获得一个对象
	 * 
	 * @param hql
	 * @param param
	 * @return
	 */
	public T get(String hql, List<Object> param);

	/**
	 * 获得一个对象
	 * @param hql
	 * @param param
	 * @return
	 * 2012-11-2 上午9:30:06
	 */
	public T get(String hql,Map<String,Object> param);
	/**
	 * select count(*) from 类
	 * 
	 * @param hql
	 * @return
	 */
	public Long count(String hql);

	/**
	 * select count(*) from 类
	 * 
	 * @param hql
	 * @param param
	 * @return
	 */
	public Long count(String hql, Object[] param);

	/**
	 * select count(*) from 类
	 * 
	 * @param hql
	 * @param param
	 * @return
	 */
	public Long count(String hql, List<Object> param);
	
	/**
	 * select count(*) from 类
	 * @param hql
	 * @param param
	 * @return
	 * 2012-11-2 下午2:01:17
	 */
	public Long count(String hql,Map<String,Object> param);

	/**
	 * 执行HQL语句
	 * 
	 * @param hql
	 * @return 响应数目
	 */
	public Integer executeHql(String hql);

	/**
	 * 执行HQL语句
	 * 
	 * @param hql
	 * @param param
	 * @return 响应数目
	 */
	public Integer executeHql(String hql, Object[] param);

	/**
	 * 执行HQL语句
	 * 
	 * @param hql
	 * @param param
	 * @return
	 */
	public Integer executeHql(String hql, List<Object> param);
	
	/**
	 * 执行HQL语句
	 * @param hql
	 * @param param
	 * @return
	 * 2012-11-2 下午2:00:42
	 */
	public Integer executeHql(String hql,Map<String,Object> param);

}
