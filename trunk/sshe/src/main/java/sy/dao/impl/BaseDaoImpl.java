package sy.dao.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sy.dao.BaseDaoI;
@Repository("baseDao")
@SuppressWarnings("unchecked")
public class BaseDaoImpl<T> implements BaseDaoI<T>{
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	/**
	 * 获取当前session
	 * @return
	 * 2012-11-2 上午9:42:51
	 */
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	/**
	 * 保存对象
	 * @param o
	 * @return
	 * 2012-11-2 上午9:41:52
	 */
	public Serializable save(T o) {
		return this.getCurrentSession().save(o);
	}
	/**
	 * 删除对象
	 * @param o
	 * 2012-11-2 上午9:41:55
	 */
	public void delete(T o) {
		this.getCurrentSession().delete(o);
	}

	/**
	 * 更新对象
	 * @param o
	 * 2012-11-2 上午9:41:57
	 */
	public void update(T o) {
		this.getCurrentSession().update(o);
	}

	/**
	 * 更新或保存对象
	 * @param o
	 * 2012-11-2 上午9:42:00
	 */
	public void saveOrUpdate(T o) {
		this.getCurrentSession().saveOrUpdate(o);
	}

	/**
	 * 查询集合
	 * @param hql
	 * @return
	 * 2012-11-2 上午9:42:02
	 */
	public List<T> find(String hql) {
		return this.getCurrentSession().createQuery(hql).list();
	}

	/**
	 * 查询集合
	 * @param hql
	 * @param param
	 * @return
	 * 2012-11-2 上午9:42:04
	 */
	public List<T> find(String hql, Object[] param) {
		Query q = this.getCurrentSession().createQuery(hql);
		if (param != null && param.length > 0) {
			for (int i = 0; i < param.length; i++) {
				q.setParameter(i, param[i]);
			}
		}
		return q.list();
	}

	/**
	 * 查询集合
	 * @param hql
	 * @param param
	 * @return
	 * 2012-11-2 上午9:42:06
	 */
	public List<T> find(String hql, List<Object> param) {
		Query q = this.getCurrentSession().createQuery(hql);
		if (param != null && param.size() > 0) {
			for (int i = 0; i < param.size(); i++) {
				q.setParameter(i, param.get(i));
			}
		}
		return q.list();
	}

	/**
	 * 查询集合
	 * @param hql
	 * @param param
	 * @return
	 * 2012-11-2 上午9:42:08
	 */
	public List<T> find(String hql,Map<String,Object> param){
		Query q=this.getCurrentSession().createQuery(hql);
		if(param!=null&&!param.isEmpty()){
			for (String key : param.keySet()) {
				q.setParameter(key, param.get(key));
			}
		}
		return q.list();
	}
	/**
	 * 查询集合(带分页)
	 * @param hql
	 * @param param
	 * @param page
	 * 			查询第几页
	 * @param rows
	 * 			每页多少条
	 * @return
	 * 2012-11-2 上午9:42:10
	 */
	public List<T> find(String hql, Object[] param, Integer page, Integer rows) {
		if (page == null || page < 1) {
			page = 1;
		}
		if (rows == null || rows < 1) {
			rows = 10;
		}
		Query q = this.getCurrentSession().createQuery(hql);
		if (param != null && param.length > 0) {
			for (int i = 0; i < param.length; i++) {
				q.setParameter(i, param[i]);
			}
		}
		return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
	}

	/**
	 * 查询集合(带分页)
	 * @param hql
	 * @param param
	 * @param page
	 * 			查询第几页
	 * @param rows
	 * 			每页多少条
	 * @return
	 * 2012-11-2 上午9:42:10
	 */
	public List<T> find(String hql, List<Object> param, Integer page, Integer rows) {
		if (page == null || page < 1) {
			page = 1;
		}
		if (rows == null || rows < 1) {
			rows = 10;
		}
		Query q = this.getCurrentSession().createQuery(hql);
		if (param != null && param.size() > 0) {
			for (int i = 0; i < param.size(); i++) {
				q.setParameter(i, param.get(i));
			}
		}
		return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
	}
	/**
	 * 查询集合(带分页)
	 * @param hql
	 * @param param
	 * @param page
	 * 			查询第几页
	 * @param rows
	 * 			每页多少条
	 * @return
	 * 2012-11-2 上午9:42:10
	 */
	public List<T> find(String hql,Map<String,Object> param,Integer page,Integer rows){
		if(page==null||page<1){
			page =1;
		}
		if(rows==null||rows<1){
			rows=10;
		}
		Query q=this.getCurrentSession().createQuery(hql);
		if(param!=null&& !param.isEmpty()){
			for (String key : param.keySet()) {
				q.setParameter(key, param.get(key));
			}
		}
		return q.setFirstResult((page-1)*rows).setMaxResults(rows).list();
	}

