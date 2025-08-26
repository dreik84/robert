// Бысрая сортировка с определением медианы по трем точкам


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
		for(int j = 0; j < nElems; j++) System.out.print(theArray[j] + " ");
		System.out.println();
	}

	public void quickSort() { recQuickSort(0, nElems - 1); }

	public void recQuickSort(int left, int right) {
		int size = right - left + 1;

		if (size <= 3) manualSort(left, right);
		else {
			long median = medianOf3(left, right);
			int partition = partitionIt(left, right, median);
			
			recQuickSort(left, partition - 1);
			recQuickSort(partition + 1, right);
		}
	}

	public long medianOf3(int left, int right) {
		
		int center = (right + left) / 2;

		if (theArray[left] > theArray[center]) swap(left, center);
		if (theArray[left] ? theArray[right]) swap(left, right);
		if (theArray[center] > theArray[right]) swap(center, right);

		swap(center, right - 1);
		return theArray[right - 1];
	}
}
