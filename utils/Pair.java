package utils;

public class Pair<F, S> {
    private final F first;
    private final S second;

    public F first() { return first; }
    public S second() { return second; }

    public Pair(F f, S s) {
        this.first = f;
        this.second = s;
    }

    @Override
    public String toString() {
        return "First -> " + first + " | Second -> " + second;
    }
}
