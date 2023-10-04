//Leetcode
//706. Design HashMap
//Time complexity: This is just a class design
//Space complexity: This is just a class design

package Leetcode;

public class DesignHashMap {

    static class MyHashMap {

        private int[] _v = new int[1000001];

        public MyHashMap() {
            for (int i = 0; i < 1000001; ++i)
                _v[i] = -1;
        }

        public void put(int key, int value) {
            _v[key] = value;
        }

        public int get(int key) {
            return _v[key];
        }

        public void remove(int key) {
            _v[key] = -1;
        }
    }

    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(1, 1); // The map is now [[1,1]]
        myHashMap.put(2, 2); // The map is now [[1,1], [2,2]]
        System.out.println(myHashMap.get(1)); // return 1, The map is now [[1,1], [2,2]]
        System.out.println(myHashMap.get(3)); // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
        myHashMap.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
        System.out.println(myHashMap.get(2)); // return 1, The map is now [[1,1], [2,1]]
        myHashMap.remove(2); // remove the mapping for 2, The map is now [[1,1]]
        System.out.println(myHashMap.get(2)); // return -1 (i.e., not found), The map is now [[1,1]]

    }
}
