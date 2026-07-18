import java.util.Stack;

public class UndoStack {
    // Data Structure 4: LIFO Stack
    private Stack<Car> deletedCars;

    public UndoStack() {
        deletedCars = new Stack<>();
    }

    public void pushDeletedCar(Car car) {
        deletedCars.push(car);
    }

    public Car popDeletedCar() {
        if (deletedCars.isEmpty()) {
            return null;
        }
        return deletedCars.pop();
    }
}