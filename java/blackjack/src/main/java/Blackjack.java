package game;

import card.Rank;
import deck.Deck;

public class Blackjack {

    private static final String WIN = "W";
    private static final String STAND = "S";
    private static final String SPLIT = "P";
    private static final String HIT = "H";
    private static final int BLACKJACK = 21;
    private static final Deck deck = new Deck();

    int parseCard(String card) {
        return deck.getValue(new Rank(card)).value();
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
