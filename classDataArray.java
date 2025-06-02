// Объекты как элементы данных
// Запуск программы: java ClassDataApp

class ClassDataApp {
	public static void main(String[] args) {
		
		int maxSize = 100;
		ClassDataArray arr;
		arr = new ClassDataArray(maxSize);

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

		arr.displayA();

		String searchKey = "Stimson";
		Person found = arr.find(searchKey);

		if (found != null) {
		       	System.out.print("Found "); 
			found.displayPerson();
		}
		else System.out.println("Can't find " + searchKey);

		arr.delete("Smith");
		arr.delete("Yee");
		arr.delete("Creswell");

		arr.displayA();
	}
}

class ClassDataArray {
	
	private Person[] a;
	private int nElems;

	public ClassDataArray(int max) {
		a = new Person[max];
		nElems = 0;
	}

	public Person find(String searchName) {
		int j;
		
		for (j = 0; j < nElems; j++)
		       if (a[j].getLast().equals(searchName)) break;

		if (j == nElems) return null;
		else return a[j];
	}

	public void insert(String last, String first, int age) {
		a[nElems] = new Person(last, first, age);
		nElems++;		
	}

	public boolean delete(String searchName) {
		int j;

		for (j = 0; j < nElems; j++) 
			if (a[j].getLast().equals(searchName)) break;

		if (j == nElems) return false;
		else {
			for (int k = j; k < nElems; k++) a[k] = a[k + 1];

			nElems--;
			return true;
		}
	}

	public void displayA() {
		for (int j = 0; j < nElems; j++) a[j].displayPerson();
	}
}
