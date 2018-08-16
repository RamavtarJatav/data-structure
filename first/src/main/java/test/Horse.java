package test;

public class Horse extends Animal {
	public void getAnimal() {
		System.out.println("I am horse");
	}
	
	public static void main(String[] args) {
		Animal an = new Horse();
		//an.getAnimal();
	}

}