	/**
	 * 获取一个对象
	 * @param c 对象类型
	 * @param id
	 * @return
	 * 2012-11-2 上午9:42:21
	 */
	public T get(Class<T> c, Serializable id) {
		return (T) this.getCurrentSession().get(c, id);
	}

	/**
	 * 获取一个对象
	 * @param hql
	 * @param param
	 * @return
	 * 2012-11-2 上午9:42:24
	 */
	public T get(String hql, Object[] param) {
		List<T> l = this.find(hql, param);
		if (l != null && l.size() > 0) {
			return l.get(0);
		} else {
			return null;
		}
	}

	/**
	 * 获取一个对象
	 * @param hql
	 * @param param
	 * @return
	 * 2012-11-2 上午9:42:26
	 */
	public T get(String hql, List<Object> param) {
		List<T> l = this.find(hql, param);
		if (l != null && l.size() > 0) {
			return l.get(0);
		} else {
			return null;
		}
	}
	
	/**
	 * 获取一个对象
	 * @param hql
	 * @param param
	 * @return
	 * 2012-11-2 上午9:42:28
	 */
	public T get(String hql,Map<String,Object> param){
		List<T> l=this.find(hql, param);
		if(l!=null&& l.size()>0){
			return l.get(0);
		}else{
			return null;
		}
	}

	/**
	 * select count(*) from 类
	 * @param hql
	 * @return
	 * 2012-11-2 上午9:42:31
	 */
	public Long count(String hql) {
		return (Long) this.getCurrentSession().createQuery(hql).uniqueResult();
	}

	/**
	 * select count(*) from 类
	 * @param hql
	 * @param param
	 * @return
	 * 2012-11-2 上午9:42:33
	 */
	public Long count(String hql, Object[] param) {
		Query q = this.getCurrentSession().createQuery(hql);
		if (param != null && param.length > 0) {
			for (int i = 0; i < param.length; i++) {
				q.setParameter(i, param[i]);
			}
		}
		return (Long) q.uniqueResult();
	}

	/**
	 * select count(*) from 类
	 * @param hql
	 * @param param
	 * @return
	 * 2012-11-2 上午9:42:35
	 */
	public Long count(String hql, List<Object> param) {
		Query q = this.getCurrentSession().createQuery(hql);
		if (param != null && param.size() > 0) {
			for (int i = 0; i < param.size(); i++) {
				q.setParameter(i, param.get(i));
			}
		}
		return (Long) q.uniqueResult();
	}

	/**
	 * select count(*) from 类
	 * @param hql
	 * @param param
	 * @return
	 * 2012-11-2 上午9:46:30
	 */
	public Long count(String hql,Map<String,Object> param){
		Query q = this.getCurrentSession().createQuery(hql);
		if (param != null && !param.isEmpty()) {
			for (String key : param.keySet()) {
				q.setParameter(key, param.get(key));
			}
		}
		return (Long) q.uniqueResult();
	}
	/**
	 * 执行HQL语句
	 * @param hql
	 * @return 响应数目
	 * 2012-11-2 上午9:42:38
	 */
	public Integer executeHql(String hql) {
		return this.getCurrentSession().createQuery(hql).executeUpdate();
	}

	/**
	 * 执行HQL语句
	 * @param hql
	 * @param param
	 * @return 响应数目
	 * 2012-11-2 上午9:42:40
	 */
	public Integer executeHql(String hql, Object[] param) {
		Query q = this.getCurrentSession().createQuery(hql);
		if (param != null && param.length > 0) {
			for (int i = 0; i < param.length; i++) {
				q.setParameter(i, param[i]);
			}
		}
		return q.executeUpdate();
	}

	/**
	 * 执行HQL语句
	 * @param hql
	 * @param param
	 * @return 响应数目
	 * 2012-11-2 上午9:42:42
	 */
	public Integer executeHql(String hql, List<Object> param) {
		Query q = this.getCurrentSession().createQuery(hql);
		if (param != null && param.size() > 0) {
			for (int i = 0; i < param.size(); i++) {
				q.setParameter(i, param.get(i));
			}
		}
		return q.executeUpdate();
	}
	/**
	 * 执行HQL语句
	 * @param hql
	 * @param param
	 * @return 响应数目
	 * 2012-11-2 上午9:42:42
	 */
	public Integer executeHql(String hql,Map<String,Object> param){
		Query q = this.getCurrentSession().createQuery(hql);
		if (param != null && !param.isEmpty()) {
			for (String key : param.keySet()) {
				q.setParameter(key, param.get(key));
			}
		}
		return q.executeUpdate();
	}
}
