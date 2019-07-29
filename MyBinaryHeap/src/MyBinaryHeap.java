
/**
 * 
 * @author Mamdouh Elgamal
 * 
 * MinHeap Implementation For Generic Object
 */
public class MyBinaryHeap<k extends Comparable<k>> {
	
	// initial capacity
	private int capacity = 20;
	Node<k>[] heap;
	
	@SuppressWarnings("unchecked")
	public MyBinaryHeap () {
		heap = new Node[this.capacity];
	}
	
	/**
	 * swap parent and child nodes in a heap
	 * 
	 * @param current
	 * @param child
	 */
	private void swap(int current, int child) {
		Node<k> temp = this.heap[current];
		this.heap[current] = this.heap[child];
		this.heap[current] = temp;
	}
	
	/**
	 * 
	 * start at last left most parent node position
	 * while start position is not zero
	 * 	while next position has children
	 * 		check parent node left and right child
	 * 		if parent node is > left node or right node
	 * 			swap parent node with max of left or right nodes
	 * 			next node position = new position of parent node (either left or right)
	 * decrement start position by 1
	 */
	private void heapfiy() {
		int end = this.heap.length - 1, current;
		int start = (end-1) / 2;
		while (start >= 0) {
			current = start;
			while (current * 2 + 1 <= end) {
				int left = current * 2 + 1;
				int right = current * 2 + 2;
				int child = left;
				
				if (right < end + 1 
						&& this.heap[child].key
						.compareTo(this.heap[right].key) > 0) {
					child = right;
				} 
				if (this.heap[child].key.
						compareTo(this.heap[current].key) < 0) {
					swap(current, child);
				}
				
				current = child;
			}
			start--;
		}
	}
	
	@SuppressWarnings("hiding")
	private class Node<k> {
		@SuppressWarnings("unused")
		private k key;
	}
}
