package lyf.test;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lyf.bean.Dog;
import lyf.bean.Person;
/**
 * 
 * @author lyf
 *
 */
public class SpringTest {

	ApplicationContext context = null;
	/**
	 * 初始化容器
	 */
	@Before
	public void init(){
		context = new ClassPathXmlApplicationContext("/beans.xml");
	}
	/**
	 * 设值注入测试
	 * <property name="name" value="小银"></property>
	 */
	@Test
	public void setterDI() {
		Dog dog = (Dog)context.getBean("pets");
		//beans.xml中配置value为“小银”
		System.out.println(dog.getName());		//输出  小银777
		
	}
	/**
	 * 构造方法注入
	 * 实体类中需要有带参的构造方法
	 * <constructor-arg index="0" value="小银"></constructor-arg>
	 */
	@Test
	public void constructorDI(){
		Dog dog = (Dog)context.getBean("pets2");
		//beans.xml中配置value为“小银”
		System.out.println(dog.getName());		//输出  小银
	}
	/**
	 * 依赖注入的属性设值：空值
	 * <constructor-arg index="0">
			<null></null>				-----输出null
		</constructor-arg>	
		
		<property name="name">
			<null/>						-----输出null777
		</property>
	 */
	@Test
	public void nullDI(){
		Dog dog = (Dog)context.getBean("pets3");
		System.out.println(dog.getName());
	}
	/**
	 * 依赖注入的引用属性：local,bean,parent(并不常用)
	 * 	
	 */
	@Test
	public void refDI(){
		Person person = (Person)context.getBean("person3");
		Dog dog = (Dog) person.getPets();
		System.out.println(dog.getName());
	}
	/**
	 * 依赖注入的集合属性：list
	 */
	@Test
	public void listDI(){
		Person person = (Person)context.getBean("person4");
		@SuppressWarnings("unchecked")
		List<String> list = (List<String>) person.getList();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	/**
	 * 依赖注入的集合属性：set
	 */
	@Test
	public void setDI(){
		Person person = (Person)context.getBean("person5");
		@SuppressWarnings("unchecked")
		Set<Integer> set = (Set<Integer>) person.getSet();
		Iterator<Integer> it = set.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
	/**
	 * 依赖注入的集合属性：map
	 */
	@Test
	public void mapDI(){
		Person person = (Person)context.getBean("person6");
		@SuppressWarnings("unchecked")
		Map<Integer,String> map = (Map<Integer, String>) person.getMap();
		Set<Integer> keys = (Set<Integer>) map.keySet();
		Iterator<Integer> it = keys.iterator();
		while(it.hasNext()){
			int key = it.next();
			System.out.println(key+":"+map.get(key));
		}
	}
	/**
	 * 依赖注入的集合属性：properties
	 */
	@Test
	public void propDI(){
		Person person = (Person)context.getBean("person7");
		Properties prop = person.getProperties();
		Set<Object> keys = prop.keySet();
		Iterator<Object> it = keys.iterator();
		while(it.hasNext()){
			String key = (String) it.next();
			System.out.println(key+":"+prop.getProperty(key));
		}
	}
}
