//Leetcode
//2353. Design a Food Rating System
//Time complexity: Constructor: O(n*log(n)), where n is the number of foods. We need to iterate through each food and insert into 
//PriorityQueues. changeRating: O(log(n)), where n is the number of foods. PriorityQueue operations take logarithmic time.
//highestRated: O(log(n)), where n is the number of foods. Removing from PriorityQueue takes logarithmic time.
//Space complexity: Constructor: O(n) : changeRating: O(1) : highestRated: O(1).

package Leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class DesignAFoodRatingSystem {

    static class FoodRatings {

        public class Info {
            String food;
            String cuisine;
            int rating;

            public Info(String food, String cuisine, int rating) {
                this.food = food;
                this.cuisine = cuisine;
                this.rating = rating;
            }
        }

        Map<String, PriorityQueue<Info>> cuisineMap;
        Map<String, Info> foodMap;

        public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
            cuisineMap = new HashMap<>();
            foodMap = new HashMap<>();
            for (int i = 0; i < foods.length; i++) {
                Info combo = new Info(foods[i], cuisines[i], ratings[i]);
                foodMap.put(foods[i], combo);
                if (cuisineMap.containsKey(cuisines[i])) {
                    cuisineMap.get(cuisines[i]).add(combo);
                } else {
                    PriorityQueue<Info> pq = new PriorityQueue<Info>(new Comparator<Info>() {
                        @Override
                        public int compare(Info a, Info b) {
                            int result = b.rating - a.rating;
                            if (result == 0) {
                                return (a.food).compareTo(b.food);
                            }
                            return result;
                        }
                    });
                    pq.add(combo);
                    cuisineMap.put(cuisines[i], pq);
                }
            }
        }

        public void changeRating(String food, int newRating) {
            Info prev = foodMap.get(food);
            Info curr = new Info(food, prev.cuisine, newRating);
            foodMap.put(food, curr);
            prev.food = "";
            cuisineMap.get(prev.cuisine).add(curr);
        }

        public String highestRated(String cuisine) {
            while (cuisineMap.get(cuisine).peek().food.equals("")) {
                cuisineMap.get(cuisine).remove();
            }
            return cuisineMap.get(cuisine).peek().food;
        }
    }

    public static void main(String[] args) {

        String[] foods = { "kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi" };
        String[] cuisines = { "korean", "japanese", "japanese", "greek", "japanese", "korean" };
        int[] ratings = { 9, 12, 8, 15, 14, 7 };
        FoodRatings foodRatings = new FoodRatings(foods, cuisines, ratings);
        foodRatings.highestRated("korean"); // return "kimchi"
                                            // "kimchi" is the highest rated korean food with a rating of 9.
        foodRatings.highestRated("japanese"); // return "ramen"
                                              // "ramen" is the highest rated japanese food with a rating of 14.
        foodRatings.changeRating("sushi", 16); // "sushi" now has a rating of 16.
        foodRatings.highestRated("japanese"); // return "sushi"
                                              // "sushi" is the highest rated japanese food with a rating of 16.
        foodRatings.changeRating("ramen", 16); // "ramen" now has a rating of 16.
        foodRatings.highestRated("japanese"); // return "ramen"
                                              // Both "sushi" and "ramen" have a rating of 16.
                                              // However, "ramen" is lexicographically smaller than "sushi".
    }
}
