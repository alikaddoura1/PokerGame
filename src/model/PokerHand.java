/** 
 * class PokerHand is a hand of cards for poker. Checks to see what kind of hand they are There are
 * no comments before methods because the method name says it all.
 * 
 * @author Rick Mercer and Ali Kaddoura
 */
package model;

import java.util.ArrayList;
import java.util.Collections;

public class PokerHand implements Comparable<PokerHand> {
	ArrayList<Card> cards;
	private int handType;
	private int highestCard;
	private int lowCard;
	private int onePair;
	private int twoPair;
	private int kicker;

	private static final int ROYAL_FLUSH = 10;
	private static final int STRAIGHT_FLUSH = 9;
	private static final int FOUR_OF_A_KIND = 8;
	private static final int FULL_HOUSE = 7;
	private static final int FLUSH = 6;
	private static final int STRAIGHT = 5;
	private static final int THREE_OF_A_KIND = 4;
	private static final int TWO_PAIR = 3;
	private static final int ONE_PAIR = 2;
	private static final int HIGH_CARD = 1;

	public PokerHand(Card c1, Card c2, Card c3, Card c4, Card c5) {

		cards = new ArrayList<Card>();

		if (cards.contains(c1))

			throw new IllegalArgumentException();

		else

			cards.add(c1);

		if (cards.contains(c2))

			throw new IllegalArgumentException();

		else

			cards.add(c2);

		if (cards.contains(c3))

			throw new IllegalArgumentException();

		else

			cards.add(c3);

		if (cards.contains(c4))
 
			throw new IllegalArgumentException();

		else

			cards.add(c4);

		if (cards.contains(c5))

			throw new IllegalArgumentException();

		else

			cards.add(c5);

		Collections.sort(cards);

		this.checkHand();

	}

	public String toString() {
		String result = "";
		for (int i = 0; i < cards.size(); i++) {
			result += cards.get(i).toString() + " ";

		}
		return result;
	}

	public boolean isRoyalFlush() {
		Card currentCard = cards.get(0);
		int currentValue = currentCard.getValue();
		Suit currentSuit = currentCard.getSuit();
		highestCard = cards.get(cards.size() - 1).getValue();

		for (int i = 1; i < cards.size(); i++) {
			int nextValue = cards.get(i).getValue();
			Suit nextSuit = cards.get(i).getSuit();
			if ((nextValue != currentValue + 1) || nextSuit != currentSuit) {
				return false;
			} else {
				currentValue = nextValue;
				currentSuit = nextSuit;
			}
		}
		if (this.highestCard == 14) {
			handType = ROYAL_FLUSH;
			return true;
		}
		return false;
	}

	public boolean isStraightFlush() {
		Card currentCard = cards.get(0);
		int currentValue = currentCard.getValue();
		Suit currentSuit = currentCard.getSuit();
		highestCard = cards.get(cards.size() - 1).getValue();

		for (int i = 1; i < cards.size(); i++) {
			int nextValue = cards.get(i).getValue();
			Suit nextSuit = cards.get(i).getSuit();
			if ((nextValue != currentValue + 1) || nextSuit != currentSuit) {
				return false;
			} else {
				currentValue = nextValue;
				currentSuit = nextSuit;
			}
		}
		handType = STRAIGHT_FLUSH;

		return true;
	}

	public boolean isFourOfKind() {
		for (int i = 0; i <= cards.size() - 4; i++) {
			int firstValue = cards.get(i).getValue();
			int fourthValue = cards.get(i + 3).getValue();

			if (firstValue == fourthValue) {
				handType = FOUR_OF_A_KIND;
				highestCard = firstValue;

				if (i == 0) {

					kicker = cards.get(cards.size() - 1).getValue();
				} else {

					kicker = cards.get(0).getValue();
				}
				return true;
			}
		}

		return false;
	}

