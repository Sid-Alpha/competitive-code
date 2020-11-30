package stack.medium;

import utils.info.Enhance;
import utils.info.Question;
import utils.info.Stat;

import java.util.Arrays;
import java.util.Stack;

@Question(url = "https://leetcode.com/problems/asteroid-collision/")
@Enhance(reduce = Stat.TIME)
public class AsteroidCollision {

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> asteroidHolder = new Stack<>();
        l1 : for (int asteroid : asteroids) {
            while (!asteroidHolder.isEmpty() && asteroidHolder.peek() > 0 && asteroid < 0)
                if (Math.abs(asteroid) > Math.abs(asteroidHolder.peek())) asteroidHolder.pop();
                else if (Math.abs(asteroid) == Math.abs(asteroidHolder.peek())) { asteroidHolder.pop(); continue l1; }
                else continue l1;
            asteroidHolder.push(asteroid);
        }
        int[] answer = new int[asteroidHolder.size()];
        for (int i = 0; i < asteroidHolder.size(); i ++) answer[i] = asteroidHolder.elementAt(i);
        return answer;
    }

    public static void main(String[] args) {
        AsteroidCollision aC = new AsteroidCollision();
        System.out.println(Arrays.toString(aC.asteroidCollision(new int[]{5, 10, -5})));
        System.out.println(Arrays.toString(aC.asteroidCollision(new int[]{8, -8})));
        System.out.println(Arrays.toString(aC.asteroidCollision(new int[]{10, 2, -5})));
        System.out.println(Arrays.toString(aC.asteroidCollision(new int[]{-2, -1, 1, 2})));
    }
}
