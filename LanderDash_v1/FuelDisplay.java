import javax.swing.*;
import javax.swing.text.*;

import java.awt.*;
import java.awt.event.*;

public class FuelDisplay extends JPanel {
    private static final long serialVersionUID = 42l;
    private JTextField quantity;
    private JLabel  warninglight;
    private JProgressBar gauge;
    public FuelDisplay() {
        setLayout(new GridBagLayout() );
        setBorder( BorderFactory.createTitledBorder("fuel"));
        GridBagConstraints gc = new GridBagConstraints();

        gc.gridx = gc.gridy = 0;
        gc.gridwidth = gc.gridheight = 1;
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.weightx = 1.0;
        gc.weighty = 0.1;
        add(new JLabel("fuel remaining:", SwingConstants.TRAILING),gc);

        gc.gridx = GridBagConstraints.RELATIVE;
        gc.weightx=0.1;
        quantity = new JTextField(5);
        quantity.setHorizontalAlignment(JTextField.TRAILING);
        add(quantity,gc);

        gc.gridx = 0;
        gc.gridy = GridBagConstraints.RELATIVE;
        gc.gridwidth = GridBagConstraints.REMAINDER;
        gc.fill = GridBagConstraints.BOTH;
        gc.weightx = 1.0;
        gauge = new JProgressBar();
        add(gauge,gc);

        warninglight = new JLabel( "Fuel Low ", off, SwingConstants.LEADING);
        gc.gridx = 0;
        gc.gridy = GridBagConstraints.RELATIVE;
        gc.gridwidth = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        add(warninglight, gc);
    }
    final float bingo = 10.0f;
    Icon warn = new ImageIcon( getClass().getResource("led-red.png"));
    Icon  off = new ImageIcon( getClass().getResource("led-grey.png"));
    public void setFuel(float percent) {
        gauge.setValue((int)percent);
        quantity.setText( Float.toString(percent) );
        warninglight.setIcon((percent>bingo)?off:warn);
    }
}
