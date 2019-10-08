import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class AddressBook {
    private static ArrayList<Person> personList = new ArrayList<>();
    private static PersonSorter personSorter = new PersonSorter();

    public static void main(String[] args) {
        personList.add(new Person("John", "O'Sullivan", "0831835567", "5, Suir house"));
        System.out.println(countContacts());
        chooseOption();
    }

    private static void chooseOption() {
        Scanner sc = new Scanner(System.in);
        String selection;
        int selectionInt;
        boolean exit = false;
        while (!exit) {
            boolean badInput = true;
            displayMenu();
            while (badInput) {
                try {
                    selection = sc.next();
                    selectionInt = Integer.parseInt(selection);
                    badInput = false;

                    switch (selectionInt) {
                        case 1: //ADD A CONTACT
                            sc = new Scanner(System.in);
                            System.out.println("Enter Contact Firstname: ");
                            String firstname = sc.nextLine();
                            System.out.println("Enter Contact Lastname: ");
                            String lastname = sc.nextLine();
                            System.out.println("Enter Contact Phone number: ");
                            String phone = sc.nextLine();
                            System.out.println("Enter Contact Address: ");
                            String address = sc.nextLine();
                            System.out.println("Please type \"yes\" If you want to save this contact. Type anything to discard this contact.");
                            Scanner sc1 = new Scanner(System.in);
                            String choice1 = sc1.next();
                            if (choice1.equalsIgnoreCase("yes")) {
                                personList.add(new Person(firstname, lastname, phone, address));
                                System.out.println("Details saved");
                            } else {
                                System.out.println("Details Discarded");
                            }
                            break;

                        case 2: // DELETE A CONTACT RECORD
                            displayContactList(personSorter.sort(personList, "id"));
                            Scanner sc2 = new Scanner(System.in);
                            while (true) {
                                System.out.println("Please Type Correct Contact ID to remove OR enter \"exit\" to go back to Main Menu. ");
                                String input = sc2.next();
                                if (input.equalsIgnoreCase("exit")) {
                                    break;
                                }
                                int intInputValue;
                                try {
                                    intInputValue = Integer.parseInt(input);
                                } catch (NumberFormatException n) {
                                    System.out.println("Please enter a valid numeric value.");
                                    continue;
                                }
                                if (listOfAllId(personList).contains(intInputValue)) {
                                    System.out.print("Contact ID found!");
                                    System.out.println("Are you sure you want to remove this contact? (Type Yes / No):");
                                    System.out.println(checkArray(intInputValue));
                                    String choice2 = sc2.next();
                                    if (choice2.equalsIgnoreCase("yes")) {
                                        removeContact(intInputValue);
                                        break;
                                    } else {
                                        System.out.println("Contact NOT deleted");
                                    }
                                    break;
                                }

                            }
                            break;

                        case 3: // EDIT A CONTACT RECORD
                            displayContactList(personList);
                            Scanner sc3 = new Scanner(System.in);
                            while (true) {
                                System.out.println("Please Type Correct Contact ID to Edit OR enter \"exit\" to go back to Main Menu. ");
                                String input = sc3.next();
                                if (input.equalsIgnoreCase("exit")) {
                                    break;
                                }
                                int intInputValue;
                                try {
                                    intInputValue = Integer.parseInt(input);
                                } catch (NumberFormatException n) {
                                    System.out.println("Please enter a valid numeric value.");
                                    continue;
                                }
                                if (listOfAllId(personList).contains(intInputValue)) {
                                    System.out.print("Contact ID found!");
                                    editContact(intInputValue);
                                    System.out.println("Changes Saved!");
                                    break;
                                }
                            }
                            break;

                        case 4: //GET SPECIFIC CONTACT RECORD INFORMATION
                            displayContactList(personSorter.sort(personList, "id"));
                            System.out.println("PLEASE ENTER CONTACT \"ID\" TO RETRIEVE SPECIFIC DETAILS");
                            Scanner sc4 = new Scanner(System.in);
                            while (true) {
                                System.out.println("Please Type Correct Contact ID to get Details OR Type \"exit\" to go back to Main Menu. ");
                                String input = sc4.next();
                                if (input.equalsIgnoreCase("exit")) {
                                    break;
                                }
                                int choice4;
                                try {
                                    choice4 = Integer.parseInt(input);
                                } catch (NumberFormatException n) {
                                    System.out.println("Please enter a valid numeric value.");
                                    continue;
                                }
                                if (listOfAllId(personList).contains(choice4)) {
                                    System.out.print("Contact ID found!");
                                    System.out.println(getContactInformation(choice4));
                                    break;
                                }
                            }
                            break;

                        case 5: // LIST ALL CONTACTS BY FIRST NAME
                            System.out.println("Sorting Contacts by Firstname");
                            displayContactList(personSorter.sort(personList, "firstname"));
                            exit = backToMenu();
                            break;

                        case 6: // LIST ALL CONTACTS BY LAST NAME
                            System.out.println("Sorting Contacts by Lastname");
                            displayContactList(personSorter.sort(personList, "lastname"));
                            exit = backToMenu();
                            break;

                        case 7: // TOTAL NUMBER OF SAVED CONTACTS
                            System.out.println(countContacts());
                            exit = backToMenu();
                            break;

                        case 8: // EXIT APPLICATION
                            System.out.println("Thank you for using this application! GoodBye");
                            exit = true;
                            break;
                        default:
                            System.out.println("Please enter correct input. Returning to main menu...");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid Choice Number");
                }
            }
        }
    }

    private static void displayMenu() {
        System.out.println("Menu : ");
        System.out.println("Type any number between 1 and 7 for selection");
        System.out.println("1)Create a new Contact Record");
        System.out.println("2)Remove a Contact Record");
        System.out.println("3)Edit a Contact Record");
        System.out.println("4)Get Specific Contact Record information");
        System.out.println("5)List all Contacts by Firstname");
        System.out.println("6)List all Contacts by Lastname");
        System.out.println("7)Show total number of Contacts");
        System.out.println("8)Exit");
    }

    private static void editContact(int choice3) {
        for (Person person : personList) {
            if (person.getId() == choice3) {
                Scanner input = new Scanner(System.in);
                System.out.println("Please enter Contact First Name." + " Current Value : " + person.getFirstname());
                System.out.println("Please leave blank if no changes required");
                String firstname = input.nextLine();
                if (!firstname.equals("")) {
                    person.setFirstname(firstname);
                }

                System.out.println("Please enter Contact Last Name." + " Current Value : " + person.getLastname());
                System.out.println("Please leave blank if no changes required");
                String lastname = input.nextLine();
                if (!lastname.equals("")) {
                    person.setLastname(lastname);
                }

                System.out.println("Please enter Contact Address." + " Current Value : " + person.getAddress());
                System.out.println("Please leave blank if no changes required");
                String address = input.nextLine();
                if (!address.equals("")) {
                    person.setAddress(address);
                }

                System.out.println("Please enter Contact Phone." + " Current Value : " + person.getPhone());
                System.out.println("Please leave blank if no changes required");
                String phone = input.nextLine();
                if (!phone.equals("")) {
                    person.setPhone(phone);
                }
                break;
            }
        }
    }

    private static void displayContactList(List<Person> personList) {
        System.out.println("ID | FULL NAME");
        for (Person person : personList) {
            System.out.println(person.getId() + "  | " + person.getFirstname() + " " + person.getLastname());
        }
    }

    private static String getContactInformation(int inp) {
        int id = 0;
        for (Person p : personList) {
            if (p.getId() == inp) {
                id = personList.indexOf(p);
            }
        }
        return "ID : " + personList.get(id).getId() + "\n" +
                "First Name : " + personList.get(id).getFirstname() + "\n" +
                "Last Name : " + personList.get(id).getLastname() + "\n" +
                "Address : " + personList.get(id).getAddress() + "\n" +
                "Phone : " + personList.get(id).getPhone();
    }

    private static Person checkArray(int in) {
        Person personFound = null;
        for (Person p : personList) {
            if (p.getId() == in) {
                personFound = personList.get(personList.indexOf(p));
            }
        }
        return personFound;
    }

    private static void removeContact(int in) {
        for (int i = 0; i < personList.size(); i++) {
            if (personList.get(i).getId() == in) {
                personList.remove(i);
                System.out.println("Contact REMOVED successfully!");
                break;
            }
        }
    }

    private static boolean backToMenu() {
        boolean exit = false;
        System.out.println("Return to Main Menu? Type Yes / No");
        Scanner sc2 = new Scanner(System.in);
        if (sc2.next().equalsIgnoreCase("no"))
            exit = true;
        return exit;
    }

    private static String countContacts() {
        return "There are " + personList.size() + " contacts in the address book.";
    }

    private static ArrayList<Integer> listOfAllId(ArrayList<Person> list) {
        ArrayList<Integer> idList = new ArrayList<>();
        for (Person p : list) {
            idList.add(p.getId());
        }
        return idList;
    }
}