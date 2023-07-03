import javax.swing.*;
import javax.swing.text.*;

import java.awt.*;
import java.awt.event.*;

public class VectorDisplay extends JPanel {
    private static final long serialVersionUID = 42l;
    private JTextField quantity;
    private JLabel  warninglight;
    private JLabel  contactlight;
    private JProgressBar gauge;
    public VectorDisplay() {
        setBorder( BorderFactory.createTitledBorder("Vectors"));
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(200,200));
        add(new JLabel("too fast", warn,SwingConstants.LEADING));
    }
    Icon warn = new ImageIcon( getClass().getResource("led-red.png"));
    Icon  off = new ImageIcon( getClass().getResource("led-grey.png"));
    Icon contact = new ImageIcon( getClass().getResource("led-orange.png"));
}
