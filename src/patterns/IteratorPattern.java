package patterns;

public class IteratorPattern {

	public static void main(String[] args) {
		HSBACourse<String> courseList = new HSBACourse(100);
		courseList.add("AOIS");
		courseList.add("SE");
		courseList.add("LAW");
		courseList.add("PM");
		Iterator<String> iter = courseList.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
		courseList.add("OOP");
		iter = courseList.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
}

interface Iterator<T>{
	boolean hasNext();
	T next();
}

class HSBACourse<T>{
	private Object[] memory;
	private int currentSize = 0;
	
	public HSBACourse(int size) {
		memory = new Object[size];
	}
	
	public Iterator<T> iterator() {
		CourseIterator<T> iter = new CourseIterator(currentSize);
		return iter;
	}
	
	public void add(String item) {
		for (int i = 0; i < memory.length; i++) {
			if(memory[i]== null) {
				memory[i] = item;
				currentSize = i;
				return;
			}
		}
	}
	
	class CourseIterator<N> implements Iterator<N>{
		private int index = 0;
		private int current = 0;
		
		public CourseIterator(int current) {
			this.current = current;
		}
		
		@Override
		public boolean hasNext() {
			return index<=current;
		}

		@Override
		public N next() {
			System.out.println(index);
			return (N)memory[index++];
		}
	}
}
