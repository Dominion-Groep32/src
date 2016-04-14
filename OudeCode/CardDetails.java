package OudeCode;

public class CardDetails {
	
	//Geld kaarten
	public int amountCopper;
	public int amountSilver;
	public int amountGold;
	
	//Grond kaarten
	public int amountEstate;
	public int amountDuchy;
	public int amountProvince;
	
	//Vloek kaarten
	public int amountCurse ;
	
	//Kaart details
	public String cardName;
	public String cardAbility;
	public String cardType;
	public int cardCost;
	public int extraCards;
	
	//Waarde en actie van de kaart
	public int coins;
	public int buys;
	public int actions;

	//Moet in het begin van het spel opgeroepen worden
	public void startUp() {
		
		amountCopper = 60;
		amountSilver = 40;
		amountGold = 30;
		
		amountEstate = 24;
		amountDuchy = 12;
		amountProvince = 12;
		
		amountCurse = 30;
		
		startTurn();
	}
	
	//Moet voor elke beurt opgeroepen worden
	public void resetCards()
	{ 		
		cardName = "";
		cardAbility = "";
		cardType = "";
		cardCost = 0;
		extraCards = 0;

	}
	
	public void startTurn(){
		actions = 1;
		coins = 0;
		buys = 1;
	}
	
	public void currentCardInfo()
	{
		System.out.println("Name "+cardName.toLowerCase());
		System.out.println("Coins "+coins);
		System.out.println("Type "+cardType.toLowerCase());
		System.out.println("Cost "+cardCost);
	}
	
	public void coinCopper()
	{
		cardName = "COPPER";
		cardType = "TREASURE";
		coins += 1;
		cardCost += 0;
		amountCopper --;
	}
	
	public void estate()
	{
		cardName = "ESTATE";
		cardType = "VICTORY";
		
	}
	
	public void coinSilver()
	{
		cardName = "SILVER";
		cardType = "TREASURE";
		coins += 2;
		cardCost += 3;
		amountSilver --;
	}
	
	public void coinGold()
	{
		cardName = "GOLD";
		cardType = "TREASURE";
		coins += 3;
		cardCost = 6;
		amountGold --;
	}
	
	public void adventurer()
	{
		cardName = "ADVENTURER";
		cardAbility = "Reveal cards from your deck until you reveal 2 Treasure cards. Put those Treasure cards into your hand and discard the other revealed cards.";
		cardType = "ACTION";
		cardCost = 6;
	}
	
	public void alchemist()
	{
		cardName = "ALCHEMIST";
		cardAbility = "+2 Cards & +1 Action - When you discard this from play, you may put this on top of your deck if you have a Potion in play.";
		cardType = "ACTION";
		cardCost = 3;
		actions += 1;
		extraCards += 2;
	}
	
	public void ambassador()
	{
		cardName = "AMBASSADOR";
		cardAbility = "Reveal a card from your hand. Return up to 2 copies of it from your hand to the Supply. Then each other player gains a copy of it.";
		cardType = "ACTION - ATTACK";
		cardCost = 3;
	}
	
	public void apothecary()
	{
		cardName = "APOTHECARY";
		cardAbility = "+1 Card & +1 Action - Reveal the top 4 cards of your deck. Put the revealed Coppers and Potions into your hand. Put the other cards back on top of your deck in any order.";
		cardType = "ACTION";
		cardCost = 2;
		actions += 1;
		extraCards += 1;
	}
	
	public void apprentice()
	{
		cardName = "APPRENTICE";
		cardAbility = "+1 Action - Trash a card from your hand. +1 Card per Coin it costs. +2 Cards if it has Potions in it cost.";
		cardType = "ACTION";
		cardCost = 5;
		actions += 1;
	}
	
	public void baron()
	{
		cardName = "BARON";
		cardAbility = "+1 Buy - You may discard an Estate card. If you do, +4 Coins. Otherwise, gain an Estate card.";
		cardType = "ACTION";
		cardCost = 4;
		buys += 1;
	}
	
	public void bazaar()
	{
		cardName = "BAZAAR";
		cardAbility = "+1 Card & +2 Actions & +1 Coin";
		cardType = "ACTION";
		cardCost = 5;
		extraCards += 1;
		actions += 2;
		coins += 1;
	}
	
	public void blackMarket()
	{
		cardName = "BLACK MARKET";
		cardAbility = "+2 Coins - Reveal the top 3 cards of the Black Market deck. You may buy one of them immediately. Put the unbought cards on the bottom of the Black Market deck in any order.";
		cardType = "ACTION";
		cardCost = 3;
		coins += 2;
	}
	
