package leetCode.problems._Online_Stock_Span;

import java.util.LinkedList;

public class StockSpanner {
	private LinkedList<Integer> spans;
	private LinkedList<Integer> prices;
    public StockSpanner() {
    	spans = new LinkedList<>();
    	prices = new LinkedList<>();
    }
    
    public int next(int price) {
        int span = 1;
        while (!spans.isEmpty()&&prices.peekLast()<=price) {
			span+=spans.pollLast();
			prices.pollLast();
		}
        spans.add(span);
        prices.add(price);
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
