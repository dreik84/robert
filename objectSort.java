// Сортировка объектов методом вставки
// Запуск программы: java ObjectSortApp

class ObjectSortApp {
	
	public static void main(String[] args) {
		
		int maxSize = 100;
		ArrayInOb arr;
		arr = new ArrayInOb(maxSize);

		arr.insert("Evans", "Patty", 24);
		arr.insert("Smith", "Lorraine", 37);
		arr.insert("Yee", "Tom", 43);
		arr.insert("Adams", "Henry", 63);
		arr.insert("Hashimoto", "Sato", 21);
		arr.insert("Stimson", "Henry", 29);
		arr.insert("Velasquez", "Jose", 72);
		arr.insert("Lamarque", "Henry", 54);
		arr.insert("Vang", "Minh", 22);
		arr.insert("Creswell", "Lucinda", 18);
		
		System.out.println("Before sorting:");
		arr.display();

		arr.insertionSort();

		System.out.println("After sorting:");
		arr.display();
	}
}

class ArrayInOb {

	private Person a[];
	private int nElems;

	public ArrayInOb(int max) {
		a = new Person[max];
		nElems = 0;
	}

	public void insert(String last, String first, int age) {
		a[nElems] = new Person(last, first, age);
		nElems++;
	}

	public void display() {
		for (int j = 0; j < nElems; j++) a[j].displayPerson();
		
		System.out.println();
	}

	public void insertionSort() {
		int out, in;

		for (out = 1; out < nElems; out++) {
			Person temp = a[out];
			in = out;

			while (in > 0 && 
				a[in - 1].getLast().compareTo(temp.getLast()) > 0) {
				a[in] = a[in - 1];
				--in;
			}
			a[in] = temp;
		}
	}

	private void swap(int one, int two) {
		Person temp = a[one];
		a[one] = a[two];
		a[two] = temp;
	}
}
