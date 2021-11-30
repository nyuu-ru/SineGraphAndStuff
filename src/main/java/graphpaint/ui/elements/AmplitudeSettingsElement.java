package graphpaint.ui.elements;

import java.awt.Font;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

public class AmplitudeSettingsElement extends JPanel {
	private static final long serialVersionUID = 1L;
	private int amplitude = 100;

	public AmplitudeSettingsElement() {
		Box layout = Box.createVerticalBox();
		
		JLabel amplitudeCaption = new JLabel("Амплитуда");
		amplitudeCaption.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 40));
		layout.add(amplitudeCaption);
		
		Box amplitudeSliderBox = Box.createHorizontalBox();
		JSlider amplitudeSlider = new JSlider(1, 100, amplitude);
		JLabel amplitudeDisplay = new JLabel(Integer.toString(amplitude));
		amplitudeDisplay.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 40));

		amplitudeSliderBox.add(amplitudeSlider);
		amplitudeSliderBox.add(Box.createHorizontalStrut(24));
		amplitudeSliderBox.add(amplitudeDisplay);
		
		layout.add(amplitudeSliderBox);
		add(layout);
		
		amplitudeSlider.addChangeListener( e -> {
			amplitude = amplitudeSlider.getValue();
			amplitudeDisplay.setText(Integer.toString(amplitude));
		});
	}
	
	public int getAmplitude() {
		return amplitude;
	}
}
