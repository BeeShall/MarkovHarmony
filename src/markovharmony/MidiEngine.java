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
	
	public void generateMidiFromProgression(ArrayList<String[]> progression) throws InvalidMidiDataException
	{
		
		
		System.out.println("Beginning MIDI creation...");
		midRange(progression);
		highRange(progression);
		openRange(progression);
		
		System.out.println("MIDI created.");
		
	}
	
	private void highRange(ArrayList<String[]> progression)
	{
		// Formalities
			try
			{
				Sequence sequence = new Sequence(javax.sound.midi.Sequence.PPQ,24);
				Track track = sequence.createTrack();
				
				byte[] b = {(byte)0xF0, 0x7E, 0x7F, 0x09, 0x01, (byte)0xF7};
				SysexMessage sm = new SysexMessage();
				sm.setMessage(b, 6);
				MidiEvent me = new MidiEvent(sm,(long)0);
				track.add(me);
				
				MetaMessage mt = new MetaMessage();
				
				mt = new MetaMessage();
				String TrackName = new String("HighRange");
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
				
				arpeggiate(track, me, mm, progression);
				
				
				// Set end of track
				
				mt = new MetaMessage();
		        byte[] bet = {}; // empty array
				mt.setMessage(0x2F,bet,0);
				me = new MidiEvent(mt, (long)140);
				track.add(me);
				
				
				File f = new File("highRange.mid");
				MidiSystem.write(sequence,1,f);
				
			

			}
			catch(Exception e)
			{
				System.out.println("Exception caught " + e.toString());
			}
		
		}

	
	
	private void midRange(ArrayList<String[]> progression) throws InvalidMidiDataException
	{
		try
		{
			
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
			String TrackName = new String("MidRange");
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
			
			
			File f = new File("midRange.mid");
			MidiSystem.write(sequence,1,f);
			
		

		}
		catch(Exception e)
		{
			System.out.println("Exception caught " + e.toString());
		}
	}
	
	private void openRange(ArrayList<String[]> progression) throws InvalidMidiDataException
	{
		try
		{
			
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
			String TrackName = new String("Pad");
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
			
			pad(track, me, mm, progression);
			
			
			// Set end of track
			
			mt = new MetaMessage();
	        byte[] bet = {}; // empty array
			mt.setMessage(0x2F,bet,0);
			me = new MidiEvent(mt, (long)140);
			track.add(me);
			
			
			File f = new File("pad.mid");
			MidiSystem.write(sequence,1,f);
			
	
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
	
	private void arpeggiate(Track track, MidiEvent me, ShortMessage mm, ArrayList<String[]> progression) throws InvalidMidiDataException
	{
		int location = 0;
		NoteMap notemap = new NoteMap();
		Random rand = new Random();
		int index1, index2;
		int velocity = 90;
		
		for(int i = 0; i < progression.size(); i++)
		{
			for(int j = 0; j < contourDivisor; j++)
			{			
				
				index1 = rand.nextInt(3);
				index2 = rand.nextInt(3);
				
				mm = new ShortMessage();
				mm.setMessage(ShortMessage.NOTE_ON, 0, notemap.Notes.get(progression.get(i)[index1])[index2], velocity);
				me = new MidiEvent(mm,(long)location);
				track.add(me);
				
				location += 6;
				
				mm = new ShortMessage();
				mm.setMessage(ShortMessage.NOTE_OFF, 0, notemap.Notes.get(progression.get(i)[index1])[index2], velocity);
				me = new MidiEvent(mm,(long)location);
				track.add(me);
				
				index1 = rand.nextInt(3);
				index2 = rand.nextInt(3);
				
				mm = new ShortMessage();
				mm.setMessage(ShortMessage.NOTE_ON, 0, notemap.Notes.get(progression.get(i)[index1])[index2], velocity);
				me = new MidiEvent(mm,(long)location);
				track.add(me);
				
				location += 6;
				
				mm = new ShortMessage();
				mm.setMessage(ShortMessage.NOTE_OFF, 0, notemap.Notes.get(progression.get(i)[index1])[index2], velocity);
				me = new MidiEvent(mm,(long)location);
				track.add(me);
				
				index1 = rand.nextInt(3);
				index2 = rand.nextInt(3);
				
				mm = new ShortMessage();
				mm.setMessage(ShortMessage.NOTE_ON, 0, notemap.Notes.get(progression.get(i)[index1])[index2], velocity);
				me = new MidiEvent(mm,(long)location);
				track.add(me);
				
				location += 6;
				
				mm = new ShortMessage();
				mm.setMessage(ShortMessage.NOTE_OFF, 0, notemap.Notes.get(progression.get(i)[index1])[index2], velocity);
				me = new MidiEvent(mm,(long)location);
				track.add(me);
				
				index1 = rand.nextInt(3);
				index2 = rand.nextInt(3);
				
				mm = new ShortMessage();
				mm.setMessage(ShortMessage.NOTE_ON, 0, notemap.Notes.get(progression.get(i)[index1])[index2], velocity);
				me = new MidiEvent(mm,(long)location);
				track.add(me);
				
				location += 6;
				
				mm = new ShortMessage();
				mm.setMessage(ShortMessage.NOTE_OFF, 0, notemap.Notes.get(progression.get(i)[index1])[index2], velocity);
				me = new MidiEvent(mm,(long)location);
				track.add(me);
				
				index1 = rand.nextInt(3);
				index2 = rand.nextInt(3);
				
				mm = new ShortMessage();
				mm.setMessage(ShortMessage.NOTE_ON, 0, notemap.Notes.get(progression.get(i)[index1])[index2], velocity);
				me = new MidiEvent(mm,(long)location);
				track.add(me);
				
				location += 6;
				
				mm = new ShortMessage();
				mm.setMessage(ShortMessage.NOTE_OFF, 0, notemap.Notes.get(progression.get(i)[index1])[index2], velocity);
				me = new MidiEvent(mm,(long)location);
				track.add(me);
				
				index1 = rand.nextInt(3);
				index2 = rand.nextInt(3);
				
				mm = new ShortMessage();
				mm.setMessage(ShortMessage.NOTE_ON, 0, notemap.Notes.get(progression.get(i)[index1])[index2], velocity);
				me = new MidiEvent(mm,(long)location);
				track.add(me);
				
				location += 6;
				
				mm = new ShortMessage();
				mm.setMessage(ShortMessage.NOTE_OFF, 0, notemap.Notes.get(progression.get(i)[index1])[index2], velocity);
				me = new MidiEvent(mm,(long)location);
				track.add(me);
				
				index1 = rand.nextInt(3);
				index2 = rand.nextInt(3);
				
				mm = new ShortMessage();
				mm.setMessage(ShortMessage.NOTE_ON, 0, notemap.Notes.get(progression.get(i)[index1])[index2], velocity);
				me = new MidiEvent(mm,(long)location);
				track.add(me);
				
				location += 6;
				
				mm = new ShortMessage();
				mm.setMessage(ShortMessage.NOTE_OFF, 0, notemap.Notes.get(progression.get(i)[index1])[index2], velocity);
				me = new MidiEvent(mm,(long)location);
				track.add(me);
				
				index1 = rand.nextInt(3);
				index2 = rand.nextInt(3);
				
				mm = new ShortMessage();
				mm.setMessage(ShortMessage.NOTE_ON, 0, notemap.Notes.get(progression.get(i)[index1])[index2], velocity);
				me = new MidiEvent(mm,(long)location);
				track.add(me);
				
				location += 6;
				
				mm = new ShortMessage();
				mm.setMessage(ShortMessage.NOTE_OFF, 0, notemap.Notes.get(progression.get(i)[index1])[index2], velocity);
				me = new MidiEvent(mm,(long)location);
				track.add(me); 
				
			}			
				
		}
		
	}
	
	void pad(Track track, MidiEvent me, ShortMessage mm, ArrayList<String[]> progression) throws InvalidMidiDataException
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
				
				location += 48;
				
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
