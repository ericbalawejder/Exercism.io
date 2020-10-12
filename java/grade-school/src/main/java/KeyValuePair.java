final class KeyValuePair implements Comparable<KeyValuePair>{
    private final String key;
    private final int value;

    KeyValuePair(String key, int value) {
        this.key = key;
        this.value = value;
    }

    public int compareTo(KeyValuePair o) {
        return value == o.value ? key.compareTo(o.key) : value - o.value;
    }

    int getValue() {
        return this.value;
    }

    String getKey() {
        return this.key;
    }
}