package leetCode.problems._900_RLE_Iterator;

public class RLEIterator {
	int index = 0;
	int count = 0;
	int[] base;
	int pre = -1;
	int res;
    public RLEIterator(int[] A) {
        base = A;
    }
    
    public int next(int n) {
        if(index>=base.length) {
        	res = -1;
        }else {
        	if(n>=base[index]-count) {
            	n-=base[index]-count;
            	index+=2;
                while (index<base.length&&n>=base[index]) {
                	if(base[index]>0)
                		pre = base[index+1];
                	n-=base[index];
                	index+=2;
    			}			
    			count = n;
    			if(count==0) {
    				res = pre;
    			}
    			else {
    				res = index<base.length?base[index+1]:-1;
    			}
            }else {
            	count+=n;
            	res = base[index+1];
            }
            
        }
        pre = res;	
        return res;
    }
    public static void main(String[] args) {
    	RLEIterator rleIterator = new RLEIterator(new int[] {635,606,576,391,370,981,36,21,961,185,124,210,801,937,22,426,101,260,221,647,350,180,504,39,101,989,199,358,732,839,919,169,673,967,58,676,846,342,250,597,442,174,472,410,569,509,
    			311,357,838,251});
		rleIterator.next(5039);
		rleIterator.next(62);
		rleIterator.next(3640);
		rleIterator.next(671);
		rleIterator.next(67);
		rleIterator.next(395);
		rleIterator.next(262);
		rleIterator.next(839);
		rleIterator.next(74);
		rleIterator.next(43);
		rleIterator.next(42);
		rleIterator.next(77);
	}
}
/**
 * Your RLEIterator object will be instantiated and called as such:
 * RLEIterator obj = new RLEIterator(A);
 * int param_1 = obj.next(n);
 */