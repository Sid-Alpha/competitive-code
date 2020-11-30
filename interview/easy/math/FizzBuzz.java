package interview.easy.math;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
    public static List<String> fizzBuzz(int n) {
        List<String> l = new ArrayList<>();
        for(int i=1;i<=n;i++) {
            if(i%5==0 & i%3==0) l.add("FizzBuzz");
            else if(i%5==0) l.add("Buzz");
            else if(i%3==0) l.add("Fizz");
            else l.add(String.valueOf(i));
        }
        return l;
    }


    public static void main(String[] args) {
        fizzBuzz(20).forEach(System.out::println);
    }
}

