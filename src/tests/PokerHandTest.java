package tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import java.util.Collections;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.Test;

import model.Card;
import model.PokerHand;
import model.Rank;
import model.Suit;

/**
 * Tests the CardHand class, last modified Sep 2015, June 2017, July 23, August
 * 23
 * 
 * I think this a pretty good unit test, if you add any other test cases please
 * send them to me!
 * 
 * I am providing all 52 possible Cars to save you time writing @Tests
 * 
 * @author Rick Mercer and Ali Kaddoura
 */
public class PokerHandTest {

	// This file contains all 52 cards to save you time with names like 
	// C2 for the two of clubs
	// AS for the ace of spades

	// Set up 52 cards so we can use C2 instead of new Card(Rank.Deuce, Suit.Clubs)
	private final static Card C2 = new Card(Rank.DEUCE, Suit.CLUBS);
	private final static Card C3 = new Card(Rank.THREE, Suit.CLUBS);
	private final static Card C4 = new Card(Rank.FOUR, Suit.CLUBS);
	private final static Card C5 = new Card(Rank.FIVE, Suit.CLUBS);
	private final static Card C6 = new Card(Rank.SIX, Suit.CLUBS);
	private final static Card C7 = new Card(Rank.SEVEN, Suit.CLUBS);
	private final static Card C8 = new Card(Rank.EIGHT, Suit.CLUBS);
	private final static Card C9 = new Card(Rank.NINE, Suit.CLUBS);
	private final static Card C10 = new Card(Rank.TEN, Suit.CLUBS);
	private final static Card CJ = new Card(Rank.JACK, Suit.CLUBS);
	private final static Card CQ = new Card(Rank.QUEEN, Suit.CLUBS);
	private final static Card CK = new Card(Rank.KING, Suit.CLUBS);
	private final static Card CA = new Card(Rank.ACE, Suit.CLUBS);

	private final static Card D2 = new Card(Rank.DEUCE, Suit.DIAMONDS);
	private final static Card D3 = new Card(Rank.THREE, Suit.DIAMONDS);
	private final static Card D4 = new Card(Rank.FOUR, Suit.DIAMONDS);
	private final static Card D5 = new Card(Rank.FIVE, Suit.DIAMONDS);
	private final static Card D6 = new Card(Rank.SIX, Suit.DIAMONDS);
	private final static Card D7 = new Card(Rank.SEVEN, Suit.DIAMONDS);
	private final static Card D8 = new Card(Rank.EIGHT, Suit.DIAMONDS);
	private final static Card D9 = new Card(Rank.NINE, Suit.DIAMONDS);
	private final static Card D10 = new Card(Rank.TEN, Suit.DIAMONDS);
	private final static Card DJ = new Card(Rank.JACK, Suit.DIAMONDS);
	private final static Card DQ = new Card(Rank.QUEEN, Suit.DIAMONDS);
	private final static Card DK = new Card(Rank.KING, Suit.DIAMONDS);
	private final static Card DA = new Card(Rank.ACE, Suit.DIAMONDS);

	private final static Card H2 = new Card(Rank.DEUCE, Suit.HEARTS);
	private final static Card H3 = new Card(Rank.THREE, Suit.HEARTS);
	private final static Card H4 = new Card(Rank.FOUR, Suit.HEARTS);
	private final static Card H5 = new Card(Rank.FIVE, Suit.HEARTS);
	private final static Card H6 = new Card(Rank.SIX, Suit.HEARTS);
	private final static Card H7 = new Card(Rank.SEVEN, Suit.HEARTS);
	private final static Card H8 = new Card(Rank.EIGHT, Suit.HEARTS);
	private final static Card H9 = new Card(Rank.NINE, Suit.HEARTS);
	private final static Card H10 = new Card(Rank.TEN, Suit.HEARTS);
	private final static Card HJ = new Card(Rank.JACK, Suit.HEARTS);
	private final static Card HQ = new Card(Rank.QUEEN, Suit.HEARTS);
	private final static Card HK = new Card(Rank.KING, Suit.HEARTS);
	private final static Card HA = new Card(Rank.ACE, Suit.HEARTS);

