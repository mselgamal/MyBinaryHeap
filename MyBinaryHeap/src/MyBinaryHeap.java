import java.util.ArrayList;

/**
 * 
 * @author Mamdouh Elgamal
 * 
 * MinHeap Implementation For Generic Object
 */
public class MyBinaryHeap<k extends Comparable<k>> {
	
	// dynamic array representing heap
	ArrayList<Node<k>> heap;
	
	public MyBinaryHeap () {
		heap = new ArrayList<Node<k>>();
	}
	
	/**
	 * swap parent and child nodes in a heap
	 * 
	 * @param current
	 * @param child
	 */
	private void swapNodes(int current, int child) {
		Node<k> temp = this.heap.get(current);
		this.heap.add(current, this.heap.get(child));
		this.heap.add(child, temp);
	}
	
	/**
	 * number of nodes in the heap
	 * 
	 * @return size
	 */
	public int size() {
		return this.heap.size();
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
		int end = this.heap.size() - 1, current;
		int start = (end - 1) / 2;
		while (start >= 0) {
			current = start;
			while (current * 2 + 1 <= end) {
				int left = current * 2 + 1;
				int right = current * 2 + 2;
				int child = left;
				
				if (right < end + 1 
						&& this.heap.get(child).value
						.compareTo(heap.get(right).value) > 0) {
					child = right;
				} 
				if (this.heap.get(child).value.
						compareTo(this.heap.get(current).value) < 0) {
					swapNodes(current, child);
				}
				
				current = child;
			}
			start--;
		}
	}
	
	/**
	 * remove root node
	 * swap root value with right most leaf node value
	 * in the array, then run heapfiy()
	 * 
	 * @return Node<value>
	 */
	public k extractMin() {
		int end = this.heap.size() - 1;
		k value = this.heap.get(0).value;
		
		this.heap.get(0).value = this.heap.get(end).value;
		this.heap.remove(end);
		
		this.heapfiy();
		
		return value;
	}
	
	/**
	 * delete first node associated with value in heap
	 * then run heapfiy()
	 * 
	 * @param value
	 */
	public void delete(k value) {
		int end = this.heap.size() - 1;
		for (int i = 0 ; i < this.heap.size() ;i++) {
			if (this.heap.get(i).value.equals(value)) {
				this.heap.get(i).value = this.heap.get(end).value;
				break;
			}
		}
		this.heap.remove(end);
		this.heapfiy();
	}
	
	/**
	 * return min value in heap
	 * 
	 * @return value
	 */
	public k getMin() {
		return this.heap.get(0).value;
	}
	
	/**
	 * insert node as leaf then run heapfiy()
	 * 
	 * @param value
	 */
	public void insert(k value) {
		Node<k> node = new Node<k>();
		node.value = value;
		this.heap.add(node);
		this.heapfiy();
	}
	
	@SuppressWarnings("hiding")
	private class Node<k> {
		private k value;
	}
}
