import java.util.ArrayList;

public class AnnotationExample {
	public static void main(String[] args) {
		
	}

	@Override
	@MethodInfo(author="wei",comments="Main Method",date="05 2017",revision=1)
	public String toString() {
		return "Overriden toString method";
	}
	
	@Deprecated
	@MethodInfo(author="wei",comments="Deprecated Method",date="05 2017",revision=1)
	public static void oldMethod(){
		System.out.println("This is a old method");
	}
	
	@SuppressWarnings("unchecked")
	@MethodInfo(author="wei",comments="Deprecated Method",date="05 2017",revision=1)
	public static void genericsTest() {
        @SuppressWarnings("rawtypes")
		ArrayList l = new ArrayList();
        l.add("abc");
        oldMethod();
	}
}
