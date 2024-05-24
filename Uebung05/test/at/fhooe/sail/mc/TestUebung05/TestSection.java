package at.fhooe.sail.mc.TestUebung05;
import at.fhooe.sail.mc.Uebung05.Aufgabe02.*;


import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestSection {

	private Section vereinHagenberg, powerCoding;
	
	@BeforeEach
	public void setUp() {
		vereinHagenberg = new Section("Hagenberg");
		AmateurAthlete axel = new AmateurAthlete("Axel", 10);
		ChairMember fabian = new ChairMember("Fabian", 7);
		HonoraryMember emre = new HonoraryMember("Emre");
		TopAthlete nikolaus = new TopAthlete("Nikolaus", 5);
		Trainer haris = new Trainer("Haris", 10);
		SupportingMember marc = new SupportingMember("Marc");
		powerCoding = new Section("PowerCoding");
		vereinHagenberg.addMember(powerCoding);
		powerCoding.addMember(axel);
		powerCoding.addMember(emre);
		powerCoding.addMember(nikolaus);
		powerCoding.addMember(haris);
		vereinHagenberg.addMember(fabian);
		vereinHagenberg.addMember(marc);
	}
	
	@Test
	public void testAddMember() {
		SupportingMember eric = new SupportingMember("Eric");
		powerCoding.addMember(eric);
	}
	
	@Test
	public void testRemoveMember() {
		AmateurAthlete sebastian = new AmateurAthlete("Sebastian", 10);
		powerCoding.addMember(sebastian);
		assertTrue(powerCoding.removeMember(sebastian));
	}
	
	@Test
	public void testIsMember() {
		TopAthlete sebastian = new TopAthlete("Sebastian", 10);
		powerCoding.addMember(sebastian);
		assertTrue(powerCoding.isMember(sebastian));
	}
	
	@Test
	public void testGetIncome() {
		assertEquals(540, powerCoding.getIncome());
		assertEquals(1340, vereinHagenberg.getIncome());
		AmateurAthlete sebastian = new AmateurAthlete("Sebastian", 10);
		assertEquals(300.0, sebastian.getIncome());
	}
	
	@Test
	public void testGetCost() {
		assertEquals(470.0, powerCoding.getCost());
		assertEquals(625.0, vereinHagenberg.getCost());
		AmateurAthlete sebastian = new AmateurAthlete("Sebastian", 10);
		assertEquals(25.0, sebastian.getCost());
	}
	
	@Test
	public void testToString() {
		String expected = "Union: Hagenberg, Income: 1340.0, Cost: 625.0, Surplus: 715.0" + "\n"
				+ "  Name: Fabian, Income: 700.0, Cost: 140.0, Surplus: 560.0" + "\n"
				+ "  Name: Marc, Income: 100.0, Cost: 15.0, Surplus: 85.0" + "\n"
				+ "  Union: PowerCoding, Income: 540.0, Cost: 470.0, Surplus: 70.0" + "\n"
				+ "    Name: Axel, Income: 300.0, Cost: 25.0, Surplus: 275.0" + "\n"
				+ "    Name: Emre, Income: 0.0, Cost: 20.0, Surplus: -20.0" + "\n"
				+ "    Name: Haris, Income: 120.0, Cost: 400.0, Surplus: -280.0" + "\n"
				+ "    Name: Nikolaus, Income: 120.0, Cost: 25.0, Surplus: 95.0" + "\n";
		assertEquals(expected, vereinHagenberg.toString(true));
		assertEquals(expected, vereinHagenberg.toString());
	}
}





