package graphpaint.ui.elements;

import java.awt.Font;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class PhaseSettingsElement extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private double phase = 0.0;
	private JSpinner phaseSpinner;
	
	public PhaseSettingsElement() {
		Box layout = Box.createVerticalBox();
		JLabel phaseCaption = new JLabel("Cмещение фазы");
		phaseCaption.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 40));
		
		phaseSpinner = new JSpinner(new SpinnerNumberModel(phase, 0.0, 1.0, 0.05));
		
		layout.add(phaseCaption);
		layout.add(phaseSpinner);
		
		add(layout);
	}
	
	public double getPhase() {
		return phase;
	}

}
