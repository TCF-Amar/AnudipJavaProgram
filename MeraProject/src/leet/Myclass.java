package leet;
import java.util.*;


class Solution {
    public List<Integer> removeElement(int[] nums, int val) {
        
        ArrayList<Integer> newArray = new ArrayList<Integer>();
        ArrayList<Integer> tempArr = new ArrayList<Integer>();
        ArrayList<Integer> conArr = new ArrayList<Integer>();


        
        for(int i:nums){
            if(i == val){
                tempArr.add(i);
            }else {
            	newArray.add(i);
            }
        }
        
        return newArray;
        
    }
}
public class Myclass {
	 public static void main(String[] args) {
		    Solution s = new Solution();
		    Scanner sc = new Scanner(System.in);
		    int size = sc.nextInt();
		    int[] nums = new int[size];
		    
		    for(int i =0; i < size; i++){
		        nums[i] = sc.nextInt();
		    }
		    
		    
		 }

}