	public boolean isFullHouse() {
		boolean firstThreeSame = cards.get(0).getValue() == cards.get(1).getValue()
				&& cards.get(1).getValue() == cards.get(2).getValue();
		boolean lastTwoSame = cards.get(3).getValue() == cards.get(4).getValue();

		boolean firstTwoSame = cards.get(0).getValue() == cards.get(1).getValue();

		boolean lastThreeSame = cards.get(2).getValue() == cards.get(3).getValue()
				&& cards.get(3).getValue() == cards.get(4).getValue();

		if (firstThreeSame && lastTwoSame) {
			handType = FULL_HOUSE;
			highestCard = cards.get(0).getValue();
			lowCard = cards.get(3).getValue();
			return true;
		}
		if (firstTwoSame && lastThreeSame) {
			handType = FULL_HOUSE;
			highestCard = cards.get(3).getValue();
			lowCard = cards.get(0).getValue();
			return true;
		}
		return false;
	}

	public boolean isFlush() {

		Suit currentCardSuit = cards.get(0).getSuit();

		for (int i = 1; i < cards.size(); i++) {
			Suit nextCardSuit = cards.get(i).getSuit();

			if (nextCardSuit != currentCardSuit) {
				return false;
			} else {

				currentCardSuit = nextCardSuit;
			}
		}
		handType = FLUSH;

		return true;
	}

	public boolean isStraight() {
		Card currentCard = cards.get(0);
		int currentValue = currentCard.getValue();

		for (int i = 1; i < cards.size(); i++) {
			int nextValue = cards.get(i).getValue();
			if (nextValue != currentValue + 1) {
				return false;
			} else {
				currentValue = nextValue;
			}
		}
		handType = STRAIGHT;
		return true;

	}

	public boolean isThreeOfKind() {

		for (int i = 0; i < cards.size() - 2; i++) {
			int firstValue = cards.get(i).getValue();
			int secondValue = cards.get(i + 1).getValue();
			int thirdValue = cards.get(i + 2).getValue();
			if ((firstValue == secondValue) && (firstValue == thirdValue)) {
				handType = THREE_OF_A_KIND;
				highestCard = firstValue;
				return true;
			}

		}
		return false;
	}

	public boolean isTwoPair() {
		int numOfPairs = 0;
		for (int i = 0; i < cards.size() - 1; i++) {
			int firstValue = cards.get(i).getValue();
			int secondValue = cards.get(i + 1).getValue();
			if (firstValue == secondValue && numOfPairs == 0) {
				onePair = firstValue;
				numOfPairs += 1;
			} else if (firstValue == secondValue && numOfPairs == 1) {
				twoPair = firstValue;
				numOfPairs += 1;
			}
		}

		if (numOfPairs >= 2) {
			handType = TWO_PAIR;
			return true;
		} else {
			return false;
		}
	}

	public boolean isPair() {
		for (int i = 0; i < cards.size() - 1; i++) {
			int firstValue = cards.get(i).getValue();
			int secondValue = cards.get(i + 1).getValue();
			if (firstValue == secondValue) {
				handType = ONE_PAIR;
				highestCard = firstValue;
				return true;
			}
		}
		return false;
	}

	public void checkHand() {
		if (this.isRoyalFlush()) {
			handType = ROYAL_FLUSH;
		} else if (this.isStraightFlush()) {
			handType = STRAIGHT_FLUSH;
		} else if (this.isFourOfKind()) {
			handType = FOUR_OF_A_KIND;
		} else if (this.isFullHouse()) {
			handType = FULL_HOUSE;
		} else if (this.isFlush()) {
			handType = FLUSH;
		} else if (this.isStraight()) {
			handType = STRAIGHT;
		} else if (this.isThreeOfKind()) {
			handType = THREE_OF_A_KIND;
		} else if (this.isTwoPair()) {
			handType = TWO_PAIR;
		} else if (this.isPair()) {
			handType = ONE_PAIR;
		} else {
			handType = HIGH_CARD;
		}

	}

	private ArrayList<Integer> getRemainingCards(ArrayList<Card> cards, int excludeValue) {
		ArrayList<Integer> remaining = new ArrayList<>();
		for (Card card : cards) {
			if (card.getValue() != excludeValue) {
				remaining.add(card.getValue());
			}
		}
		return remaining;
	}

