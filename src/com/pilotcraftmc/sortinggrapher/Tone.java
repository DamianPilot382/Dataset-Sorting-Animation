package com.pilotcraftmc.sortinggrapher;

import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Synthesizer;

public class Tone {
	
	public static void playNote(int[] arr, int i){
    	int channel = 0; // 0 is a piano, 9 is percussion, other channels are for other instruments

        int volume = 80; // between 0 et 127
        int duration = 200; // in milliseconds

        try {
            Synthesizer synth = MidiSystem.getSynthesizer();
            synth.open();
            MidiChannel[] channels = synth.getChannels();            
            
            channels[channel].noteOn(arr[i]/arr.length, volume);
            Thread.sleep(10);

            synth.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
	}
	
}
