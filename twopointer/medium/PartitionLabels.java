package twopointer.medium;

import utils.info.Enhance;
import utils.info.Question;
import utils.info.Stat;
import utils.info.UsedHints;

import java.util.LinkedList;
import java.util.List;

@Question(url = "https://leetcode.com/problems/partition-labels/")
@UsedHints
@Enhance(reduce = Stat.TIME)
public class PartitionLabels {

    public List<Integer> partitionLabels(String S) {
        int[] lastSeen = new int[26];
        for (int i = 0; i < S.length(); i++)
            lastSeen[S.charAt(i)-'a'] = i;

        int j = 0, anchor = 0;
        List<Integer> answer = new LinkedList<>();
        for (int i = 0; i < S.length(); i++) {
            j = Math.max(j, lastSeen[S.charAt(i) - 'a']);
            if (i == j) {
                answer.add(i - anchor + 1);
                anchor = i + 1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        PartitionLabels partitionLabels = new PartitionLabels();
        System.out.println(partitionLabels.partitionLabels("ababcbacadefegdehijhklij"));
    }

}
