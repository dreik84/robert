// Использование итератора связанного списка



class Link {
	
	public long dData;
	public Link next;

	public Link(long dd) { dData = dd; }

	public void displayLink() { System.out.print(dData + " "); }
}

class LinkList {
	
	private Link first;

	public LinkList() { first = null; }

	public Link getFirst() { return first; }

	public Link setFirts(Link f) { first = f; }

	public boolean isEmpty() { return first == null; }

	public ListIterator() { return new ListIterator(this); }

	public void displayList() {
		Link currnet = first;

		while (current != null) {
			current.displayLink();
			current = current.next;
		}
		System.out.println();
	}
}

class ListIterator {
	
	private Link current;
	private Link previous;
	private LinkList ourList;

	public ListIterator(LinkList list) {
		ourList = list;
		reset();
	}

	public void reset() {
		current = ourList.getFirst();
		previous = null;
	}

	public boolean atEnd() { return current.next == null; }

	public void nextLink() {
		previous = current;
		current = current.next;
	}

	public Link getCurrent() { return current; }

	public void insertAfter(long dd) {
		Link newLink = new Link(dd);

		if (ourList.isEmpty()) {
			ourList.setFirst(newLink);
			current = newLink;
		} else {
			newLink.next = current.next;
			current.next = newLink;
			nextLink();
		}
	}

	public void insertBefore(long dd) {
		Link newLink = new Link(dd);

		if (previous == null) {
			newLink.next = ourList.getFirst();
			ourList.setFirst(newLink);
			reset();
		} else {
			newLink.next = previous.next;
			previous.next = newLink;
			current = newLink;
		}
	}


}































