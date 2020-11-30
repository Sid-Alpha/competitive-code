package interview.easy.sortAndSearch;

import interview.bespoke.VersionControl;
import utils.info.Enhance;

@Enhance(details = "Reduce time complexity")
public class FirstBadVersion extends VersionControl {
    private FirstBadVersion(int badVersion) {
        super(badVersion);
    }

    public int firstBadVersion(int n) {
        long low = 1, high = n;
        while(low < high)
        {
            if(isBadVersion((int)((low+high)/2))) high = (low+high)/2;
            else low = (low + high)/2;
            if(Math.abs(high-low)==1) break;
        }
        return isBadVersion((int)low) ? (int)low: (int)high;
    }

    public static void main(String[] args) {
        System.out.println(new FirstBadVersion(1).firstBadVersion(10));
        System.out.println(new FirstBadVersion(8).firstBadVersion(10));
        System.out.println(new FirstBadVersion(6).firstBadVersion(10));
        System.out.println(new FirstBadVersion(2).firstBadVersion(11));
        System.out.println(new FirstBadVersion(3).firstBadVersion(11));
        System.out.println(new FirstBadVersion(1702766719).firstBadVersion(2126753390));
    }
}
