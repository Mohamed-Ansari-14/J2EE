package propertyInjection;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Driver 
{
	public static void main(String[] args) 
	{
		Resource resource= new ClassPathResource("mobile.xml");
		BeanFactory beanFactory= new XmlBeanFactory(resource);
		Mobile mobile = (Mobile) beanFactory.getBean("mobile");
		//mobile.used();
		System.out.println(mobile);
	}
}
