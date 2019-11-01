class Bob {

    String hey(String remark) {
        if (isYellingAQuestion(remark)) {
            return  "Calm down, I know what I'm doing!";
        } else if (isYelling(remark)) {
            return  "Whoa, chill out!";
        } else if (isAQuestion(remark)) {
            return "Sure.";
        } else if (isSayingAnything(remark)) {
            return  "Fine. Be that way!";
        } else {
            return "Whatever.";
        }
    }

    private boolean isAQuestion(String remark) {
        return remark.trim().endsWith("?");
    }

    private boolean isYelling(String remark) {
        return remark.equals(remark.toUpperCase()) && !remark.equals(remark.toLowerCase());
    }

    private boolean isYellingAQuestion(String remark) {
        return remark.equals(remark.toUpperCase()) && !remark.equals(remark.toLowerCase()) &&
                remark.endsWith("?");
    }

    private boolean isSayingAnything(String remark) {
        return remark.matches("\\s*");
    }

}