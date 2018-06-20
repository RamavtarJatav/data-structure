package test;

public class ConcretePrototype1 extends Prototype {

	@Override
	public Prototype Clone() throws CloneNotSupportedException {
		return (ConcretePrototype1)super.clone();
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) throws CloneNotSupportedException {
		Prototype pr = new ConcretePrototype1();
		
		Prototype pr1 = pr.Clone();
		System.out.println(pr);
		System.out.println(pr1);
		
	}

}
