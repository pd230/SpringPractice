//package springJDBC;
//
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.ConfigurableApplicationContext;
//
//@SpringBootApplication
//public class JdbcController {
//	public static void main(String[] args) {
//		
//		ConfigurableApplicationContext context = SpringApplication.run(JdbcController.class, args);
//		StudModel sm = context.getBean(StudModel.class);
//		sm.setId(1);
//		sm.setName("PD");
//		sm.setAge(20);
//		
//		ServiceRepo sr = context.getBean(ServiceRepo.class);
//		sr.save(sm);
//		System.out.println(sr.find());
//		System.out.println(sr.findAll());
//	    sr.deleteRow(101);
//		System.out.println(sr.findAll());
//		sr.update(102, "abc");
//		System.out.println(sr.findAll());
//		sr.DeleteAll();
//		System.out.println(sr.findAll());
//		sr.alter();
//		
//	}
//}
