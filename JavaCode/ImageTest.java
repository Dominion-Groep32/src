package JavaCode;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.annotation.Generated;
import javax.swing.*;
import org.junit.validator.PublicClassValidator;
import org.omg.CORBA.PUBLIC_MEMBER;
import jdk.internal.org.objectweb.asm.Label;
import java.util.*;
import sun.net.www.content.image.jpeg;
import java.util.Random;




public class ImageTest extends JFrame {
	private ImageIcon Image;
	private JLabel label;
	public String[] images;
	private JButton button1;
	private Random rng;
	public String[] startKaarten;
	public JPanel paneel;
	
	
	public ImageTest() {
		
		paneel = new JPanel();
		setLayout(new FlowLayout());
		JButton generate = new JButton();
		generate.setIcon(new ImageIcon(getClass().getResource("../images/back.jpg")));
		
		add(generate);
		Generated();
		
		generate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("deze knop werkt");
				Generated();
				}
	});
	}
	
	public void Generated(){
		
		String[] startKaarten = {"copper","copper","copper","copper","copper","copper","copper","estate","estate","estate"};
		JLabel[] arrayVanLabels = new JLabel[5];
		
		for (int i = 0; i <5; i++) {
			Random rng = new Random();
			int randomGetal = rng.nextInt(startKaarten.length);
			Image = new ImageIcon(getClass().getResource("../images/" + startKaarten[randomGetal]+".jpg"));
			label = new JLabel(Image);
			this.add(label);}
		}
	
	

	public void Setup(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.pack();
		this.setTitle("image Program");
		
	}
	
	public static void main (String args[]){
		ImageTest gui = new ImageTest();
		gui.Setup();
	
	}
	
	
	
	

}
