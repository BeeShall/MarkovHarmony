package markovharmony.db;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StartMenu extends JFrame  {
	
	public StartMenu(){
		super("Welcome!");
		 this.setSize(700, 400);
	        Dimension windowSize = this.getSize();
	        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	        this.setLocation(screenSize.width/2 - windowSize.width/2, screenSize.height/2 - windowSize.height/2);
	        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        super.setVisible(true);
	        
	        Font font = new Font("Verdana", Font.BOLD, 17);


	        JPanel panel = new JPanel();
	        GridLayout grid = new GridLayout(0,2);
	        panel.setLayout(grid);
	        
	        JLabel label1 = new JLabel("Welcome to Markovsky!");
	        label1.setFont(font);
	        
	        JLabel label2 = new JLabel("New? Click here!");	
	        label2.setFont(font);
	        JButton jb1 = new JButton("Start the database");
	        jb1.setFont(font);;
	        jb1.addActionListener( new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					startDatabase.start();
					FileReader.readFile();
				}
	        	
	        });
	        
	        JLabel label3 = new JLabel("Been here before? click here!");	
	        label3.setFont(font);
	        JButton jb2 = new JButton("Launch Markovsky!");
	        jb2.setFont(font);
	        jb2.addActionListener( new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					javax.swing.SwingUtilities.invokeLater(new Runnable() {
			            public void run() {
			                MusicUI.createAndShowGUI();
			                StartMenu.getFrames()[0].dispose();
			            }
			        });
				}
	        	
	        });
	        panel.add(label1);
	        panel.add(new JLabel(""));
	        panel.add(label2);
	        Dimension d = new Dimension(100,100);
	        jb1.setSize(d);
	        panel.add(jb1);
	        panel.add(label3);
	        
	        jb2.setPreferredSize(new Dimension(100, 100));
	        panel.add(jb2);
	        panel.setBackground(Color.WHITE);
	        panel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
	        this.add(panel); 
	        

	}

	    
		public static void main(String[] args) {
	        new StartMenu().setVisible(true);
		}

}
