package offer;

/**
 * Created by Ocean lin on 2019/5/27.
 *
 * @author Ocean lin
 */
public class MaxSum {

    public static void main(String[] args) {
//        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
//        int[] nums = {1};
        int[] nums = {-2, 1};
//        int[] nums = {1, 2};
        System.out.println(maxSubArray(nums));
    }

    /**
     * 1. a[i] > 0，否则我们完全可以去掉a[i]这个元素 而得到一个更大的和；
     * 2. i > 0且a[i - 1] < 0 或 i == 0，下面假设i > 0，这一条性质也是因为如果a[i - 1] > 0的话我们求和时可以加上a[i - 1]这个元素得到一个更大的和；
     * 3. 元素a[i - 1]与它之前的任一元素之间的子串之和sum < 0 ，即对于任何一个m(0 <= m < i - 1)，则有a[m] + a[m + 1] + ... + a[i - 1] < 0，这条性质同样可以用反证法证明。
     * <p>
     * <p>
     * 只要找到分解点 a[i - 1]，最大和的子串要么就在a[i - 1]元素之后，要么就在a[i - 1]之前，最大和的子串不可能跨过a[i - 1]这个点
     * 一个数组中可能有多个这种分界点，但每个分界点都可以把前后完全分开，可以单独算分界点之间的最大和，然后在这些最大和之间取最大值
     *
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int sumMax = nums[0];
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            if (sum > sumMax) {
                sumMax = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        return sumMax;
    }
}
