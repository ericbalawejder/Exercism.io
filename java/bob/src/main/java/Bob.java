class Bob {

    String hey(String remark) {
        if (isYelling(remark) && isAQuestion(remark)) {
            return  "Calm down, I know what I'm doing!";
        } else if (isYelling(remark)) {
            return  "Whoa, chill out!";
        } else if (isAQuestion(remark)) {
            return "Sure.";
        } else if (isSilence(remark)) {
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

    private boolean isSilence(String remark) {
        return remark.trim().isEmpty();
    }

}