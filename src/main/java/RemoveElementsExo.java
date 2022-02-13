import java.util.Arrays;
import java.util.stream.Collectors;

public class RemoveElementsExo {

    /**
     * remove all occurrences of val in nums in-place.
     * @param nums integer array,  The relative order of the elements may be changed.
     * @param val  integer val
     * @return new length of the array without the duplicates of val
     */
    public static int removeElement(int[] nums, int val) {
        int length = nums.length;
        int first = 0;
        int last = length-1;
        while (first <= last){
            if (first == length-1){
                return length;
            }
            if (nums[first] == val && nums[last]!= val){
                nums[first] = nums[last];
                nums[last] = val;
                first ++;
                last --;
            } else if(nums[first] == val && nums[last]== val){
                last --;
            }
            else {
                first ++;
            }
        }
        return first;
    }
}
