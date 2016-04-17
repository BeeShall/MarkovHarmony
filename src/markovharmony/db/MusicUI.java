package markovharmony.db;


/**
 * Create the GUI form to allow the user to select their music options
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;


 

public class MusicUI extends JPanel
                          implements ActionListener {
    JComboBox artistList, genreList, eraList, locationList;
    JRadioButton c1, c2,p4,p8,minor,major;
    
    ButtonGroup chords,phrases, minor_major; 
    
    DBOperations operations;
    
    public MusicUI() {
        super(new GridLayout(0,2));
<<<<<<< HEAD
        Font font = new Font("Verdana", Font.BOLD, 15);
        Font font3 = new Font("Verdana", Font.BOLD, 18);
        Font font2 = new Font("Verdana", Font.BOLD, 37);
        String[] artists = { "", "Sia", "OMI", "Taylor Swift", "DNCE", "Walk the Moon"};
        String[] genres ={"","Rock","Hip_Hop","RandB","Classical","Country","Electronic","Pop"};
        String[] musicEra ={"","Baroque","Classical","Romantic", "20th Century", "Modern"};
        String[] locations ={"","African", "European", "North American", "Asian", "South American","Australian"};
=======
        try {
			operations = new DBOperations();
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			System.out.println(ex.getMessage());
			System.exit(0);
		}	
        String[] artists = operations.getArtists();//{ "", "Sia", "OMI", "Taylor Swift", "DNCE", "Walk the Moon"};
        String[] genres =operations.getGenre();//{"","Rock","Hip_Hop","RandB","Classical","Country","Electronic","Pop"};
        String[] musicEra =operations.getEra();//{"","Baroque","Classical","Romantic", "20th Century", "Modern"};
        String[] locations = operations.getLocations();//{"","African", "European", "North American", "Asian", "South American","Australian"};
>>>>>>> b7e47102819ba7da60619e4709687964b2692c4f
        
 
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
        
        minor = new JRadioButton("minor",true);
        major = new JRadioButton("major");
        minor_major = new ButtonGroup();
        minor_major.add(minor);
        minor_major.add(major);
        
        //create the labels for the combo boxes 
        JLabel header = new JLabel ("         MARKOVSKY");
        header.setFont(font2);
        JLabel directions = new JLabel ("Pick your poison or combination of poisons:");
        directions.setFont(font3);
        JLabel spacer = new JLabel("");
        
        JLabel artistLabel = new JLabel();
        artistLabel.setText("Artist");
        artistLabel.setFont(font);
        
        JLabel genLabel= new JLabel();
        genLabel.setText("Genre");
        genLabel.setFont(font);
        
        JLabel eraLabel= new JLabel();
        eraLabel.setText("Era");
        eraLabel.setFont(font);
        
        JLabel locLabel= new JLabel();
        locLabel.setText("Location");
        locLabel.setFont(font);
        
        JLabel chords = new JLabel("Chords Per Measure");
        chords.setFont(font);
        
        JLabel phr = new JLabel("Phrase Length");
        phr.setFont(font);
        
        JLabel maj = new JLabel("Mode");
        maj.setFont(font);
        
        JButton submit = new JButton("Make me something beautiful");
        submit.addActionListener(this);
        
        //Lay out 
        
        add(new JLabel(""));
        add(header);
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
        add(chords);
        add(new JLabel(""));
        add(c1);
        add(c2);
        add(phr);
        add(spacer);
        add(p4);
        add(p8);
        add(maj);
        add(new JLabel(""));
        add(minor);
        add(major);
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
        Font font = new Font("Verdana", Font.BOLD, 17);
        
        //Create and set up the content pane.
        JComponent newContentPane = new MusicUI();
        newContentPane.setBackground(Color.WHITE);
        newContentPane.setFont(font);
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
        if(genre == "") genre = "none";
        String era = eraList.getSelectedItem().toString();
        String loc = locationList.getSelectedItem().toString();
        String mode = "MINOR";
        
        int phrases = 4;
        
        if(c2.isSelected()){
            mode = "MAJOR";
        }
        
        if(p8.isSelected()){
          phrases = 8;
        }
        
			ArrayList<ArrayList<Integer>> els = operations.getFilteredData(artist, Genre.valueOf(genre.toUpperCase()), loc, era, Mode.valueOf(mode.toUpperCase())); //artist
			for(ArrayList<Integer> el: els){
				for(Integer chord: el){
					System.out.print(chord+" ");
				}
				System.out.println();
			}
			
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


 

