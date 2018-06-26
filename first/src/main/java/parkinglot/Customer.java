package parkinglot;

import java.io.Serializable;

public class Customer implements Serializable{
	private static final long serialVersionUID = 1L;
	private final String id ;
	private final String name;
	private final String number;
	private  String address;
	
	Customer(String id , String name , String number ){
		this.id = id;
		this.name= name;
		this.number = number;
		
	}

}
