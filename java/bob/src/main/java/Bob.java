class Bob {

    String hey(String remark) {
        String response;
        if (remark.equals(remark.toUpperCase()) && !remark.equals(remark.toLowerCase()) &&
                remark.matches(".*\\?$")) {
            response = "Calm down, I know what I'm doing!";
        } else if (remark.equals(remark.toUpperCase()) && !remark.equals(remark.toLowerCase())) {
            response = "Whoa, chill out!";
        } else if (remark.trim().matches(".*\\?$")) {
            response = "Sure.";
        } else if (remark.matches("\\s*")) {
            response = "Fine. Be that way!";
        } else {
            response = "Whatever.";
        }
        return response;
    }

}