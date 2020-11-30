package interview.easy.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public class duplicateInArray {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        AtomicBoolean val = new AtomicBoolean(false);
        Arrays.stream(nums).forEach(i -> {
            if(!set.add(i)) val.set(true);
        });
        return val.get();
    }
}
