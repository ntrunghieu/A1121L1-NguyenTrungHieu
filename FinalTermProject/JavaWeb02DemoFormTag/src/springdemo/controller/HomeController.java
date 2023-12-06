package springdemo.controller;
import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import springdemo.dao.HibernateDatabaseConnection;
import springdemo.model.bean.Fruit;
import springdemo.model.bean.Patient;



@Controller
public class HomeController {
	
	@RequestMapping("/home")
	private String homePage(Model model) {
		// TODO Auto-generated method stub
		Session session = null;
		session = HibernateDatabaseConnection.getSessionFactory().openSession();
//		List<Fruit> fruits = session.createQuery("FROM Fruit ORDER BY id ASC", Fruit.class)
//                .getResultList();
		
		List<Patient> patients = session.createQuery("FROM Patient", Patient.class)
                .getResultList();
		
		
        
        model.addAttribute("patients", patients);		
        
		return "main-list";
	}
}
