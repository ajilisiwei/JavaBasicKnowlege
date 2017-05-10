import java.lang.reflect.Proxy;

import org.junit.Test;

public class JDKInvocationDemoTest {
	@Test
	public void Test1(){
		PersonService targetPersonService=new PersonServiceImpl();
		Logger logger=new Logger();
		Privilege privilege=new Privilege();
		privilege.setAcces("admin");
		MyInterceptor interceptor=new MyInterceptor(targetPersonService, logger, privilege);
		PersonService proxy=(PersonService) Proxy.newProxyInstance(
				targetPersonService.getClass().getClassLoader(), 
				targetPersonService.getClass().getInterfaces(),
				interceptor);
		proxy.savePerson();		
	}
}
