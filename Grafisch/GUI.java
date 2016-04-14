package Grafisch;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.annotation.Generated;
import javax.imageio.ImageIO;
import javax.smartcardio.Card;
import javax.swing.*;

//import org.eclipse.swt.widgets.Link;
import org.omg.CORBA.PUBLIC_MEMBER;

import com.sun.javafx.geom.AreaOp.NZWindOp;

import OudeCode.CardDetails;

import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
//import junit.framework.Test;

import java.util.*;
import sun.net.www.content.image.jpeg;

public class GUI extends JFrame {
	private JPanel pannelTop, pannelBottom, pannelRight, pannelLeft, pannelCenter, pannelCenterCenter, pannelCenterLeft,
			pannelCenterRight, pannelLeftTop, pannelLeftBottom, pannelRightTop, pannelRightBottom,testpannel;
	private JButton ButtonsTopPannel[], ButtonsBottomPannel[], ButtonsRightPannel[], ButtonsLeftPanel[],
			ButtonsPlayField[], ButtonsActions[];
	private JLabel actions, buys, coins, imageLabel, testLabel[],test;
	private int aantalActieKaarten = 10;
	private int aantalKaartenHand = 5;
	private ImageIcon image;
	private String[] actieKaarten = { "ambassador", "cellar", "chancellor", "chapel", "councilroom", "feast",
			"festival", "laboratory", "library", "market", "militia", "moat", "moneylender", "smithy", "spy", "thief",
			"village", "witch", "woodcutter", "workshop" };
	private String[] landKaarten = { "province", "duchy", "estate" };
	private String[] geldKaarten = { "copper", "silver", "gold", "curse" };
	

	

	
	
	
	public GUI() {
		InitComponents();
		LayoutComponents();
		//InitListeners();
		 
	}

	// maakt componenten
	public void InitComponents() {
		
		
		// venster
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(50, 50);
		setTitle("JENS IS PRO");
		setVisible(true);
		setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);

		// background
		//image = new ImageIcon(getClass().getResource("../images/background.jpg"));
		//imageLabel = new JLabel(image);
		//setSize(1940, 1100);
		//add(imageLabel);
		
		
		

		// pannels aanmaken
		pannelRight = new JPanel();
		pannelLeft = new JPanel();
		pannelTop = new JPanel();
		pannelBottom = new JPanel();
		pannelCenter = new JPanel();
		pannelCenterCenter = new JPanel();
		pannelLeftTop = new JPanel();
		pannelLeftBottom = new JPanel();
		pannelRightTop = new JPanel();
		pannelRightBottom = new JPanel();
		pannelCenterLeft = new JPanel();
		pannelCenterRight = new JPanel();
		
		

		// buttons 10 kaarten toppanel
		ButtonsTopPannel = new JButton[aantalActieKaarten];
		for (int i = 0; i < ButtonsTopPannel.length; i++) {
			ButtonsTopPannel[i] = new JButton();
			ButtonsTopPannel[i].setBorder(BorderFactory.createLineBorder(Color.white));
		}

		// labels 5 kaarten bottompanel
		ButtonsBottomPannel = new JButton[aantalKaartenHand];
		for (int i = 0; i < ButtonsBottomPannel.length; i++) {
			ButtonsBottomPannel[i] = new JButton();
			ButtonsBottomPannel[i].setBorder(BorderFactory.createLineBorder(Color.white));
		}
	}

	// geeft waardes aan componenten
	public void LayoutComponents() {

		// main frame in 3 verdelen
		setLayout(new BorderLayout());
		add(pannelLeft, BorderLayout.WEST);
		add(pannelCenter, BorderLayout.CENTER);
		add(pannelRight, BorderLayout.EAST);

		// left in 2 delen
		pannelLeft.setLayout(new BorderLayout());
		pannelLeft.add(pannelLeftTop, BorderLayout.NORTH);
		pannelLeft.add(pannelLeftBottom, BorderLayout.SOUTH);

		// right in 2 delen
		pannelRight.setLayout(new BorderLayout());
		pannelRight.add(pannelRightTop, BorderLayout.NORTH);
		pannelRight.add(pannelRightBottom, BorderLayout.SOUTH);

		// center in 3 delen boven elkaar verdelen

		pannelCenter.setLayout(new BorderLayout());
		pannelCenter.add(pannelTop, BorderLayout.NORTH);
		pannelCenter.add(pannelCenterCenter, BorderLayout.CENTER);
		pannelCenter.add(pannelBottom, BorderLayout.SOUTH);

		// left buttons generaten
		pannelLeftTop.setLayout(new GridLayout(3, 1));
		ButtonsLeftPanel = new JButton[3];
		
		for (int i = 0; i < 3; i++) {
			ButtonsLeftPanel[i] = new JButton();
			ButtonsLeftPanel[i].setPreferredSize(new Dimension(120, 190));
			pannelLeftTop.add(ButtonsLeftPanel[i]);
		}

		// right buttons generaten
		pannelRightTop.setLayout(new GridLayout(4, 1));
		ButtonsRightPannel = new JButton[4];
		for (int i = 0; i < 4; i++) {
			ButtonsRightPannel[i] = new JButton();
			ButtonsRightPannel[i].setPreferredSize(new Dimension(120, 190));
			pannelRightTop.add(ButtonsRightPannel[i]);
		}

		
		//actionkaarten positioneren
		pannelTop.setLayout(new GridLayout(2, 7));
		testLabel = new JLabel[20];

		for (int i = 0; i < 2; i++) {
			testLabel[1] = new JLabel();
			pannelTop.add(testLabel[1]);
		}
		for (int i = 0; i < 5; i++) {
			pannelTop.add(ButtonsTopPannel[i]);
		}
		for (int i = 0; i < 4; i++) {
			testLabel[1] = new JLabel();
			pannelTop.add(testLabel[1]);
		}
		for (int i = 5; i < 10; i++) {
			pannelTop.add(ButtonsTopPannel[i]);
		}
		for (int i = 0; i < 2; i++) {
			testLabel[1] = new JLabel();
			pannelTop.add(testLabel[1]);
		}
		
		

		// bottom buttons generaten
		pannelBottom.setLayout(new FlowLayout());
		for (int i = 0; i < ButtonsBottomPannel.length; i++) {
			pannelBottom.add(ButtonsBottomPannel[i]);
		}

		// action buttons generaten
		pannelRightBottom.setLayout(new GridLayout(2, 1));
		ButtonsActions = new JButton[2];
		ButtonsActions[0] = new JButton("Swap cards");
		ButtonsActions[1] = new JButton("PlayTressuers");
		pannelRightBottom.add(ButtonsActions[0]);
		pannelRightBottom.add(ButtonsActions[1]);
		}

	
