package interview.easy;

import java.time.Instant;
import java.util.function.Supplier;

public class RunTimeCompute {

    public static<O> O compute(Supplier<O> function){
        long startTime = Instant.now().toEpochMilli();

        O output = function.get();
        long endTime = Instant.now().toEpochMilli();
        System.out.println("Time executed: " + (endTime-startTime) + " ms");

        return output;
    }
}
