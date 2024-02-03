package withoutxmlfile;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Driver 
{
	public static void main(String[] args) 
	{
		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		Charger charger = context.getBean("charger",Charger.class);
		System.out.println(charger);
		Mobile mobile = context.getBean("mobile",Mobile.class);
		System.out.println(mobile);
	}
}