	private final static Card S2 = new Card(Rank.DEUCE, Suit.SPADES);
	private final static Card S3 = new Card(Rank.THREE, Suit.SPADES);
	private final static Card S4 = new Card(Rank.FOUR, Suit.SPADES);
	private final static Card S5 = new Card(Rank.FIVE, Suit.SPADES);
	private final static Card S6 = new Card(Rank.SIX, Suit.SPADES);
	private final static Card S7 = new Card(Rank.SEVEN, Suit.SPADES);
	private final static Card S8 = new Card(Rank.EIGHT, Suit.SPADES);
	private final static Card S9 = new Card(Rank.NINE, Suit.SPADES);
	private final static Card S10 = new Card(Rank.TEN, Suit.SPADES);
	private final static Card SJ = new Card(Rank.JACK, Suit.SPADES);
	private final static Card SQ = new Card(Rank.QUEEN, Suit.SPADES);
	private final static Card SK = new Card(Rank.KING, Suit.SPADES);
	private final static Card SA = new Card(Rank.ACE, Suit.SPADES);

	@Test
	public void testRoyalFlushes() {
		PokerHand a = new PokerHand(DA, DQ, D10, DK, DJ);
		PokerHand b = new PokerHand(D10, DK, DJ, DA, DQ);

		assertTrue(a.compareTo(b) == 0);

	}

	@Test
	public void testStraightFlushes() {
		PokerHand a = new PokerHand(D5, D3, D4, D6, D7);
		PokerHand b = new PokerHand(D10, D8, D9, D7, D6);
		PokerHand c = new PokerHand(D7, D3, D5, D6, D4);

		assertTrue(a.compareTo(b) < 0);
		assertTrue(b.compareTo(a) > 0);
		assertTrue(a.compareTo(c) == 0);

	}

	@Test
	public void testFourOfKinds() {
		PokerHand a = new PokerHand(D5, D3, H5, C5, S5);
		PokerHand b = new PokerHand(D2, D8, H2, C2, S2);

		PokerHand c = new PokerHand(D5, D4, H5, S5, C5);

		assertTrue(a.compareTo(b) > 0);
		assertTrue(a.compareTo(c) < 0);

	}

	@Test
	public void testFullHouses() {
		PokerHand a = new PokerHand(D5, D3, H5, S3, S5);
		PokerHand b = new PokerHand(D2, D4, S4, C2, H4);
		PokerHand c = new PokerHand(S5, D5, H3, C3, C5);
		PokerHand d = new PokerHand(S5, D5, H4, C4, C5);

		assertTrue(a.compareTo(b) > 0);
		assertTrue(b.compareTo(a) < 0);
		assertTrue(a.compareTo(c) == 0);
		assertTrue(a.compareTo(d)<0);  

	}

	@Test
	public void testFlushes() {
		PokerHand a = new PokerHand(D5, D3, D6, D2, DK);
		PokerHand b = new PokerHand(S2, S4, S3, S6, S7);
		PokerHand c = new PokerHand(H3, H5, H2, HK, H7);

		assertTrue(a.compareTo(b) > 0);
		assertTrue(b.compareTo(a) < 0);
		assertTrue(a.compareTo(c) < 0);

	}

	@Test
	public void testStraights() {
		PokerHand a = new PokerHand(D5, S4, C2, S3, H6);
		PokerHand b = new PokerHand(S3, S6, H4, C7, S5);
		PokerHand c = new PokerHand(H5, H4, C6, S2, C3);

		assertTrue(a.compareTo(b) < 0);
		assertTrue(b.compareTo(a) > 0);
		assertTrue(a.compareTo(c) == 0);

	}

	@Test
	public void testThreeOfKinds() {
		PokerHand a = new PokerHand(D4, C4, HA, H4, H7);
		PokerHand b = new PokerHand(H9, H6, CQ, C6, D6);

		int result = a.compareTo(b);

		if (result < 0) {
			System.out.println("Hand a is lower rank than Hand b.");
		} else if (result > 0) {
			System.out.println("Hand a is higher rank than Hand b.");
		} else {
			System.out.println("Hand a is of the same rank as Hand b.");
		}

		System.out.println("Hand a: " + a.toString());
		System.out.println("Hand b: " + b.toString());

		assertTrue(result < 0);

	}

	@Test
	public void testTwoPairs() {
		PokerHand a = new PokerHand(D5, S5, C2, H3, H2);
		PokerHand b = new PokerHand(S3, S6, H3, C2, S2);
		PokerHand c = new PokerHand(H5, C5, C3, S3, D7);
		PokerHand d = new PokerHand(C5, D5, D3, H3, D7);

		PokerHand e = new PokerHand(C7, D3, H3, H7, DA);
		PokerHand f = new PokerHand(C5, D4, D5, H4, D2);

		assertTrue(a.compareTo(b) > 0);
		assertTrue(b.compareTo(a) < 0);
		assertTrue(a.compareTo(c) < 0);
		assertTrue(c.compareTo(d) == 0);

		assertTrue(e.compareTo(f) > 0);

	}

