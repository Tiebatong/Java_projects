class Hash_Set {

    private final int SIZE = 10;
    Person[] persons = new Person[SIZE];


    void insert(Person person) {
        int index = person.h() % SIZE;
        //lineares sondieren
        while (persons[index] != null) {
            index++;
            index %= SIZE;
        }
        persons[index] = person;

    }

    void delete(Person person) {
        int index = person.h() % SIZE;
        persons[index] = null;
    }

    boolean contains(Person person) {
        int index = person.h() % SIZE;
        while (persons[index] != null && persons[index].equals(person)) {
            index++;
            index %= SIZE;
        }

        if (persons[index] == null) {
            return false;
        }
        return true;
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
                ausgabe += p + ", ";
            }
        }
        return ausgabe + "}";
    }


}
