// Сортировка методом выбора
// Запуск программы: java SelectSortApp

class SelectSortApp {
	
	public static void main(String[] args) {
		
		int maxSize = 100;
		ArraySel arr;
		arr = new ArraySel(maxSize);

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
		arr.selectoinSort();
		arr.display();

		arr.reversedSelectoinSort();
                arr.display();

		maxSize = 10000;
                ArraySel bigArr = new ArraySel(maxSize);

                for (int j = 0; j < maxSize; j++) {
                        long n = (long) (java.lang.Math.random() * (maxSize - 1));
                        bigArr.insert(n);
                }

                long start = System.currentTimeMillis();
                bigArr.selectoinSort();
                long end = System.currentTimeMillis();

                System.out.println("Select Sort: " + maxSize + " elements per " +
                        (end - start) + " ms");
	}
}

class ArraySel {

	private long a[];
	private int nElems;

	public ArraySel(int max) {
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

	public void selectoinSort() {
		int out, in, min;

		for (out = 0; out < nElems; out++) {
			min = out;

			for (in = out + 1; in < nElems; in++) 
				if (a[in] < a[min]) 
					min = in;

			swap(out, min);
		}
	}

	public void reversedSelectoinSort() {
                int out, in, min;

                for (out = 0; out < nElems; out++) {
                        min = out;

                        for (in = out + 1; in < nElems; in++)
                                if (a[in] > a[min])
                                        min = in;

                        swap(out, min);
                }
        }

	private void swap(int one, int two) {
		long temp = a[one];
		a[one] = a[two];
		a[two] = temp;
	}
}
