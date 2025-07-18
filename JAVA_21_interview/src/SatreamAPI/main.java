package SatreamAPI;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class main {
    public static void main(String[] args) {
        System.out.println(haveSameCharacters("BEeUL", "BUEeL"));  // true

        List<Employee>list =     List.of(new Employee("Agnic","dep1",10000.00),
                new Employee("jhon","dep2",13000.00),
                new Employee("damin","dep3",20000.00),
                new Employee("luki","dep1",40000.00),
                new Employee("langcgeg","dep2",20000.00),
                new Employee("Taktuk","dep2",50000.00),
                new Employee("aman","dep3",60000.00),
                new Employee("Disha","dep3",20000.00),
                new Employee("lajug","dep2",70000.00));

        Map<String, Double> collect = list.stream().collect(Collectors.groupingBy(Employee::getDept, Collectors.averagingDouble(Employee::getSalary)));
System.out.println("Map of averageing salary::"+collect);
        Map<String, Double> collect1 = list.stream()
                .collect(Collectors.toMap(
                        e -> e.getDept(),
                        e -> e.getSalary(),
                        (existing, duplicate) -> existing // keep the first salary encountered
                ));
        System.out.println("Map of toMap salary::"+collect1);
        List<Employee> collect2 = list.stream().sorted(Comparator.comparing(Employee::getSalary).reversed().thenComparing(Employee::getDept)).collect(Collectors.toList());


        Map<String, Double> collect3 = list.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDept,
                        Collectors.collectingAndThen(
                                Collectors.mapping(Employee::getSalary,
                                        Collectors.toList()),
                                salaries -> salaries.stream()
                                        .collect(Collectors.averagingDouble(Double::doubleValue))
                        )
                ));

        Map<String, List<Double>> collect4 = list.stream().filter(e -> (e.getSalary() > 20000.00)).sorted(Comparator.comparing(Employee::getSalary).reversed()).collect(Collectors.groupingBy(Employee::getDept, Collectors.mapping(Employee::getSalary, Collectors.toList())));
        System.out.println("Cpllect$::"+collect4);

        List<Employee> e=  list.stream().sorted(Comparator.comparing(Employee::getSalary).reversed().thenComparing(Employee::getDept)).collect(Collectors.toList());
        System.out.println("collect5::"+e);
        e.forEach(s -> System.out.println(s.getSalary() + ":::::::::" + s.getName()));
        Map<String, Double> sortedMap = e.stream()
                .collect(Collectors.toMap(
                        Employee::getName,
                        Employee::getSalary,
                        (existing, duplicate) -> existing // keep the first one
                ))
                .entrySet()
                .stream()
                .sorted(
                        Comparator.comparing(Map.Entry<String, Double>::getKey).reversed()
                                .thenComparing(Map.Entry<String, Double>::getValue).reversed()
                )
                .collect(Collectors.toMap(
                        Map.Entry<String, Double>::getKey,
                        Map.Entry<String, Double>::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new
                ));
        System.out.println("collect6::"+sortedMap);
        List<Double> t = list.stream().map(s -> s.getSalary() * 1.10).collect(Collectors.toList());
        System.out.println(t);
    }
    public static boolean haveSameCharacters(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        return Arrays.equals(arr1, arr2);
    }


}
