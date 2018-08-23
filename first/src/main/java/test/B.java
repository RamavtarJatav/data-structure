package test;

public class B extends A{
    
	public void print() {
		System.out.println("print");
	}
	
//	public void pr() {
//		System.out.println("b");
//	}
	public static void main(String[] args) {
		B b = (B) new A();
		//b.print();
		//b.pr();
	}
	
}
