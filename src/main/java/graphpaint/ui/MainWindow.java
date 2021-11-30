package graphpaint.ui;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.UIManager;

import graphpaint.ui.elements.AmplitudeSettingsElement;
import graphpaint.ui.elements.ColorSettingsElement;
import graphpaint.ui.elements.IntegerSettingElement;
import graphpaint.ui.elements.PeriodsSettingsElement;
import graphpaint.ui.elements.PhaseSettingsElement;

import java.awt.*;

public class MainWindow extends JFrame {
	private SineGraphPanel sineGraphPanel;
	IntegerSettingElement amplitudeSettingsElement;
	IntegerSettingElement periodsSettingsElement;
	PhaseSettingsElement phaseSettingsElement;
        ColorSettingsElement colorSettingsElement;
	
	private int amplitude = 100;
	
	/*
	 * Домашнее задание :)
	 * 
	 * Создать элемент, позволяющий выбрать цвет графика.
	 * Цвет должен быть типа Color
	 * На основе чего делать выбор цвета - можно выбрать, например,
	 * на https://web.mit.edu/6.005/www/sp14/psets/ps4/java-6-tutorial/components.html
	 * 
	 */
	
	public MainWindow() {
		setTitle("Рисовалка графика y=sin(x) :)");
		setSize(3000, 1800);
		setLocation(200, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		sineGraphPanel = new SineGraphPanel();
		add(sineGraphPanel);
		
		Box settingsPanel = Box.createVerticalBox();
		amplitudeSettingsElement = new IntegerSettingElement(
                        "Амплитуда (0 ... 100)",
                        0, 100, 90);
		periodsSettingsElement = new IntegerSettingElement(
                        "Количество периодов (1 ... 10)",
                        1, 10, 1);
		phaseSettingsElement = new PhaseSettingsElement();
                colorSettingsElement = new ColorSettingsElement(
                        "Цвет графика", Color.red);

		settingsPanel.add(Box.createVerticalGlue());
		settingsPanel.add(new JSeparator());
		settingsPanel.add(amplitudeSettingsElement);
		settingsPanel.add(new JSeparator());
		settingsPanel.add(periodsSettingsElement);
		settingsPanel.add(new JSeparator());
		settingsPanel.add(phaseSettingsElement);
		settingsPanel.add(new JSeparator());
		settingsPanel.add(colorSettingsElement);
		settingsPanel.add(new JSeparator());
                
		settingsPanel.add(Box.createVerticalGlue());
		
		add(settingsPanel, BorderLayout.WEST);
                
                amplitudeSettingsElement.addValueChangeListener(e -> {
                    sineGraphPanel.setAmplitude(e.getNewValue());
                    sineGraphPanel.repaint();
                });
                
                periodsSettingsElement.addValueChangeListener(e -> {
                    sineGraphPanel.setPeriods(e.getNewValue());
                    sineGraphPanel.repaint();
                });
                
                colorSettingsElement.addValueChangeListener(e -> {
                    sineGraphPanel.setGraphColor(e.getNewValue());
                    sineGraphPanel.repaint();
                });
                
	}

}
