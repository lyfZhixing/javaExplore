package lyf.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lyf.bean.Dog;
import lyf.bean.Pets;

public class Test {
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("/beans.xml");
		Dog pets = (Dog)context.getBean("pets");
		System.out.println(pets.getName());
		pets.play();
	}
	
	
}
