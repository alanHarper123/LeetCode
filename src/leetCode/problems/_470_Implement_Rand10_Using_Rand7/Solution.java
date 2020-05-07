package leetCode.problems._470_Implement_Rand10_Using_Rand7;

/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */
class SolBase{
	
}
public class Solution extends SolBase {
	private int rand7() {
		return 0;
	}
    public int rand10() {
    	int rand = rand7();
        if(rand<4) {
        	while (true) {
				int r = rand7();
				if(r<4)
					return rand;
				else if (r>4) {
					return rand+7;
				}
			}
        }else{
            while (true) {
				int r = rand7();
				if(r<4)
					return rand;
				else if (r>4) {
					return rand10();
				}
			}
        }
        
    }
}
