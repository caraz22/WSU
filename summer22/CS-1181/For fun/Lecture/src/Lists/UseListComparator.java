package Lists;
//Sorting: using the Comparable<T> interface
//Comparable<T> defines "natural order" of a comparable class
//
//Sorting: using the Comparator<T> interface
//
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class UseListComparator {

public static void main(String[] args) {
        //sort
        List<Student> listStudents = new ArrayList<>();
        listStudents.add(new Student("Chris", 1010, 4.0));
        listStudents.add(new Student("Alex", 1003, 3.0));
        listStudents.add(new Student("Grant", 1006, 4.0));
        listStudents.add(new Student("Nathan", 1005, 3.2));
        //null is allowed to be added to an ArrayList
        //listStudents.add(null);//This will break sort if null is not properly handled by Comparable<T>

        /*listStudents = Arrays.asList(
                new Student("Chris", 1010, 4.0),
                new Student("Alex", 1003, 3.0),
                new Student("Grant", 1006, 4.0),
                new Student("Nathan", 1005, 3.2));*/ //array-backed arraylist
        
        System.out.println("Before sort using natural order----");
        System.out.println(listStudents);
        listStudents.sort(null);//use sort() of ArrayList; null means using "natural order"
        System.out.println("Sort using natural order++++");
        System.out.println(listStudents);

        
        System.out.println("");
        System.out.println("Sort using grade comparator----");
        listStudents.sort(new ByGrade());//sort() takes a comparator object
        System.out.println(listStudents);
        
        System.out.println("");
        System.out.println("Sort using grade comparator reversed ----");
        listStudents.sort(new ByGrade().reversed());
        System.out.println(listStudents);
        
        System.out.println("");
        System.out.println("Sort using grade comparator reversed and sorted by id comparator ----");
        listStudents.sort(new ByGrade().reversed().thenComparing(new ById()));
        System.out.println(listStudents);

        //Now go back to sorting using "natural order"
        //Notice we use static method of Comparator interface for comparator
        //
        System.out.println("");
        System.out.println("Sort using natural order++++ again");
        listStudents.sort(Comparator.naturalOrder());
        System.out.println(listStudents);
        //Reverse the natural order
        System.out.println("Reverse the natural order++++");
        listStudents.sort(Comparator.reverseOrder());
        System.out.println(listStudents);

        System.out.println("\nHandle null-----");
        //add null entry to ArrayList
        listStudents.add(null);//cannot add/remove if you created listStudents using Arrays.asList
        //sort() that handles null
        //null entry appears before others
        System.out.println("\nnullsFirst");
        listStudents.sort(Comparator.nullsFirst(new ByGrade()));
        System.out.println(listStudents);
        //null entry appear after others
        System.out.println("\nnullsLast");
        listStudents.sort(Comparator.nullsLast(new ByGrade()));
        System.out.println(listStudents);

        //Sort using Collections sort API
        System.out.println("\nCollections sort API");
        listStudents.remove(null);//let us remove null from the list; otherwise code breaks
        Collections.sort(listStudents);//sort by "natural order"
        System.out.println(listStudents);
        
        System.out.println("\nByGrade++++");//sort using comparator
        Collections.sort(listStudents, new ByGrade());
        //use labmda
        //Collections.sort(listStudents, (s1, s2) -> Double.compare(s1.getGrade(), s2.getGrade()));
        /*
        ByGrade compareByGrade = new ByGrade();
        Collections.sort(listStudents, compareByGrade::compare);//method reference
        */
        System.out.println(listStudents);

        System.out.println("\nById++++");
        Collections.sort(listStudents, new ById());
        //use lambda
        //Collections.sort(listStudents, (s1, s2) -> Integer.compare(s1.getId(), s2.getId()));
        /*
        ById compareById = new ById();
        Collections.sort(listStudents, compareById::compare);//method reference
        */
        System.out.println(listStudents);

        System.out.println("\nById reversed and then ByGrade++++");
        Collections.sort(listStudents, new ById().reversed().thenComparing(new ByGrade()));
        System.out.println(listStudents);

    }

}

//Comparable<T> interface defines "natural order"
//
class Student implements Comparable<Student> {

    private final String name;
    private final int id;
    private double grade;

    public Student(String name, int id, double grade) {
        this.name = name;
        this.id = id;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "Student{" + "name=" + name + ", id=" + id + ", grade=" + grade + '}';
    }

    @Override
    public int compareTo(Student t) {
        t = Objects.requireNonNull(t, "Parameter nullpointer.");
        return this.name.compareTo(t.name);
    }

}

//Comparator<T> functional interface
//Class implements Comparator<T> interface
//
class ByGrade implements Comparator<Student> {

    @Override
    public int compare(Student t, Student t1) {
        return Double.compare(t.getGrade(), t1.getGrade());
    }

}

//Class implements Comparator<T> interface
//
class ById implements Comparator<Student> {

    @Override
    public int compare(Student t, Student t1) {
        return Integer.compare(t.getId(), t1.getId());
    }

}
