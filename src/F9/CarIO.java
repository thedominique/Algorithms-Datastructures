package F9;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;


 
public class CarIO implements Serializable{

	// skriv till fil
    public static void serializeToFile(String filename, Car[] cars) throws IOException {
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(
            new FileOutputStream(filename));
            out.writeObject(cars);
        }
        finally {
            try {
                if(out != null){
                    out.close();
                }
            } catch(Exception e) {
                throw new NullPointerException("null exception");
            }
        }
    }
    
    // läs från fil
    @SuppressWarnings("unchecked")
    public static Car[] deSerializeFromFile(String filename) throws IOException, ClassNotFoundException {
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(
            new FileInputStream(filename));
            Car[] cars = (Car[]) in.readObject();
            return cars;
        }finally {
            try {
                if(in != null)	
                    in.close();
            } 
            catch(Exception e) {
                throw new NullPointerException("null exception");
            }			
        }
    }
}