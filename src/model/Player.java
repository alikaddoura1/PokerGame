// Ali Kaddoura
package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Player implements Comparable<Player> {

	public ArrayList<Card> hands;
	public double money;
	public int playerNumber;
	PokerHand bestHand;

	public Player(double money, int playerNumber) {
		this.hands = new ArrayList<>();
		this.money = money;
		this.playerNumber = playerNumber;
	}

	public void buyIn() {
		money = money - 2;
	}

	public void addCardsToHand(ArrayList<Card> cards) {
		this.hands.addAll(cards);
	}

	public void generateAllPossibleHands() {
		ArrayList<PokerHand> allHands = new ArrayList<>();

		// Generate all combinations of 5 cards out of the 7
		for (int i = 0; i < hands.size(); i++) {
			for (int j = i + 1; j < hands.size(); j++) {
				for (int k = j + 1; k < hands.size(); k++) {
					for (int l = k + 1; l < hands.size(); l++) {
						for (int m = l + 1; m < hands.size(); m++) {
							// Create a new PokerHand with each combination
							PokerHand hand = new PokerHand(hands.get(i), hands.get(j), hands.get(k), hands.get(l),
									hands.get(m));
							allHands.add(hand);
						}
					}
				}
			}
		}

		Collections.sort(allHands);

		bestHand = Collections.max(allHands);
	}

	@Override
	public int compareTo(Player other) {
		return this.bestHand.compareTo(other.bestHand);
	}

	public void clearHand() {
		this.hands.clear();
		this.bestHand = null;
	}

}
