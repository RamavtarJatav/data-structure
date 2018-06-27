package test;

public class Circle  extends Shape{
	
	void print() {
		System.out.println("circle method " );
	}
	 
	Circle(){
		System.out.println("circle");
	}
	
	public static void main(String[] args) {
		Circle shape = (Circle) new Shape();
		//shape.print();
		
	}

}
