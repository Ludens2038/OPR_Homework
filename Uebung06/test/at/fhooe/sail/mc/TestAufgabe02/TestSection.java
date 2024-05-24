package at.fhooe.sail.mc.TestAufgabe02;

import at.fhooe.sail.mc.Aufgabe01Exceptions.InvalidAccessException;
import at.fhooe.sail.mc.Aufgabe01Exceptions.ValueException;
import at.fhooe.sail.mc.Aufgabe02.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestSection {

	private Section vereinHagenberg, powerCoding;
	private AmateurAthlete axel;
	private ChairMember fabian;
	private HonoraryMember emre;
	private TopAthlete nikolaus;
	private Trainer haris;
	private SupportingMember marc;

	@BeforeEach
	public void setUp() {

		vereinHagenberg = new Section("Hagenberg");
		try {
			axel = new AmateurAthlete("Axel", 10);
			fabian = new ChairMember("Fabian", 7);
			emre = new HonoraryMember("Emre");
			nikolaus = new TopAthlete("Nikolaus", 5);
			haris = new Trainer("Haris", 10);
			marc = new SupportingMember("Marc");
			powerCoding = new Section("PowerCoding");
			vereinHagenberg.addMember(powerCoding);
			powerCoding.addMember(axel);
			powerCoding.addMember(emre);
			powerCoding.addMember(nikolaus);
			powerCoding.addMember(haris);
			vereinHagenberg.addMember(fabian);
			vereinHagenberg.addMember(marc);
		} catch (ValueException e) {
			System.out.println(e.toString());
		}
	}

	@Test
	public void testAddMember() {
		SupportingMember eric = new SupportingMember("Eric");
		powerCoding.addMember(eric);
		try {
		TopAthlete athlete = new TopAthlete("Athlete", 22);
		}catch (ValueException e) {
			System.out.println(e.toString());
		}
	}
	
	@Test
	public void testAddMemberChairMember() {
		try {
		ChairMember member = new ChairMember("Member", 22);
		}catch (ValueException e) {
			System.out.println(e.toString());
		}
	}
	
	@Test
	public void testAddMemberAmateur() {
		try {
		AmateurAthlete member = new AmateurAthlete("Member", -2);
		}catch (ValueException e) {
			System.out.println(e.toString());
		}
	}
	
	@Test
	public void testAddMemberTrainer() {
		try {
		Trainer member = new Trainer("Trainer", -73);
		}catch (ValueException e) {
			System.out.println(e.toString());
		}
	}

	@Test
	public void testRemoveMember() {

		AmateurAthlete sebastian = null;
		try {
			sebastian = new AmateurAthlete("Sebastian", 10);
		} catch (ValueException e) {
			System.out.println(e.toString());
		}
		powerCoding.addMember(sebastian);
		assertTrue(powerCoding.removeMember(sebastian));

	}

	@Test
	public void testIsMember() {
		try {
			TopAthlete sebastian = new TopAthlete("Sebastian", 10);
			powerCoding.addMember(sebastian);
			assertTrue(powerCoding.isMember(sebastian));
		} catch (ValueException e) {
			System.out.println(e.toString());
		}
	}

	@Test
	public void testGetIncome() {
		try {
			assertEquals(540, powerCoding.getIncome());
			assertEquals(1340, vereinHagenberg.getIncome());
			AmateurAthlete sebastian = new AmateurAthlete("Sebastian", 10);
			assertEquals(300.0, sebastian.getIncome());
		} catch (ValueException e) {
			System.out.println(e.toString());
		}
	}

	@Test
	public void testGetCost() {
		assertEquals(5420.0, powerCoding.getCost());
		assertEquals(5575.0, vereinHagenberg.getCost());
	}

	@Test
	public void testToString() {
		String expected = "Union: Hagenberg, Income: 1340.0, Cost: 5575.0, Surplus: -4235.0" + "\n"
				+ "  name: Fabian, Income: 700.0, Cost: 140.0, Surplus: 560.0" + "\n"
				+ "  name: Marc, Income: 100.0, Cost: 15.0, Surplus: 85.0" + "\n"
				+ "  Union: PowerCoding, Income: 540.0, Cost: 5420.0, Surplus: -4880.0" + "\n"
				+ "    name: Axel, Income: 300.0, Cost: 300.0, Surplus: 0.0" + "\n"
				+ "    name: Emre, Income: 0.0, Cost: 20.0, Surplus: -20.0" + "\n"
				+ "    name: Haris, Income: 120.0, Cost: 4800.0, Surplus: -4680.0" + "\n"
				+ "    name: Nikolaus, Income: 120.0, Cost: 300.0, Surplus: -180.0" + "\n";
		assertEquals(expected, vereinHagenberg.toString(true));
		assertEquals(expected, vereinHagenberg.toString());
	}
	
	@Test
	public void testExpectExceptionInsert() {
		assertThrows(InvalidAccessException.class, () -> {
			powerCoding.addMember(axel);
		});
	}
}
