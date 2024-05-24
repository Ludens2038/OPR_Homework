package aufgabe05.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import aufgabe05.basic_class.*;
import aufgabe05.members.*;
import aufgabe05.members.function.*;
import aufgabe05.sections.Section;

public class tests {
        AbstractMember Simon = new AmateurAthlete("Simon", 5);
        AbstractMember Fabian = new ChairMember("Fabian", 5);
        AbstractMember Moritz = new HonoraryMember("Moritz");
        AbstractMember Isabel = new SupportingMember("Isabel");
        AbstractMember Leni = new TopAthlete("Leni", 5);
        AbstractMember Lorena = new Trainer("Lorena", 5);
        AbstractMember Peter = new Trainer("Peter", 5);

        @Test
        public void test1() {
                Section Club = new Section("Club");
                assertEquals("Club - surplus: 0.0 - income: 0.0 - costs: 0.0\n", Club.toString());
                assertEquals("Club - surplus: 0.0 - income: 0.0 - costs: 0.0\n", Club.toString(true));
                assertEquals("Club - surplus: 0.0 - income: 0.0 - costs: 0.0\n", Club.toString(false));

                assertEquals("name: Moritz - surplus: -20.0 - income: 0.0 - costs: 20.0\n", Moritz.toString());

                assertTrue(Club.addMember(Simon));
                assertTrue(Club.addMember(Fabian));
                assertTrue(Club.addMember(Moritz));
                assertTrue(Club.addMember(Isabel));
                assertTrue(Club.addMember(Leni));
                assertTrue(Club.addMember(Lorena));
                assertFalse(Club.addMember(Lorena));
                assertEquals(
                                "Club - surplus: -1845.0 - income: 1140.0 - costs: 2985.0\n   name: Fabian - surplus: 400.0 - income: 500.0 - costs: 100.0\n   name: Isabel - surplus: 85.0 - income: 100.0 - costs: 15.0\n   name: Leni - surplus: -180.0 - income: 120.0 - costs: 300.0\n   name: Lorena - surplus: -2280.0 - income: 120.0 - costs: 2400.0\n   name: Moritz - surplus: -20.0 - income: 0.0 - costs: 20.0\n   name: Simon - surplus: 150.0 - income: 300.0 - costs: 150.0\n",
                                Club.toString());
                assertEquals(
                                "Club - surplus: -1845.0 - income: 1140.0 - costs: 2985.0\n   name: Fabian - surplus: 400.0 - income: 500.0 - costs: 100.0\n   name: Isabel - surplus: 85.0 - income: 100.0 - costs: 15.0\n   name: Leni - surplus: -180.0 - income: 120.0 - costs: 300.0\n   name: Lorena - surplus: -2280.0 - income: 120.0 - costs: 2400.0\n   name: Moritz - surplus: -20.0 - income: 0.0 - costs: 20.0\n   name: Simon - surplus: 150.0 - income: 300.0 - costs: 150.0\n",
                                Club.toString(true));
                assertTrue(Club.isMember(Moritz));
                assertFalse(Club.isMember(Peter));
                assertEquals(1140.0, Club.getIncome(), 0);
                assertEquals(2985.0, Club.getCosts(), 0);
                assertEquals(-1845.0, Club.getSurplus(), 0);
        }

        @Test
        public void test2() {
                Section Club = new Section("Club");
                Section Soccer = new Section("Soccer");
                Section Female = new Section("Female");
                Club.addMember(Soccer);
                Club.addMember(Simon);
                Soccer.addMember(Fabian);
                Soccer.addMember(Simon);
                Club.addMember(Simon);
                Soccer.addMember(Moritz);
                Soccer.addMember(Female);
                Female.addMember(Isabel);
                Female.addMember(Lorena);
                assertEquals(
                                "Club - surplus: -1515.0 - income: 1320.0 - costs: 2835.0\n   name: Simon - surplus: 150.0 - income: 300.0 - costs: 150.0\n   Soccer - surplus: -1665.0 - income: 1020.0 - costs: 2685.0\n      name: Fabian - surplus: 400.0 - income: 500.0 - costs: 100.0\n      Female - surplus: -2195.0 - income: 220.0 - costs: 2415.0\n         name: Isabel - surplus: 85.0 - income: 100.0 - costs: 15.0\n         name: Lorena - surplus: -2280.0 - income: 120.0 - costs: 2400.0\n      name: Moritz - surplus: -20.0 - income: 0.0 - costs: 20.0\n      name: Simon - surplus: 150.0 - income: 300.0 - costs: 150.0\n",
                                Club.toString());
                assertEquals(1320.0, Club.getIncome(), 0);
                assertEquals(2835.0, Club.getCosts(), 0);
                assertEquals(-1515.0, Club.getSurplus(), 0);
                assertEquals(1020.0, Soccer.getIncome(), 0);
                assertEquals(2685.0, Soccer.getCosts(), 0);
                assertEquals(-1665.0, Soccer.getSurplus(), 0);
                assertTrue(Female.removeMember(Lorena));
                assertEquals(
                                "Club - surplus: 765.0 - income: 1200.0 - costs: 435.0\n   name: Simon - surplus: 150.0 - income: 300.0 - costs: 150.0\n   Soccer - surplus: 615.0 - income: 900.0 - costs: 285.0\n      name: Fabian - surplus: 400.0 - income: 500.0 - costs: 100.0\n      Female - surplus: 85.0 - income: 100.0 - costs: 15.0\n         name: Isabel - surplus: 85.0 - income: 100.0 - costs: 15.0\n      name: Moritz - surplus: -20.0 - income: 0.0 - costs: 20.0\n      name: Simon - surplus: 150.0 - income: 300.0 - costs: 150.0\n",
                                Club.toString());
                assertTrue(Female.removeMember(Isabel));
                assertTrue(Club.removeMember(Simon));
                assertFalse(Female.removeMember(Simon));
                assertTrue(Soccer.removeMember(Female));
                assertEquals(
                                "Club - surplus: 530.0 - income: 800.0 - costs: 270.0\n   Soccer - surplus: 530.0 - income: 800.0 - costs: 270.0\n      name: Fabian - surplus: 400.0 - income: 500.0 - costs: 100.0\n      name: Moritz - surplus: -20.0 - income: 0.0 - costs: 20.0\n      name: Simon - surplus: 150.0 - income: 300.0 - costs: 150.0\n",
                                Club.toString(true));
                assertEquals(
                                "Club - surplus: 530.0 - income: 800.0 - costs: 270.0\n   Soccer - surplus: 530.0 - income: 800.0 - costs: 270.0\n      name: Simon - surplus: 150.0 - income: 300.0 - costs: 150.0\n      name: Moritz - surplus: -20.0 - income: 0.0 - costs: 20.0\n      name: Fabian - surplus: 400.0 - income: 500.0 - costs: 100.0\n",
                                Club.toString(false));
        }
}


