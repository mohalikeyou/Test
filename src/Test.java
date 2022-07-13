import java.lang.management.ThreadMXBean;
import java.util.*;
import java.util.jar.JarEntry;

/**
 * @author CrazyYao
 * @create 2022-06-12 16:23
 */
public class Test {
    public static void main(String[] args) {
        new Solution().moveZeroes(new int[]{1,0});
    }
}

//the definition of a tree node;
class Solution {
    public void moveZeroes(int[] nums) {
        if (nums.length == 1) return;

        for (int i = 0, j = 0; i < nums.length; ++i) {
            if(nums[i] != 0) {
                nums[i] += nums[j];
                nums[j] = nums[i] - nums[j];
                nums[i] = nums[i] - nums[j];
                ++j;
            }
        }
    }
}





