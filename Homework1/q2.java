
public class q2 {
	public static void secret(ListADT<String> origL) {
		ListADT<String> newL = new SimpleArrayList<String>();
		for (int i = 0; i < origL.size(); i++)
			newL.add(i, origL.remove(i));
		for (int i = 0; i < newL.size(); i++)
			origL.add(newL.remove(0));
	}
}
