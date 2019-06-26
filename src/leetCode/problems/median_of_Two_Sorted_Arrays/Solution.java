package leetCode.problems.median_of_Two_Sorted_Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

class Solution {
	private Boolean firstTime = true;
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    	double result = 0;
    	
    	Set<Integer> keypointSet = new HashSet<>();
    	if(firstTime&&nums2.length>nums1.length) {
    		int[] temp = nums2;
    		nums2 = nums1;
    		nums1 = temp;

    	}
    	
    	int m = nums1.length;
    	int n = nums2.length;
    	
    	if(n==0) {
    		if(m%2==0) {
    			result+= nums1[m/2];
    			result+=nums1[m/2-1];
    			return result/2;
    		}else {
				return nums1[m/2];
			}
    	}
    	
    	int keyPoint = Math.max(m/2-1,0);
    	keypointSet.add(keyPoint);
    	int keyPoint2 = 0;
    	
    	Boolean even = (m+n)%2==0;
    	int up1 = m-1;
    	int up2 = n-1;
    	int low1 = 0;
    	int low2 = 0;
    	
    	
    	
    	for(keyPoint2=findKeyPoint(nums1[keyPoint], nums2, low2, up2);;) {
	
    		if(keyPoint2==-1) {

    			if(keyPoint<=(m+n)/2-n) {
    				keyPoint = (m+n)/2-n;
    				if(even){
    					result+=nums1[keyPoint];
    					result+=Math.max(nums2[nums2.length-1],keyPoint-1>-1?nums1[keyPoint-1]:nums2[nums2.length-1]);
    					result/=2;
    				}else {
    					result = nums1[keyPoint];
    				}
    				return result;

    				
    			}else if (keyPoint+n-(m+n)/2==1) {
    				if(even) {
    					if(keyPoint==0) {
    						result+=nums2[nums2.length-1];
    						result+=nums2[nums2.length-2];
    						
    					}else {
    						if(nums2[nums2.length-1]>nums1[keyPoint-1]) {
    							result+=nums2[nums2.length-1];
    							
    							result+=Math.max(nums1[keyPoint-1],nums2.length-2>-1?nums2[nums2.length-2]:nums1[keyPoint-1]);
    							
    						}else {
    							result+=nums1[keyPoint-1];
    							result+=Math.max(nums2[nums2.length-1], keyPoint-2>-1?nums1[keyPoint-2]:nums2[nums2.length-1]);
							}
    					}
    					result/=2;
    				}else {
						result+=Math.max(nums2[nums2.length-1], keyPoint-1>-1?nums1[keyPoint-1]:nums2[nums2.length-1]);
					}
					return result;
					
				}else {
    				up1=keyPoint;
    				keyPoint = Math.max(keyPoint - Math.max((n+keyPoint-(m+n)/2)/2, 1), low1);
    				
    			}
    			
    		}else if(keyPoint2 == -2) {
    			if(keyPoint>=(m+n)/2) {
    				keyPoint = (m+n)/2;
    				result += nums1[keyPoint];
    				if(even){
    					result += nums1[keyPoint-1];
    					result /= 2;
    				}
    					
    				return result;
    			}else if ((m+n)/2-keyPoint==1) {
    				result += Math.min(nums2[0], keyPoint+1<nums1.length?nums1[keyPoint+1]:nums2[0]);
    				if(even){
    					result += nums1[keyPoint];
    					result /= 2;
    				}
					return result;
				}else {
					low1 = keyPoint;
					keyPoint = Math.min(keyPoint+Math.max(((m+n)/2-keyPoint)/2, 1), up1);
					
				}
    			
    		}else {
    			if(keyPoint+keyPoint2+1>(m+n)/2) {
    				if(keyPoint+keyPoint2+1-(m+n)/2==1) {
    					if(keyPoint-1>-1) {
    						if(nums1[keyPoint-1]>nums2[keyPoint2]) {
    							result = nums1[keyPoint-1];
    							if(even) {
    								if(keyPoint-2>-1) result+= Math.max(nums1[keyPoint-2], nums2[keyPoint2]);
    								else {
										result += nums2[keyPoint2];
									}
    								result /= 2;
    							}
    							
    						}else {
    							result = nums2[keyPoint2];
    							if (even) {
    								if(keyPoint2-1>-1) result += Math.max(nums1[keyPoint-1], nums2[keyPoint2-1]);
									else result += nums1[keyPoint-1];
    								result /= 2;
								}
    						}
    					}else {
    						result = nums2[keyPoint2];
    						if(even) {
    							result += nums2[keyPoint2-1];
    							result /= 2;
    						}
    					}
    					return result;
    				}

    				keyPoint = Math.max(keyPoint - Math.max((keyPoint2+keyPoint-(m+n)/2)/2, 1), low1);

    				
    			}else if(keyPoint+keyPoint2+1<(m+n)/2) {
    				if(keyPoint+keyPoint2+1-(m+n)/2==-1) {
    					
    					result = Math.min(nums2[keyPoint2+1], keyPoint+1<nums1.length?nums1[keyPoint+1]:nums2[keyPoint2+1]);

    					if (even) {
    						result += nums1[keyPoint];
    						result /= 2;
 
    					}

    					return result;
    				}
    				
    				keyPoint = Math.min(keyPoint+Math.max(((m+n)/2-keyPoint-keyPoint2)/2, 1), up1);

    			}else {
    				result+= nums1[keyPoint];
    				
					if(even) {
						result += Math.max(nums2[keyPoint2], keyPoint>0?nums1[keyPoint-1]:nums2[keyPoint2]);
						result/=2;
					}
					return result;
					
    			}
    		}
    		if(keypointSet.contains(keyPoint)) {
				firstTime = false;

				return findMedianSortedArrays(nums2, nums1);
			}else keypointSet.add(keyPoint);
    		keyPoint2 = findKeyPoint(nums1[keyPoint], nums2, low2, up2);
    		
    			
		}		

    }
    public static void main(String[] args) {
		int[] test1 = {1,2,6};
		int[] test2 = {3,4,5};
		int[] test3 = {1,2,3,4,5,6,7,8,9};
		int[] test4 = {0,1,2,3,4,5,6,7,8,9,10};
//		Integer[] test5 = {null,null,1,2};
//		ArrayList<Integer> askdajhdk = new ArrayList<>(Arrays.asList(test5));
//		Collections.sort(askdajhdk);
//		System.out.println(askdajhdk);
		Solution solution = new Solution();
		System.out.println(solution.findMedianSortedArrays(test1,test2));
		for(int i : test4) {
			System.out.println(findKeyPoint(i, test3, 0, test3.length-1));
		}
		
		
	}
    
    public static int findKeyPoint(int keyPoint, int[] nums, int low, int up1) {

    	int up = up1;
    	if (keyPoint<nums[low]) {
    		return -2;
    	}else if(keyPoint>=nums[up]) {
    		return -1;
    	}
    	
    	for(int i = (up+low)/2; ;) {
    		if (nums[i]<=keyPoint) {
    			if(keyPoint<nums[i+1]) {
    				return i;
    			}else {
					low = i;
					i = (up+low)/2;
				}
    		}else {
    			up = i;
    			i = (up+low)/2;
    		}
    	}
    	
	}
}
