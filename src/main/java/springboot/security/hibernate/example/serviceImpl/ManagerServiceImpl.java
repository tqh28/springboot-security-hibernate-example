package springboot.security.hibernate.example.serviceImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import springboot.security.hibernate.example.HibernateUtil;
import springboot.security.hibernate.example.model.Manager;
import springboot.security.hibernate.example.service.ManagerService;

public class ManagerServiceImpl implements ManagerService {
	
	private SessionFactory sessionFactory;
	
	public ManagerServiceImpl() {
		sessionFactory = HibernateUtil.getSessionFactory();
	}

	@Override
	public List<Manager> getAll() {
		Session session = sessionFactory.openSession();
		
		List<Manager> list = session.createQuery("from Manager").getResultList();
		
		session.close();
		return list;
	}
	
	@Override
	public Manager getById(int id) {	
		Session session = sessionFactory.openSession();
		
		Manager res = session.get(Manager.class, id);
		
		session.close();
		return res;
	}
	
	@Override
	public void update(Manager man) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.merge(man);
		session.getTransaction().commit();
		session.close();
	}
	
	@Override
	public void delete(Manager man) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(man);
		session.getTransaction().commit();
		session.close();
	}
}
