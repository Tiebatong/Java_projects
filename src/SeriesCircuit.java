public class SeriesCircuit implements Resistor{

    final private Resistor resistor0;
    final private Resistor resistor1;

    SeriesCircuit(Resistor r0, Resistor r1) {
        this.resistor0 = r0;
        this.resistor1 = r1;
    }

    public double resistance() {
        return this.resistor0.resistance() + this.resistor1.resistance();
    }

    public int resistorCount() {
        return this.resistor0.resistorCount() + this.resistor1.resistorCount();
    }
}
