
public class MyHashMap {
	int capacity = 1024;
	Object[] ar = new Object[capacity];
	Object[] keys = new Object[capacity];
	int size = 0;
	
	public MyHashMap() {
		for (int i=0;i<capacity;i++) {
			ar[i] = null;
		}
	}
	
	public void put(Object key, Object value) throws HashMapFullException {
		if (size>=capacity) throw new HashMapFullException();
		int idx = key.hashCode();
		if (idx<0) idx=-idx;
		idx = idx % this.capacity;
		
		
		if (ar[idx]==null) {
			ar[idx] = value;
			keys[idx] = key;
			size++;
			return;
		}
		
		while (ar[idx]!=null) {
			idx++;
			idx %= capacity;
		}
		
		ar[idx] = value;
		keys[idx] = key;
		size++;
	}
	
	public Object get(Object key) {
		int idx = key.hashCode() % capacity;
		if (idx<0) idx=-idx;
		if (ar[idx]==null) return null;
		
		for (int i=0;i<capacity;i++) {
			if (keys[idx].equals(key))
				return ar[idx];
			idx++;
			idx %= capacity;
		}
		
		return null;
	}
}


