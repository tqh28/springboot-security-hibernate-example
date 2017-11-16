package springboot.security.hibernate.example.serviceImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import springboot.security.hibernate.example.HibernateUtil;
import springboot.security.hibernate.example.model.Account;
import springboot.security.hibernate.example.service.AccountRepository;

public class AccountRepositoryImpl implements AccountRepository {

	@Override
	public Account findByUsername(String username) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		List list = session.createQuery("select a from Account a where username = :username")
				.setParameter("username", username).getResultList();
		
		if (list != null && list.size() > 0) {
			return (Account)list.get(0);
		}
		return null;
	}
}
