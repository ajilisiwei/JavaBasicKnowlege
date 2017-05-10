import org.junit.Test;

public class CGLibInvacationDemoTest {
	@Test
	public void Test1(){
		Logger logger=new Logger();
		Privilege privilege=new Privilege();
		privilege.setAcces("admin");
		PersonService personService=new PersonService();
		MyInterceptor interceptor=new MyInterceptor(logger, privilege, personService);
		PersonService personService2 = (PersonService)interceptor.createProxy();
		personService2.savePerson();
	}
	
}
