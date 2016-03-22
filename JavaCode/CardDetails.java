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

	public void marsquerade()
	{
		cardName = "MASQUERADE";
		cardAbility = "+1 Cards - Each player passes a card from his hand to the left at once. Then you may trash a card from your hand.";
		cardType = "ACTION";
		cardCost = 3;
	}
	
	public void merchantShip()
	{
		cardName = "MERCHANT SHIP";
		cardAbility = "Now and at the start of your next turn: +2 Coins";
		cardType = "ACTION - DURATION";
		cardCost = 5;
	}
	
	public void militia()
	{
		cardName = "MILITIA";
		cardAbility = "+2 Coins - Each other player discards down to 3 cards in his hand.";
		cardType = "ACTION - ATTACK";
		cardCost = 4;
	}
	
	public void mine()
	{
		cardName = "MINE";
		cardAbility = "Trash a Treasure card from your hand. Gain a Treasure card costing up to 3 coins more; put it into your hand.";
		cardType = "ACTION";
		cardCost = 5;
	}
	
	public void miningVillage()
	{
		cardName = "MINING VILLAGE";
		cardAbility = "+1 Card & +2 Actions - You may trash this card immediately. If you do, +2 coins.";
		cardType = "ACTION";
		cardCost = 4;
	}
	
	public void minion()
	{
		cardName = "MINION";
		cardAbility = "+1 Action - Choose one: +2 Coins; or discard your hand, +4 Cards, and each other player with at least 5 cards in hand discards his hand a draws 4 cards.";
		cardType = "ACTION - ATTACK";
		cardCost = 5;
	}
	
	public void moat()
	{
		cardName = "MOAT";
		cardAbility = "+2 Cards - when another player plays an Attack card, you may reveal this from your hand. If you do, you are unaffected by that Attack.";
		cardType = "ACTION - REACTION";
		cardCost = 2;
	}
	
	public void moneylender()
	{
		cardName = "MONDEYLENDER";
		cardAbility = "Trash a Copper card from your hand. If you do, +3 Coins";
		cardType = "ACTION";
		cardCost = 5;
	}
	
	public void nativeVillage()
	{
		cardName = "NATIVE VILLAGE";
		cardAbility = "+2 Actoins - Choose one: Set aside the top card of your deck face down on your Native Village mat; or put all the cards from your mat into you hand. You may look at the cards on your mat at any time; return them to your deck at the end of the game.";
		cardType = "ACTION";
		cardCost = 2;
	}
	
	public void navigator()
	{
		cardName = "NAVIGATOR";
		cardAbility = "+2 Coins - Look at the top 5 cards of your deck. Either discard all of them, or put them back on top of your deck in any order.";
		cardType = "ACTION";
		cardCost = 4;
	}
	
	public void nobles()
	{
		cardName = "NOBLES";
		cardAbility = "Choose one: +3 Cards; or +2 Actions --- 2 Shields";
		cardType = "ACTION - VICTORY";
		cardCost = 6;
	}
	
	public void outpost()
	{
		cardName = "OUTPOST";
		cardAbility = "You only draw 3 cards (instead of 5) in this turn's Clean-up phase. Take an extra turn after this one. This can't cause you to take more than two consecutive turns.";
		cardType = "ACTION - DURATION";
		cardCost = 5;
	}
	
	public void pawn()
	{
		cardName = "PAWN";
		cardAbility = "Choose two: +1 Card; +1 Action; +1 Buy; +1 Coin. (The choices must be different.)";
		cardType = "ACTION";
		cardCost = 2;
	}
	
	public void pearlDiver()
	{
		cardName = "PEARL DIVER";
		cardAbility = "+1 Card & +1 Action - Look at the bottom card of your deck. You may put it on top.";
		cardType = "ACTION";
		cardCost = 2;
	}
	
	public void philosophersStone()
	{
		cardName = "PHILOSOPHER'S STONE";
		cardAbility = "When you play this, count your deck and discard pile. Worth 1 coin per 5 cards total between them (rounded down).";
		cardType = "TREASURE";
		cardCost = 3;
	}
	
	public void pirateShip()
	{
		cardName = "PIRATE SHIP";
		cardAbility = "Choose one: Each other player reveals the top 2 cards of his deck, trashes a revealed Treasure that you choose, discards the rest, and if anyone trashed a Treasure you take a Coin token; or, +1 Coin per Coin token you've taken with Pirate Ships this game.";
		cardType = "ACTION";
		cardCost = 4;
	}
	
	public void possession()
	{
		cardName = "POSSESSION";
		cardAbility = "The player to your left takes an extra turn after this one, in which you can see all cards he can and make all decisions for him. Any cards he would gain on that turn, you gain instead; any cards of this that are trashed are set aside and returned to his discard pile at end of turn.";
		cardType = "ACTION";
		cardCost = 6;
	}
	
	public void potion()
	{
		cardName = "POTION";
		cardType = "TREASURE";
		cardCost = 4;
	}
	
	public void province()
	{
		cardName = "PROVINCE";
		cardType = "VICTORY";
		cardCost = 8;
	}
	
	public void remodel()
	{
		cardName = "REMODEL";
		cardAbility = "Trash a card from your hand. Gain a card costing up to 2 Coins more than the trashed card.";
		cardType = "ACTION";
		cardCost = 4;
	}
	
	public void saboteur()
	{
		cardName = "SABOTEUR";
		cardAbility = "Each other player reveals cards from the top of his deck until revealing one costing 3 Coins or more. He trashes that card and may gain a card costing at most 2 coins less than it. He discards the other revealed cards.";
		cardType = "ACTION - ATTACK";
		cardCost = 5;
	}
	
	public void salvager()
	{
		cardName = "SALVAGER";
		cardAbility = "+1 Buy - Trash a card from your hand. + coins equal to its cost.";
		cardType = "ACTION";
		cardCost = 4;
	}
	
	public void scout()
	{
		cardName = "SCOUT";
		cardAbility = "+1 Action - Reveal the top 4 cards of your deck. Put the revealed Victory cards into your hand. Put the other cards on top of your deck in any order.";
		cardType = "ACTION";
		cardCost = 4;
	}
	
	public void scryingPool()
	{
		cardName = "SCRYING POOL";
		cardAbility = "+1 Action - Each player (including you) reveals the top card of his deck and either discards it or puts it back, your choice. Then reveal cards from the rop of your deck until you reveal one that is not an Action. Put all of your revealed cards into your hand.";
		cardType = "ACTION - ATTACK";
		cardCost = 2;
	}
	
	public void seaHag()
	{
		cardName = "SEA HAG";
		cardAbility = "Each other player discards the top card of his deck, then gains a Curse card, putting it on top of his deck.";
		cardType = "ACTION - ATTACK";
		cardCost = 4;
	}
	
	public void secretChamber()
	{
		cardName = "SECRET CHAMBER";
		cardAbility = "Discard any number of cards. +1 Coin per card discarded. --- When another player plays an Attack card, you may reveal this from your hand. If you do, +2 Cards, then put 2 cards from your hand on top of your deck.";
		cardType = "ACTION - REACTION";
		cardCost = 2;
	}
	
}
