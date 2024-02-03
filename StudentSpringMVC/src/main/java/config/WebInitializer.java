package config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer
{

	@Override
	protected Class<?>[] getRootConfigClasses() {	//we can't use it as of now
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() 
	{
		return new Class[] {StudentConfig.class};
	}

	@Override
	protected String[] getServletMappings() 
	{
		return new String[] {"/"};
	}
	
}
