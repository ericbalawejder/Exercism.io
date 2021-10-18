class LogLevels {

    static String message(String logLine) {
        return logLine.split(":")[1].trim();
    }

    static String logLevel(String logLine) {
        return logLine.replaceFirst(".*\\[(.*?)\\]:.*", "$1")
                .toLowerCase()
                .trim();
    }

    static String reformat(String logLine) {
        return String.format("%s (%s)", message(logLine), logLevel(logLine));
    }

}
