
public class IntNode {
	
	// the private members can be accessed/modified through methods.
	private int data; //int gets initialized to 0
	private IntNode link;
	
	
	//initializes data and link. initialLink may be null, indicating nothing is after it
	public IntNode(int initialData, IntNode initialLink) {
		this.data=initialData; //this is also a null element for now.
		this.link=initialLink; //this is a null reference. There is no following node.
	
	}
	public int getData() {
		
		return data;
	}
	public IntNode getLink() {
		
		return this.link;	//can be null
	}
	public void setData(int newdata) {
		
		this.data=newdata;
	}
	public void setLink(IntNode newLink) {
		
		this.link=newLink;	// can be null if there is no node after this
	}
	public void printLink() {
		this.data=getData();
		this.link=getLink();
		System.out.println(data+ "   " + link);
			
	}
	//element is the data to place in the new node
	public void addNodeAfter(int element) {
		
		this.link = new IntNode(element, this.link);
		
		
	}
	public void removeNodeAfter() {
		this.link=this.link.link;
	}
	
	public static int listLength(IntNode head) {
		int answer = 0;	// if cursor at head==null, loop is skipped and returns 0
		IntNode cursor;
//***	FOR LOOP BELOW, IMPORTANT!!! \/ \/ *********************************
//			use if ALL NODES need traversing
//		*** Can replace cursor=cursor.link with cursor=cursor.getLink();
		for (cursor=head; cursor != null; cursor=cursor.link) { //cursor.link may become null
			answer++;
		}
		return answer;
	}
	public static IntNode listSearch(IntNode head, int target) { //same heading as above!!
		IntNode cursor;
		for (cursor=head; cursor!=null; cursor=cursor.link) {
			if (target==cursor.data) // the element/data the node refers to
				return cursor; // the node referring to the data/element
		}
		return cursor; //null at this stage
	}
	// finding node by a specified position:
	public static IntNode listPosition(IntNode head, int position) {
		IntNode cursor;
		int i;
		if (position<=0) throw new IllegalArgumentException("position is not positive");
		
		cursor=head; //i=1 at this pos, NOT 0. tracking references, not data.
		
		for (i=1; (i<position) && (cursor != null); i++)
			cursor=cursor.link;
		
		return cursor; //can be null if position not in loop and >0
	}
	public static IntNode listCopy(IntNode source) {
		// handle an empty list:
		if (source==null) return null;
		
		IntNode copyHead = new IntNode(source.data, null); // new head with same data as source head
		IntNode copyTail = copyHead;	// initialize tail to be same as head
		
		while (source.link != null) {
			source = source.link;	//advances a link in source 
			copyTail.addNodeAfter(source.data); //add data from source to tail 
			copyTail = copyTail.link; //extends list by advancing the tail
// ***	/\ /\ see page 201-202 for visualization of above /\ /\
		}
		return copyHead; //reference to the head of new list. isn't null at this point.
	}
	// similar to list copy, but returns array of both head and tail references
	public static IntNode[] listCopyWithTail(IntNode source) {
		
		IntNode copyHead;
		IntNode copyTail;
		IntNode[] answer = new IntNode[2]; // length of 2 initialized with nulls
		
		// Handles empty source:
		if (source==null) return null; 
		
		copyHead = new IntNode(source.data, null); // new head same value as source
		copyTail = copyHead;	// initializes tail to be same as head
		
		while (source.link != null) {//advances links while there is a link
			source=source.link; // advance a link in source
			copyTail.addNodeAfter(source.data); //adds node after specified val in source
			copyTail = copyTail.link; // advances tail in the copy
						
		}
// ****** NEW: 
		answer[0] = copyHead;
		answer[1] = copyTail;
		return answer;	// returns an IntNode array with the head and tail references
	}
	
// Similar to list, but user can specify range
	public static IntNode[] listPart(IntNode start, IntNode end) {
		IntNode copyHead;
		IntNode copyTail;
		IntNode[] answer = new IntNode[2]; // new array with nulls
		if (start==null || end==null) throw new IllegalArgumentException(
				"either start or end is null. re write method to determine which");
		copyHead = new IntNode(start.data, null); // new head with same val as source
		copyTail = copyHead; // new tail, points to head for now

		while (start != end) { // continue until start points to end
			start=start.link; // advances source
			// Below \/ \/ means start has advanced all the way through,
			//	without finding the end node.
			if (start==null) throw new IllegalArgumentException("end not found");
			
			copyTail.addNodeAfter(start.data);	// adds new node to tail
			copyTail=copyTail.link;			// advances tail
		}
		answer[0] = copyHead;
		answer[1]=copyTail;
		return answer; //may be null
			
	}
	
	
	
	public static void main(String[] args) {
		IntNode head = null;
		IntNode tail;
		if (head==null)	head = new IntNode(42, null);
	
		//IntNode link = head;
		IntNode link2=new IntNode(5, head);
		IntNode link3=new IntNode(22, link2);
		IntNode link4 = new IntNode(0, head);
		
		head.printLink();
		link2.printLink();
		link3.printLink();
		link4.printLink();
		head = head.getLink();
	//	head.printLink();
		if (link2 != null) { 
			if (link2.getLink()==null) link2=null;
			else link2.removeNodeAfter();
		}
		link2.addNodeAfter(99);
		link2.removeNodeAfter();
	//	link2.removeNodeAfter();
	//	link2.removeNodeAfter();
		IntNode head2 = new IntNode(1, null);
		IntNode tail2=head2;
		int i;
		for (i=2; i<=100; i++) {
			tail2.addNodeAfter(i);
			tail2 = tail2.getLink();
		}
		System.out.println(IntNode.listLength(tail2) + "\n Size of head2: " +
		IntNode.listLength(head2));
		head2.removeNodeAfter();
		IntNode copy = IntNode.listCopy(head2);
		System.out.println("Size of the copy of head2 named copy: " + IntNode.listLength(copy));
		
	}
	
	
}
