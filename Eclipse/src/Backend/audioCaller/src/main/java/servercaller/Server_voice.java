/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package servercaller;


/**
 *
 * @author chris
 */
public class Server_voice {

    /**
     * @param args the command line arguments
     */
    public static boolean calling = false;
    public static void main(String args[]) {
        Server fr = new Server();
        fr.setVisible(true);
    }
}
