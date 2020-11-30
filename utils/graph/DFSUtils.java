package utils.graph;

public class DFSUtils {

    public enum DFSState {
        WHITE(false), BLACK(false), GREY(true);

        final boolean loop;
        DFSState(boolean loop) {this.loop = loop;}
    }

}
