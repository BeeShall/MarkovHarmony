package markovharmony;

/**
 * Create the GUI form to allow the user to select their music options
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 

public class MusicUI extends JPanel
                          implements ActionListener {
    JComboBox artistList, genreList, eraList, locationList;
    JRadioButton c1, c2,p4,p8;
    
    ButtonGroup chords,phrases; 
    
    public MusicUI() {
        super(new GridLayout(0,2));
        String[] artists = { "", "The Grateful Dead", "David Bowie", "Beastie Boys", "The Rolling Stones", "Frank Ocean"};
        String[] genres ={"","Rock","Hip-Hop","R&B","Classical","Country","Electronic","Pop"};
        String[] musicEra ={"","Baroque","Classical","Romantic", "20th Century", "Modern"};
        String[] locations ={"","African", "European", "North American", "Asian", "South American","Australian"};
        
 
        //Create the combo boxes, make automatic blank
        artistList = new JComboBox(artists);
        artistList.setSelectedIndex(0);
        
        genreList = new JComboBox(genres);
        genreList.setSelectedIndex(0);
        
        eraList = new JComboBox(musicEra);
        eraList.setSelectedIndex(0);
        
        locationList = new JComboBox(locations);
        locationList.setSelectedIndex(0);
        
        //set up radio button choices for chords/phrases
        c1= new JRadioButton("1", true);
        c2= new JRadioButton("2");
        chords = new ButtonGroup();
        chords.add(c1);
        chords.add(c2);
        
        p4= new JRadioButton("4", true);
        p8= new JRadioButton("8");
        phrases = new ButtonGroup();
        phrases.add(p4);
        phrases.add(p8);
        
        //create the labels for the combo boxes 
        JLabel directions = new JLabel ("Pick your poison or combination of poisons:");
        JLabel spacer = new JLabel("");
        
        JLabel artistLabel = new JLabel();
        artistLabel.setText("Artist");
        
        JLabel genLabel= new JLabel();
        genLabel.setText("Genre");
        
        JLabel eraLabel= new JLabel();
        eraLabel.setText("Era");
        
        JLabel locLabel= new JLabel();
        locLabel.setText("Location");
        
        JButton submit = new JButton("Make me something beautiful");
        submit.addActionListener(this);
        
        //Lay out 
        add(directions);
        add(new JLabel(""));
        add(artistLabel);
        add(artistList);
        add(genLabel);
        add(genreList);
        add(eraLabel);
        add(eraList);
        add(locLabel);
        add(locationList);
        add(new JLabel("Chords Per Measure"));
        add(new JLabel(""));
        add(c1);
        add(c2);
        add(new JLabel("Phrase Length"));
        add(spacer);
        add(p4);
        add(p8);
        add(submit);
        setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
    }
    
      /**
     * Create the GUI and show it. Should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Markovsky");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BoxLayout boxLayout = new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS); // top to bottom
  
        //Create and set up the content pane.
        JComponent newContentPane = new MusicUI();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
    
     
    /** Listens to the combo box. */
    public void actionPerformed(ActionEvent e) {
        //user input, empty string if it was a blank query
        String artist = artistList.getSelectedItem().toString();
        String genre= genreList.getSelectedItem().toString();
        String era = eraList.getSelectedItem().toString();
        String loc = locationList.getSelectedItem().toString();
        int chords = 1;
        int phrases = 4;
        
        if(c2.isSelected()){
            chords = 2;
        }
        
        if(p8.isSelected()){
          phrases = 8;
        }
        
        System.out.println(chords);
    }
   
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

}


 

