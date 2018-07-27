package pecs;

import java.util.ArrayList;
import java.util.List;

public class GenericsExamples
{
   public static void main(String[] args)
   {   
	   
	   List<? super  Fish > ani = new ArrayList<Fish>();
	   ani.add(new Fish(0));
	  // ani.add(e)
	   
	   List<? extends Animal> animals;
//	   animals = new ArrayList<Animal>();
//	   animals = new ArrayList<SeaAnimal>();
//	   animals = new ArrayList<Fish>();
//	   
//	   animals.add(new Animal());
      //List of apples
//      List<? super Fruit> apples = new ArrayList<Fruit>();
//      apples.add(new Apple());
//      apples.add(new Fruit());
//      apples.add(new Seed());
//       
//      //We can assign a list of apples to a basket of fruits;
//      //because apple is subtype of fruit
//      List<? extends Fruit> basket = (List<? extends Fruit>) apples;
//      
//       
//      //Here we know that in basket there is nothing but fruit only
//      for (Fruit fruit : basket)
//      {
//         System.out.println(fruit);
//      }
//       
//      //basket.add(new Apple()); //Compile time error
//      //basket.add(new Fruit()); //Compile time error
   }
}

