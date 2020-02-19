
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
	public void printLink() {
		data=getData();
		link=getLink();
		System.out.println(data+ "   " + link);
			
	}
	//element is the data to place in the new node
	public void addNodeAfter(int element) {
		
		link = new IntNode(element, link);
		
		
	}
	public void removeNodeAfter() {
		link=link.link;
	}
	
	
	
	
	
	public static void main(String[] args) {
		IntNode head;
		IntNode tail;
		head = new IntNode(42, null);
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
		link2.addNodeAfter(99);
		link2.removeNodeAfter();
		link2.removeNodeAfter();
		link2.removeNodeAfter();
		
	}
	
	
}
