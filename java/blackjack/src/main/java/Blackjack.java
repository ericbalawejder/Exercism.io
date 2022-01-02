import java.util.Map;

class Blackjack {

    private static final String WIN = "W";
    private static final String STAND = "S";
    private static final String SPLIT = "P";
    private static final String HIT = "H";
    private static final int BLACKJACK = 21;
    private static final Map<String, Integer> CARDS_BY_SCORE = Map.ofEntries(
            Map.entry("ace", 11),
            Map.entry("king", 10),
            Map.entry("queen", 10),
            Map.entry("jack", 10),
            Map.entry("ten", 10),
            Map.entry("nine", 9),
            Map.entry("eight", 8),
            Map.entry("seven", 7),
            Map.entry("six", 6),
            Map.entry("five", 5),
            Map.entry("four", 4),
            Map.entry("three", 3),
            Map.entry("two", 2)
    );

    int parseCard(String card) {
        return CARDS_BY_SCORE.getOrDefault(card, 0);
    }

    boolean isBlackjack(String card1, String card2) {
        return CARDS_BY_SCORE.getOrDefault(card1, 0) +
                CARDS_BY_SCORE.getOrDefault(card2, 0) == BLACKJACK;
    }

    String largeHand(boolean isBlackjack, int dealerScore) {
        if (isBlackjack && !(dealerScore == 10 || dealerScore == 11)) {
            return WIN;
        } else if (isBlackjack) {
            return STAND;
        } else {
            return SPLIT;
        }
    }

    String smallHand(int handScore, int dealerScore) {
        if (handScore >= 12 && handScore <= 16 && dealerScore >= 7) {
            return HIT;
        } else if (handScore >= 12) {
            return STAND;
        } else {
            return HIT;
        }
    }

    String firstTurn(String card1, String card2, String dealerCard) {
        final int handScore = parseCard(card1) + parseCard(card2);
        final int dealerScore = parseCard(dealerCard);

        return handScore > 20 ? largeHand(isBlackjack(card1, card2), dealerScore) :
                smallHand(handScore, dealerScore);
    }

}
