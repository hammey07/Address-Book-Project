import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AddressBookTest {
    @Test
    public void testAddPerson() { // Testing adding contact functionality.
        Person createdPerson;
        String expectedFirstName = "John";
        String expectedLastName = "Smith";
        String expectedPhone = "083345343";
        String expectedAddress = "5, Riverside , New ross, Waterford";
        createdPerson = AddressBook.addPerson(expectedFirstName, expectedLastName, expectedPhone, expectedAddress);
        assertEquals(expectedFirstName, createdPerson.getFirstname());
        assertEquals(expectedLastName, createdPerson.getLastname());
        assertEquals(expectedAddress, createdPerson.getAddress());
        assertEquals(expectedPhone, createdPerson.getPhone());
    }

    @Test
    public void testDeletePerson() {// Testing Delete Contact functionality of application
        Person createdPerson;
        String expectedFirstName = "James";
        String expectedLastName = "Donohoe";
        String expectedPhone = "083345343";
        String expectedAddress = "52, brendayway , Ferrybank, Waterford";
        createdPerson = AddressBook.addPerson(expectedFirstName, expectedLastName, expectedPhone, expectedAddress);
        AddressBook.removeContact(createdPerson.getId());
        assertEquals(false, AddressBook.getPersonList().contains(createdPerson));
    }

    @Test
    public void testGetContactInfo() { // Testing get contact info
        Person createdPerson;
        String expectedFirstName = "Tanya";
        String expectedLastName = "Khen";
        String expectedPhone = "083345343";
        String expectedAddress = "52, Alisbury road, Co limeirck";
        createdPerson = AddressBook.addPerson(expectedFirstName, expectedLastName, expectedPhone, expectedAddress);
        assertEquals(createdPerson, AddressBook.getContactInformation(createdPerson.getId()));
    }

    @Test
    public void testSortByFirstname() {// Testing sort
        PersonSorter sortByFirstname = new PersonSorter();
        sortByFirstname.sort(AddressBook.getPersonList(), "firstname");
        assertEquals(AddressBook.getPersonList(), sortByFirstname.sort(AddressBook.getPersonList(), "firstname"));
    }

    @Test
    public void testSortByLastname() { // Testing sort
        PersonSorter sortByFirstname = new PersonSorter();
        sortByFirstname.sort(AddressBook.getPersonList(), "lastname");
        assertEquals(AddressBook.getPersonList(), sortByFirstname.sort(AddressBook.getPersonList(), "lastname"));
    }

    @Test
    public void testTotalCount() { // Testing  Addressbook count feature
        assertEquals(AddressBook.getPersonList().size(), AddressBook.countContacts());
    }

    @Test
    public void testEditContact() { //Testing if all created Details matches with expected values.
        Person createdPerson;
        String FirstName = "Jessie";
        String LastName = "Pinkman";
        String Phone = "+134343453553";
        String Address = "6, Jane's house, Albuquerque";
        createdPerson = AddressBook.addPerson(FirstName, LastName, Phone, Address);

        int expectedId = createdPerson.getId();
        String expectedFirstName = "Walter";
        String expectedLastName = "White";
        String expectedPhone = "+134343453553";
        String expectedAddress = "White Residence, 308 Negra Arroyo lane, Albuquerque";
        Person editedPerson = AddressBook.editContactDetails(createdPerson, expectedFirstName, expectedLastName, expectedPhone, expectedAddress);
        assertEquals(expectedId, editedPerson.getId());
        assertEquals(expectedFirstName, editedPerson.getFirstname());
        assertEquals(expectedLastName, editedPerson.getLastname());
        assertEquals(expectedAddress, editedPerson.getAddress());
        assertEquals(expectedPhone, editedPerson.getPhone());
    }
}