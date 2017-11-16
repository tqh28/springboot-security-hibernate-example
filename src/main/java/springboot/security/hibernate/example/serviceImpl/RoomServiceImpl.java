package springboot.security.hibernate.example.serviceImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import springboot.security.hibernate.example.HibernateUtil;
import springboot.security.hibernate.example.model.Room;
import springboot.security.hibernate.example.service.RoomService;

public class RoomServiceImpl implements RoomService {
	
	private SessionFactory sessionFactory;
	
	public RoomServiceImpl() {
		sessionFactory = HibernateUtil.getSessionFactory();
	}

	@Override
	public void insert(Room room) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.persist(room);
		
		session.getTransaction().commit();
		session.close();
	}
}
