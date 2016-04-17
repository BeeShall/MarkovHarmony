package markovharmony.db;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StartMenu extends JFrame  {
	
	public StartMenu(){
		super();
		 this.setSize(500, 400);
	        Dimension windowSize = this.getSize();
	        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	        this.setLocation(screenSize.width/2 - windowSize.width/2, screenSize.height/2 - windowSize.height/2);
	        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        super.setVisible(true);


	        JPanel panel = new JPanel();
	        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
	        panel.setLayout(boxlayout);
	        
	        JLabel label1 = new JLabel("Welcome to Markovsky!");
	        
	        JLabel label2 = new JLabel("If you're visiting the first time, click here!");		        
	        JButton jb1 = new JButton("Start the database");
	        jb1.addActionListener( new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					startDatabase.start();
				}
	        	
	        });
	        
	        JLabel label3 = new JLabel("If you've already created the database, click here!");	        
	        JButton jb2 = new JButton("Launch Markovsky!");
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
	        panel.add(label2);
	        panel.add(jb1);
	        panel.add(label3);
	        panel.add(jb2);
	        
	        this.add(panel);            

	}

	    
		public static void main(String[] args) {
	        new StartMenu().setVisible(true);
		}

}
