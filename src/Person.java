class Person {

    private final String lastname;
    
    Person(String lastname) {
        this.lastname = lastname;
    }
    
    int hashwert() {
        int hash = 0;
        for(char character: lastname.toCharArray()) {
            hash += character - 'A';
        }
        return hash;
    }
    
    @Override
    public boolean equals(Object other) {
        if(!(other instanceof Person otherPerson)) {
            return false;
        }
        return this.lastname.equals(otherPerson.lastname);
    }
    
    @Override
    public String toString() {
        return lastname;
    }

}
