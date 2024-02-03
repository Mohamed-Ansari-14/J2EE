package last;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Zoo
{
	@Autowired	//->We can write @Qualifier along with the @Autowired only!!!
	@Qualifier(value = "cow")	//->@Qualifier is More Preference than @Primary
	private Animal animal;
	
	public void sound()
	{
		animal.sound();
	}
}
