package model;

/** 
 * class Card represents one of the 52 poker cards. There are
 * no comments before methods because the method name says it all.
 * 
 * @author Rick Mercer and Ali Kaddoura
 */

public class Card implements Comparable<Card> {
  private final Rank rank;
  private final Suit suit;

  // Constructor
  public Card(Rank rank, Suit suit) {
    this.rank = rank;
    this.suit = suit;
  }

  public Suit getSuit() {
    return this.suit;
  }

  public Rank getRank() {
    return this.rank;
  }
  
  public int getValue() {
    return rank.getValue();
  }
  
  

  public String toString() {
    // Use these four Unicode icons for the solid suit icons. 
    char suitIcon = '\u2663';
    if (suit == Suit.DIAMONDS)
      suitIcon = '\u2666';
    if (suit == Suit.HEARTS)
      suitIcon = '\u2665';
    if (suit == Suit.SPADES)
      suitIcon = '\u2660';
    
   
    String valueToString = Integer.toString(getValue());

    // Need to get the value instead of "?"
    return valueToString + suitIcon;
  }

  @Override
  public int compareTo(Card other) {
	  String cardOne = toString();
	  String cardTwo = other.toString();
	  
	  return cardOne.compareTo(cardTwo);
  }
  
  public Boolean equals(Card other) {
	  
	  int cardOne = getValue();
	  int cardTwo = other.getValue();
	  return cardOne == cardTwo; 
  }

}