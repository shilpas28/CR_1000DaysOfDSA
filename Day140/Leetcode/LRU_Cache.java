//Leetcode
//146. LRU Cache
//Time complexity: Just a class design
//Space complexity: Just a class design

package Leetcode;

import java.util.LinkedHashMap;

public class LRU_Cache {

    static class LRUCache {

        public int _capacity;
        public LinkedHashMap<Integer, Integer> _map;

        public LRUCache(int capacity) {
            _capacity = capacity;
            _map = new LinkedHashMap<Integer, Integer>();
        }

        public int get(int key) {
            if (_map.containsKey(key)) {
                int val = _map.get(key);
                _map.remove(key);
                _map.put(key, val);
                return val;
            }
            return -1;
        }

        public void put(int key, int value) {
            if (_map.containsKey(key))
                _map.remove(key);
            else if (_map.size() == _capacity)
                _map.remove(_map.keySet().iterator().next());
            _map.put(key, value);
        }
    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        lRUCache.get(1); // return 1
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        lRUCache.get(2); // returns -1 (not found)
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        lRUCache.get(1); // return -1 (not found)
        lRUCache.get(3); // return 3
        lRUCache.get(4); // return 4
    }
}
