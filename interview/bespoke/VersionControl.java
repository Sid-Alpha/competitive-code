package interview.bespoke;

public class VersionControl {
    private final int badVersion;
    public VersionControl(int badVersion) {
        this.badVersion = badVersion;
    }

    public boolean isBadVersion(int version) {
        return version >= badVersion;
    }
}