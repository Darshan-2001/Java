//Tester for GenLinkedList

public class GenLLTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenLinkedList<String> strList = new GenLinkedList<String>();
		
		//GenLinkedList<int> intList = new GenLinkedList<int>(); This is wrong. 
		//The type T has to be an object type 
		GenLinkedList<Integer> intList = new GenLinkedList<Integer>();
		String str = "*";
		for(int i = 0; i<5; i++) {
			strList.insert(str);
			str += "*";
			intList.insert(i);
		}
		strList.print();
		intList.print();
		System.out.println();
		intList.moveCurrentForward();
		intList.moveCurrentForward();
		intList.setCurrent(intList.getCurrent()+10);
		intList.print();
		System.out.println();
		intList.resetCurrent();
		while(intList.moreToIterate()) {
			intList.setCurrent(intList.getCurrent()+10);
			intList.moveCurrentForward();
		}
		intList.print();
	}

}
