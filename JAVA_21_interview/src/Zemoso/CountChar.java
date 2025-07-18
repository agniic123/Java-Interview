package Zemoso;

import java.util.function.Function;
import java.util.stream.Collectors;

public class CountChar {

    public static void main(String[] args) {
        String s="ssssdddffrrwww";
        s.chars().mapToObj(c->(char) c).collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).entrySet().stream() .map(entry -> entry.getKey() + "" + entry.getValue()) // convert each entry to String
                .collect(Collectors.joining());
    }
}
