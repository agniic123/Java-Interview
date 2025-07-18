import SatreamAPI.Employee;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6, 7, 89, 8, 9, 10);

        List<Integer> collect = integers.stream().takeWhile(e -> e % 2 == 0).collect(Collectors.toList());

        System.out.println("Hello world!"+collect);

        char [] sc={'p','s'};

        Employee employee=new Employee(String.valueOf(sc),null,null);
        System.out.println(employee.getName());

      

    }
}