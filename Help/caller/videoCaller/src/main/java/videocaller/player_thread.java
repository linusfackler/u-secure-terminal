
package videocaller;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.SourceDataLine;

/**
 *
 * Plays audio as a thread
 */
public class player_thread extends Thread {
    public DatagramSocket din;
    public SourceDataLine audio_out;
    byte[] buffer = new byte[512];
    
    @Override // Plays audio to the server
    public void run(){
        DatagramPacket incoming = new DatagramPacket(buffer, buffer.length);
        // int i = 0;
        while(Server.calling){
            try {
                // Keeps on receiving audio until calling is set to false by end button
                din.receive(incoming);
                buffer = incoming.getData();
                audio_out.write(buffer, 0, buffer.length);
                // System.out.println("#" + i++);  // Used to make sure server is receiving
            } catch (IOException ex) {
                Logger.getLogger(player_thread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        audio_out.close();
        audio_out.drain();
        //System.out.println("Stopped");
        
    }
}
