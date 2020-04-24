package leetCode.problems._432_All_O_one_Data_Structure;


import java.util.HashMap;


class Node{
	String key;
	int val;
	Node pre;
	Node next;
	public Node(String key,int val) {
		this.key=key;
		this.val=val;
	}
}
public class AllOne {

	private HashMap<String, Node> allNodes = new HashMap<>();
	private HashMap<Integer, Node[]> valtoHeadTails = new HashMap<>();
	private Node minNode;
	private Node maxNode;
	/** Initialize your data structure here. */
	public AllOne() {
	}

	/** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
	public void inc(String key) {
		Node target = allNodes.get(key);
		if(target==null) {
			target = new Node(key, 1);
			target.next = minNode;
			if(minNode!=null)
				minNode.pre = target;
			minNode=target;
			allNodes.put(key, target);
		} else  {
			int targetVal = target.val;
			target.val++;
			Node[] preHeadTail = valtoHeadTails.get(targetVal);
			if(target==minNode) {
				if(preHeadTail[0]==target) {
					if(target.next!=null&&target.next.val==targetVal)
						minNode = target.next;
				}else {
					minNode = preHeadTail[0];
				}

			}
			if(preHeadTail[0]==target) {
				if(target.next!=null&&target.next.val==targetVal) {
					preHeadTail[0]=target.next;
				}else 
					preHeadTail[0]=null;
			}
			if(preHeadTail[1]!=target){
				if(target.pre!=null) {
					target.pre.next = target.next;
				}
				if(target.next!=null) {
					target.next.pre = target.pre;
				}
				target.next = preHeadTail[1].next;
				if(preHeadTail[1].next!=null)
					preHeadTail[1].next.pre = target;
				target.pre = preHeadTail[1];
				preHeadTail[1].next = target;
			}else {
				if(target.pre!=null&&target.pre.val==targetVal) {
					preHeadTail[1]=target.pre;
				}else {
					preHeadTail[1]=null;
				}
			}
			if(preHeadTail[0]==null&&preHeadTail[1]==null) {
				valtoHeadTails.remove(targetVal);
			}else {
				if(preHeadTail[0]==null)
					preHeadTail[0]=preHeadTail[1];
				if(preHeadTail[1]==null)
					preHeadTail[1]=preHeadTail[0];
			}
		}
		
		Node[] postHeadTail = valtoHeadTails.get(target.val);
		if(postHeadTail==null) {
			postHeadTail = new Node[] {target, target};
			valtoHeadTails.put(target.val, postHeadTail);
			if(maxNode==null||maxNode.val<target.val)
				maxNode = target;
		}else {
			postHeadTail[0] = target;
		}
		
	}

	/** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
	public void dec(String key) {
		Node target = allNodes.get(key);
		if(target!=null) {
			int targetVal = target.val;
			target.val--;
			Node[] preHeadTail = valtoHeadTails.get(targetVal);
			if(target == maxNode) {
				if(preHeadTail[1]==target) {
					if(target.pre!=null&&target.pre.val==targetVal)
						maxNode = target.pre;
				}
				else {
					maxNode=preHeadTail[1];
				}
			}
				
			if(preHeadTail[1]==target) {
				if(target.pre!=null&&target.pre.val==targetVal) {
					preHeadTail[1]=target.pre;
				}else {
					preHeadTail[1]=null;
				}
			}
				
			if(preHeadTail[0]!=target){
				if(target.pre!=null)
					target.pre.next = target.next;
				if(target.next!=null)
					target.next.pre = target.pre;
				target.next = preHeadTail[0];
				target.pre = preHeadTail[0].pre;
				if(preHeadTail[0].pre!=null)
					preHeadTail[0].pre.next = target;
				preHeadTail[0].pre = target;
			}else {
				if(target.next!=null&&target.next.val==targetVal) {
					preHeadTail[0]=target.next;
				}else {
					preHeadTail[0]=null;
				}
				
			}
			if(preHeadTail[0]==null&&preHeadTail[1]==null){
					valtoHeadTails.remove(targetVal);
			}else {
				if(preHeadTail[0]==null)
					preHeadTail[0]=preHeadTail[1];
				if(preHeadTail[1]==null)
					preHeadTail[1]=preHeadTail[0];
			}
			
			if(target.val==0) {
				allNodes.remove(key);
				if(target==minNode)
					minNode = minNode.next;
				if(target==maxNode)
					maxNode = target.pre;
			}else {
				Node[] postHeadTail = valtoHeadTails.get(target.val);
				if(postHeadTail==null) {
					postHeadTail = new Node[] {target,target};
					valtoHeadTails.put(target.val, postHeadTail);
					if(minNode.val>target.val)
						minNode = target;
				}else {
					postHeadTail[1]=target;
				}
			}
		}
				
	}

	/** Returns one of the keys with maximal value. */
	public String getMaxKey() {
		return maxNode==null?"":maxNode.key;
	}

	/** Returns one of the keys with Minimal value. */
	public String getMinKey() {
		return minNode==null?"":minNode.key;
	}
	public static void main(String[] args) {
		AllOne allOne = new AllOne();
		allOne.inc("hello");
		allOne.inc("world");
		allOne.inc("leet");
		allOne.inc("code");
		allOne.inc("DS");
		allOne.inc("leet");
		System.out.println(allOne.getMaxKey());
		allOne.inc("DS");
		allOne.dec("leet");
//		allOne.inc("a");
//		allOne.inc("b");
//		allOne.inc("c");
//		allOne.inc("d");
//		allOne.inc("a");
//		allOne.dec("b");
//		allOne.dec("c");
//		allOne.inc("d");
//		allOne.inc("c");
//		allOne.inc("d");
//		allOne.dec("d");
//		allOne.inc("a");
		System.out.println(allOne.getMaxKey());
		
	}
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
