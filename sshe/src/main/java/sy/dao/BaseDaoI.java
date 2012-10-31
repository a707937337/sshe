package sy.dao;

public interface BaseDaoI<T>{
	public java.io.Serializable save(T o);
}
