package F9;
import java.io.Serializable;

public class Car implements Comparable<Car>, Serializable{
    
    private String make;
    private int date;
    private int drivenMil;
    
    public Car(String make, int date, int drivenMil){
        this.make = make;
        this.date = date;
        this.drivenMil = drivenMil;
    }
    
    // jämför make
    @Override
    public int compareTo(Car o) {
        return this.make.compareTo(o.make);
    }

    public String getMake() {
        return make;
    }

    public int getDate() {
        return date;
    }

    public int getDrivenMil() {
        return drivenMil;
    }

    @Override
    public String toString() {
        return "Car{" + "make=" + make + ", date=" + date + ", drivenMil=" + drivenMil + '}';
    }
    
    
}