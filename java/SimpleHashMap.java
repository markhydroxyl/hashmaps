/**
 * A simple, array implementation of a table.
 * However, this is not a HashMap, since hashcodes aren't even used.
 * @param <K> The key's type.
 * @param <V> The value's type.
 */
public class SimpleHashMap<K, V> implements HashMap<K, V> {
	private static final int DEFAULT_SIZE = 10;
	private K[] keys;
	private V[] vals;
	private int size;

	/**
	 * Constructs empty HashMap with default internal size 10.
	 */
	public SimpleHashMap() {
		keys = (K[]) new Object[DEFAULT_SIZE];
		vals = (V[]) new Object[DEFAULT_SIZE];
	}

	/**
	 * Constructs empty HashMap with specified default internal size.
	 * @param size The size of the HashMap.
	 * @throws IllegalArgumentException Thrown when the given size is illegal.
	 */
	public SimpleHashMap(int size) throws IllegalArgumentException {
		if (size <= 0) throw new IllegalArgumentException("Illegal HashMap size");
		keys = (K[]) new Object[size];
		vals = (V[]) new Object[size];
	}

	/**
	 * Finds the index for the given key.
	 * @param key The key to find.
	 * @return If present, the index. Else, -1.
	 */
	private int find(K key) {
		if (key == null) {
			for (int i=0; i<keys.length; i++)
				if (keys[i] == null) return i;
		} else {
			for (int i=0; i<keys.length; i++)
				if (keys[i] != null && keys[i].equals(key)) return i;
		}
		return -1;
	}

	/**
	 * Resizes the internal arrays to the new size.
	 * @param size The new size of the arrays.
	 */
	private void resize(int size) throws IllegalArgumentException {
		if (size <= 0) throw new IllegalArgumentException("Hashmap has reached max size");
		keys = Arrays.copyOf(keys, size);
		vals = Arrays.copyOf(vals, size);
	}

	@Override
	public V get(K key) throws IllegalArgumentException {
		if (key == null) throw new IllegalArgumentException("Null key not supported");
		int idx = find(key);
		return (idx == -1 ? null : vals[idx]);
	}

	@Override
	public boolean put(K key, V val) throws IllegalArgumentException {
		if (key == null) throw new IllegalArgumentException("Null key not supported");
		int idx = find(key);
		if (idx == -1) {
			if (this.size == keys.length) resize(2*this.size);
			idx = find(null);
			this.size++;
		}
		keys[idx] = key;
		vals[idx] = val;
		return true;
	}

	@Override
	public boolean remove(K key) throws IllegalArgumentException {
		if (key == null) throw new IllegalArgumentException("Null key not supported");
		int idx = find(key);
		if (0 <= idx) {
			keys[idx] = null;
			this.size--;
			return true;
		}
		return false;
	}

	@Override
	public boolean contains(K key) throws IllegalArgumentException {
		if (key == null) throw new IllegalArgumentException("Null key not supported");
		int idx = find(key);
		return (0 <= idx);
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return (size == 0);
	}
}