	public void bridge()
	{
		cardName = "BRIDGE";
		cardAbility = "+1 Buy & +1 Coin - All cards (including cards in players hand) cost 1 Coin less this turn, but not less than 0 Coins.";
		cardType = "ACTION";
		cardCost = 4;
		buys += 1;
		coins += 1;
	}
	
	public void bureaucrat()
	{
		cardName = "BUREAUCRAT";
		cardAbility = "Gain a Silver card; put it on top of your deck. Each other player reveals a Victory card from his hand and puts it on his deck (or reveals a hand with no Victory cards).";
		cardType = "ACTION - ATTACK";
		cardCost = 4;
	}
	
	public void caravan()
	{
		cardName = "CARAVAN";
		cardAbility = "+1 Card & +1 Action - At the start of your next turn, +1 Card";
		cardType = "ACTION - DURATION";
		cardCost = 4;
		extraCards += 1;
		actions += 1;
	}
	
	public void chellar()
	{
		cardName = "CELLAR";
		cardAbility = "+1 Action - Discard any number of cards. +& Card per card discarded.";
		cardType = "ACTION";
		cardCost = 2;
		actions += 1;
	}
	
	public void chancellor()
	{
		cardName = "CHANCELLOR";
		cardAbility = "+2 coins - You may immediately put your deck into the discard pile.";
		cardType = "ACTION";
		cardCost = 3;
		coins += 2;
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
		coins += 2;
	}
	
	public void coppersmith()
	{
		cardName = "COPPERSMITH";
		cardAbility = "Copper produces an extra 1 Coin this turn.";
		cardType = "ACTION";
		cardCost = 4;
		coins += 1;
	}
	
	public void councilRoom()
	{
		cardName = "COUNCIL ROOM";
		cardAbility = "+4 Cards & +1 Buy - Each other player draws a card.";
		cardType = "ACTION";
		cardCost = 2;
		extraCards += 4;
		buys += 1;
	}
	
	public void courtyard()
	{
		cardName = "COURTYARD";
		cardAbility = "+3 cards - Put a card from your hand on top of your deck.";
		cardType = "ACTION";
		cardCost = 2;
		extraCards += 3;
	}
	
	public void cutpurse()
	{
		cardName = "CUTPURSE";
		cardAbility = "+2 coins - Each other player discards a Copper card (or reveals a hand with no Copper).";
		cardType = "ACTION - ATTACK";
		cardCost = 4;
		coins += 2;
	}
	
	public void embargo()
	{
		cardName = "EMBARGO";
		cardAbility = "+2 coins - Trash this card. Put an Embargo token on top of a Supply pile. --- When a player buys a card, he gains a Curse card per Embargo token on that pile.";
		cardType = "ACTION";
		cardCost = 2;
		coins += 2;
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
		extraCards += 1;
		actions += 1;
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
		actions += 2;
		buys += 1;
		coins += 2;
	}
	
	public void fishingVillage()
	{
		cardName = "FISHING VILLAGED";
		cardAbility = "+2 Actions & +1 Coins - At the start of your next turn: +1 Action & +1 Coin";
		cardType = "ACTION - DURATIONS";
		cardCost = 3;
		actions += 2;
		coins += 1;
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
		extraCards += 2;
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
		extraCards += 1;
		actions += 1;
	}
	
	public void harem()
	{
		cardName = "HAREM";
		cardAbility = "2 coins & 2 shields";
		cardType = "TREASURE - VICTORY";
		cardCost = 9;
		coins += 2;
	}
	
	public void haven()
	{
		cardName = "HAVEN";
		cardAbility = "+1 Card & +1 Action - Set aside a card from your hand face down. At the start of your next turn, put it into your hand.";
		cardType = "ACTION - DURATION";
		cardCost = 2;
		extraCards += 1;
		actions += 1;
	}
	
	public void herbalist()
	{
		cardName = "HERBALIST";
		cardAbility = "+1 Buy & +1 Coin - When you discard this from play, you may put one of your Treasures from play on top of your deck.";
		cardType = "ACTION";
		cardCost = 2;
		buys += 1;
		coins += 1;
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
		extraCards += 2;
		actions += 1;
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
		actions += 1;
	}
	
	public void lookout()
	{
		cardName = "LOOKOUT";
		cardAbility = "+1 Action - Look at the top 3 cards of your deck. Trash one of them. Discard one of them. Put the other one on top of your deck.";
		cardType = "ACTION";
		cardCost = 3;
		actions += 1;
	}
	
