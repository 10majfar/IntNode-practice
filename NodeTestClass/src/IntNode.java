
public class IntNode {
	
	// the private members can be accessed/modified through methods.
	private int data; //int gets initialized to 0
	private IntNode link;
	
	
	//initializes data and link. initialLink may be null, indicating nothing is after it
	public IntNode(int initialData, IntNode initialLink) {
		data=initialData; //this is also a null element for now.
		link=initialLink; //this is a null reference. There is no following node.
	
	}
	public int getData() {
		
		return data;
	}
	public IntNode getLink() {
		
		return link;	//can be null
	}
	public void setData(int newdata) {
		
		data=newdata;
	}
	public void setLink(IntNode newLink) {
		
		link=newLink;	// can be null if there is no node after this
	}
	
	
	
	
	
	public static void main(String[] args) {
		IntNode head;
		head = new IntNode(42, null);
	//	head = new IntNode(getData(), null);
	//	int i = getData();
		// System.out.println(getData());
	}
	
	
}
