package com.yatish.LinkedList;

public class J1_LinkedListImplementation {

	public static void main(String[] args) {
		
		java.util.LinkedList<String> list = new java.util.LinkedList<String>();
		list.add("a");
		list.addFirst("b");
		for(String s : list) {
			System.out.println(s);
		}
		
		LinkedListImplementation obj = new LinkedListImplementation();
		obj.head = new Node(1);
		obj.head.nextNode = new Node(2);
		obj.head.nextNode.nextNode = new Node(3);
		obj.head.nextNode.nextNode.nextNode = new Node(4);
		obj.head.nextNode.nextNode.nextNode.nextNode = obj.head.nextNode;
		//obj.addAtFirst(2);
		//obj.addAtFirst(3);
		//obj.deleteElement(2);
		//obj.swapWithOneIteration(3, 1);
		//obj.swap(3, 1);
		//obj.reverseLinkedList();
		//obj.reverseLinedListInBatch(3);
		//obj.printLinkedList();
		obj.DetectLoopAndBreakIt();
		System.out.println("Loop present : " + obj.DetectLoop());
		//System.out.println("Lenght : " + obj.findLenght());
		
	}

}


class LinkedListImplementation {
	
	Node head;
	
	/*
	 * This will add the new element at the last of the list.  
	 */
	public void add(int a) {
		Node newNode = new Node(a);
		if(head == null) {
			head = newNode;
			return;
		}
		Node cur = head;
		while(cur.nextNode != null) {
			cur = cur.nextNode;
		}
		cur.nextNode = newNode;
	}
	
	/*
	 * Add the new element at the first
	 */
	public void addAtFirst(int a) {
		 Node newNode = new Node(a);
		 Node temp = head;
		 head = newNode;
		 newNode.nextNode = temp;
	}
	
	/*
	 * Print all the element of the linked list.
	 */
	public void printLinkedList() {
		Node cur = head;
		while(cur != null) {
			System.out.println(cur.data);
			cur = cur.nextNode;
		}
	}
	
	/*
	 * Deleting the Specified element.
	 */
	public void deleteElement(int a) {
		Node x = new Node(a);
		Node prev = null;
		Node cur = head;
		while(cur != null) {
			if(cur.equals(x)) {
				break;
			}
			prev = cur;
			cur = cur.nextNode;
		}
		//if first element itself matches to delete it.
		if(prev == null) {
			head = cur.nextNode;
			return;
		}
		prev.nextNode = cur.nextNode;
	}
	
	
	/*
	 * Find the Length of Linked list using reccursion
	 */
	public int findLenght() {
		return recursiveLenghtFunction(head);
	}
	private int recursiveLenghtFunction(Node cur) {
		if(cur == null) {
			return 0;
		}
		return 1 + recursiveLenghtFunction(cur.nextNode);
	}
	
	
	/*
	 * Swapping 2 nodes,
	 * 	Input:  10->15->12->13->20->14,  x = 12, y = 20
		Output: 10->15->20->13->12->14
		
		Input:  10->15->12->13->20->14,  x = 10, y = 20
		Output: 20->15->12->13->10->14
		
		Input:  10->15->12->13->20->14,  x = 12, y = 13
		Output: 10->15->13->12->20->14
	 */
	public void swap(int x,int y) {
		Node X = new Node(x);
		Node Y = new Node(y);
		//moving pointer to X element.
		Node prevX = null;
		Node curX = head;
		while(curX != null) {
			if(curX.equals(X)) {
				break;
			}
			prevX = curX;
			curX = curX.nextNode;
		}
		//moving pointer to Y element.
		Node prevY = null;
		Node curY = head;
		while(curY != null) {
			if(curY.equals(Y)) {
				break;
			}
			prevY = curY;
			curY = curY.nextNode;
		}
		// if X is first element itself
		if(prevX == null) {
			head = curY;
		} else {
			prevX.nextNode = curY;
		}
		//If Y is first element itself.
		if(prevY == null) {
			head = curX;
		} else {
			prevY.nextNode = curX;
		}
		Node XNextNode = curX.nextNode;
		Node YNextNode = curY.nextNode;
		curY.nextNode = XNextNode;
		curX.nextNode = YNextNode;
	}
	
