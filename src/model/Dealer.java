// Author: Ali Kaddoura
package model;

import java.util.ArrayList;
import java.util.Collections;

public class Dealer {

	ArrayList<Card> deck;
	public double pot;

	public Dealer() {
		deck = new ArrayList<>();

		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
				Card card = new Card(rank, suit);
				deck.add(card);
			}
		}

		pot = 0;

	}

	public void shuffleDeck() {
		Collections.shuffle(deck);

	}

	public void clear() {
		deck = new ArrayList<>();
		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
				Card card = new Card(rank, suit);
				deck.add(card);
			}
		}

	}

}
