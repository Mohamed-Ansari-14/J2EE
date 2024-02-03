package withoutBean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Driver 
{
	public static void main(String[] args) 
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("withoutbeantag.xml");
		Mobile mobile = context.getBean("mobile",Mobile.class);
		System.out.println(mobile);
		Charger charger = context.getBean("charger",Charger.class);
		System.out.println(charger);
	}
}
