import aufgabe05.basic_class.AbstractMember;
import aufgabe05.members.*;
import aufgabe05.members.function.*;
import aufgabe05.sections.Section;

public class Main {
    public static void main(String[] args) {
        Section member = new Section("Fußball");
		AbstractMember s = new SupportingMember("Felix");
		member.addMember(s);

		AbstractMember s1 = new TopAthlete("Sams",2);
		member.addMember(s1);

		AbstractMember sec1 = new Trainer("Karl", 2);
		AbstractMember sec2 = new Trainer("Sepp", 2);

		Section section = new Section("Hallenfußball");
		section.addMember(sec1);
		section.addMember(sec2);
		member.addMember(section);

		AbstractMember sec3 = new Trainer("Hubert von Goisern", 2);
		AbstractMember sec4 = new Trainer("Hubert von Hagenberg", 2);

		Section section1 = new Section("LFrauenfußball");
		section1.addMember(sec3);
		section1.addMember(sec4);
		section.addMember(section1);

		Section section2 = new Section("LFrauenfußball");
		section1.addMember(sec3);
		section1.addMember(sec4);
		section1.addMember(section2);

        System.out.print(member.toString());

        System.out.println();

		System.out.println("Club Cost: " + member.getCosts());
		System.out.println("Club Income: " + member.getIncome());
		System.out.println("Club Surplus: " + member.getSurplus());
    }
}