	public void market()
	{
		cardName = "MARKET";
		cardAbility = "+1 Card & +1 Action & +1 Buy & +1 Coin";
		cardType = "ACTION";
		cardCost = 5;
		extraCards += 1;
		actions += 1;
		buys += 1;
		coins += 1;
	}

	public void marsquerade()
	{
		cardName = "MASQUERADE";
		cardAbility = "+1 Cards - Each player passes a card from his hand to the left at once. Then you may trash a card from your hand.";
		cardType = "ACTION";
		cardCost = 3;
		extraCards += 2;
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
		coins += 2;
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
		extraCards += 1;
		actions += 2;
	}
	
	public void minion()
	{
		cardName = "MINION";
		cardAbility = "+1 Action - Choose one: +2 Coins; or discard your hand, +4 Cards, and each other player with at least 5 cards in hand discards his hand a draws 4 cards.";
		cardType = "ACTION - ATTACK";
		cardCost = 5;
		actions += 1;
	}
	
	public void moat()
	{
		cardName = "MOAT";
		cardAbility = "+2 Cards - when another player plays an Attack card, you may reveal this from your hand. If you do, you are unaffected by that Attack.";
		cardType = "ACTION - REACTION";
		cardCost = 2;
		extraCards += 2;
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
		actions += 2;
	}
	
	public void navigator()
	{
		cardName = "NAVIGATOR";
		cardAbility = "+2 Coins - Look at the top 5 cards of your deck. Either discard all of them, or put them back on top of your deck in any order.";
		cardType = "ACTION";
		cardCost = 4;
		coins += 2;
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
		extraCards += 1;
		actions += 1;
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
		buys += 1;
	}
	
	public void scout()
	{
		cardName = "SCOUT";
		cardAbility = "+1 Action - Reveal the top 4 cards of your deck. Put the revealed Victory cards into your hand. Put the other cards on top of your deck in any order.";
		cardType = "ACTION";
		cardCost = 4;
		actions += 1;
	}
	
