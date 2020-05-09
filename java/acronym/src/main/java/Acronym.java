class Acronym {
    private final String phrase;
    
    Acronym(String phrase) {
        this.phrase = generateAcronym(phrase);
    }

    String get() {
        return phrase;
    }

    private String generateAcronym(String phrase) {
        return phrase.replaceAll("[^a-zA-Z\\s-]", "")
                .replaceAll("\\B.", "")
                .replaceAll("\\s+|-", "")
                .toUpperCase();
    }

}
