package last;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary	//->Less Preference than @Qualifier 
public class Lion implements Animal
{
	@Override
	public void sound() 
	{
		System.out.println("Roarrrrr");
	}
}