	@Test
	public void testIsPairs() {
		PokerHand a = new PokerHand(D5, S5, C2, H3, HA);
		PokerHand b = new PokerHand(S3, S6, H3, C7, S2);
		PokerHand c = new PokerHand(H5, C5, C2, S3, DA);
		PokerHand d = new PokerHand(H5, C5, C2, S3, D9);

		assertTrue(a.compareTo(b) > 0);
		assertTrue(b.compareTo(a) < 0);
		assertTrue(a.compareTo(c) == 0);

		assertTrue(a.compareTo(d) > 0);

	}

	@Test
	public void testHighCards() {
		PokerHand a = new PokerHand(D2, S6, C2, H7, HA);
		PokerHand b = new PokerHand(S3, S6, H4, C7, S2);

		assertTrue(a.compareTo(b) > 0);
		assertTrue(b.compareTo(a) < 0);

	}

	@Test
	public void testDifferentHands() {
		PokerHand royalFlush = new PokerHand(DA, DK, DQ, D10, DJ);
		PokerHand straightFlush = new PokerHand(D5, D4, D3, D2, D6);
		PokerHand fourOfKind = new PokerHand(D4, C4, H4, S4, D2);
		PokerHand fullHouse = new PokerHand(D4, C4, H2, S4, D2);
		PokerHand flush = new PokerHand(D4, D7, D5, D10, DK);
		PokerHand straight = new PokerHand(C5, C2, C4, D3, D6);
		PokerHand threeOfKind = new PokerHand(D4, S4, H9, D10, H4);
		PokerHand twoPair = new PokerHand(D4, S4, H10, D10, H5);
		PokerHand pair = new PokerHand(D4, H5, S4, D10, DK);

		PokerHand highCard = new PokerHand(S3, S6, H4, C7, S2);

		assertTrue(royalFlush.compareTo(straightFlush) > 0);
		assertTrue(fourOfKind.compareTo(threeOfKind) > 0);

	}

	@Test
	public void testIsRoyalFlush() {
		PokerHand a = new PokerHand(D9, DK, DQ, D10, DJ);
		PokerHand b = new PokerHand(DA, DK, DQ, D10, CJ);

		assertFalse(a.isRoyalFlush());
		assertFalse(b.isRoyalFlush());

	}

	@Test
	public void testIsStraightFlush() {

		PokerHand c = new PokerHand(D5, D4, D3, D2, D6);
		PokerHand d = new PokerHand(D7, D3, D5, D6, D4);
		PokerHand e = new PokerHand(D5, D3, D4, D6, D7);

		assertTrue(c.isStraightFlush());
		assertTrue(d.isStraightFlush());
		assertTrue(e.isStraightFlush());

	}

	@Test
	public void testIsFourOfKind() {
		PokerHand a = new PokerHand(D4, C4, H4, S4, DK);
		PokerHand b = new PokerHand(DA, DK, DQ, D10, CJ);

		assertTrue(a.isFourOfKind());
		assertFalse(b.isFourOfKind());

	}

	@Test
	public void testIsFullHouse() {
		PokerHand a = new PokerHand(D4, C4, H2, S4, D2);
		PokerHand b = new PokerHand(DA, DK, DQ, D10, CJ);
		PokerHand c = new PokerHand(D2, C6, H2, C2, D6);

		assertTrue(a.isFullHouse());
		assertFalse(b.isFullHouse());
		assertTrue(c.isFullHouse());

	}

	@Test
	public void testIsFlush() {
		PokerHand a = new PokerHand(D4, D7, D5, D10, DK);
		PokerHand b = new PokerHand(DA, DK, DQ, D10, CJ);

		assertTrue(a.isFlush());
		assertFalse(b.isFlush());

	}

	@Test
	public void testIsStraight() {
		PokerHand a = new PokerHand(C5, C2, C4, D3, D6);
		PokerHand b = new PokerHand(C5, CK, D2, DA, SK);
		assertTrue(a.isStraight());
		assertFalse(b.isStraight());
		PokerHand c = new PokerHand(C5, C3, D2, DA, S4);
		assertFalse(c.isStraight());

		PokerHand d = new PokerHand(DA, DK, DQ, D10, CJ);
		assertTrue(d.isStraight());
	}

