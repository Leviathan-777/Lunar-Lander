import javax.swing.*;
import javax.swing.text.*;

import java.awt.*;
import java.awt.event.*;

public class AltitudeDisplay extends JPanel {
    private static final long serialVersionUID = 42l;
    private JTextField quantity;
    private JLabel  warninglight;
    private JLabel  contactlight;
    private JProgressBar gauge;
    public AltitudeDisplay() {
        setLayout(new GridBagLayout() );
        setBorder( BorderFactory.createTitledBorder("Altitude"));
        GridBagConstraints gc = new GridBagConstraints();

        gc.gridx = 1;
        gc.gridy = 0;
        gc.gridwidth = gc.gridheight = 1;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.fill =  GridBagConstraints.HORIZONTAL;
        gc.weightx = 0.7;
        gc.weighty = 0;
        add(new JLabel("Altitude:", SwingConstants.TRAILING),gc);

        gc.gridx = GridBagConstraints.RELATIVE;
        quantity = new JTextField(5);
        quantity.setHorizontalAlignment(JTextField.TRAILING);
        add(quantity,gc);

        warninglight = new JLabel( "Proximity ", off, SwingConstants.LEADING);
        gc.gridx = 1;
        gc.gridy = GridBagConstraints.RELATIVE;
        gc.gridwidth = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(warninglight, gc);

        contactlight = new JLabel( "Contact ", off, SwingConstants.LEADING);
        gc.gridx = 1;
        gc.gridy = GridBagConstraints.RELATIVE;
        gc.gridwidth = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(contactlight, gc);

        gc.gridx = 0;
        gc.gridy = 0;
        gc.gridwidth = 1;
        gc.gridheight= GridBagConstraints.REMAINDER;
        gc.fill = GridBagConstraints.BOTH;
        gc.weightx = 0.1;
        gauge = new JProgressBar(SwingConstants.VERTICAL);
        add(gauge,gc);
    }
    final float proximity = 15.0f;
    Icon warn = new ImageIcon( getClass().getResource("led-red.png"));
    Icon  off = new ImageIcon( getClass().getResource("led-grey.png"));
    Icon contact = new ImageIcon( getClass().getResource("led-orange.png"));
    public void setAltitude(float alt) {
        gauge.setValue((int)alt);
        quantity.setText( Float.toString(alt) );
        warninglight.setIcon((alt>proximity)?off:warn);
        contactlight.setIcon((alt>1)?off:contact);
    }
}
