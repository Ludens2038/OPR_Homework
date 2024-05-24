package at.fhooe.sail.mc.Aufgabe01Exceptions;

//Checked exception
public class InvalidAccessException extends Exception {
	
	public InvalidAccessException(String msg) {
		super(msg);
	}
}