package rakesh.carrental.data;

import java.util.LinkedList;
import java.util.List;

import rakesh.carrental.model.Car;

public final class CarDatabase {
	
	public static List<Car> cars = new LinkedList<Car>();
	
	static{
		cars.add(new Car("SEDAN"));
		cars.add(new Car("SUV"));
	}

}
