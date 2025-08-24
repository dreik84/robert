// Простая версия быстрой сортировки


class ArrayIns {
	
	private long[] theArray;
	private int nElems;

	public ArrayIns(int max) {
		theArray = new long[max];
		nElems = 0;
	}

	public void insert(long value) { theArray[nElems++] = value; }

	public void display() {
		System.out.print("A=");
		for (int j = 0; j < nElems; j++) System.out.print(theArray[j] + " ");
		System.out.println();
	}

	public void quickSort() { recQuickSort(0, nElems - 1); }

	public void recQuickSort(int left, int right) {
		
		if (right - left <= 0) return;
		else {
			long pivot = theArray[right];
			int partition = partitionIt(left, right, pivot);

			recquicksort(left, partition - 1);
			recquicksort(partition + 1, right);
		}
	}


}
