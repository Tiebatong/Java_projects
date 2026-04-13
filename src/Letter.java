class Letter implements Sendable{

    final private Location senderLocation;
    final private Location recieverLocation;
    final private double weight;

    Letter(Location senderLocation, Location recieverLocation) {
        this.senderLocation = senderLocation;
        this.recieverLocation = recieverLocation;
        this.weight = 80;
    }

    public Location senderLocation() {
        return this.senderLocation;
    }

    public Location receiverLocation() {
        return this.recieverLocation;
    }

    public double weight() {
        return this.weight;
    }
}
