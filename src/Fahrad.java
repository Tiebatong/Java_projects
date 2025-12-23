record Fahrad(int Preis) implements comparable <Fahrad>{

    public int compare(Fahrad anderesFahread) {

        if(this.Preis < anderesFahread.Preis) {
            return -1;
        } else if(this.Preis == anderesFahread.Preis) {
            return 0;
        } else return 1;
    }
}
