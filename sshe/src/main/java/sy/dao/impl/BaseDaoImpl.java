package sy.dao.impl;

import java.io.Serializable;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sy.dao.BaseDaoI;
@Repository("baseDao")
public class BaseDaoImpl<T> implements BaseDaoI<T> {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Serializable save(T u) {
		return this.sessionFactory.getCurrentSession().save(u);
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
