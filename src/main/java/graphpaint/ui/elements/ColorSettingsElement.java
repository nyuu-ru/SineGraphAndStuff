/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graphpaint.ui.elements;

import graphpaint.events.ValueChangeEvent;
import java.awt.Color;
import java.util.EventListener;
import java.util.HashMap;
import javax.swing.Box;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author unyuu
 */
public class ColorSettingsElement extends JPanel {
    private Color color;
    private JColorChooser colorChooser;

    public ColorSettingsElement(String caption, Color defaultColor) {
        Box layout = Box.createVerticalBox();
        
        JLabel captionLabel  = new JLabel(caption);
        layout.add(captionLabel);
        
        if (defaultColor == null)
            throw new NullPointerException();
        color = defaultColor;
        
        colorChooser = new JColorChooser(color);
        
        var panels = colorChooser.getChooserPanels();
        for (var p : panels) {
            if (!p.getDisplayName().equals("HSV"))
                colorChooser.removeChooserPanel(p);
        }
        colorChooser.setPreviewPanel(new JPanel());

        colorChooser.getSelectionModel().addChangeListener(e -> {
            color = colorChooser.getColor();
            fireValueChange();
        });
        
        layout.add(colorChooser);        
        add(layout);
    }
    
    private void fireValueChange() {
        ValueChangeEvent<Color> event = new ValueChangeEvent<>(this, color);
        var listeners = listenerList.getListenerList();
        for (int index = 0; index < listeners.length; index += 2) {
            if (listeners[index] == ValueChangeListener.class)
                ((ValueChangeListener)listeners[index+1]).valueChanged(event);
        }
    }
    
    public void addValueChangeListener(ValueChangeListener listener) {
        listenerList.add(ValueChangeListener.class, listener);
    }
    
    public void removeValueChangeListener(ValueChangeListener listener) {
        listenerList.remove(ValueChangeListener.class, listener);
    }
   
    public interface ValueChangeListener extends EventListener {
        public void valueChanged(ValueChangeEvent<Color> e);
    }    
    
}
