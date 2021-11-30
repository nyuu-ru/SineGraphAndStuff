/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graphpaint.ui.elements;

import graphpaint.events.ValueChangeEvent;
import java.util.EventListener;
import java.util.HashMap;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

/**
 *
 * @author unyuu
 */
public class IntegerSettingElement extends JPanel {
    protected int minValue;
    protected int maxValue;
    protected int value;
    
    private JSlider valueSlider;
    private JLabel  valueLabel;

    public IntegerSettingElement(String caption,
            int minValue, int maxValue, int initValue) {
        if (initValue < minValue) initValue = minValue;
        if (initValue > maxValue) initValue = maxValue;
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.value = initValue;
        
        Box layout = Box.createVerticalBox();
        JLabel captionLabel = new JLabel(caption);
        layout.add(captionLabel);
        
        valueSlider = new JSlider(minValue, maxValue, value);
        valueLabel = new JLabel("" + value);
        Box sliderBox = Box.createHorizontalBox();
        sliderBox.add(valueSlider);
        sliderBox.add(valueLabel);
        layout.add(sliderBox);
        
        valueSlider.addChangeListener(e -> {
            value = valueSlider.getValue();
            valueLabel.setText("" + value);
            fireValueChange();            
        });
        
        add(layout);        
    }
    
    public void addValueChangeListener(ValueChangeListener listener) {
        listenerList.add(ValueChangeListener.class, listener);
    }
    
    public void removeValueChangeListener(ValueChangeListener listener) {
        listenerList.remove(ValueChangeListener.class, listener);
    }
    
    private void fireValueChange() {
        ValueChangeEvent<Integer> event = new ValueChangeEvent<>(this, value);
        
        Object[] listeners = listenerList.getListenerList();
        for (int index = 0; index < listeners.length; index += 2) {
            if (listeners[index] == ValueChangeListener.class)
                ((ValueChangeListener)listeners[index+1]).valueChanged(event);
        }
    }
    
    public interface ValueChangeListener extends EventListener {
        public void valueChanged(ValueChangeEvent<Integer> event);
    }
}
