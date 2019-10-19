/*
 * Written By Prashant Thirumal
 */

public class JeepTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JeepHeap<Jeep> JeepHeaps = new JeepHeap<Jeep>();

		//Creating 15 Jeeps
		Jeep jeep1 = new Jeep("Wrangler", 250.00, 200000 );
		Jeep jeep2 = new Jeep("Tacoma", 150.00, 1000);
		Jeep jeep3 = new Jeep("Forerunner", 130.00, 121212);
		Jeep jeep4 = new Jeep("Cosmos",200.00 , 250000);
		Jeep jeep5 = new Jeep("Frizea", 175.00, 230000);
		Jeep jeep6 = new Jeep("Siracha",215.00, 250000);
		Jeep jeep7 = new Jeep("Rovver",270.00, 235000);
		Jeep jeep8 = new Jeep("Sky Lander", 270.00, 20000);
		Jeep jeep9 = new Jeep("Goku SSJ", 350.00, 190000);
		Jeep jeep10 = new Jeep("Goku SSJ 1", 340.00, 151515);
		Jeep jeep11 = new Jeep("Goku SSJ 2", 293.00, 141414);
		Jeep jeep12 = new Jeep("Goku SSJ God" , 431.00, 131313);
		Jeep jeep13 = new Jeep("Frizea Gold", 333.00, 161616);
		Jeep jeep14 = new Jeep("Punde", 412.00, 171717 );
		Jeep jeep15 = new Jeep("LastOne" , 376.14, 181818);
		Jeep jeep16 = new Jeep("KinddingBruh", 454.00,212121);

		//Inserting 15 Jeeps
		System.out.println("Adding 15 Jeeps");
		JeepHeaps.addJeep(jeep1);
		JeepHeaps.addJeep(jeep2);
		JeepHeaps.addJeep(jeep3);
		JeepHeaps.addJeep(jeep5);
		JeepHeaps.addJeep(jeep6);
		JeepHeaps.addJeep(jeep7);
		JeepHeaps.addJeep(jeep8);
		JeepHeaps.addJeep(jeep9);
		JeepHeaps.addJeep(jeep10);
		JeepHeaps.addJeep(jeep11);
		JeepHeaps.addJeep(jeep12);
		JeepHeaps.addJeep(jeep13);
		JeepHeaps.addJeep(jeep14);
		JeepHeaps.addJeep(jeep15);
		JeepHeaps.addJeep(jeep16);

		//Printout Jeeps
		JeepHeaps.JeepRollCall();

		//Remove 5 Jeeps
		System.out.println("\nRemoving 5 Jeeps");
		int remover = 5; //No. of times to execute removeJeep()
		for(int i=0; i<remover;i++) {
			JeepHeaps.removeJeep();
		}
		//Printout Jeeps
		JeepHeaps.JeepRollCall();
		
		System.out.println("\nTesting Heap Sort");
		JeepHeaps.heapSort();
		JeepHeaps.JeepRollCall();


	}

}
