// Класс массива с высокоуровневым интерфейсом
// Запуск программы: java HighArrayApp

class HighArrayApp {
	public static void main(String[] args) {
		
		int maxSize = 100;
		HighArray arr;
		arr = new HighArray(maxSize);

		arr.insert(77);
		arr.insert(99);
		arr.insert(44);
		arr.insert(55);
		arr.insert(22);
		arr.insert(88);
		arr.insert(44);
		arr.insert(11);
		arr.insert(00);
		arr.insert(66);
		arr.insert(33);

		arr.display();

		int searchKey = 35;
		if (arr.find(searchKey)) System.out.println("Found " + searchKey);
		else System.out.println("Can't find " + searchKey);

		arr.delete(00);
		arr.delete(55);
		arr.delete(99);

		arr.display();

		System.out.println("Max value: " + arr.getMax());
		System.out.println("Max value remove: " + arr.removeMax());

		arr.display();

		arr.noDups();
                arr.display();

		long[] sortedArr = new long[10];
		
		for (int i = 0; i < sortedArr.length; i++) 
			sortedArr[i] = arr.removeMax();
	}
}

class HighArray {
	
	private long[] a;
	private int nElems;

	public HighArray(int max) {
		a = new long[max];
		nElems = 0;
	}

	public void noDups() {

		for (int i = 0; i < nElems; i++) 
			for (int j = i + 1; j < nElems; j++)
				if (a[i] == a[j]) {
					for (int k = j; k < nElems; k++) 
						a[k] = a[k + 1];

					nElems--;
				}
	}

	public boolean find(long searchKey) {
		int j;
		
		for (j = 0; j < nElems; j++)
		       if (a[j] == searchKey) break;

		if (j == nElems) return false;
		else return true;
	}

	public long getMax() {
		long res = -1;

		for (int j = 0; j < nElems; j++) {
			res = (res > a[j]) ? res : a[j];
		}

		return res;
	}

	public long removeMax() {
		int j;
		long res = 0;
		int resIndex = 0;

		for (j = 0; j < nElems; j++) { 
			if (res < a[j]) {
				res = a[j];
				resIndex = j;
			}
		}

		if (resIndex != nElems) 
			for (int k = resIndex; k < nElems; k++) a[k] = a[k + 1];

		nElems--;
		return res;
	}

	public void insert(long value) {
		a[nElems] = value;
		nElems++;		
	}

	public boolean delete(long value) {
		int j;

		for (j = 0; j < nElems; j++) 
			if (value == a[j]) break;

		if (j == nElems) return false;
		else {
			for (int k = j; k < nElems; k++) a[k] = a[k + 1];

			nElems--;
			return true;
		}
	}

	public void display() {
		for (int j = 0; j < nElems; j++) System.out.print(a[j] + " ");

		System.out.println();
	}
}
