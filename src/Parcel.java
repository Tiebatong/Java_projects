class Parcel implements Sendable{

    final private Location senderLocation;
    final private Location recieverLocation;
    final private double weight;

    Parcel(Location senderLocation, Location recieverLocation, double weight) {
        this.senderLocation = senderLocation;
        this.recieverLocation = recieverLocation;
        this.weight = weight;
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
