package JavaCode;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.annotation.Generated;
import javax.swing.*;
import org.junit.validator.PublicClassValidator;
import org.omg.CORBA.PUBLIC_MEMBER;

import javafx.geometry.VerticalDirection;
import jdk.internal.org.objectweb.asm.Label;
import java.util.*;
import sun.net.www.content.image.jpeg;
import java.util.Random;




public class GUI extends JFrame {
    private JPanel pannelTop, pannelBottom, pannelRight, pannelLeft, pannelCenter, pannelCenterCenter;
    private JButton b1, b2, b3, b4;
    private JLabel labelsTopPannel[], labelsBottomPannel[],labelsRightPannel[];
    private int aantalActieKaarten = 10;
    private int aantalKaartenHand = 5;
    private ImageIcon image;
    private JScrollPane vertical;
 
    public GUI() {
        InitComponents();
        LayoutComponents();
        InitListeners();
    }
 
    // maakt componenten
    public void InitComponents() {
        // 4 sides pannels
        pannelRight = new JPanel();
        pannelLeft = new JPanel();
        pannelTop = new JPanel();
        pannelBottom = new JPanel();
        pannelCenter = new JPanel();
        pannelCenterCenter = new JPanel();
        

 
        // test buttons
        b1 = new JButton("Province");
        b2 = new JButton("Dutchy");
        b3 = new JButton("Estate");
        b4 = new JButton("test");
 
        // labels 10 kaarten toppanel
        labelsTopPannel = new JLabel[aantalActieKaarten];
 
        for (int i = 0; i < labelsTopPannel.length; i++) {
            labelsTopPannel[i] = new JLabel(i + "");
            labelsTopPannel[i].setBorder(BorderFactory.createLineBorder(Color.white));
            
        }
 
        // labels 5 kaarten bottompanel
        labelsBottomPannel = new JLabel[aantalKaartenHand];
        for (int i = 0; i < labelsBottomPannel.length; i++) {
            labelsBottomPannel[i] = new JLabel(i + "");
            labelsBottomPannel[i].setBorder(BorderFactory.createLineBorder(Color.white));
        }
 
        // venster
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(50, 50);
        setTitle("JENS IS PRO");
        setVisible(true);
        setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);
    }
 
    // geeft waardes aan componenten
    public void LayoutComponents() {
 
        // main frame in 3 verdelen
    	
        setLayout(new BorderLayout());
        add(pannelLeft, BorderLayout.WEST);
        add(pannelCenter, BorderLayout.CENTER);
        add(pannelRight, BorderLayout.EAST);
 
        // center in 3 delen boven elkaar verdelen
        pannelCenter.setLayout(new BorderLayout());
        pannelCenter.add(pannelTop, BorderLayout.NORTH);
        pannelCenter.add(pannelCenterCenter, BorderLayout.CENTER);
        pannelCenter.add(pannelBottom, BorderLayout.SOUTH);
 
        // left
        pannelLeft.setLayout(new GridLayout(3, 1));
        pannelLeft.add(b1);
        pannelLeft.add(b2);
        pannelLeft.add(b3);
 
        // right
        pannelRight.setLayout(new GridLayout(4, 1));
        labelsRightPannel = new JLabel[3];
        for (int i = 0; i < 3; i++) {
            labelsRightPannel[i] = new JLabel(i + "");
            labelsRightPannel[i].setBorder(BorderFactory.createLineBorder(Color.white));
            
            }
        
 
        // labels adden aan top pannel
        pannelTop.setLayout(new GridLayout(2, aantalActieKaarten / 2));
        for (int i = 0; i < labelsTopPannel.length; i++) {
            pannelTop.add(labelsTopPannel[i]);
        }
 
        // labels adden aan bottom panel
        pannelBottom.setLayout(new FlowLayout());
        for (int i = 0; i < labelsBottomPannel.length; i++) {
            pannelBottom.add(labelsBottomPannel[i]);
        }
       
 
    }
 
   
    public void InitListeners() {
    	// acties (buttons/labels...etc)
    }
 
    public void GenerateCardsHand() {
        String[] startKaarten = { "copper", "copper", "copper", "copper", "copper", "copper", "copper", "estate",
                "estate", "estate" };
     
 
        // fill bottom panel (hand)
        for (int i = 0; i < aantalKaartenHand; i++) {
            Random rng = new Random();
            int randomGetal = rng.nextInt(startKaarten.length);
            String path = "../images/" + startKaarten[randomGetal] + ".jpg"; // PATH??????
            
            image = new ImageIcon(getClass().getResource(path));
            labelsBottomPannel[i].setIcon(image);
 
        }
    }
 
    public void GenerateCardsField() {
    	 String[] actieKaarten = { "ambassador", "cellar", "chancellor", "chapel", "councilroom", "feast",
                 "festival", "laboratory", "library", "market", "militia", "moat", "moneylender", "smithy", "spy",
                 "thief", "village", "witch", "woodcutter", "workshop" };
   	
 
    	 Collections.shuffle((Arrays.asList(actieKaarten)));    
 
        // fill top panel (field)
        for (int i = 0; i < 10; i++) {
            String path = "../images/Action/" + actieKaarten[i] + ".jpg"; // PATH??????
            image = new ImageIcon(getClass().getResource(path));
            labelsTopPannel[i].setIcon(image);
        }
 
    }
    
   
 
}
	
	


