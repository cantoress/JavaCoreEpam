package storage;

public final class SequenceIDGenerator {
    private static long value = 0;

    private SequenceIDGenerator() {
    }

    public static long getNextID() {
        return ++value;
    }
}
