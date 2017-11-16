package springboot.security.hibernate.example.service;

import java.util.List;

import springboot.security.hibernate.example.model.Manager;

public interface ManagerService {

	public List<Manager> getAll();
	public Manager getById(int id);
	public void update(Manager man);
	public void delete(Manager man);
}
