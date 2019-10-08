import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class PersonSorter {
    List<Person> sort(List<Person> personList, final String type) {
        Collections.sort(personList, new Comparator<Person>(){
            int result;
            public int compare(Person a,Person b){
                switch (type.toLowerCase()){
                    case "firstname":
                        result =  a.getFirstname().compareTo(b.getFirstname());
                        break;
                    case "lastname":
                        result =  a.getLastname().compareTo(b.getLastname());
                        break;
                    case "id":
                        result =  Integer.compare(a.getId(), b.getId());
                        break;
                }
                return result;
            }
        });
        return personList;
    }
}
