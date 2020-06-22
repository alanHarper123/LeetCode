package leetCode.problems._707_Design_Linked_List;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

class Node {
	int val;
	Node next;
	public Node(int val,Node next) {
		this.val = val;
		this.next = next;
	}
}
public class MyLinkedList {
	
	private int size = 0;
	Node headNode = null;
	Node tailNode = null;
    /** Initialize your data structure here. */
    public MyLinkedList() {
        
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index<0||index>=size)
        	return -1;
        Node runner = headNode;
        int count = 0;
        while (count<index) {
			count++;
			runner=runner.next;
		}
        return runner.val;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        headNode = new Node(val, headNode);
        size++;
        if(size==1)
        	tailNode = headNode;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
    	size++;
        Node newTail = new Node(val, null);
        if(tailNode!=null) {
        	tailNode.next = newTail;
        }else {
        	headNode = newTail;
        }
        tailNode = newTail;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index==0) {
        	addAtHead(val);
        }else if(index>0&&index<size) {
        	size++;
            Node runner = headNode;
            Node pre = null;
            int count = 0;
            while (count<index) {
    			count++;
    			pre = runner;
    			runner=runner.next;
    		}
            Node newNode = new Node(val, runner);
            pre.next = newNode;
        }else if(index==size) {
        	addAtTail(val);
        }
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index>=0&&index<size) {
        	size--;
        	if(index==0) {
        		headNode = headNode.next;
            	if(headNode==null)
            		tailNode = null;
        	}else {
        		 Node runner = headNode;
                 Node pre = null;
                 int count = 0;
                 while (count<index) {
         			count++;
         			pre = runner;
         			runner=runner.next;
         		}
                pre.next = runner.next;
                if(index==size)
                	tailNode = pre;
        	}
        }
    }
    public int[] nextInt(String data,int start) {
    	char c;
    	while ((c=data.charAt(start))<'0'||c>'9') {
			start++;
		}
    	int val = 0;
    	while (start<data.length()&&(c=data.charAt(start))>='0'&&c<='9') {
			val*=10;
			val+=c-'0';
			start++;
		}
    	return new int[] {val,start};
    }
    public static void main(String[] args) {
    	MyLinkedList linkedList = new MyLinkedList();
    	try {
			BufferedReader br = new BufferedReader(new FileReader(
					new File("F:\\codeJava\\practice\\leetCode\\src\\leetCode\\problems\\_707_Design_Linked_List\\gg")));
			String data1 = br.readLine();
			data1 = data1.substring(1, data1.length()-1);
			String data2 = br.readLine();
			data2 = data2.substring(1, data2.length()-1);
			String[] data1arr = data1.split(",");
			int start = 0;
			for (int i = 1; i < data1arr.length; i++) {
				String op = data1arr[i];
				switch (op) {
				case "\"addAtHead\"":
					int[] par1 = linkedList.nextInt(data2, start);
					start = par1[1];
					linkedList.addAtHead(par1[0]);
					break;
				case "\"addAtTail\"":
					int[] par2 = linkedList.nextInt(data2, start);
					start = par2[1];
					linkedList.addAtTail(par2[0]);
					break;
				case "\"get\"":
					int[] par3 = linkedList.nextInt(data2, start);
					start = par3[1];
					linkedList.get(par3[0]);
					break;
				case "\"deleteAtIndex\"":
					int[] par4 = linkedList.nextInt(data2, start);
					start = par4[1];
					linkedList.deleteAtIndex(par4[0]);
					break;
				case "\"addAtIndex\"":
					int[] par5 = linkedList.nextInt(data2, start);
					start = par5[1];
					int[] par6 = linkedList.nextInt(data2, start);
					start = par6[1];
					linkedList.addAtIndex(par5[0],par6[0]);
					break;
				default:
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
