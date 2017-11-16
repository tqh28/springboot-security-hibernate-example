package springboot.security.hibernate.example.serviceImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import springboot.security.hibernate.example.HibernateUtil;
import springboot.security.hibernate.example.model.Employee;
import springboot.security.hibernate.example.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {
	
	private SessionFactory sessionFactory;
	
	public EmployeeServiceImpl() {
		sessionFactory = HibernateUtil.getSessionFactory();
	}
	
	@Override
	public List<Employee> getAll() {
		Session session = sessionFactory.openSession();

		
		List<Employee> list = session.createQuery("from Employee").list();
		
		
//		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
//		CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
//		Root<Employee> root = criteriaQuery.from(Employee.class);
//		criteriaQuery.select(root.get()).where(
//				criteriaBuilder.equal(root.get("empName"), "Huy"));
////				criteriaBuilder.greaterThan(root.get("id"), 40));
//		
//		Query<Employee> query = session.createQuery(criteriaQuery);
//		List<Employee> list = query.getResultList();
		
//		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
//
//		CriteriaQuery<Tuple> criteria = builder.createQuery( Tuple.class );
//
//		Root<Person> personRoot = criteria.from( Person.class );
//		Root<Partner> partnerRoot = criteria.from( Partner.class );
//		criteria.multiselect( personRoot, partnerRoot );
//
//		Predicate personRestriction = builder.and(
//		    builder.equal( personRoot.get( Person_.address ), address ),
//		    builder.isNotEmpty( personRoot.get( Person_.phones ) )
//		);
//		Predicate partnerRestriction = builder.and(
//		    builder.like( partnerRoot.get( Partner_.name ), prefix ),
//		    builder.equal( partnerRoot.get( Partner_.version ), 0 )
//		);
//		criteria.where( builder.and( personRestriction, partnerRestriction ) );
//
//		List<Tuple> tuples = entityManager.createQuery( criteria ).getResultList();
		
		session.close();
		
		return list;
	}
	
	@Override
	public void insert(Employee e) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.persist(e);
		session.getTransaction().commit();
		session.close();
	}
}
