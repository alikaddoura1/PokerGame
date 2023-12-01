// Author: Ali Kaddoura
package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Game {

	ArrayList<Player> players;
	ArrayList<Card> community;
	Dealer dealer;
	ArrayList<Player> winners;

	public Game() {

		dealer = new Dealer();
		players = new ArrayList<>();
		community = new ArrayList<>();
		winners = new ArrayList<>();
	}

	public void start() {

		ArrayList<PokerHand> playersHands = new ArrayList<>();
		Scanner keyboard = new Scanner(System.in);
		boolean playing = true;

		System.out.print("How many players? ");
		
		
		

		int intPlayers = Integer.parseInt(keyboard.nextLine());
		addPlayers(intPlayers);

		while (playing) {
			community.clear();
			winners.clear();
			dealer.clear();
			resetPlayerHands();
			dealer.pot = intPlayers * 2;

			dealer.shuffleDeck();

			// Dealing community cards
			for (int i = 0; i < 5; i++) {
				Card communityCard = dealer.deck.remove(0);
				community.add(communityCard);
				for (Player player : players) {
					player.addCardsToHand(new ArrayList<>(Arrays.asList(communityCard)));
				}
			}
			System.out.println();
			System.out.println("Community Cards: " + communityCards(community));
			System.out.println();

			for (Player player : players) {
				ArrayList<Card> playerHand = new ArrayList<>();
				Card passed = dealer.deck.get(0);
				Card secondPassed = dealer.deck.get(1);
				player.buyIn();
				String formattedMoney = String.format("%.2f", player.money);
				System.out.println("Player" + " " + Integer.toString(player.playerNumber) + ": " + "$" + formattedMoney
						+ " " + "-" + " " + passed + " " + secondPassed);
				playerHand.add(dealer.deck.remove(0));
				playerHand.add(dealer.deck.remove(0));
				player.addCardsToHand(playerHand);
				player.generateAllPossibleHands();
				System.out.println("   Best Hand: " + player.bestHand + "    " + player.bestHand.typeWord);
				System.out.println();

			}

			ArrayList<Player> sortedPlayers = new ArrayList<>(players);
			Collections.sort(sortedPlayers);
			addWinners(sortedPlayers);

			if (winners.size() > 1) {
				double moneyDivided = dealer.pot / winners.size();
				System.out.println("Winning hands (tie)");
				for (Player player : winners) {
					player.money += moneyDivided;
					String tieFormat = String.format("%.2f", player.money);
					System.out.println(player.bestHand + " " + player.bestHand.typeWord + " " + "Player "
							+ player.playerNumber + " " + "$" + tieFormat);
				}
			}
			if (winners.size() == 1) {
				for (Player player : winners) {
					player.money += dealer.pot;
					String formatted = String.format("%.2f", player.money);
					System.out.println("Winner: " + "Player " + player.playerNumber + " " +  "$"+formatted);
					System.out.println(player.bestHand + "  " + player.bestHand.typeWord);
					System.out.println();
				}
			}

			System.out.print("Play another game? <y or n> ");
			String keepPlaying = keyboard.nextLine();
			playing = keepPlaying.equalsIgnoreCase("y");
		}

		keyboard.close();
	}

	public void addPlayers(int numberOfPlayers) {
		for (int i = 1; i <= numberOfPlayers; i++) {
			players.add(new Player(100.00, i));
		}

	}

	public String communityCards(ArrayList<Card> com) {
		String result = "";

		for (int i = 0; i < community.size(); i++) {
			result += com.get(i).toString() + " ";
		}
		return result;
	}

	public void addWinners(ArrayList<Player> sortedPlayers) {
		Player topPlayer = Collections.max(sortedPlayers);
		winners.add(topPlayer);

		for (Player player : sortedPlayers) {
			if (player != topPlayer && player.compareTo(topPlayer) == 0) {
				winners.add(player);
			}
		}
	}

	private void resetPlayerHands() {
		for (Player player : players) {
			player.clearHand();
		}
	}

}
