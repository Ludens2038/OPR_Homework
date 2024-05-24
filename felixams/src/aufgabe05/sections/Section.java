package aufgabe05.sections;

import aufgabe05.basic_class.AbstractMember;
import aufgabe05.tree.BinarySearchTree;

public class Section extends AbstractMember {

    private BinarySearchTree<AbstractMember> members;
    static private int format;

    public Section(String name) {
        super(name);
        members = new BinarySearchTree<>();
    }

    @Override
    public double getIncome() {
        Comparable<AbstractMember>[] array = members.toArray(true);
        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += ((AbstractMember) array[i]).getIncome();
        }
        return sum;
    }

    @Override
    public double getCosts() {
        Comparable<AbstractMember>[] array = members.toArray(true);
        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += ((AbstractMember) array[i]).getCosts();
        }
        return sum;
    }
    

    public boolean addMember(AbstractMember m) {
        return members.insert(m);
    }

    public boolean removeMember(AbstractMember m) {
        return members.remove(m);
    }

    public boolean isMember(AbstractMember m) {
        return members.find(m);
    }

    @Override
    public String toString() {
        return toString(true);
    }
    
    @Override
    public String toString(boolean ascending) {
        Comparable<AbstractMember>[] array = members.toArray(ascending);
        StringBuilder builder = new StringBuilder();
        builder.append(name).append(" - surplus: ").append(getSurplus()).append(" - income: ")
                .append(getIncome()).append(" - costs: ").append(getCosts()).append("\n");
        format += 3;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < format; j++) {
                builder.append(" ");
            }
            builder.append(((AbstractMember) array[i]).toString(ascending));
        }
        format -= 3;
        return builder.toString();
    }
}