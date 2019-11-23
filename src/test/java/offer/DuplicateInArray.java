package offer;

/**
 * Created by Ocean lin on 2019/11/22.
 *
 * @author Ocean lin
 */
public class DuplicateInArray {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1};
        int i = duplicateInArray(nums);
        System.out.println(i);
    }

    public static int duplicateInArray(int[] nums) {
        int l = 1, r = nums.length;
        while (l < r) {
            int mid = (l + r) >> 1;
            int s = 0;
            for (int n : nums) {
                if (n >= l && n <= mid) {
                    s++;
                }
            }
            if (s > mid - l + 1) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }

}
