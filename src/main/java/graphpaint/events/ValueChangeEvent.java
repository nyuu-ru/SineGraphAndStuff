/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graphpaint.events;

import java.util.EventObject;

/**
 *
 * @author unyuu
 */
public class ValueChangeEvent<T> extends EventObject {
    private T newValue;

    public ValueChangeEvent(Object source, T value) {
        super(source);
        newValue = value;
    }

    public T getNewValue() {
        return newValue;
    }
}
