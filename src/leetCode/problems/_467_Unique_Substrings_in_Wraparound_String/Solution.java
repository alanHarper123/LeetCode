package leetCode.problems._467_Unique_Substrings_in_Wraparound_String;

public class Solution {
    public int findSubstringInWraproundString(String p) {
    	if(p==null||p.length()==0)
    		return 0;
    	
    	int[] uniqueCombos = new int[26];
    	int count = 1;
    	int dif = 0;
    	for (int i = 1; i < p.length();i++) {
			while (i < p.length()
					&&((dif=p.charAt(i)-p.charAt(i-1))==1
					||(p.charAt(i)=='a'&&dif==-25))) {
				count++;
				i++;
			}
			int comboi = p.charAt(i-count)-'a';

			uniqueCombos[comboi] = Math.max(uniqueCombos[comboi], count);
			count=1;
		}
    	
    	long uniqueCount = 0;
//    	int roudtripEnd = Math.min(0, uniqueCombos[0]-26);
    	uniqueCount += countCombinations(uniqueCombos[0]);

    	for (int i = 1; i < uniqueCombos.length; i++) {
    		int shadow = Math.max(uniqueCombos[i-1]-1, 0);
			if(uniqueCombos[i]>shadow) {
//				roudtripEnd = Math.min(i, uniqueCombos[i]-26+i);
	    		uniqueCount+=countCombinations(uniqueCombos[i])-countCombinations(shadow);

			}else {
				uniqueCombos[i] = shadow;
			}
		}
        
        int shadowU = Math.max(uniqueCombos[25], 0);
        int shadowCurrent = 1;
        for (int i = 0; i <p.length()&&shadowU>0; i++) {
        	shadowU--;
        	shadowCurrent = Math.max(shadowCurrent-1, 0);
        	if(uniqueCombos[i]==shadowCurrent) {
        		uniqueCombos[i] = shadowU;
        		continue;
        	}

			if(uniqueCombos[i]< shadowU) {
				uniqueCount -= countCombinations(uniqueCombos[i])-countCombinations(shadowCurrent);
				shadowCurrent = uniqueCombos[i];
				
			}else {
				uniqueCount -= countCombinations(shadowU)-countCombinations(shadowCurrent);
				break;
			}
			
		}
        int last =p.charAt(p.length()-1)-'a';
        if(uniqueCombos[last]==0)
    		uniqueCount++;
    	return (int)uniqueCount;
    }
    private long countCombinations(long n) {
    	long c = 0;

    		c+=n*(n+1)/2;
    	
    	return c;
    }
    public static void main(String[] args) {
		Solution solution = new Solution();
//		System.out.println(solution.findSubstringInWraproundString("vwxyefghijklmnopqrsomnopqrstuvefghijklmklmnopqrsqrstefghijklmnopqpqrstuvwxyzidefghijbcefghijklmnopqrstuvwghijklmnopqrstuvwhijklmnopbcdefghijklmnopopqrstuvwxyzstuvwxyfghijklmnopqrstuvwxyzmnopqrstuvwxyzhijklmnopfghijklfghijklmnopfghijklmnopqrsttuvwxabcdefghijklmnjklmnopqrstuvwxijklmnopabcdefghijklmnopqopqrstuvfghijklmnopqrstuvefghijkklmnopqrstuvabcdefghijklmnopqabcdefklmnopqefghijklmnopqrmbcdefghmnopqrstulnopqrstklmnopqrstuvwstuvnopqrstuvwxytuvwxhijklmnopqrstuvwxyzijklmnopqrstuabcdefghipqrstulabcdefghijklmnopijklmnopqrsabcdefgcdefghijklmnopqfghijklmnopqrfghijklmnohijklmnopqrstuvwxyzabcdhijklmnopqrstuvghijkrstuvwxyzabcdefghijklmnopqrcdefghijklmfghijklmnopqrstuvghijlmnopopqrstuvwxyjklmndefghijklmnopqrstuvwjklmghijklmnopqrstuvwxyfghijklmdefghijklmnopqrstuvwxfghijklmnopqrshijklmnopqcdefghiabcdefghijklmnopqrsttuvwuvwxyzhijklmnofghijkllmnopqrstuvwxnopqrhijklmnopqrstuvwxyzjklmnopqrstuvwxefghiefghijklmnopqrtuvwxpqrstuvklmnabcdefghijklmnopklefghijklmnopqrstuvjklmnopqrsbcdefghijkcdefghijklmfghijklmnopqrstuv"));
//		System.out.println(solution.findSubstringInWraproundString("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz"));
		System.out.println(solution.findSubstringInWraproundString(
				"tuvwxbcdqrabfghijklmnopqrstuvwxyjklmnohijklmnopqnopqrstudefghijkjklmnopqnopqrstuklmabcdefghefghijdefghijklmnopqropqrstuvwxyzhijklmnopqrsthijklmnopqrsabcdefghijklmnopqrstqrstuvwefghighijklmnopqrstughijklmnopqqrstuvwxyzbcdabcdefghijklmnopqqrstuvwxyefghijklmnopqrstuvcdefefmnopqlmnopqrfghijklmnopqrstuvwxvwdeffghijklmnopqrstuvwxyrstuvwxyzhijklmnopqrsstuklmnopqrstuhijklmcdefghijklmnoplmnopqijklmnopqrsijklmnopqrstucdefghijklijklmhijklmnopqrstuvwmnopqrklmnoiijklmnobcdefghijklmqrstuvwxyfghijklrstuvwxyefghijklmnopqrsghijklmnopqrstuvopqabcdefklmnmnoprstfghijklmnopqrshijklmnopqrstbcdefghijklmnopqrstuvmnopqrstuvwxyzmnopqrstuvcdefghijjklmnopqrstuvwxymnopqrstuvwxmnopqropqrstuvwxcdefgcdefghijklmnopqrstuvwxybcdefghijkdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwfghijklmnopqrstjkijklmbcdefghijklmnopqcdefghijklmnomnopqrstefghijklmnopqrstlmnopqrstuvwxycdefghijklcdefghijklmnopqrstuvwxycdefghijklmnopqrstuvwxdefghighijklrstuvcdefghijklmnopqbcdefgh"));
	}
}
