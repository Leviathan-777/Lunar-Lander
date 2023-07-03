import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;
import javax.swing.border.*;
import java.io.*;
import java.net.*;
import java.util.*;

public class LanderDash extends JFrame implements Runnable {
    public static final long serialVersionUID = 2L;
    public static void main ( String[] args ) throws UnknownHostException {
        SwingUtilities.invokeLater( new Runnable() {
            public void run() {
                new LanderDash();
            }
        });
    }

    /* Information from Lander to Display */
    float altitude;  /* height above ground */
    float fuel;      /* percent fuel remaining */
    boolean flying;  /* is it flying */
    boolean crashed; /* crashed or not when down */

    /* other information */
    /* float orientation; /* attitude */
    /* float V_x; /* X velocity */
    /* float V_y; /* y velocity */

    AltitudeDisplay alt = new AltitudeDisplay();
    FuelDisplay fuelpc = new FuelDisplay();
    DatagramPanel connection = new DatagramPanel();
    public LanderDash() {
        super("Lunar Lander Dashboard");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().setLayout(
            new BoxLayout(getContentPane(),BoxLayout.Y_AXIS) );

        add( connection ) ;
        add( fuelpc );
        add( alt );

        pack();
        setVisible(true);
        (new Thread(this)).start();
    }

    public void run() {
        try {
            InetAddress addr = InetAddress.getLocalHost();
            int portno = 65250;
            DatagramSocket socket = new DatagramSocket(portno, addr);
            connection.setAddress((InetSocketAddress)socket.getLocalSocketAddress());
            while(fuel>=0) {

                /* set up socket for reception */
                if(socket!=null) {
                    /* start with fresh datagram packet */
                    byte[] buffer = new byte[1024];
                    DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                    socket.receive( packet );
                    /* extract message and pick appart into
                       lines and key:value pairs
                    */
                    String message = new String(packet.getData());


                    String[] lines = message.trim().split("\n");
                    for(String l : lines) {
                        String[] pair = l.split(":");
                        switch(pair[0]) {
                        case "fuel":
                            fuelpc.setFuel(Float.parseFloat(pair[1]));
                            break;
                        case "altitude":
                            alt.setAltitude(Float.parseFloat(pair[1]));
                            break;
                        }
                    }
                }
                try {
                    Thread.sleep(100);
                }
                catch(InterruptedException e) {}
            }
        }
        catch(Exception e) {
            System.err.println(e);
            System.err.println("in LanderDash.run()");
            System.exit(-1);
        }
    }
}
