package last;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Driver 
{
	public static void main(String[] args) 
	{
		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
//		Animal animal = context.getBean("lion",Lion.class);
//		animal.sound();
		Zoo zoo = context.getBean("zoo",Zoo.class);
		zoo.sound();
	}
}
