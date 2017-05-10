import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class MyInterceptor implements MethodInterceptor{
	
	private Logger Logger;
	private Privilege privilege;
	private Object target;
	
	

	public MyInterceptor(Logger logger, Privilege privilege, Object target) {
		super();
		Logger = logger;
		this.privilege = privilege;
		this.target = target;
	}

	public Object createProxy() {
		Enhancer enhancer=new Enhancer();
		enhancer.setCallback(this);
		enhancer.setSuperclass(target.getClass());
		return enhancer.create();
	}

	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		this.Logger.writeLog();
		boolean isAccessed = this.privilege.isAccessed();
		if (isAccessed) {
			method.invoke(target);
		}
		return null;
	}


}
