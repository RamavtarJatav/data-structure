package reflection;

import java.lang.reflect.Field;
import java.util.List;

public class Example1 {
	public static void main(String[] args) {
		Object person = new Person();
		Field[] fields = person.getClass().getDeclaredFields();
		//List<String> actualFieldNames = getFieldNames(fields);
	}
	

}
