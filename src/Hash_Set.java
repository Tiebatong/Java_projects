class Hash_Set {

    private final int SIZE = 50;
    Person[] persons = new Person[SIZE];


    void insert(Person person) {
        int index = person.h();

        persons[index] = person;
    }

    void delete(Person person) {
        int index = person.h();
        persons[index] = null;
    }

    boolean contains(Person person) {
        int index = person.h();
        return persons[index] != null;
    }

    int size() {
        int size = 0;
        for(Person p: persons) {
            if (p != null) {
                size++;
            }
        }
        return size;
    }

    @Override
    public String toString() {
        String ausgabe = "{";

        for (Person p: this.persons) {
            if (p != null) {
                ausgabe += p.toString() + ", ";
            }
        }
        return ausgabe + "}";
    }


}
