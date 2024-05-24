package aufgabe05.members;

import aufgabe05.basic_class.AbstractMember;

public abstract class ActiveMember extends AbstractMember {

    public int activityLevel;
    
    public abstract double getIncome();
    public abstract double getCosts();

    public ActiveMember(String name, int activityLevel) {
        super(name);
        this.activityLevel = activityLevel;
    }
}