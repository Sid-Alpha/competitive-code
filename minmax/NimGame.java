package minmax;

import utils.info.NewAlgo;
import utils.info.Question;

@Question(url = "https://leetcode.com/problems/nim-game/")
@NewAlgo(details = "Check Nim game in game theory")
public class NimGame {

    public boolean canWinNim(int n) {
        return (n % 4) != 0;
    }

    public static void main(String[] args) {
        NimGame nimGame = new NimGame();
        System.out.println(nimGame.canWinNim(4));
    }

}
