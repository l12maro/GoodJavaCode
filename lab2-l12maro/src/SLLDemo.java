public class SLLDemo {

	public static void main(String[] args) {

		SLinkedList<String> linkedList = new SLinkedList<>();
		try {
			String a = "a";
			String b = "b";
			String c = "c";
			linkedList.add(a);
			linkedList.add(b);
			linkedList.add(c);

			System.out.printf("Size: expected 3, actual %d%n%n", linkedList.size());
			System.out.printf("Second element: expected b, actual %s%n%n", linkedList.get(1));
			System.out.printf("Index of 'a': expected 0, actual %d%n%n", linkedList.indexOf(a));
			System.out.printf("List empty? Expected false, actual %s%n%n", linkedList.isEmpty());

			linkedList.remove(2);
			linkedList.remove(1);
			linkedList.remove(0);

			System.out.printf("List empty? Expected true, actual %s%n%n", linkedList.isEmpty());

			linkedList.add("lists");
			linkedList.add("are");
			linkedList.add("cool");

			System.out.printf("toString: expected [lists,are,cool], actual %s%n", linkedList.toString());

		} catch (NullPointerException | IndexOutOfBoundsException e) {
			System.err.println(e.getMessage());
		}
	}
}
