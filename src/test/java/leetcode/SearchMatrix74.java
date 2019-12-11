package leetcode;

/**
 * Created by Ocean lin on 2019/12/11.
 *
 * @author Ocean lin
 */
public class SearchMatrix74 {

    public static void main(String[] args) {
        int[][] matrix = {{1, 3}};
        int target = 3;
        System.out.println(searchMatrix(matrix, target));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int n = matrix.length;
        int m = matrix[0].length;

        /**
         for(int i = m-1 ; i >=0 ; i --){
         for(int j = 0 ; j < n ; j++){
         if(matrix[i][j]==target){
         return true;
         }
         }
         }
         return false;**/
        int l = 0, r = m * n - 1;

        while (l < r) {
            int mid = l + r >> 1;
            if (matrix[mid / m][mid % m] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return matrix[l / m][l % m] == target;
    }
}
