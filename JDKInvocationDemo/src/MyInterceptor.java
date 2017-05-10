import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInterceptor implements InvocationHandler{
	
	private PersonService target;
	private Logger Logger;
	private Privilege privilege;

	public MyInterceptor(PersonService target, Logger logger, Privilege privilege) {
		super();
		this.target = target;
		Logger = logger;
		this.privilege = privilege;
	}


	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		this.Logger.writeLog();
		boolean isAccessed = this.privilege.isAccessed();
		if(isAccessed){
			this.target.savePerson();
		}
		return null;
	}

}
