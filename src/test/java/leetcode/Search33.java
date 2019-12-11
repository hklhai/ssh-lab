package leetcode;

/**
 * Created by Ocean lin on 2019/12/10.
 *
 * @author Ocean lin
 */
public class Search33 {

    public static void main(String[] args) {
        int[] a = {1, 3};
        int t = 3;
        System.out.println(search(a, t));
    }

    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int len = nums.length - 1;
        int l = 0, r = len;

        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] <= nums[r]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        if (target <= nums[len]) {
            r = len;
        } else {
            l = 0;
            r--;
        }

        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return target == nums[l] ? l : -1;
    }

}
