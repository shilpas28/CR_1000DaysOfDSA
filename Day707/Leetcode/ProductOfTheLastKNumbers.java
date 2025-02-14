//Leetcode
//1352. Product of the Last K Numbers
//Time complexity: O(1) - Adding a number involves a single operation of updating the list.
//O(1) - Getting the product involves a single division operation.
//Space complexity: O(n), Space used by the list to store cumulative products, where n is the number of elements added.

import java.util.ArrayList;
import java.util.List;

public class ProductOfTheLastKNumbers {

    public static void main(String[] args) {
        ProductOfNumbers productOfNumbers = new ProductOfNumbers();
        productOfNumbers.add(3); // [3]
        productOfNumbers.add(0); // [3,0]
        productOfNumbers.add(2); // [3,0,2]
        productOfNumbers.add(5); // [3,0,2,5]
        productOfNumbers.add(4); // [3,0,2,5,4]
        System.out.println(productOfNumbers.getProduct(2)); // return 20. The product of the last 2 numbers is 5 * 4 =
                                                            // 20
        System.out.println(productOfNumbers.getProduct(3)); // return 40. The product of the last 3 numbers is 2 * 5 * 4
                                                            // = 40
        System.out.println(productOfNumbers.getProduct(4)); // return 0. The product of the last 4 numbers is 0 * 2 * 5
                                                            // * 4 = 0
        productOfNumbers.add(8); // [3,0,2,5,4,8]
        System.out.println(productOfNumbers.getProduct(2)); // return 32. The product of the last 2 numbers is 4 * 8 =
                                                            // 32
    }

    static class ProductOfNumbers {

        List<Integer> listProduct;
        public ProductOfNumbers() {
            listProduct = new ArrayList<>();
            listProduct.add(1);
        }

        public void add(int num) {
            if (num == 0) {
                listProduct = new ArrayList<>();
                listProduct.add(1);
            } else {
                listProduct.add(listProduct.get(listProduct.size() - 1) * num);
            }
        }

        public int getProduct(int k) {
            if (k > listProduct.size() - 1) {
                return 0;
            } else {
                return listProduct.get(listProduct.size() - 1) / listProduct.get(listProduct.size() - 1 - k);
            }
        }
    }
}
