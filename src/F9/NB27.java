package F9;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author barih
 */
public class NB27 {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException {

		// SKRIV TILL FIL
		/*
		 * Car[] cars = new Car[3];
		 * 
		 * cars[0] = new Car("volvo", 200207, 2); cars[1] = new Car("bmw", 200208, 5);
		 * cars[2] = new Car("saab", 100411, 7);
		 * 
		 * CarIO.serializeToFile("cars2.txt", cars);
		 */
		
		// DATA FRÅN FIL
		/*Car[] cars = CarIO.deSerializeFromFile("cars2.txt");

		System.out.println("BEFORE SORT " + Arrays.toString(cars));

		Arrays.sort(cars);  // 

		System.out.println("AFTER SORT " + Arrays.toString(cars));

		CarIO.serializeToFile("cars2.txt", cars);

		*/
		/* */ Car[] cars = CarIO.deSerializeFromFile("cars2.txt");
		  
		  List<Car> carList = Arrays.asList(cars);
		  System.out.println("before sort (date)" + carList.toString());
		  Collections.sort(carList, new CompareCar());
		  
		  System.out.println("after sort (date)" + carList.toString());
		  
		  cars = new Car[carList.size()]; 
		  cars = (Car[])carList.toArray();
		  System.out.println(Arrays.toString(cars)); CarIO.serializeToFile("cars77.txt", cars);
		 /**/
	}

}