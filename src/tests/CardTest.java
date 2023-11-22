package tests;

/** 
 * Start of a JUnit test for class Card with enums.
 * 
 * 
 *
 * @author Rick Mercer and Ali Kaddoura
 */

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

import model.Card;
import model.Rank;
import model.Suit;

public class CardTest {

	@Test
	public void testGetters() {
		Card c1 = new Card(Rank.DEUCE, Suit.CLUBS);
		assertEquals(Rank.DEUCE, c1.getRank());
		assertEquals(Suit.CLUBS, c1.getSuit());
		assertEquals(2, c1.getValue());
	}

	@Test
	public void testCompareTo() {
		Card c1 = new Card(Rank.DEUCE, Suit.CLUBS);
		Card c2 = new Card(Rank.THREE, Suit.DIAMONDS);

		Card c3 = new Card(Rank.QUEEN, Suit.CLUBS);
		Card c4 = new Card(Rank.KING, Suit.DIAMONDS);

		Suit value = c4.getSuit();
		System.out.println(value);
		assertTrue(c1.compareTo(c2) < 0);
		assertTrue(c2.compareTo(c1) > 0);
		assertTrue(c1.compareTo(c1) == 0);

		assertTrue(c3.compareTo(c4) < 0);
		assertTrue(c4.compareTo(c3) > 0);

	}

	@Test
	public void testToString() {
		Card c2 = new Card(Rank.DEUCE, Suit.CLUBS);
		assertEquals("2" + '\u2663', c2.toString());
		Card c3 = new Card(Rank.THREE, Suit.DIAMONDS);
		assertEquals("3" + '\u2666', c3.toString());
		Card c4 = new Card(Rank.FOUR, Suit.HEARTS);
		assertEquals("4" + '\u2665', c4.toString());
		Card c5 = new Card(Rank.ACE, Suit.HEARTS);
		assertEquals("A" + '\u2665', c5.toString());
		Card c6 = new Card(Rank.KING, Suit.HEARTS);
		assertEquals("K" + '\u2665', c6.toString());
		Card c7 = new Card(Rank.QUEEN, Suit.HEARTS);
		assertEquals("Q" + '\u2665', c7.toString());
		Card c8 = new Card(Rank.JACK, Suit.HEARTS);
		assertEquals("J" + '\u2665', c8.toString());

		System.out.println(c4);
		System.out.println(c5);
		System.out.println(c6);
		System.out.println(c7);
		System.out.println(c8);
	}

	@Test
	public void testEquals() {
		Card c1 = new Card(Rank.DEUCE, Suit.CLUBS);
		Card c2 = new Card(Rank.THREE, Suit.CLUBS);
		Card c3 = new Card(Rank.DEUCE, Suit.DIAMONDS);
		Card c4 = new Card(Rank.THREE, Suit.CLUBS);

		assertFalse(c1.equals(c2));
		assertFalse(c3.equals(c2));
		assertFalse(c1.equals(c3));
		assertTrue(c2.equals(c4));
	}

	@Test
	public void testComparesThing() {
		String a = "aaa";
		String ab = "aa";

		assertTrue(a.compareTo(ab) > 0);
	}

}
