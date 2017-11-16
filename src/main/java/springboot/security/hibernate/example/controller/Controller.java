package springboot.security.hibernate.example.controller;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.apache.commons.lang3.StringEscapeUtils;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import springboot.security.hibernate.example.model.Employee;
import springboot.security.hibernate.example.model.Manager;
import springboot.security.hibernate.example.model.Room;
import springboot.security.hibernate.example.service.EmployeeService;
import springboot.security.hibernate.example.service.ManagerService;
import springboot.security.hibernate.example.service.RoomService;

@RestController
public class Controller {
	
	@Autowired
	private EmployeeService es;
	
	@Autowired
	private ManagerService ms;
	
	@Autowired
	private RoomService rs;
	
	@Autowired
	ObjectMapper mapper;
	
	@RequestMapping({"/", "/getAllManagers"})
	public List<Manager> getAllManagers() throws Exception {
		
		
		
		
		List<Manager> list = ms.getAll();
		return list;
//		
//		
//		JAXBContext contextObj = JAXBContext.newInstance(Manager.class);  
//		  
//	    Marshaller marshallerObj = contextObj.createMarshaller();
//	    marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//	    
//		StringWriter sw = new StringWriter();
//	    marshallerObj.marshal(list, sw);
//	    
//		return sw.toString();
//		return null;
	}
	
	@RequestMapping("/getAllEmployees")
	public List<Employee> getAllEmployees() throws Exception {
		List<Employee> list = es.getAll();
		return list;
	}
	
	@RequestMapping("/getMangerById/")
	public Manager getMangerById(@RequestParam final String id) throws JsonGenerationException, JsonMappingException, NumberFormatException, IOException, JAXBException {
		return ms.getById(Integer.parseInt(id));
		
		
//		return mapper.writeValueAsString(ms.getById(Integer.parseInt(id)));
//		JAXBContext contextObj = JAXBContext.newInstance(Manager.class);  
//		  
//	    Marshaller marshallerObj = contextObj.createMarshaller();
//	    marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
////	    marshallerObj.setProperty(Marshaller.JAXB_ENCODING, false);
//	    
//		StringWriter sw = new StringWriter();
//	    marshallerObj.marshal(ms.getById(Integer.parseInt(id)), sw);
//	    
////		String s = StringEscapeUtils.unescapeXml(sw.toString());
////	    return s;
//		
//		return sw.toString();
	}
	
	@RequestMapping("/insertEmployee")
	public int insertEmployee(@RequestParam String data) throws JsonParseException, JsonMappingException, IOException {
		Employee em = mapper.readValue(data, Employee.class);
		
		es.insert(em);
		return em.getId();
	}
	
	@RequestMapping("/insertRoom")
	public int insertRoom(@RequestParam String data) throws JsonParseException, JsonMappingException, IOException {
		Room room = mapper.readValue(data, Room.class);
		rs.insert(room);
		
		return room.getId();
		
		
	}
	
	@RequestMapping("/deleteEmployee/")
	public int deleteEmployee(@RequestParam final int managerId, @RequestParam final int employeeId) {
		Manager man = ms.getById(managerId);
		for (Employee e: man.getEmployees()) {
			if (e.getId() == employeeId) {
				man.getEmployees().remove(e);
				break;
			}
		}
		
		ms.update(man);
		return 1;
	}
	
	@RequestMapping("/deleteManager/")
	public int deleteEmployee(@RequestParam final int managerId) {
		Manager man = ms.getById(managerId);
		
		ms.delete(man);
		return 1;
	}
	
	
	@RequestMapping("/test")
	public int test() {
		return 1;
	}
}
