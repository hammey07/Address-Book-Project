class Person {
    private String firstname;
    private String lastname;
    private String phone;
    private String address;
    private int id;
    private static int counter = 0;

    Person(String firstname, String lastname, String phone, String address, int id) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.address = address;
    }

    int getId() {
        return id;
    }

    String getFirstname() {
        return firstname;
    }

    void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    String getLastname() {
        return lastname;
    }

    void setLastname(String lastname) {
        this.lastname = lastname;
    }

    String getPhone() {
        return phone;
    }

    void setPhone(String phone) {
        this.phone = phone;
    }

    String getAddress() {
        return address;
    }

    void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "ID : " + id + "\n" +
                "Firstname : " + firstname + "\n" +
                "Lastname : " + lastname + "\n" +
                "Phone :" + phone + "\n" +
                "Address : " + address + "\n";
    }
}
