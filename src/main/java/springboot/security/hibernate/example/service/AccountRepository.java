package springboot.security.hibernate.example.service;

import springboot.security.hibernate.example.model.Account;

public interface AccountRepository {
	public Account findByUsername(String username);
//	public void insert(String userName, String password);
}
