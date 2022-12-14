
package videocaller;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamException;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.TargetDataLine;
import javax.swing.ImageIcon;


/**
 *
 * Client video caller, sends video output to server
 */
@SuppressWarnings("serial")
public class Client extends javax.swing.JFrame {
	// Connects at port 8888 for datagram protocol
    public static int audio_port_server = 8888;
    // Add address that will be connected to (127.0.0.1 for self)
    public static String audio_add_server = "127.0.0.1";
    
    public static boolean calling = false;
    
    // Formats the audio and how it will sound to the server
    public static AudioFormat getaudioformat(){
        float sampleRate = 8000.0F;
        int sampleSizeInBits = 16;
        int channel = 2;
        boolean signed = true;
        boolean bigEndian = false;
        return new AudioFormat(sampleRate, sampleSizeInBits, channel, signed, bigEndian);
    }
    
    static TargetDataLine audio_in;
    
    /**
     * Creates new form Client
     */
    public Client() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        img_client = new javax.swing.JLabel();
        end_btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        img_client.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        end_btn.setText("End call");
        end_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                end_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(img_client, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(end_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(125, 125, 125))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(img_client, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(end_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Ends call and exits the system
    private void end_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_end_btnActionPerformed
        // TODO add your handling code here:
        Client.calling = false;
        System.exit(0);
    }//GEN-LAST:event_end_btnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws IOException {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } 
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Client().setVisible(true);
            }
        });
        
        try (// Change IP address to server connection (127.0.0.1 for self)
		    // Uses port 7800 for tcp protocol, useful for time-sensitive connections
        	Socket video_server = new Socket("127.0.0.1",7800)) {
			// Opens webcam and outputs video
			ObjectOutputStream out = new ObjectOutputStream(video_server.getOutputStream());
			ImageIcon ic;
			BufferedImage br;
			Webcam cam = Webcam.getDefault();
			cam.open();
			
			// Opens audio connection
			init_audio();
			
			// Outputs image to server while session is open
			// Outputs image to self
			while(true){
			    br = cam.getImage(); // Buffer gets webcam image 
			    ic = new ImageIcon(br); // image icon allows the buffered image to be displayed
			    out.writeObject(ic);
			    out.flush();
			    img_client.setIcon(ic); 
			}
		} catch (WebcamException ex) {
			ex.printStackTrace();
		} catch(java.net.SocketException ex) {
			System.out.println("Connection ended by client");
		}
        
        
        
    }
    
    // Initializes audio
    public static void init_audio() {
        try {
        	// Formats the audio and gets audio input
            AudioFormat format = getaudioformat();
            DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);
            // Exits if audio line is not supported
            if(!AudioSystem.isLineSupported(info)){
                System.out.println("Line is not supported");
                System.exit(0);
            }
            // Gets the audio format and audio line while starting the audio call
            audio_in = (TargetDataLine) AudioSystem.getLine(info);
            audio_in.open(format);
            audio_in.start();
            
            // Receives audio input
            recorder_thread r = new recorder_thread();
            InetAddress inet = InetAddress.getByName(audio_add_server);
            r.audio_in = audio_in;
            r.dout = new DatagramSocket();
            // Gets server ip / port
            r.server_ip = inet;
            r.server_port = audio_port_server;
            // Sets the call to true and starts running the recorder thread
            Client.calling = true;
            r.start();
             
        } catch (LineUnavailableException | UnknownHostException | SocketException ex) {
            // Catches calls
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton end_btn;
    public static javax.swing.JLabel img_client;
    // End of variables declaration//GEN-END:variables
}
