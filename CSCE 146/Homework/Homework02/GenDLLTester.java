/*
 * Written By Prashant Thirumal
 */

public class GenDLLTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenDoubleLinkedList<String> strList = new GenDoubleLinkedList<String>(); 
		GenDoubleLinkedList<Integer> intList = new GenDoubleLinkedList<Integer>();
		
		String str = "*";
		
		
		
		//Check if insert method works by creating a list of values to be added
		for(int i = 1; i<5; i++) {
			strList.insert(str);
			str += "*";
			intList.insert(i);
		}
		intList.showList(); // Also shows showList work
		System.out.println();
		strList.showList();
		
		//Check if goToNext method works by changing the 3rd number 99
		//Check if goToNext method works by changing the 3rd line of * to _
		System.out.println("\n *********Test 1*********");
		Integer checker1 = 99;
		String strChecker = "_";
		intList.goToNext();
		intList.goToNext();
		intList.setDataAtCurrent(checker1); //Also shows that setDataAtCurrent works
		strList.goToNext();
		strList.goToNext();
		strList.setDataAtCurrent(strChecker);
		intList.showList();
		System.out.println();
		strList.showList();
		
		//Check if goToPrev method works by moving the node one back and setting the number to 66
		//Theoretically, second number must be 66
		//Check if goToPrev method works by moving the node one back and setting the * to @@@
		//Theoretically, second line must be @@@
		System.out.println("\n *********Test 2*********");
		Integer checker2 = 66;
		String strChecker2 = "@@@";
		intList.goToPrev();
		intList.setDataAtCurrent(checker2);
		strList.goToPrev();
		strList.setDataAtCurrent(strChecker2);
		strList.showList();
		System.out.println();
		intList.showList();
		
		//Check if insertNodeAfterCurrent method works by inserting the number 33
		//Check if insertNodeAfterCurrent method works by inserting ^%^%
		System.out.println("\n *********Test 3*********");
		Integer checker3 = 33;
		String strChecker3 = "^%^%";
		intList.insertNodeAfterCurrent(checker3);
		strList.insertNodeAfterCurrent(strChecker3);
		intList.showList();
		System.out.println();
		strList.showList();
		
		//Check if deleteCurrentNode method works. Number 66 should be deleted
		//Check if deleteCurrentNode method works.  @@@ should be deleted
		System.out.println("\n *********Test 3*********");
		intList.deleteCurrentNode();
		strList.deleteCurrentNode();
		intList.showList();
		System.out.println();
		strList.showList();
		
		//Check if inList works. input type Integer (checker3) and type String (strChecker3) into inList. Both should return true
		System.out.println("\n *********Test 4*********");
		System.out.println(intList.inList(checker3));
		System.out.println(strList.inList(strChecker3));

	}

}
