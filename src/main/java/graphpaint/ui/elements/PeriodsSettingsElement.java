package graphpaint.ui.elements;

import java.awt.Font;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class PeriodsSettingsElement extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private int periods = 1;
	private JSpinner periodsSpinner;
	
	public PeriodsSettingsElement() {
		Box layout = Box.createVerticalBox();
		JLabel periodsCaption = new JLabel("Количество периодов");
		periodsCaption.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 40));
		
		periodsSpinner = new JSpinner(new SpinnerNumberModel(periods, 1, 10, 1));
		
		layout.add(periodsCaption);
		layout.add(periodsSpinner);
		
		add(layout);
	}
	
	public int getPeriods() {
		return periods;
	}
}

