package JavaCode;

public class CardDetails {
	
	public static String cardName = "Province";
	public static String cardAbility = "Beschrijving van de kaart";
	public static int cardValue = 6;
	public static String cardType = "Victory";
	public static int cardCost = 8;
	
	public void currentCardInfo()
	{
		System.out.println(cardName);
		System.out.println(cardValue);
		System.out.println(cardType);
		System.out.println(cardCost);
	}
	
	public void chellar()
	{
		cardName = "CELLAR";
		cardAbility = "+1 Action - Discard any number of cards. +& Card per card discarded.";
		cardType = "ACTION";
		cardCost = 2;
	}
	
	public void chancellor()
	{
		cardName = "CHANCELLOR";
		cardAbility = "+2 coins - You may immediately put your deck into the discard pile.";
		cardType = "ACTION";
		cardCost = 3;
	}
	
	public void chapel()
	{
		cardName = "CHAPEL";
		cardAbility = "Trash up to 4 cards from your hand";
		cardType = "ACTION";
		cardCost = 2;
	}
	
	public void conspirator()
	{
		cardName = "CONSPIRATOR";
		cardAbility = "+2 coins - If you've played 3 or more Actions this turn (counting this): +1 Card, +1 Action.";
		cardType = "ACTION";
		cardCost = 4;
	}
	
	public void coppersmith()
	{
		cardName = "COPPERSMITH";
		cardAbility = "Copper produces an extra 1 Coin this turn.";
		cardType = "ACTION";
		cardCost = 4;
	}
	
	public void councilRoom()
	{
		cardName = "COUNCIL ROOM";
		cardAbility = "+4 Cards & +1 Buy - Each other player draws a card.";
		cardType = "ACTION";
		cardCost = 2;
	}
	
	public void courtyard()
	{
		cardName = "COURTYARD";
		cardAbility = "+3 cards - Put a card from your hand on top of your deck.";
		cardType = "ACTION";
		cardCost = 2;
	}
	
	public void cutpurse()
	{
		cardName = "CUTPURSE";
		cardAbility = "+2 coins - Each other player discards a Copper card (or reveals a hand with no Copper).";
		cardType = "ACTION - ATTACK";
		cardCost = 4;
	}
	
	public void embargo()
	{
		cardName = "EMBARGO";
		cardAbility = "+2 coins - Trash this card. Put an Embargo token on top of a Supply pile. --- When a player buys a card, he gains a Curse card per Embargo token on that pile.";
		cardType = "ACTION";
		cardCost = 2;
	}
	
	public void envoy()
	{
		cardName = "ENVOY";
		cardAbility = "Reveal the top 5 cards of your deck. The player to your left chooses one for you to discard. Draw the rest.";
		cardType = "ACTION";
		cardCost = 4;
	}
	
	public void explorer()
	{
		cardName = "EXPOLRER";
		cardAbility = "You may reveal a Province card from your hand. If you do, gain a Gold card, putting it into your hand. Otherwise, gain a Silver card, putting it into your hand.";
		cardType = "ACTION";
		cardCost = 5;
	}
	
	public void familiar()
	{
		cardName = "FAMILIAR";
		cardAbility = "+1 Card & +1 Action - Each other player gains a Curse";
		cardType = "ACTION - ATTACK";
		cardCost = 3;
	}
	
	public void Feast()
	{
		cardName = "FEAST";
		cardAbility = "Trash this card. Gain a card costing up to 5 coins";
		cardType = "ACTION";
		cardCost = 4;
	}
	
	public void Festival()
	{
		cardName = "FESTIVAL";
		cardAbility = "+2 Actions & 1 Buy & +2 Coins";
		cardType = "ACTION";
		cardCost = 5;
	}
	
	public void fishingVillage()
	{
		cardName = "FISHING VILLAGED";
		cardAbility = "+2 Actions & +1 Coins - At the start of your next turn: +1 Action & +1 Coin";
		cardType = "ACTION - DURATIONS";
		cardCost = 3;
	}
	
	public void gardens()
	{
		cardName = "GARDENS";
		cardAbility = "Worth 1 shield for every 10 cards in your deck (rounded down).";
		cardType = "VICTORY";
		cardCost = 4;
	}
	
	public void ghostShip()
	{
		cardName = "GHOST SHIP";
		cardAbility = "+2 Cards - Each other player with 4 or more cards in hand puts cards from his hand on top of his deck until he has 3 cards in his hand.";
		cardType = "ACTION - ATTACK";
		cardCost = 5;
	}
	
	public void golem()
	{
		cardName = "GOLEM";
		cardAbility = "Reveal cards from your deck until you reveal 2 Actions cards other then Golem cards. Discard the other cards, then play the Action cards in either order.";
		cardType = "ACTION";
		cardCost = 4;
	}
	
	public void greatHall()
	{
		cardName = "GREAT HALL";
		cardAbility = "+1 Card & +1 Action - 1 Shield";
		cardType = "ACTION - VICTORY";
		cardCost = 3;
	}
	
	public void harem()
	{
		cardName = "HAREM";
		cardAbility = "2 coins & 2 shields";
		cardType = "TREASURE - VICTORY";
		cardCost = 9;
	}
	
	public void haven()
	{
		cardName = "HAVEN";
		cardAbility = "+1 Card & +1 Action - Set aside a card from your hand face down. At the start of your next turn, put it into your hand.";
		cardType = "ACTION - DURATION";
		cardCost = 2;
	}
	
	public void herbalist()
	{
		cardName = "HERBALIST";
		cardAbility = "+1 Buy & +1 Coin - When you discard this from play, you may put one of your Treasures from play on top of your deck.";
		cardType = "ACTION";
		cardCost = 2;
	}
	
	public void ironworks()
	{
		cardName = "IRONWORKS";
		cardAbility = "Gain a card costing up to 4 coins - If it is an... Action card, +1 Acion. Treasure card, +1 Coin, Victory card, +1 Card";
		cardType = "ACTION";
		cardCost = 4;
	}
	
	public void island()
	{
		cardName = "ISLAND";
		cardAbility = "Set aside this and another card from your hand. Return them to your deck at the end of the game --- 2 Shields";
		cardType = "ACTION - VICTORY";
		cardCost = 4;
	}
	
	public void Laboratory()
	{
		cardName = "LABORATORY";
		cardAbility = "+2 Cards, +1 Action";
		cardType = "ACTION";
		cardCost = 5;
	}
	
	public void Libary()
	{
		cardName = "LIBARY";
		cardAbility = "Draw until you have 7 cards in hand. You may set aside any Action cards drawn this way, as you draw them; discard the set aside cards after you finish drawing.";
		cardType = "ACTION";
		cardCost = 5;
	}
	
	public void lighthouse()
	{
		cardName = "LIGHTHOUSE";
		cardAbility = "+1 Action - Now and at the start of your next turn: +1 coin. --- While this is in play, when another player plays an Attack card, it doesn't affect you.";
		cardType = "ACTION";
		cardCost = 2;
	}
	
	public void lookout()
	{
		cardName = "LOOKOUT";
		cardAbility = "+1 Action - Look at the top 3 cards of your deck. Trash one of them. Discard one of them. Put the other one on top of your deck.";
		cardType = "ACTION";
		cardCost = 3;
	}
	
	public void market()
	{
		cardName = "MARKET";
		cardAbility = "+1 Card & +1 Action & +1 Buy & +1 Coin";
		cardType = "ACTION";
		cardCost = 5;
	}

}
