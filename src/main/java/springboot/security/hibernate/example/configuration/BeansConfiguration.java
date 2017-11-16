package springboot.security.hibernate.example.configuration;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springboot.security.hibernate.example.service.AccountRepository;
import springboot.security.hibernate.example.service.EmployeeService;
import springboot.security.hibernate.example.service.ManagerService;
import springboot.security.hibernate.example.service.RoomService;
import springboot.security.hibernate.example.serviceImpl.AccountRepositoryImpl;
import springboot.security.hibernate.example.serviceImpl.EmployeeServiceImpl;
import springboot.security.hibernate.example.serviceImpl.ManagerServiceImpl;
import springboot.security.hibernate.example.serviceImpl.RoomServiceImpl;

@Configuration
public class BeansConfiguration {

	@Bean
	public EmployeeService getEmployeeService() {
		return new EmployeeServiceImpl();
	}

	@Bean
	public AccountRepository getAccountRepository() {
		return new AccountRepositoryImpl();
	}

	@Bean
	public ManagerService getManagerService() {
		return new ManagerServiceImpl();
	}
	
	@Bean
	public ObjectMapper getObjectMapper() {
		return new ObjectMapper();
	}
	
	@Bean
	public RoomService getRoomService() {
		return new RoomServiceImpl();
	}

}