	/*
	 * In previous swap function, we showed swapping but we can do the same with only one iteration over the linked list that is O(1) as shown in the below function.
	 */
	public void swapWithOneIteration(int x, int y) {
		Node X = new Node(x);
		Node Y = new Node(y);
		Node FinalprevX = null;
		Node FinalcurX = head;
		Node FinalprevY = null;
		Node FinalcurY = head;
		//moving pointer to X and Y element.
		Node prevX = null;
		Node curX = head;
		Node prevY = null;
		Node curY = head;
		while(curX != null) {
			if(curX.equals(X)) {
				FinalprevX = prevX;
				FinalcurX = curX;
			}
			if(curY.equals(Y)) {
				FinalprevY = prevY;
				FinalcurY = curY;
			}
			prevX = curX;
			curX = curX.nextNode;
			prevY = curY;
			curY = curY.nextNode;
		}
		
		// if X is first element itself
		if(FinalprevX == null) {
			head = FinalcurY;
		} else {
			FinalprevX.nextNode = FinalcurY;
		}
		//If Y is first element itself.
		if(prevY == null) {
			head = FinalcurX;
		} else {
			FinalprevY.nextNode = FinalcurX;
		}
		Node XNextNode = FinalcurX.nextNode;
		Node YNextNode = FinalcurY.nextNode;
		FinalcurY.nextNode = XNextNode;
		FinalcurX.nextNode = YNextNode;
	}
	
	/*
	 * Reverse the linked list.
	 */
	public void reverseLinkedList() {
		Node prev = null;
		Node cur = head;
		Node next = head.nextNode;
		
		while(cur != null) {
			cur.nextNode = prev;
			prev = cur;
			cur = next;
			if(next != null) {
				next = next.nextNode;
			}	
		}
		head = prev;
	}
	
	/*
	 * Reverse the linked list in batches
	 * Example:
		Inputs:  1->2->3->4->5->6->7->8->NULL and k = 3 
		Output:  3->2->1->6->5->4->8->7->NULL. 
		
		Inputs:   1->2->3->4->5->6->7->8->NULL and k = 5
		Output:  5->4->3->2->1->8->7->6->NULL. 
	 */
	public void reverseLinedListInBatch(int batchSize) {
		reverseLinkedListInBatches(head,head,batchSize);
	}
	public void reverseLinkedListInBatches(Node startNode, Node previousHead,int batchSize) {
		Node prev = null;
		Node cur = startNode;
		Node next = startNode.nextNode;
		int i = 0;
		while(cur != null && i < batchSize) {
			cur.nextNode = prev;
			prev = cur;
			cur = next;
			if(next != null) {
				next = next.nextNode;
			}		
			i++;
		}
		
		if(startNode == head) {
			head = prev;
		} else {
			previousHead.nextNode = prev;
		}
		
		if(cur == null) {
			return;
		}
		reverseLinkedListInBatches(cur,startNode,batchSize);
	}
	
	
	/*
	 * Detect if there is a loop in the linked list
	 * 
	 */
	public boolean DetectLoop() {
		Node a = head;
		Node b = head;
		while(a != null && b != null) {
			 a = a.nextNode;
			 b = b.nextNode.nextNode;
			if(a == b) {
				return true;
			}
		}
		return false;
	}
	
	/*
	 * Detect if there is a loop in the linked list and then remove it.
	 * 
	 */
	public void DetectLoopAndBreakIt() {
		Node a = head;
		Node b = head;
		while(a != null && b != null) {
			 a = a.nextNode;
			 b = b.nextNode.nextNode;
			if(a == b) {
				a.nextNode = null;		// Usually both a and b will be pointing to the last element from which the loop is happening. hence if we just make its next element null that is enough.
				break;
			}
		}
	}
	
	
	/*
	 * Rotate the linked list based on the integer value specified. like if the given linked list is 10->20->30->40->50->60 and k is 2, the list should be modified to 50->60->10->20->30->40.
	 */
}	
	


class Node {
	int data;
	Node nextNode;
	
	Node(int data) {
		this.data = data;
	}
	
	public boolean equals(Node node) {
		if(this.data == node.data) {
			return true;
		}
		return false;
	}
	
	
}
