package markovharmony;
import javax.sound.midi.*;
import java.io.*;
import java.util.*;

public class MidiEngine 
{
	private Integer contourDivisor;
	
	public MidiEngine(Integer chordsPerMeasure)
	{
		contourDivisor = chordsPerMeasure;
	}
	
	public void generateMidiFromProgression(ArrayList<String[]> progression)
	{
		
		
		try
		{
			System.out.println("Beginning MIDI creation...");
			
			// Formalities
			
			Sequence sequence = new Sequence(javax.sound.midi.Sequence.PPQ,24);
			Track track = sequence.createTrack();
			
			byte[] b = {(byte)0xF0, 0x7E, 0x7F, 0x09, 0x01, (byte)0xF7};
			SysexMessage sm = new SysexMessage();
			sm.setMessage(b, 6);
			MidiEvent me = new MidiEvent(sm,(long)0);
			track.add(me);
			
			MetaMessage mt = new MetaMessage();
			
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

			// Dance track
			
			dancePattern(track, me, mm, progression);
			
			
			// Set end of track
			
			mt = new MetaMessage();
	        byte[] bet = {}; // empty array
			mt.setMessage(0x2F,bet,0);
			me = new MidiEvent(mt, (long)140);
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
	
	private void dancePattern(Track track, MidiEvent me, ShortMessage mm, ArrayList<String[]> progression) throws InvalidMidiDataException
	{
		
		int location = 0;
		NoteMap notemap = new NoteMap();
		
		for(int i = 0; i < progression.size(); i++)
		{
			for(int j = 0; j < contourDivisor; j++)
			{			
				mm = new ShortMessage();
				mm.setMessage(ShortMessage.NOTE_ON, 0, notemap.Notes.get(progression.get(i)[0])[0], 93);
				me = new MidiEvent(mm,(long)location);
				track.add(me);
				
				mm = new ShortMessage();
				mm.setMessage(ShortMessage.NOTE_ON, 0, notemap.Notes.get(progression.get(i)[1])[0], 93);
				me = new MidiEvent(mm,(long)location);
				track.add(me);
				
				mm = new ShortMessage();
				mm.setMessage(ShortMessage.NOTE_ON, 0, notemap.Notes.get(progression.get(i)[2])[0], 93);
				me = new MidiEvent(mm,(long)location);
				track.add(me);
				
				location += 18;
				
				mm = new ShortMessage();
				mm.setMessage(ShortMessage.NOTE_OFF, 0, notemap.Notes.get(progression.get(i)[0])[0], 93);
				me = new MidiEvent(mm,(long)location);
				track.add(me);
				
				mm = new ShortMessage();
				mm.setMessage(ShortMessage.NOTE_OFF, 0, notemap.Notes.get(progression.get(i)[1])[0], 93);
				me = new MidiEvent(mm,(long)location);
				track.add(me);
				
				mm = new ShortMessage();
				mm.setMessage(ShortMessage.NOTE_OFF, 0, notemap.Notes.get(progression.get(i)[2])[0], 93);
				me = new MidiEvent(mm,(long)location);
				track.add(me);
			}			
			
			for(int j = 0; j < contourDivisor; j++)
			{			
				mm = new ShortMessage();
				mm.setMessage(ShortMessage.NOTE_ON, 0, notemap.Notes.get(progression.get(i)[0])[0], 93);
				me = new MidiEvent(mm,(long)location);
				track.add(me);
				
				mm = new ShortMessage();
				mm.setMessage(ShortMessage.NOTE_ON, 0, notemap.Notes.get(progression.get(i)[1])[0], 93);
				me = new MidiEvent(mm,(long)location);
				track.add(me);
				
				mm = new ShortMessage();
				mm.setMessage(ShortMessage.NOTE_ON, 0, notemap.Notes.get(progression.get(i)[2])[0], 93);
				me = new MidiEvent(mm,(long)location);
				track.add(me);
				
				location += 18;
			
				mm = new ShortMessage();
				mm.setMessage(ShortMessage.NOTE_OFF, 0, notemap.Notes.get(progression.get(i)[0])[0], 93);
				me = new MidiEvent(mm,(long)location);
				track.add(me);
				
				mm = new ShortMessage();
				mm.setMessage(ShortMessage.NOTE_OFF, 0, notemap.Notes.get(progression.get(i)[1])[0], 93);
				me = new MidiEvent(mm,(long)location);
				track.add(me);
				
				mm = new ShortMessage();
				mm.setMessage(ShortMessage.NOTE_OFF, 0, notemap.Notes.get(progression.get(i)[2])[0], 93);
				me = new MidiEvent(mm,(long)location);
				track.add(me);	
			
			}
			
			for(int j = 0; j < contourDivisor; j++)
			{
						
				mm = new ShortMessage();
				mm.setMessage(ShortMessage.NOTE_ON, 0, notemap.Notes.get(progression.get(i)[0])[0], 93);
				me = new MidiEvent(mm,(long)location);
				track.add(me);
				
				mm = new ShortMessage();
				mm.setMessage(ShortMessage.NOTE_ON, 0, notemap.Notes.get(progression.get(i)[1])[0], 93);
				me = new MidiEvent(mm,(long)location);
				track.add(me);
				
				mm = new ShortMessage();
				mm.setMessage(ShortMessage.NOTE_ON, 0, notemap.Notes.get(progression.get(i)[2])[0], 93);
				me = new MidiEvent(mm,(long)location);
				track.add(me);
				
				location += 12;
	
				
				mm = new ShortMessage();
				mm.setMessage(ShortMessage.NOTE_OFF, 0, notemap.Notes.get(progression.get(i)[0])[0], 93);
				me = new MidiEvent(mm,(long)location);
				track.add(me);
				
				mm = new ShortMessage();
				mm.setMessage(ShortMessage.NOTE_OFF, 0, notemap.Notes.get(progression.get(i)[1])[0], 93);
				me = new MidiEvent(mm,(long)location);
				track.add(me);
				
				mm = new ShortMessage();
				mm.setMessage(ShortMessage.NOTE_OFF, 0, notemap.Notes.get(progression.get(i)[2])[0], 93);
				me = new MidiEvent(mm,(long)location);
				track.add(me);
			}		
			
			
		}

		
	}
	
	
	
	
	
}