	public void scryingPool()
	{
		cardName = "SCRYING POOL";
		cardAbility = "+1 Action - Each player (including you) reveals the top card of his deck and either discards it or puts it back, your choice. Then reveal cards from the rop of your deck until you reveal one that is not an Action. Put all of your revealed cards into your hand.";
		cardType = "ACTION - ATTACK";
		cardCost = 2;
		actions += 1;
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
	
	public void shantyTown()
	{
		cardName = "SHANTY TOWN";
		cardAbility = "+2 Actions - Reveal your hand. If you have no Action cards in hand, +2 Cards.";
		cardType = "ACTION";
		cardCost = 3;
		actions += 2;
	}
	
	public void smithy()
	{
		cardName = "SMITHY";
		cardAbility = "+3 Cards";
		cardType = "ACTION";
		cardCost = 4;
		extraCards += 3;
	}
	
	public void smugglers()
	{
		cardName = "SMUGGLERS";
		cardAbility = "Gain a copy of a card costing up to 6 Coins that the player to your right gained on his last turn.";
		cardType = "ACTION";
		cardCost = 3;
	}
	
	public void spy()
	{
		cardName = "SPY";
		cardAbility = "+1 Card & +1 Action - Each player (including you) reveals the top card of his deck and either discards it or puts it back, your choise.";
		cardType = "ACTION - ATTACK";
		cardCost = 4;
		extraCards += 1;
		actions += 1;
	}
	
	public void stash()
	{
		cardName = "STASH";
		cardAbility = "2 Coins --- When you shuffle, you may put this anywhere in your deck.";
		cardType = "TREASURE";
		cardCost = 5;
	}
	
	public void steward()
	{
		cardName = "STEWARD";
		cardAbility = "Choose one: +2 Cards, or +2 Coins; or trash 2 cards from your hand.";
		cardType = "ACTION";
		cardCost = 3;
	}
	
	public void swindler()
	{
		cardName = "SWINDLER";
		cardAbility = "+2 Coins - Each other player trashes the top card of his deck and gains a card with the same cost that you choose.";
		cardType = "ACTION - ATTACK";
		cardCost = 3;
		coins += 1;
	}
	
	public void tactician()
	{
		cardName = "TACTICIAN";
		cardAbility = "Discard your hand. If you discarded any cards this way. Then at the start of your next turn, +5 Cards, +1 Buy, and +1 Action.";
		cardType = "ACTION - DURATIONS";
		cardCost = 5;
	}
	
	public void thief()
	{
		cardName = "THIEF";
		cardAbility = "Each other player reveals the top 2 cards of his deck. If they revealed any Treasure cards, they trash one of them that you choose. You may gain any or all of these trashed cards. They discard the other revealed cards.";
		cardType = "ACTION - ATTACK";
		cardCost = 4;
	}
	
	public void throneRoom()
	{
		cardName = "THRONE ROOM";
		cardAbility = "Choose an Action card in your hand. Play it twice";
		cardType = "ACTION";
		cardCost = 4;
	}
	
	public void torturer()
	{
		cardName = "TORTURER";
		cardAbility = "+3 Cards - Each other player chooses one: he discards 2 cards";
		cardType = "ACTION - ATTACK";
		cardCost = 5;
		extraCards += 3;
	}
	
	public void tradingPost()
	{
		cardName = "TRADING POST";
		cardAbility = "Trash 2 cards from your hand. If you do, gain a Silver card; put it into your hand.";
		cardType = "ACTION";
		cardCost = 5;
	}
	
	public void transmute()
	{
		cardName = "TRANSMUTE";
		cardAbility = "Trash a card from your hand. If it is an... Action card, gain a Duchy; Treasure card, gain a Transmute; Victory card, gain a Gold.";
		cardType = "ACTION";
		cardCost = 0;
	}
	
	public void treasureMap()
	{
		cardName = "TREASURE MAP";
		cardAbility = "Trash this and another copy of Treasure Map from your hand. If you do trash two Treasure Maps, gain 4 Gold cards, putting them on top of your deck.";
		cardType = "ACTION";
		cardCost = 4;
	}
	
	public void treasury()
	{
		cardName = "TREASURE";
		cardAbility = "+1 Card & +1 Action & +1 Coin - When you discard this from play, if you didn't buy a Victory card this turn, you may put this on top of your deck.";
		cardType = "ACTION";
		cardCost = 5;
		extraCards += 1;
		actions += 1;
		coins += 1;
	}
	
	public void tribute()
	{
		cardName = "TRIBUTE";
		cardAbility = "The player to your left reveals then discards the top 2 cards of his deck. For each differently named card revealed, if it is an... Action Card, +2 Actions; Treasure Card, +2 Coins; Victory Card, +2 Cards";
		cardType = "ACTION";
		cardCost = 5;
	}
	
	public void university()
	{
		cardName = "UNIVERSITY";
		cardAbility = "+2 Actions - You may gain an Action card costing up to 5 Coins";
		cardType = "ACTION";
		cardCost = 2;
		actions += 2;
	}
	
	public void upgrade()
	{
		cardName = "UPGRADE";
		cardAbility = "+1 Card & +1 Action - Trash a card from your hand. Gain a card costing exactly 1 Coin more than it.";
		cardType = "ACTION";
		cardCost = 5;
		extraCards += 1;
		actions += 1;
	}
	
	public void village()
	{
		cardName = "VILLAGE";
		cardAbility = "+1 Card & +1 Actions";
		cardType = "ACTION";
		cardCost = 3;
		extraCards += 1;
		actions += 2;
	}
	
	public void vineyard()
	{
		cardName = "VINEYARD";
		cardAbility = "Worth 1 Shield for every 3 Action cards in your deck (rounded down).";
		cardType = "VICTORY";
		cardCost = 0;
	}
	
	public void warehouse()
	{
		cardName = "WAREHOUSE";
		cardAbility = "+3 Cards & +1 Action - Discard 3 cards";
		cardType = "ACTION";
		cardCost = 3;
		extraCards += 3;
		actions += 1;
	}
	
	public void whare()
	{
		cardName = "WHARE";
		cardAbility = "Now and at the start of your next turn: +2 Cards & +1 Buy";
		cardType = "ACTION";
		cardCost = 2;
		extraCards += 2;
		buys += 1;
	}
	
	public void whihingWell()
	{
		cardName = "WHARE";
		cardAbility = "+1 Card & +1 Action - Name a card. Reveal the top card of your deck. If it's the named card, put it into your hand.";
		cardType = "ACTION";
		cardCost = 3;
		extraCards += 1;
		actions += 1;
	}
	
	public void witch()
	{
		cardName = "WITCH";
		cardAbility = "+2 Cards - Each other player gains a Curse card.";
		cardType = "ACTION - ATTACK";
		cardCost = 5;
		extraCards += 2;
	}
	
	public void woodcutter()
	{
		cardName = "WOODCUTTER";
		cardAbility = "+1 Buy & +2 Coins";
		cardType = "ACTION";
		cardCost = 3;
		buys += 1;
		coins += 2;
	}
	
	public void workshop()
	{
		cardName = "WORKSHOP";
		cardAbility = "Gain a card costing up to 4 Coins";
		cardType = "ACTION";
		cardCost = 3;
	}
	
}
