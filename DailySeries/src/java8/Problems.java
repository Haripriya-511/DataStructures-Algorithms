package java8;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problems {
    public static List<Employee> employees ;
    @BeforeEach
    public void setup(){
        employees = Arrays.asList(
                new Employee("Alice", 95000, "Engineering","Female",26),
                new Employee("Bob", 87000, "Engineering","Male",28),
                new Employee("Charlie", 99000, "Engineering","Male",69),
                new Employee("David", 75000, "Engineering","Male",74),
                new Employee("Eve", 88000, "HR","Male",63),
                new Employee("Frank", 92000, "HR","Male",52),
                new Employee("Grace", 88000, "HR","Female",20),
                new Employee("Heidi", 89000, "HR","Female",52),
                new Employee("Ivan", 102000, "Sales","Male",63),
                new Employee("Judy", 98000, "Sales","Female",87),
                new Employee("Ken", 96000, "Sales","Male",23),
                new Employee("Leo", 91000, "Sales","Male",86),
                new Employee("Mallory", 78000, "Marketing","Female",47),
                new Employee("Niaj", 82000, "Marketing","Male",44),
                new Employee("Olivia", 80000, "Marketing","Female",32),
                new Employee("Peggy", 85000, "Marketing","Male",19)
        );
    }
    @Test
    public void findFrequencyOfEachChaar(){
        String str="ThIs iS AweSomE";
        Map<Character, Long> map =
                str.toLowerCase()
                        .chars()
                        .mapToObj(ch-> (char)ch)
                        .filter(ch -> ch != ' ')
                        .collect(Collectors.groupingBy(c-> c, Collectors.counting()));


        for(Map.Entry<Character,Long> entry: map.entrySet())
            System.out.println(entry);

    }
    @Test
    public void separateEvenOdd(){
        List<Integer> ll=Arrays.asList(1,2,3,45,56,78,89);
        System.out.println(ll.stream().
                collect(Collectors.groupingBy(i->i%2==0?"Even":"Odd")));
    }
    @Test
    public void unionOfTwLists(){
        int arr1[]={11,24,3,4,5,6,7,8,9};
        int arr2[]={3,4,5,6,7,54,23,90};
        Set<Integer> set1 = Arrays.stream(arr1)
                .boxed()
                .collect(Collectors.toSet());
        List<Integer> result = Arrays.stream(arr2)
                .boxed()
                .filter(set1::contains)
                .collect(Collectors.toList());
        System.out.println(result);
    }

    @Test
    public void highestPaying(){
        // highest salaried employees
        List<String> top3 = employees.stream()
                .sorted(Comparator.comparingLong(Employee::getSalary).reversed())
                .limit(3)
                .map(Employee::getName)
                .collect(Collectors.toList());
        System.out.println(top3);
        // highest paid per dept
        Map<String, List<String>> top3PerDept = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,// key in map
                        Collectors.collectingAndThen(
                                Collectors.toList(),// collects all Employees into a List
                                list -> list.stream()
                                        .sorted(Comparator.comparingLong(Employee::getSalary).reversed())
                                        .limit(3)
                                        .map(Employee::getName)
                                        .collect(Collectors.toList())// collects list of names
                        )
                ));
        System.out.println(top3PerDept);
    }

    //employee count according to gender having salary more than 50 k
    // no of male employees having salary more than 50 k and same in female
    //Ex: [{"Male": 5}, {"Female":6"}]
    @Test
    public  void employeeCount(){
        Map<String, Long> collect = employees.stream()
                .filter(employee -> employee.getSalary() > 50000)// filtered employees having above 50K
                .collect(Collectors.groupingBy(Employee::getGender,// Key of map
                        Collectors.counting()));//value of map
        System.out.println(collect);
    }
    @Test
    public  void findMinMax(){
        List<Integer> l= Arrays.asList(10,2,3,4,5,6,7,80);
        //my way
        System.out.println("max:"+l.stream().sorted(Comparator.reverseOrder()).limit(1).findFirst());
        System.out.println("min:"+l.stream().sorted(Comparator.naturalOrder()).limit(1).findFirst());

    }
    @Test
    public  void mostYoungestEmployee(){
        Employee employee = employees.stream()
                .sorted(Comparator.comparingInt(Employee::getAge))
                .limit(1)
                .findFirst().get();
        System.out.println(employee);
    }
    @Test
    public  void averageAgePerDept(){
        Map<String, Double> collect = employees.stream()
                .collect(
                        Collectors.groupingBy(Employee::getDepartment,
                                Collectors.averagingInt(Employee::getAge)
                        ));
        System.out.println(collect);
    }
    @Test
    public void nonRepeatingChaarcters(){
        String str= "am new army person";
        Character c1 = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream().filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst().get();
        System.out.println("Non repeating characters:"+c1);
    }
    @Test
    public void lastElementOfArray(){
        List<String> l=Arrays.asList("Java", "Python", "C#", "HTML", "Kotlin", "C++", "COBOL","Cpoiu");
        List<Character> lastELements = l.stream().map(s -> s.charAt(s.length() - 1)).collect(Collectors.toList());
        System.out.println(lastELements);

        String lastElement = l.stream().reduce((first,second)-> second).get();

        System.out.println(lastElement);
    }
    @Test
    public void sortStringsInIncOrderOfLength(){
        //Given a list of strings, sort them according to increasing order of their length?
        List<String> l=Arrays.asList("Java", "Python", "C#", "HTML", "Kotlin", "C++", "COBOL","Cpoiu");
        l.stream()
                .sorted((a, b) -> a.length() - b.length())
                .forEach(System.out::println);
    }
    @Test
    public void vowelsIndices(){
        String vowels="aeiojkplenbbyuaol";
        List<String> collect1 = IntStream.range(0, vowels.length())
                .filter(i -> {
                    char ch = vowels.charAt(i);
                    boolean b = (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u');
                    return b;
                }).mapToObj(i -> vowels.charAt(i) + " -> " + i)
                .collect(Collectors.toList());
        System.out.println(collect1);

        List<Character> collect2 = vowels.chars()
                .mapToObj(c -> (char) c)
                .filter(ch -> {
                    boolean b = (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u');
                    return b;
                }).collect(Collectors.toList());
        System.out.println(collect2);




    }

}
