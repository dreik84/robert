// Сортировка методом четно-нечетных перестановок
// Запуск программы: java OddEvenSortApp

class OddEvenSortApp {
	
	public static void main(String[] args) {
		
		int maxSize = 100;
		ArrayOddEven arr;
		arr = new ArrayOddEven(maxSize);

		arr.insert(77);
		arr.insert(99);
		arr.insert(44);
		arr.insert(55);
		arr.insert(22);
		arr.insert(88);
		arr.insert(11);
		arr.insert(00);
		arr.insert(66);
		arr.insert(33);

		arr.display();
                arr.oddEvenSort();
                arr.display();
		
		maxSize = 10000;
		ArrayOddEven bigArr = new ArrayOddEven(maxSize);

		for (int j = 0; j < maxSize; j++) {
			long n = (long) (java.lang.Math.random() * (maxSize - 1));
			bigArr.insert(n);
		}

		long start = System.currentTimeMillis();
		bigArr.oddEvenSort();
		long end = System.currentTimeMillis();


		System.out.println("OddEven Sort: " + maxSize + " elements per " +
			(end - start) + " ms");
	}
}

class ArrayOddEven {

	private long a[];
	private int nElems;

	public ArrayOddEven(int max) {
		a = new long[max];
		nElems = 0;
	}

	public void insert(long value) {
		a[nElems] = value;
		nElems++;
	}

	public void display() {
		for (int j = 0; j < nElems; j++) System.out.print(a[j] + " ");
		
		System.out.println();
	}

	public void oddEvenSort() {

		for (int i = 0 ; i < nElems; i++) {
			
			if (i % 2 == 0) {				
				for (int j = 0; j <= nElems - 2; j += 2) // нечетная 
					if (a[j] > a[j + 1]) swap(j, j + 1);
			} else {
				for (int j = 1; j <= nElems - 2; j += 2) // четная
					if (a[j] > a[j + 1])swap(j, j + 1);
			}
		}
	}

	private void swap(int one, int two) {
		long temp = a[one];
		a[one] = a[two];
		a[two] = temp;
	}
}
