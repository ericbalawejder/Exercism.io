class MicroBlog {

    private static final int MAX = 5;

    public String truncate(String input) {
        return input.codePoints()
                .limit(MAX)
                .collect(StringBuilder::new,
                        StringBuilder::appendCodePoint,
                        StringBuilder::append)
                .toString();
    }

}
