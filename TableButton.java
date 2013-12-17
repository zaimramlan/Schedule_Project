
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TableButton extends JButton implements MouseListener {

    private String[] label;                 
    private double[] columnWidth;
    private Dimension dimension = new Dimension(900,40);
    private CustomFont font = new CustomFont();
    private boolean isHeader = false;

    /*
    Constructors
     */
    public TableButton(String[] label, double[] columnWidth) {
        this.label = label;
        this.columnWidth = columnWidth;
        enableEvents(AWTEvent.MOUSE_EVENT_MASK);
        setContentAreaFilled(false);
        setBorder(BorderFactory.createEmptyBorder());
        setFont(font.getFontAbel(15));
        setForeground(CustomColour.getNightBlue());
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        addMouseListener(this);
    }


    /*
    paints the TableButton
     */
    public void paintComponent(Graphics g) {

        // draw the label according to design in the button
        Font f = getFont();
        if (f != null) {
            FontMetrics fm = getFontMetrics(getFont());
            Graphics2D g2d = (Graphics2D) g;
        	
            for(int i=0; i<label.length; i++) {
	            g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);
                g2d.drawString(label[i], (int)columnWidth[i]-(fm.stringWidth(label[i])/2), (getHeight()/2)+5);
            }
        }
    }

    public void mouseEntered (MouseEvent event) { if(!isHeader) setForeground(CustomColour.getLighterBlue()); }
    public void mouseExited (MouseEvent event) { if(!isHeader) setForeground(CustomColour.getNightBlue()); }
    public void mousePressed (MouseEvent event) {}
    public void mouseClicked (MouseEvent event) {}
    public void mouseReleased (MouseEvent event) {}

    /*
    Setter methods
    */
    public void setIsHeader(Boolean isHeader) {
        this.isHeader = isHeader;
    }

    public void setPreferredSize(Dimension dimension) {
        this.dimension = dimension;
    }

    /*
    Getter methods
    */
    public Dimension getPreferredSize() {
        return dimension;
    }

    public Dimension getMinimumSize() {
        return getPreferredSize();
    }

    public Dimension getMaximumSize() {
        return getPreferredSize();
    }
}