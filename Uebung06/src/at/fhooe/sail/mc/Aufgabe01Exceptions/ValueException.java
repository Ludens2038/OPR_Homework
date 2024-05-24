package at.fhooe.sail.mc.Aufgabe01Exceptions;

import at.fhooe.sail.mc.Aufgabe02.AbstractMember;

//Checked exception
public class ValueException extends Exception {

    public ValueException(int whichVal) {
        super("Invalid Value: " + whichVal + " Expected Value is out of range" + "\n" + "\n");
    }

    public ValueException(Object a) {
        super(a.toString() + "Invalid Input, Object is not acceptable." + "\n" + "\n");
    }
}