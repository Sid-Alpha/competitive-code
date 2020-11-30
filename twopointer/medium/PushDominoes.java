package twopointer.medium;

import utils.info.Garbage;
import utils.info.Question;
import utils.info.Unfinished;

@Question(url = "https://leetcode.com/problems/push-dominoes/")
@Garbage
@Unfinished
public class PushDominoes {

    public String pushDominoes(String dominoes) {
        return null;
    }

    public static void main(String[] args) {
        PushDominoes pushDominoes = new PushDominoes();
        System.out.println(pushDominoes.pushDominoes(".L.R...LR..L.."));    // "LL.RR.LLRRLL.."
        System.out.println(pushDominoes.pushDominoes("RR.L"));  // "RR.L"
    }

}
