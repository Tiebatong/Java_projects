class Person implements Comparable<Person> {
    private String vorname;
    private String nachname;

    Person(String vorname, String nachname) {
        this.vorname = java.util.Objects.requireNonNull(vorname);
        this.nachname = java.util.Objects.requireNonNull(nachname);
    }
    
    void setNachname(String nachname) {
        this.nachname = java.util.Objects.requireNonNull(nachname);
    }
    
    @Override
    public String toString() {
        return "Person: %s %s".formatted(vorname, nachname);
    }
    
    @Override
    public boolean equals(Object other) {
        if(!(other instanceof Person otherPerson)) {
            return false;
        }
        return this.vorname.equals(otherPerson.vorname) && this.nachname.equals(otherPerson.nachname);
    }

    @Override
    public int compareTo(Person other) {
        return this.nachname.compareTo(other.nachname);
    }

    int h() {
        return nachname.charAt(0) - 'A';
    }
}
