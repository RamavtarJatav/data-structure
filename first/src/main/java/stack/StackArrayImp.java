package stack;

public class StackArrayImp {
      int[] array;
      int CAPACITY;
      int index;
      StackArrayImp(){
    	  CAPACITY = 2 << 1;
    	  array = new int[CAPACITY];
    	  index = -1;
    
      }
      
      
      void push(int data){
    	  if (index == CAPACITY-1) {
    		  CAPACITY = CAPACITY << 1;
    		  int[] temp = new int[CAPACITY] ;
    		  for(int i = 0 ; i <= index ; i++) {
    			  temp[i] = array[i];
    		  }
    		  array = temp;
    	  }
    		  array[++index] = data;
    		  
    	  
    	  
      }
      
      
      Integer pop() throws Exception {
    	  if(index < 0 ) {
    		 throw new Exception("Stack is empty");
    	  }
		return array[index--];
		
      }
      
      void print() {
    	  for(int i = 0 ; i <= index ; i++) {
    		  System.out.print(array[i]+ " ");
    	  }
    	  
    	  System.out.println();
      }
      
      public static void main(String[] args) throws Exception {
    	  StackArrayImp SA  = new StackArrayImp();
    	  SA.push(1);
    	  SA.push(2);
    	  SA.push(3);
    	  SA.push(4);
    	  SA.push(5);
    	  SA.push(6);
    	  
    	  SA.print();
    	  SA.pop();
    	  SA.print();
    	  SA.pop();
    	  SA.pop();
    	  SA.pop();
    	  SA.pop();
    	  SA.pop();
    	  SA.pop();
    	  SA.pop();
    	  SA.print();
	}
}
