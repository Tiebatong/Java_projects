public class SingleResistor implements Resistor{

    final private double resistance;
    final private int resistorCount;

    SingleResistor(double resistance) {
        this.resistance = resistance;
        this.resistorCount = 1;
    }

    public double resistance() {
        return this.resistance;
    }

    public int resistorCount() {
        return 1;
    }

}
