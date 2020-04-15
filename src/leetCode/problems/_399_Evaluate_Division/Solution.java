package leetCode.problems._399_Evaluate_Division;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class Node{
	String string;
	public Node(String s) {
		this.string = s;
	}
	LinkedList<Node> nexts = new LinkedList<>();
	LinkedList<Double> quotients = new LinkedList<>();
}
public class Solution {
	private HashMap<String, Node> nodes;
    public double[] calcEquation(List<List<String>> equations,
    		double[] values, List<List<String>> queries) {
    	nodes = new HashMap<>();
    	int i=0;
    	for(List<String> list:equations) {
    		String divident = list.get(0);
    		String divisor = list.get(1);
    		Node dividentNode = nodes.get(divident);
    		Node divisorNode = nodes.get(divisor);
    		if(dividentNode==null) {
    			dividentNode = new Node(divident);
    			nodes.put(divident, dividentNode);
    		}
    		if(divisorNode==null) {
    			divisorNode = new Node(divisor);
    			nodes.put(divisor, divisorNode);
    		}
    		dividentNode.nexts.add(divisorNode);
    		dividentNode.quotients.add(values[i]);
    		divisorNode.nexts.add(dividentNode);
    		divisorNode.quotients.add(1/values[i]);
    		i++;
    	}
    	double[] answers = new double[queries.size()];
    	int answeri=0;
    	for (List<String> query:queries) {
    		Double answer = null;
    		Node dividentNode = nodes.get(query.get(0));
    		Node divisorNode = nodes.get(query.get(1));
    		if(dividentNode!=null&&divisorNode!=null) {
    			if(dividentNode==divisorNode)
    				answer = 1.0;
    			else {
    				HashSet<Node> nodesVisted = new HashSet<>();
    				LinkedList<Node> frontiers = new LinkedList<>();
    				LinkedList<Double> frontierQuotients = new LinkedList<>();
    				frontiers.add(dividentNode);
    				nodesVisted.add(dividentNode);
    				frontierQuotients.add(1.0);
    				bfs : while (!frontiers.isEmpty()) {
    					Node frontier = frontiers.pollFirst();
    					Double frontierQuotient = frontierQuotients.pollFirst();
						Iterator<Double> quotientIter=frontier.quotients.listIterator(0);
    					for (Iterator<Node> iterator = frontier.nexts.listIterator(0);
    							iterator.hasNext();) {
							Node next = iterator.next();
							Double quotient = quotientIter.next()*frontierQuotient; 
							if(next==divisorNode) {
								answer = quotient;
								break bfs;
							}else if(!nodesVisted.contains(next)) {
								nodesVisted.add(next);
								frontiers.add(next);
								frontierQuotients.add(quotient);
							}
								
						}
    				}
    			}
    		}
    		if(answer==null)
    			answer=-1.0;
    		answers[answeri++]=answer;
		}
    		
        return answers;
    }
}
