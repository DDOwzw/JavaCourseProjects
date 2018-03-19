
public interface ListADT<E> extends Iterable<E>{
	E[] get();
	void add(E newItem);
	void add(int pos, E newItem);
	int size();
	E remove(int pos);
	boolean isEmpty();
	Iterator<E> iterator();
}
