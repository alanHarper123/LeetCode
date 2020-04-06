package leetCode.problems._374_Guess_Number_Higher_or_Lower;
/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is lower than the guess number
 *			      1 if num is higher than the guess number
 *               otherwise return 0
 * int guess(int num);
 */
class GuessGame{
	int guess(int num) {
		return 0;
	}
}
public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int start = 1; int end = n;
        int mid;
        while (start<=end) {
        	mid = start+(end-start)/2;
        	int guess = guess(mid);
        	if(guess==0)
        		return mid;
        	else if(guess<0)
        		end = mid-1;
        	else
        		start = mid+1;
		}
        return 0;
    }
}
