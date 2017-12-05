/* last name, first name
 * 2csa-##
 * CS 203
 * Lab Exercise 5
 */

public class SLL<T> {
    private SLLNode<T> head,tail;
    
    public SLL() {
	head = tail = null;
    }
    
    public int numElements()
    {
        int count=1;
        while (head.next != tail.next)
        {
            count++;
            head = head.next;
        }
        return count;
    }
    
    public void printDups()
    {
        SLLNode<T> headTemp1 = head,headTemp = head, tempElement=head, tailTemp=head;
        //System.out.println(headTemp1.info);
        if(((Comparable)head.info).equals((head.next).info))
            System.out.println(head.info);
        while (tailTemp.next.next != tail)
        {
            tailTemp=tailTemp.next;
        }
        if(((Comparable)tail.info).equals((tailTemp.next).info))
            System.out.println(tailTemp.info);
        while (headTemp != tail)
        {
            headTemp1 = headTemp.next;
            boolean a=true;
            while (a && headTemp1 != tail)
            {
                if (((Comparable)headTemp1.info).equals(headTemp.info))
                {
                    if (((Comparable)headTemp.info).compareTo(tempElement.info) == 0){}
                    else
                    System.out.println(headTemp.info);
                    a=false;
                    tempElement = headTemp1;
                }
                
                headTemp1 = headTemp1.next;
            }
            headTemp = headTemp.next;
        }
    }
    
    public void printNotDups()
    {
        SLLNode<T> headTemp1 = head,headTemp = head, tempElement=head, tailTemp=head;
        //System.out.println(headTemp1.info);
        if(((Comparable)head.info).equals((head.next).info))
            System.out.println(head.info);
        while (tailTemp.next.next != tail)
        {
            tailTemp=tailTemp.next;
        }
        if(((Comparable)tail.info).equals((tailTemp.next).info))
            System.out.println(tailTemp.info);
        while (headTemp != tail)
        {
            headTemp1 = headTemp.next;
            boolean a=true;
            while (a && headTemp1 != tail)
            {
                if (((Comparable)headTemp1.info).equals(headTemp.info))
                {
                    if (((Comparable)headTemp.info).compareTo(tempElement.info) == 0){}
                    else
                    System.out.println(headTemp.info);
                    a=false;
                    tempElement = headTemp1;
                }
                
                headTemp1 = headTemp1.next;
            }
            headTemp = headTemp.next;
        }
    }
    
    public void printNegative()
    {
        SLLNode<T> headTemp = head;
        while(headTemp != tail)
        {
            if (((Comparable)headTemp.info).compareTo(0) < 0)
               System.out.println(headTemp.info); 
            headTemp = headTemp.next;
        }
    }
    
    public boolean isEmpty() {
	return head == null;
    }
    
    public void addToHead(T el) {
	head = new SLLNode<T>(el,head);
	if (tail == null) tail = head;
    }
    
    public void addToTail(T el) {
	if (isEmpty()) addToHead(el);
	tail.next = new SLLNode<T>(el);
	tail = tail.next;
    }
    
    public void deleteNode(T el)
    {
        SLLNode<T> tempHead=head, tempHead1=head;
        if (isEmpty()) {}
	else if (head == tail)
        {
            if (((Comparable)head.info).compareTo(el) == 0)
                head = tail = null;
        }
        else 
        {
            while(tempHead!=tail)
            {
                if(((Comparable)tempHead.info).compareTo(el) == 0)
                {
                    if(tempHead==head)
                    head = tempHead.next;
                    else if (tempHead==tail)
                    {
                        
                    }
                    else
                    {
                        tempHead1 = tempHead.next;
                    }
                }
            }          
        }
    }
    
    public void deleteFromHead() {
	if (isEmpty()) {}
	else if (head == tail) head = tail = null;
	else head = head.next;
    }
    
    public void deleteFromTail() {
	if (isEmpty()) {}
	else if (head == tail) head = tail = null;
	else {
	    SLLNode<T> h;
	    for (h = head; h.next != tail; h = h.next) {}
	    tail = h;
	    h.next = null;
	}
    }
    
    public String toString() {
	SLLNode<T> node;
	String str = "";
	
	for (node = head; node != null; node = node.next)
	    str += node.info.toString() + " ";
	
	return str;
    }
    
    public SLLNode<T> getNode(T el) {
	SLLNode<T> node = head;
	while (node != null && ((Comparable)node.info).compareTo(el) != 0) node = node.next;
	return node;
    }
    
    public boolean isInList(T el) {
	return getNode(el) != null;
    }
    
    public void insertAfterNode(T el, SLLNode<T> node) {
	if (node != null) {
	    if (node == tail) addToTail(el);
	    else {
		SLLNode<T> insertNode = new SLLNode<T>(el,node.next);
		node.next = insertNode;
	    }
	}
    }
    
    public void insertAfterElt(T oldEL, T newEL) {
	SLLNode<T> node = getNode(oldEL);
	if (node != null) insertAfterNode(newEL, node);
    }
    
    public void insertAsc(T el) {
	if (isEmpty()) addToHead(el);
	else if (head == tail) {	
	    if (((Comparable)head.info).compareTo(el) >= 0) addToHead(el);	
	    else addToTail(el); 
	} else {	
	    SLLNode<T> prevNode = head,
		node = head.next;
	    
	    if (((Comparable)head.info).compareTo(el) >= 0) addToHead(el); 
	    else {
		while (node != null && ((Comparable)node.info).compareTo(el) <= 0) {	
		    prevNode = node;
		    node = node.next;
		}
		
		insertAfterNode(el, prevNode);
	   }
	}
    }
    
    public void insertDesc(T el) {
	if (isEmpty()) addToHead(el);
	else if (head == tail) {	
	    if (((Comparable)head.info).compareTo(el) <= 0) addToHead(el);	
	    else addToTail(el); 
	} else {	
	    SLLNode<T> prevNode = head,
		node = head.next;
	    
	    if (((Comparable)head.info).compareTo(el) <= 0) addToHead(el); 
	    else {
		while (node != null && ((Comparable)node.info).compareTo(el) <= 0) {	
		    prevNode = node;
		    node = node.next;
		}
		
		insertAfterNode(el, prevNode);
	   }
	}
    }
}