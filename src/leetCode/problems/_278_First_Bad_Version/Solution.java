package leetCode.problems._278_First_Bad_Version;


public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int end = n,k;
        while (true) {
        	k=1;
        	while (isBadVersion(end-k)) {
        		end -= k;
            	k=k<<1;
    		}
        	if(k==1)
        		break;
        	k=k>>1;
        	
        	while (!isBadVersion(end-k)) {
        		k=k>>1;
			}
        	end -= k;
		}
        
        return end;
    }
}
