public class ParallelCircuit implements Resistor{
    final private Resistor r0;
    final private Resistor r1;

    ParallelCircuit(Resistor r0, Resistor r1) {
        this.r0 = r0;
        this.r1 = r1;
    }

    public double resistance() {
        return (this.r0.resistance() * this.r1.resistance()) / (this.r0.resistance() + this.r1.resistance());
    }

    public int resistorCount() {
        return this.r0.resistorCount() + this.r1.resistorCount();
    }
}
