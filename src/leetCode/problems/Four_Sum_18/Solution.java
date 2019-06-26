package leetCode.problems.Four_Sum_18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

	public List<List<Integer>> fourSum(int[] nums, int target) {
		Arrays.sort(nums);
		ArrayList<List<Integer>> result = new ArrayList<>();

		for (int i = 0; i < nums.length-3; i++) {
			for (int j = i+1; j < nums.length-2; j++) {
				for (int k = j+1; k < nums.length-1; k++) {
					int temp = target - nums[i] - nums[j] - nums[k];
					if(temp<nums[k+1]) {
						break;
					}
					if(temp>nums[nums.length-1]) {
						continue;
					}
					int b1=k+1, e1=nums.length-1;
					while (e1-b1>1) {
						int mid = (e1+b1)/2;
						if(temp>nums[mid]) {
							b1 = mid;
						}else if (temp<nums[mid]) {
							e1=mid;
						}else {
							ArrayList<Integer> element = new ArrayList<>(Arrays.asList(
									nums[i],nums[j],nums[k],nums[mid]));
							addElement(result, element);
							break;
						}
					}
					int rightV = k;
					if(temp==nums[b1]) {
						rightV = b1;
					}else if (temp == nums[e1]) {
						rightV = e1;
					}
					if (rightV == k) {
						continue;
					}else {
						ArrayList<Integer> element = new ArrayList<>(Arrays.asList(
								nums[i],nums[j],nums[k],nums[rightV]));
						addElement(result, element);
					}
				}
			}
		}
		
		return result;
	}
	Boolean addElement(List<List<Integer>> result, ArrayList<Integer> element) {
		
		if(result.size()!=0) {
			label1: for (int i = result.size()-1; i >= 0; i--) {
				List<Integer> ielement = result.get(i);
				if(ielement.get(0).intValue()!=element.get(0).intValue()) {
					break;
				}else {
					for (int j = 1; j < element.size(); j++) {
						if(element.get(j).intValue()!=ielement.get(j).intValue()) {
							continue label1;
						};
					}
					return false;
				}
			}
		}
//		System.out.println(element);
		result.add(element);
		return true;
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] zxcv = {-497,-494,-484,-477,-453,-453,-444,-442,-428,-420,-401,
				-393,-392,-381,-357,-357,-327,-323,-306,-285,-284,-263,-262,
				-254,-243,-234,-208,-170,-166,-162,-158,-136,-133,-130,-119,
				-114,-101,-100,-86,-66,-65,-6,1,3,4,11,69,77,78,107,108,108,
				121,123,136,137,151,153,155,166,170,175,179,211,230,251,255,
				266,288,306,308,310,314,321,322,331,333,334,347,349,356,357,
				360,361,361,367,375,378,387,387,408,414,421,435,439,440,441,470,492
				};
		List<List<Integer>> result = solution.fourSum(zxcv, 1682);
		for (List<Integer> list : result) {
//			System.out.println(list+"\n");
		}
		System.out.println(result.size());
		List<List<Integer>> result2 = new ArrayList<>();
		ArrayList<Integer> element = new ArrayList<>(Arrays.asList(333, 387, 470, 492));
		result2.add(element);
		System.out.println(solution.addElement(result2, element));
	}
}
