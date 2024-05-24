package at.fhooe.sail.mc.Aufgabe02;

import at.fhooe.sail.mc.Aufgabe01Exceptions.ValueException;

//abstract class for active members with the activity level
public abstract class ActiveMember extends AbstractMember {

    // activity level of the member
    public int activityLevel;

    // constructor for the active member with the name and the activity level
    public ActiveMember(String name, int activityLevel) throws ValueException {
        // calling the constructor of the abstract member
        super(name);
        if (activityLevel < 1 || activityLevel > 10) {
            throw new ValueException(activityLevel);
        }
        this.activityLevel = activityLevel;

    }

    // abstract method for getting the income of the member that has to be
    // implemented by the subclasses
    public abstract double getIncome();

    // abstract method for getting the cost of the member that has to be implemented
    // by the subclasses
    public abstract double getCost();


}
