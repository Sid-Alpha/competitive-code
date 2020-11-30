package bfs.medium;

import utils.info.Enhance;
import utils.info.Question;
import utils.info.Stat;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

@Question(url = "https://leetcode.com/problems/lexicographically-smallest-string-after-applying-operations/")
@Enhance(reduce = {Stat.SPACE, Stat.TIME})
public class LexicographicallySmallestStringAfterApplyingOperations {

    public String findLexSmallestString(String s, int a, int b) {
        HashSet<String> stringData = new HashSet<>();
        String answer = s, current;
        Queue<String> q = new LinkedList<>();
        stringData.add(s);
        StringBuilder sb = new StringBuilder();
        if (s != null) q.offer(s);
        while (!q.isEmpty()) {
            current = q.poll();
            if (answer.compareTo(current) > 0) answer = current;
            sb.setLength(0);
            sb.append(current, b, s.length());
            sb.append(current, 0, b);
            if (stringData.add(sb.toString())) q.offer(sb.toString());

            sb.setLength(0);
            for(int i = 0; i < current.length(); i++)
                if (i % 2 == 0) sb.append(current.charAt(i));
                else sb.append((current.charAt(i) - '0' + a) % 10);
            if (stringData.add(sb.toString())) q.offer(sb.toString());
        }

        return answer;
    }

    public static void main(String[] args) {
        LexicographicallySmallestStringAfterApplyingOperations lsso = new LexicographicallySmallestStringAfterApplyingOperations();
        System.out.println(lsso.findLexSmallestString("5525", 9, 2));
        System.out.println(lsso.findLexSmallestString("74", 5, 1));
        System.out.println(lsso.findLexSmallestString("0011", 4 ,2));
        System.out.println(lsso.findLexSmallestString("43987654", 7 ,3));
    }

}
