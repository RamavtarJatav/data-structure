package test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Ini {
	Ini() throws Exception{
		throw new Exception("a");
	}
	
	public void print() {
		System.out.println("aa");
	}
	
	public static void main(String[] args) throws Exception {
		Ini ini = new Ini();
		ini.print();
		
	}

}
