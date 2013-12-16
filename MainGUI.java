import courseschedule.gui.*;
import courseschedule.util.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainGUI extends JPanel {
    public static ScheduleBuilder sb = null;
	private CustomFont font = new CustomFont();
	private Frame frame = new Frame();

	public MainGUI() {
		setLayout(new BorderLayout());

		Panel1 panel1 = new Panel1();
		Panel2 menuPanelTop = new Panel2();
		Panel3 menuPanelBottom = new Panel3();
		JPanel menuPanel = new JPanel();
		JPanel panel2 = new JPanel();

		menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
		menuPanel.add(menuPanelTop);
		menuPanel.add(Box.createRigidArea(new Dimension(0,5)));
		menuPanel.add(menuPanelBottom);

		panel2.setLayout(new BoxLayout(panel2, BoxLayout.X_AXIS));
		panel2.add(Box.createRigidArea(new Dimension(100,0)));
		panel2.add(menuPanel);
		panel2.add(Box.createRigidArea(new Dimension(100,0)));

		add(panel1, BorderLayout.NORTH);
		add(panel2, BorderLayout.CENTER);
		add(Box.createRigidArea(new Dimension(0,25)), BorderLayout.SOUTH);
	}

	private class Panel1 extends JPanel {
		private JLabel label;

		public Panel1() {
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			label = new JLabel("Main Menu");
			label.setFont(font.getFontSegoe(48));
			label.setForeground(CustomColour.silver);

			add(Box.createRigidArea(new Dimension(25,80)));
			add(label);
		}
	}

	private class Panel2 extends JPanel {
		private SquareButton[] btn = new SquareButton[4];
		private JLabel[] imgLabel = new JLabel[4];

		public Panel2() {
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBackground(CustomColour.silverclouds);
			setButton();
			setTile();

			for(int i=0; i<2; i++) {
				add(btn[i]);
				add(Box.createRigidArea(new Dimension(5,0)));
				add(imgLabel[i]);
				add(Box.createRigidArea(new Dimension(5,0)));
			}
		}

		public void setButton() {
			btn[0] = new SquareButton("COURSE", "add course to be generated.");
			btn[1] = new SquareButton("LECTURER", "assign lecturer to course.");

			btn[0].setCustomColor(CustomColour.lightergreen);
			btn[1].setCustomColor(CustomColour.lighterblue);

			for(int i=0; i<2; i++) {
				btn[i].addActionListener(new ButtonListener());
				// btn[i].setFontUpperLabel(font.getFontSegoe(14,Font.BOLD,-0.09));
				btn[i].setFontUpperLabel(font.getFontPTSans(15, Font.BOLD, -0.05));
				// btn[i].setFontLowerLabel(font.getFontSegoe(13,-0.03));
				btn[i].setFontLowerLabel(font.getFontPTSans(14, -0.07));
			}
		}

		public void setTile() {
			imgLabel[0] = new JLabel(new ImageIcon("Image\\1.png"));
			imgLabel[1] = new JLabel(new ImageIcon("Image\\2.png"));

			for(int i=0; i<2; i++) {
				imgLabel[i].setOpaque(true);
				imgLabel[i].setBackground(CustomColour.nightblue);
				imgLabel[i].setPreferredSize(new Dimension(170,196));
				imgLabel[i].setMinimumSize(new Dimension(170,196));
				imgLabel[i].setMaximumSize(new Dimension(170,196));
			}
		}

		private class ButtonListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btn[0]) {
					CourseTableGUI c = new CourseTableGUI();
					c.setFrame(frame);
					frame.setContentPane(c);
				}

				if(e.getSource() == btn[1]) {
					LecturerTableGUI l = new LecturerTableGUI();
					l.setFrame(frame);
					frame.setContentPane(l);
				}
				frame.revalidate();
				frame.repaint();
			}
		}
	}

	private class Panel3 extends JPanel {
		private SquareButton[] btn = new SquareButton[4];
		private JLabel[] imgLabel = new JLabel[4];

		public Panel3() {
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBackground(CustomColour.silverclouds);
			setButton();
			setTile();

			for(int i=0; i<2; i++) {
				add(imgLabel[i]);
				add(Box.createRigidArea(new Dimension(5,0)));
				add(btn[i]);
				add(Box.createRigidArea(new Dimension(5,0)));
			}
		}

		public void setButton() {
			btn[0] = new SquareButton("VENUE", "venues to be assigned.");
			btn[1] = new SquareButton("GENERATE", "generate the schedule.");

			btn[0].setCustomColor(CustomColour.lighterred);
			btn[1].setCustomColor(CustomColour.turqoise);

			for(int i=0; i<2; i++) {
				btn[i].addActionListener(new ButtonListener());
				// btn[i].setFontUpperLabel(font.getFontSegoe(14, Font.BOLD,-0.09));
				btn[i].setFontUpperLabel(font.getFontPTSans(15, Font.BOLD, -0.05));
				// btn[i].setFontLowerLabel(font.getFontSegoe(13,-0.03));
				btn[i].setFontLowerLabel(font.getFontPTSans(14, -0.07));
			}
		}

		public void setTile() {
			imgLabel[0] = new JLabel(new ImageIcon("Image\\3.png"));
			imgLabel[1] = new JLabel(new ImageIcon("Image\\4.png"));

			for(int i=0; i<2; i++) {
				imgLabel[i].setOpaque(true);
				imgLabel[i].setBackground(CustomColour.nightblue);
				imgLabel[i].setPreferredSize(new Dimension(170,196));
				imgLabel[i].setMinimumSize(new Dimension(170,196));
				imgLabel[i].setMaximumSize(new Dimension(170,196));
			}
		}

		private class ButtonListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btn[0]) {
					VenueTableGUI v = new VenueTableGUI();
					v.setFrame(frame);
					frame.setContentPane(v);
				}

				if(e.getSource() == btn[1]) {
					sb.fixCourseSections();
					ScheduleTableGUI st = new ScheduleTableGUI();
					st.setFrame(frame);
					frame.setContentPane(st);
				}

				frame.revalidate();
				frame.repaint();
			}
		}
	}

	public void setFrame(Frame frame) {
		this.frame = frame;
		sb = Frame.sb;
	}
}