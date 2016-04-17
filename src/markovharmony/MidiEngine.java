package markovharmony;
import javax.sound.midi.*;
import java.io.*;
import java.util.*;

public class MidiEngine 
{
	public static void generateMidiFromProgression()
	{
		try
		{
			System.out.println("Beginning MIDI creation...");
			
			Sequence sequence = new Sequence(javax.sound.midi.Sequence.PPQ,24);
			Track track = sequence.createTrack();
			
			byte[] b = {(byte)0xF0, 0x7E, 0x7F, 0x09, 0x01, (byte)0xF7};
			SysexMessage sm = new SysexMessage();
			sm.setMessage(b, 6);
			MidiEvent me = new MidiEvent(sm,(long)0);
			track.add(me);
			
			MetaMessage mt = new MetaMessage();
	        byte[] bt = {0x02, (byte)0x00, 0x00};
			mt.setMessage(0x51 ,bt, 3);
			me = new MidiEvent(mt,(long)0);
			track.add(me);
			
			mt = new MetaMessage();
			String TrackName = new String("Markov Demo Track");
			mt.setMessage(0x03 ,TrackName.getBytes(), TrackName.length());
			me = new MidiEvent(mt,(long)0);
			track.add(me);
			
			ShortMessage mm = new ShortMessage();
			mm.setMessage(0xB0, 0x7D,0x00);
			me = new MidiEvent(mm,(long)0);
			track.add(me);
			
			mm = new ShortMessage();
			mm.setMessage(0xB0, 0x7F,0x00);
			me = new MidiEvent(mm,(long)0);
			track.add(me);
			
			mm = new ShortMessage();
			mm.setMessage(0xC0, 0x00, 0x00);
			me = new MidiEvent(mm,(long)0);
			track.add(me);

			mm = new ShortMessage();
			mm.setMessage(0x90,0x3C,0x60);
			me = new MidiEvent(mm,(long)1);
			track.add(me);
			
			mm = new ShortMessage();
			mm.setMessage(0x80,0x3C,0x40);
			me = new MidiEvent(mm,(long)121);
			track.add(me);
			
			File f = new File("midifile.mid");
			MidiSystem.write(sequence,1,f);
			
			
			System.out.println("MIDI created.");

		}
		catch(Exception e)
		{
			System.out.println("Exception caught " + e.toString());
		}
		
		
		
		
	}
	
	
	
	
	
	
	
}
