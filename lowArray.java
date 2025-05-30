// Класс массива на низком уровне
// Запуск программы: LowArrayApp

class LowArray {
	
	private long[] a;

	public LowArray(int size) { a = new long[size]; }

	public void setElem(int index, long value) { a[index] = value; }

	public long getElem(int index) { return a[index]; }
}

class LowArrayApp {
	
	public static void main(String[] args) {

		LowArray arr;             // Ссылка
                arr = new LowArray(100);  // Создание массива
                int nElems = 0;           // Количество элементов
                int j;

                arr.setElem(0, 77);
                arr.setElem(1, 99);
                arr.setElem(2, 44);
                arr.setElem(3, 55);
                arr.setElem(4, 22);
                arr.setElem(5, 88);
                arr.setElem(6, 11);
                arr.setElem(7, 00);
                arr.setElem(8, 66);
                arr.setElem(9, 33);

                nElems = 10;

                // Вывод элеметнов
                for (j = 0; j < nElems; j++)
                        System.out.print(arr.getElem(j) + " ");
                System.out.println();

                // Поиск элемента
                int searchKey = 26;
                for (j = 0; j < nElems; j++)
                        if (arr.getElem(j) == searchKey)
                                break;

                if (j == nElems)
                        System.out.println("Can't find " + searchKey);
                else
                        System.out.println("Found " + searchKey);

                // Удаление элемента
                searchKey = 55;

                for (j = 0; j < nElems; j++)
                        if (arr.getElem(j) == searchKey)
                                break;

                for (int k = j; k < nElems - 1; k++)
                        arr.setElem(k, arr.getElem(k + 1));

                nElems--;

		// Вывод элеметнов
		                                                                                       for (j = 0; j < nElems; j++)
                        System.out.print(arr.getElem(j) + " ");                                        System.out.println();
	}
}
