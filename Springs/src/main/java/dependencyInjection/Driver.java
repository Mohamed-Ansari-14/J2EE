package dependencyInjection;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Driver 
{
	public static void main(String[] args) 
	{
		Resource resource = new ClassPathResource("cl.xml");
		BeanFactory beanFactory = new XmlBeanFactory(resource);
		Charger charger = beanFactory.getBean("ch",Charger.class);
		Laptop laptop = beanFactory.getBean("lap",Laptop.class);
		System.out.println(charger);
		System.out.println(laptop);
	}
}