/*	public void InitListeners() {
		
		ButtonsActions[0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AddDrawHandImages(deckActions.startKaarten());
			}});
		
		
		for (int i = 0; i < ButtonsBottomPannel.length; i++) {
			int getal = i;
			ButtonsBottomPannel[i].addActionListener(new ActionListener() {		
				@Override
				public void actionPerformed(ActionEvent e) {
					
					
					String selectedCardName = ButtonsBottomPannel[getal].getName().toLowerCase();					
					String selectedCardType = gameActions.getCardType(selectedCardName).toLowerCase();
										
					
					if (!selectedCardType.equals("victory")) {
						
						playableField.add(ButtonsBottomPannel[getal].getName());
						ButtonsBottomPannel[getal].setVisible(false);
						playableFieldButtons(playableField, selectedCardName, getal);
						
						//System.out.println("tester " + gameActions.getCardCoins(selectedCardName));

					}}});}
		
		
		ButtonsActions[1].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < aantalKaartenHand; i++) {
					
					String selectedCardName = ButtonsBottomPannel[i].getName();
					String selectedCardType = gameActions.getCardType(selectedCardName).toLowerCase();
					
					if (selectedCardType.equals("treasure")) {
						playableField.add(selectedCardName);
						ButtonsBottomPannel[i].setVisible(false);
						playableFieldButtons(playableField,selectedCardName, i);
						
						}}}}); 
		
		for (int i = 0; i < ButtonsTopPannel.length; i++) {
			int getal = i;
			ButtonsTopPannel[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					//gameActions.getCardType(ButtonsTopPannel[getal].getName());
			
				}});}
		
		for (int i = 0; i < ButtonsRightPannel.length; i++) {
			int getal = i;
			ButtonsRightPannel[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println(ButtonsRightPannel[getal].getName());
					System.out.println(gameActions.getCardCoins(ButtonsRightPannel[getal].getName()));
				}});}
			}
	
	*/
	
	public void playableFieldButtons(LinkedList<String> list, String selectedCardName, int getal) {
		ButtonsPlayField = new JButton[50];
		ButtonsPlayField[getal] = new JButton();
		image = new ImageIcon(getClass().getResource("../images/" + selectedCardName + ".jpg"));
		ButtonsPlayField[getal].setIcon(image);
		ButtonsPlayField[getal].setPreferredSize(new Dimension(190, 300));
		pannelCenterCenter.add(ButtonsPlayField[getal]);
	}

	public void GenerateMoneyCards() {

		for (int i = 0; i < geldKaarten.length; i++) {
			String path = "../images/Side/" + geldKaarten[i] + ".jpg";
			image = new ImageIcon(getClass().getResource(path));
			ButtonsRightPannel[i].setIcon(image);
			ButtonsRightPannel[i].setName(geldKaarten[i]);
			}
	}

	public void GenerateFieldCards() {

		for (int i = 0; i < landKaarten.length; i++) {
			String path = "../images/Side/" + landKaarten[i] + ".jpg";
			image = new ImageIcon(getClass().getResource(path));
			ButtonsLeftPanel[i].setIcon(image);
			ButtonsLeftPanel[i].setName(landKaarten[i]);
		}
	}

	public void displayActionCards(LinkedList<String> list) {

		for (int i = 0; i < aantalActieKaarten; i++) {
			String path = "../images/Action/" + list.get(i) + ".jpg";
			image = new ImageIcon(getClass().getResource(path));
			ButtonsTopPannel[i].setIcon(image);
			ButtonsTopPannel[i].setName(list.get(i).toLowerCase());
		}

	}
	
	
	
	public void AddDrawHandImages(LinkedList<String> list) {
		
		for (int i = 0; i < aantalKaartenHand; i++) {
			String path = "../images/" + list.get(i) + ".jpg";
			image = new ImageIcon(getClass().getResource(path));
			ButtonsBottomPannel[i].setIcon(image);
			ButtonsBottomPannel[i].setName(list.get(i).toLowerCase());
		}
	}

	/*public void GenerateCardsField() {
		displayActionCards(deckActions.actieKaartenGenereren());
		GenerateFieldCards();
		GenerateMoneyCards();
		AddDrawHandImages(deckActions.startKaarten());

	}*/

}
