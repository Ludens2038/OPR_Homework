package aufgabe05.members.function;

import aufgabe05.members.ActiveMember;

public class TopAthlete extends ActiveMember {

    public TopAthlete(String name, int activityLevel) {
        super(name, activityLevel);
    }

    @Override
    public double getIncome() {
        return 10 * 12;
    }

    @Override
    public double getCosts() {
        return activityLevel * 5 * 12;
    }
    
}