	private static int compareKickers(PokerHand hand1, PokerHand hand2) {

		for (int i = hand1.cards.size() - 1; i >= 0; i--) {
			int card1Value = hand1.cards.get(i).getValue();
			int card2Value = hand2.cards.get(i).getValue();
			if (card1Value != card2Value) {
				return Integer.compare(card1Value, card2Value);
			}
		}
		return 0;
	}

	@Override
	public int compareTo(PokerHand other) {
		if (this.handType != other.handType) {
			return Integer.compare(this.handType, other.handType);
		}
		if (this.handType == ROYAL_FLUSH && other.handType == ROYAL_FLUSH) {
			return 0;
		}
		if (this.handType == STRAIGHT_FLUSH && other.handType == STRAIGHT_FLUSH) {
			return Integer.compare(this.highestCard, other.highestCard);
		}
		if (this.handType == FOUR_OF_A_KIND && other.handType == FOUR_OF_A_KIND) {
			if (Integer.compare(this.highestCard, other.highestCard) != 0) {
				return Integer.compare(this.highestCard, other.highestCard);
			}
			return Integer.compare(this.kicker, other.kicker);
		}
		if (this.handType == FULL_HOUSE && other.handType == FULL_HOUSE) {
			int compareThreeOfKind = Integer.compare(this.highestCard, other.highestCard);
			if (compareThreeOfKind != 0) {
				return compareThreeOfKind;
			}
			ArrayList<Integer> remainingCardsThis = getRemainingCards(this.cards, this.highestCard);
			ArrayList<Integer> remainingCardsOther = getRemainingCards(other.cards, other.highestCard);

			for (int i = remainingCardsThis.size() - 1; i >= 0; i--) {
				int comparison = Integer.compare(remainingCardsThis.get(i), remainingCardsOther.get(i));
				if (comparison != 0) {
					return comparison;
				}
			}
			return 0;
		}
		if (this.handType == FLUSH && other.handType == FLUSH) {
			for (int i = cards.size() - 1; i >= 0; i--) {
				int comparison = Integer.compare(this.cards.get(i).getValue(), other.cards.get(i).getValue());
				if (comparison != 0) {
					return comparison;
				}
			}
			return 0;
		}
		if (this.handType == STRAIGHT && other.handType == STRAIGHT) {
			return Integer.compare(this.highestCard, other.highestCard);
		}
		if (this.handType == THREE_OF_A_KIND && other.handType == THREE_OF_A_KIND) {
			int compareThreeOfKind = Integer.compare(this.highestCard, other.highestCard);
			if (compareThreeOfKind != 0) {
				return compareThreeOfKind;
			}
			ArrayList<Integer> remainingCardsThis = getRemainingCards(this.cards, this.highestCard);
			ArrayList<Integer> remainingCardsOther = getRemainingCards(other.cards, other.highestCard);

			for (int i = remainingCardsThis.size() - 1; i >= 0; i--) {
				int comparison = Integer.compare(remainingCardsThis.get(i), remainingCardsOther.get(i));
				if (comparison != 0) {
					return comparison;
				}
			}
			return 0;
		}
		if (this.handType == TWO_PAIR && other.handType == TWO_PAIR) {
			if (this.twoPair != other.twoPair) {
				return Integer.compare(this.twoPair, other.twoPair);
			} else if (this.onePair != other.onePair) {
				return Integer.compare(this.onePair, other.onePair);
			}
			return compareKickers(this, other);
		}
		if (this.handType == ONE_PAIR && other.handType == ONE_PAIR) {
			if (this.highestCard != other.highestCard) {
				return Integer.compare(this.highestCard, other.highestCard);
			}
			return compareKickers(this, other);
		}
		if (this.handType == HIGH_CARD && other.handType == HIGH_CARD) {
			for (int i = cards.size() - 1; i >= 0; i--) {
				int comparison = Integer.compare(this.cards.get(i).getValue(), other.cards.get(i).getValue());
				if (comparison != 0) {
					return comparison;
				}
			}
			return 0;
		}
		throw new IllegalStateException("Not known hand type: " + this.handType);

	}

}
