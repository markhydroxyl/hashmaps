/**
 * An interface to define all necessary methods for a HashMap.
 * @param <K> The key type.
 * @param <V> The value type.
 */
public interface HashMap<K, V> {
	/**
	 * Gets the value corresponding to key.
	 * @param key The key to get.
	 * @return If present, the value. Else, null.
	 */
	public V get(K key);

	/**
	 * Puts a (key, val) pair into the HashMap.
	 * If the key already exists, prior value is overwritten.
	 * If the key does not yet exist, a new entry is created.
	 * @param key The key to put val into.
	 * @param val The val to put.
	 * @return Whether the operation was successful.
	 */
	public boolean put(K key, V val);

	/**
	 * Removes the key from the HashMap.
	 * @param key The key to remove.
	 * @return Whether the key was actually present.
	 */
	public boolean remove(K key);

	/**
	 * Returns whether the key is present.
	 * @return Whether the key is present.
	 */
	public boolean contains(K key);

	/**
	 * Returns the size of the HashMap.
	 * @return The size of the HashMap.
	 */
	public int size();

	/**
	 * Returns whether the HashMap is empty.
	 * @return Whether the HashMap is empty.
	 */
	public boolean isEmpty();
}