package test;

class EmployeeRecord extends Prototype {

	private int id;
	private String name, designation;
	private double salary;
	private String address;

	public EmployeeRecord() {
		System.out.println("   Employee Records of Oracle Corporation ");
		System.out.println("---------------------------------------------");
		System.out.println("Eid" + "\t" + "Ename" + "\t" + "Edesignation" + "\t" + "Esalary" + "\t\t" + "Eaddress");

	}

	public EmployeeRecord(int id, String name, String designation, double salary, String address) {

		this();
		this.id = id;
		this.name = name;
		this.designation = designation;
		this.salary = salary;
		this.address = address;
	}

	public void showRecord() {

		System.out.println(id + "\t" + name + "\t" + designation + "\t" + salary + "\t" + address);
	}

	@Override
	public Prototype Clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return (EmployeeRecord) super.clone();
	}
	
	public static void main(String[] args) throws CloneNotSupportedException {
		Prototype pr = new EmployeeRecord(1,"r" , "m", 1, "q");
		Prototype pr1 =  pr.Clone();
		System.out.println(pr);
		System.out.println(pr1);
		
	}
}// End of EmployeeRecord class.
