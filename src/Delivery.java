class Delivery {

    private Sendable[] deliveryArr;

    Delivery(Sendable[] sendable) {
        for (Sendable s: sendable) {
            java.util.Objects.requireNonNull(s);
        }
        this.deliveryArr = sendable.clone();
    }

    Delivery(Sendable sendable) {
        java.util.Objects.requireNonNull(sendable);

        this.deliveryArr = new Sendable[] {sendable};
    }

    private static int postage(Sendable sendable) {
        int price = 0;

        if (!sendable.senderLocation().equals(sendable.receiverLocation())) {
            price += 1;
        }

        if (sendable.weight() < 100) {
            price += 1;
        } else {
            price += 2;
        }

        return price;
    }

    int postage() {
        int price = 0;

        for (Sendable s: this.deliveryArr) {
            price += postage(s);
        }
        return price;
    }
}
