import java.util.Iterator;

public class SLLDemo {

	public static void main(String[] args) {

		SLinkedList<String> linkedList = new SLinkedList<>();
		try {
			String a1 = "a";
			String b = "b";
			String c = "c";
			String d = "d";
			linkedList.add(a1);
			linkedList.add(b);
			linkedList.add(c);

			System.out.printf("Size: expected 3, actual %d%n%n", linkedList.size());
			System.out.printf("First element: expected a, actual %s%n%n", linkedList.get(0));
			System.out.printf("Second element: expected b, actual %s%n%n", linkedList.get(1));
			System.out.printf("Third element: expected c, actual %s%n%n", linkedList.get(2));
			System.out.printf("Index of 'a': expected 0, actual %d%n%n", linkedList.indexOf(a1));
			System.out.printf("Index of 'c': expected 2, actual %d%n%n", linkedList.indexOf(c));
			System.out.printf("Index of 'd': expected -1, actual %d%n%n", linkedList.indexOf(d));
			System.out.printf("List empty? Expected false, actual %s%n%n", linkedList.isEmpty());

			linkedList.remove(2);
			linkedList.remove(1);
			linkedList.remove(0);

			System.out.printf("List empty? Expected true, actual %s%n%n", linkedList.isEmpty());
			System.out.println("Good so far");

			linkedList.add("lists");
			linkedList.add("are");
			String cool = ("cool");
			linkedList.add(cool);

			System.out.printf("Size: expected 3, actual %d%n%n", linkedList.size());
			System.out.printf("Second element: expected are, actual %s%n%n", linkedList.get(1));
			System.out.printf("Third element: expected cool, actual %s%n%n", linkedList.get(2));
			System.out.printf("IndexOf cool: expected 2, actual %s%n%n", linkedList.indexOf(cool));
			System.out.printf("IndexOf a: expected -1, actual %s%n%n", linkedList.indexOf(a1));


			linkedList.remove(1);

			System.out.printf("toString: expected [lists,cool], actual %s%n", linkedList.toString());

			SLinkedList<Word> linkedList2 = new SLinkedList<>();
			System.out.println("get: expected error message null, actual "+ linkedList2.get(0));
			System.out.println("indexOf: expected error message -1, actual "+ linkedList2.indexOf(a1));
			Word x = new Word ("sun", "noun");
			linkedList2.add(x);
			System.out.println("toString: expected [sun noun], actual " + linkedList2.toString());

			System.out.println("Testing inner class");
			SLinkedList<String> l = new SLinkedList<String>();
			String hola = "hola";
			String que = "que";
			String tal = "tal";
			l.add(hola);
			l.add(que);
			l.add(tal);
			Iterator<String> i = l.iterator();
			while (i.hasNext()) {
				System.out.println(i.next());
			}

		} catch (NullPointerException | IndexOutOfBoundsException e) {
			System.err.println(e.getMessage());
		}
	}
}
