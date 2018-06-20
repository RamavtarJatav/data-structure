package important;

public class NullOverloading {
	public static  void doSomething(Object obj) {
	    System.out.println("Object called");
	}

	public static  void doSomething(char obj) {
	    System.out.println("Array called");
	}

	public static  void doSomething(int obj) {
	    System.out.println("Integer called");
	}
	
//	public static  void doSomething(String obj) {
//	    System.out.println("String called");
//	}
	
	public static void main(String[] args) {
//		char[] x = null;
//		doSomething(x);
//		Integer y = null;
//		doSomething(y);
//		Object z = null;
//		doSomething(z);
		doSomething(null);
		
	}

}
