import java.util.HashMap;
public class LinkedListNode {
	LinkedListNode next = null;
	int data;
	public LinkedListNode(int d){data = d;}
	public LinkedListNode appendToTail(int d)
	{
		LinkedListNode end = new LinkedListNode(d);
		LinkedListNode n = this;
		while(n.next != null){n = n.next;}
		n.next = end;
		return end;
	}
	LinkedListNode deleteNode(LinkedListNode head, int d)
	{
		LinkedListNode n = head;
		if(n.data == d)
		{
			return n.next;
		}
		while(n.next != null)
		{
			if(n.next.data == d)
			{
				n.next = n.next.next;
				return head;
			}
			n = n.next;
		}
		return head;
	}
	static LinkedListNode FindBeginningLoop(LinkedListNode head) 
	{
		HashMap<LinkedListNode,Boolean> map = new HashMap<LinkedListNode,Boolean>();
		while(head != null)
		{
			if(map.containsKey(head))
				return head;
			else
			{
				map.put(head,true);
				head = head.next;
			}
		}
		return head;
	}
	public static void main(String[] args)
	{
		LinkedListNode n = new LinkedListNode(0);
		LinkedListNode n1 = null;
		LinkedListNode n2 = null;
		for(int i = 1; i < 15; i++)
		{		
			n1 = n.appendToTail(i);
			if(i == 5)
				n2 = n1;
		}
		n1.next = n2;
		n1 = FindBeginningLoop(n);
		System.out.println(n1.data);
	}
}