	@Test
	public void testIsThreeOfKind() {
		PokerHand a = new PokerHand(D4, S4, H9, D10, H4);
		PokerHand b = new PokerHand(DA, DK, DQ, D10, CJ);

		assertTrue(a.isThreeOfKind());
		assertFalse(b.isThreeOfKind());

	}

	@Test
	public void testIsTwoPair() {
		PokerHand a = new PokerHand(D4, S4, H10, D10, H5);
		PokerHand b = new PokerHand(DA, DK, DQ, D10, CJ);

		assertTrue(a.isTwoPair());
		assertFalse(b.isTwoPair());

	}

	@Test
	public void testIsPair() {
		PokerHand a = new PokerHand(D4, H5, S4, D10, DK);
		PokerHand b = new PokerHand(DA, DK, DQ, D10, CJ);
		PokerHand c = new PokerHand(S3, D3, H4, S9, CA);

		assertTrue(a.isPair());
		assertFalse(b.isPair());
		assertTrue(c.isPair());

	}

	@Test
	public void testThrowsExceptions() {

		assertThrows(IllegalArgumentException.class, () -> new PokerHand(D4, H5, D4, D10, DK));

	}

	@Test
	public void testvalue() {
		PokerHand a = new PokerHand(D2, C3, H5, H9, H8);

		PokerHand b = new PokerHand(D4, C4, H4, H7, HA);

		PokerHand c = new PokerHand(D4, C4, H4, H9, H8);

		PokerHand d = new PokerHand(D4, C4, H4, H9, H6);

		PokerHand e = new PokerHand(D4, C4, H4, H9, H8);

		PokerHand f = new PokerHand(D4, C4, H4, H9, H2);

		PokerHand g = new PokerHand(S6, D6, D2, CA, H3);

		PokerHand h = new PokerHand(S3, D3, S9, CA, H4); 

		PokerHand i = new PokerHand(S6, D6, D4, CA, H5);

		PokerHand j = new PokerHand(C6, H9, D6, CQ, H6);

		PokerHand k = new PokerHand(S6, D6, C3, CK, H7);

		PokerHand l = new PokerHand(C7, H7, C4, C3, H8);

		PokerHand m = new PokerHand(S6, D7, C5, C7, H9);

		PokerHand n = new PokerHand(D5, D4, D3, D2, D6);

		PokerHand o = new PokerHand(D3, D5, D4, D6, D7);

		PokerHand p = new PokerHand(HA, HJ, HQ, H10, HK);

		PokerHand q = new PokerHand(HA, HJ, HQ, H10, HK);

		PokerHand r = new PokerHand(HA, SJ, DA, HJ, H2);

		PokerHand s = new PokerHand(H10, CQ, HQ, C10, H5);

		PokerHand t = new PokerHand(HA, SJ, DA, HJ, H3);

		PokerHand u = new PokerHand(D2, C3, H5, H9, H10);
		
		PokerHand v = new PokerHand(D2, C6, H2, S2, C2);
		PokerHand w = new PokerHand(D2, C7, H2, S2, C2);
		PokerHand x = new PokerHand(D5, C7, H5, S5, C5);
		PokerHand y = new PokerHand(S5, D5, H3, C3, C5);
		PokerHand z = new PokerHand(S2, D3, C5, C4,H6);
		PokerHand zy = new PokerHand(S4, D5, H7, H6, C8);
		PokerHand zz = new PokerHand(S3, S7,S9,S2,SA);

		ArrayList<PokerHand> hands = new ArrayList<>();
		hands.add(a);

		hands.add(b);

		hands.add(c);

		hands.add(d);

		hands.add(e);

		hands.add(f);

		hands.add(g);

		hands.add(h);

		hands.add(i);

		hands.add(j);

		hands.add(k);

		hands.add(l);

		hands.add(m);

		hands.add(n);

		hands.add(o);

		hands.add(p);

		hands.add(q);

		hands.add(r);

		hands.add(s);

		hands.add(t);

		hands.add(u);
		
		hands.add(v);
		
		hands.add(w);
		
		hands.add(x);
		
		hands.add(y);
		hands.add(z);
		hands.add(zy);
		hands.add(zz);
		Collections.sort(hands);

		for (PokerHand hand : hands) {

			System.out.println(hand);

		}
		System.out.println("Best Hand: " + Collections.max(hands));

	}

}