//Leetcode
//1095. Find in Mountain Array
//Time complexity: O(logN)
//Space complexity: O(1)

package Leetcode;

// This is MountainArray's API interface.
// You should not implement it, or speculate about its implementation
interface MountainArray {
    public int get(int index);

    public int length();
}

public class FindInMountainArray implements MountainArray {

    public static void main(String[] args) {
        
    }

    public static int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        int maxPosition = -1;
        int left = 1;
        int right = n - 2;
        int mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                left = mid + 1;
            } else {
                right = mid;
            }

        }
        maxPosition = left;
        left = 0;
        right = maxPosition;
        int me;
        while (left <= right) {
            mid = left + (right - left) / 2;
            me = mountainArr.get(mid);
            if (me == target)
                return mid;
            if (me > target)
                right = mid - 1;
            else
                left = mid + 1;
        }
        left = maxPosition;
        right = n - 1;
        while (left <= right) {

            mid = left + (right - left) / 2;
            me = mountainArr.get(mid);
            if (me == target)
                return mid;
            if (me < target)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return -1;
    }

    @Override
    public int get(int index) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public int length() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'length'");
    }
}
