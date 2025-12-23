record Studi(String Name, int MatrikelNummer) implements comparable <Studi>{

    public int compare(Studi andererStudi) {
        if(this.MatrikelNummer < andererStudi.MatrikelNummer) {
            return -1;
        } else if(this.MatrikelNummer == andererStudi.MatrikelNummer) {
            return 0;
        } else return 1;
    }
}
