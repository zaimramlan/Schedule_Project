
import javax.swing.*;
import java.awt.*;

public class CustomField extends JTextField {
	private CustomFont font = new CustomFont();

	public CustomField() {
		super();

		// set background colour
		setBackground(CustomColour.silvergray);

		// creates outer border and inner border(for indentation)
		setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(), BorderFactory.createEmptyBorder(10, 10, 10, 10)));

		// fix alignment problem in Y.AXIS Box Layout
		setAlignmentX(JTextField.CENTER_ALIGNMENT);

		// set text font & colour
		setFont(font.getFontAbel(25, -0.05));
		setForeground(CustomColour.silverclouds);
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(287, 50);
	}

	@Override
	public Dimension getMinimumSize() {
		return getPreferredSize();
	}

	@Override
	public Dimension getMaximumSize() {
		return getPreferredSize();
	}
}