package F9;

import java.util.Comparator;


public class CompareCar implements Comparator<Car>{
    
	// jämför datum
    
    @Override
    public int compare(Car c1, Car c2) {
        return c1.getDate() - c2.getDate();
    }
    
    
    
    
}

