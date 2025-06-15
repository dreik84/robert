// Пузырьковая сортировка
// Запуск программы: java BubbleSortApp

class BubbleSortApp {
	
	public static void main(String[] args) {
		
		int maxSize = 100;
		ArrayBub arr;
		arr = new ArrayBub(maxSize);

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
		arr.reversedBubbleSort();
		arr.display();

                arr.bubbleSort();
                arr.display();
		
		maxSize = 10000;
		ArrayBub bigArr = new ArrayBub(maxSize);

		for (int j = 0; j < maxSize; j++) {
			long n = (long) (java.lang.Math.random() * (maxSize - 1));
			bigArr.insert(n);
		}

		long start = System.currentTimeMillis();
		bigArr.bubbleSort();
		long end = System.currentTimeMillis();


		System.out.println("Bublle Sort: " + maxSize + " elements per " +
			(end - start) + " ms");
	}
}

class ArrayBub {

	private long a[];
	private int nElems;

	public ArrayBub(int max) {
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

	public void bubbleSort() {
		int out, in;

		for (out = nElems - 1; out > 1; out--)
			for (in = 0; in < out; in++) 
				if (a[in] > a[in + 1])
					swap(in, in + 1);
	}

	public void reversedBubbleSort() {
                int out, in;

                for (out = nElems - 1; out > 1; out--)
                        for (in = 0; in < out; in++)
                                if (a[in] < a[in + 1])
                                        swap(in, in + 1);
        }

	private void swap(int one, int two) {
		long temp = a[one];
		a[one] = a[two];
		a[two] = temp;
	}
}
