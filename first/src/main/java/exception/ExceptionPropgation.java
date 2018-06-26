package exception;

public class ExceptionPropgation {
	int add(int x, int y) {
		
			int z = x / y;
			return z;	
	}
	
	void display() {
		add(10,0);
		
		int m = 2;
		System.out.println(m);
	}
   public static void main(String[] args) {
	   ExceptionPropgation ex = new ExceptionPropgation();
	   ex.display();
}
}
