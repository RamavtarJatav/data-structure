package corejava;

public class Systemexit {
	public static void main(String[] args) {
		try {
			throw new Exception();
			//System.out.println("a");
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			System.out.println("finally");
		}
	}

}
