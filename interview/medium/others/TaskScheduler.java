package interview.medium.others;

import utils.info.Garbage;
import utils.info.Question;
import utils.info.Unfinished;
import utils.info.UsedHints;

import java.util.Arrays;

@Question(url = "https://leetcode.com/explore/interview/card/top-interview-questions-medium/114/others/826/")
@Garbage
@UsedHints
public class TaskScheduler {

    public int leastInterval(char[] tasks, int n) {
        if (tasks == null || tasks.length == 0) return 0;
        int[] taskGroupCount = new int[26];

        for(int i = 0; i < tasks.length; i++)
            taskGroupCount[tasks[i]-'A']++;

        int maxTaskFreq = Arrays.stream(taskGroupCount).max().getAsInt();
        int maxCounts = (int) Arrays.stream(taskGroupCount).filter(s -> s == maxTaskFreq).count();
        int windows = maxTaskFreq - 1;
        int spaceInWindow = windows * (n - maxCounts + 1);
        int totalRemainingTasks = tasks.length - (maxTaskFreq * maxCounts);
        int idles = Math.max(0, spaceInWindow - totalRemainingTasks);

        return idles + tasks.length;
    }

    public static void main(String[] args) {
        TaskScheduler taskScheduler = new TaskScheduler();
        System.out.println(taskScheduler.leastInterval(new char[]{'A','A','A','B','B','B'}, 2));
        System.out.println(taskScheduler.leastInterval(new char[]{'A','A','A','B','B','B'}, 0));
        System.out.println(taskScheduler.leastInterval(new char[]{'A','A','A','A','A','A','B','C','D','E','F','G'}, 2));
        System.out.println(taskScheduler.leastInterval(new char[]{'A','A','B','B','C','C','D','D','E','E','F','F','G','G'}, 2));
        System.out.println(taskScheduler.leastInterval(new char[]{'A','A','B','B','C','C','D','D','E','E','F','F','G','G', 'H','H','I','I','J','J','K','K','L','L','M','M','N','N','O','O','P','P','Q','Q','R','R','S','S','T','T','U','U','V','V','W','W','X','X','Y','Y','Z','Z'},2));
    }
}
