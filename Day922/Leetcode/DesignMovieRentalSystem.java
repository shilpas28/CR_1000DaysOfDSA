//Leetcode
//1912. Design Movie Rental System
//Time complexity: Constructor: O(NlogN) search, rent, drop, report: O(logN)
//Space complexity: O(N)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class DesignMovieRentalSystem {

    static class MovieRentingSystem {

        // Maps movie -> available shops sorted by (price, shop)
        private Map<Integer, TreeSet<int[]>> availableMovies;
        // Sorted set of rented movies (price, shop, movie)
        private TreeSet<int[]> rentedMovies;
        // Maps (shop, movie) -> price
        private Map<String, Integer> prices;

        public MovieRentingSystem(int n, int[][] entries) {
            availableMovies = new HashMap<>();
            rentedMovies = new TreeSet<>(
                    (a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0])
                            : (a[1] != b[1] ? Integer.compare(a[1], b[1]) : Integer.compare(a[2], b[2])));
            prices = new HashMap<>();

            for (int[] entry : entries) {
                int shop = entry[0], movie = entry[1], price = entry[2];
                String key = shop + "#" + movie;
                prices.put(key, price);

                availableMovies.putIfAbsent(movie, new TreeSet<>(
                        (a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1])));
                availableMovies.get(movie).add(new int[] { price, shop });
            }
        }

        // Find cheapest 5 shops for an unrented movie
        public List<Integer> search(int movie) {
            List<Integer> result = new ArrayList<>();
            if (availableMovies.containsKey(movie)) {
                int count = 0;
                for (int[] p : availableMovies.get(movie)) {
                    if (count == 5)
                        break;
                    result.add(p[1]);
                    count++;
                }
            }
            return result;
        }

        // Rent a movie
        public void rent(int shop, int movie) {
            String key = shop + "#" + movie;
            int price = prices.get(key);
            availableMovies.get(movie).remove(new int[] { price, shop });
            rentedMovies.add(new int[] { price, shop, movie });
        }

        // Drop off a rented movie
        public void drop(int shop, int movie) {
            String key = shop + "#" + movie;
            int price = prices.get(key);
            rentedMovies.remove(new int[] { price, shop, movie });
            availableMovies.get(movie).add(new int[] { price, shop });
        }

        // Report 5 cheapest rented movies
        public List<List<Integer>> report() {
            List<List<Integer>> result = new ArrayList<>();
            int count = 0;
            for (int[] t : rentedMovies) {
                if (count == 5)
                    break;
                result.add(Arrays.asList(t[1], t[2])); // {shop, movie}
                count++;
            }
            return result;
        }
    }

    public static void main(String[] args) {
        int[][] entries = { { 0, 1, 5 }, { 0, 2, 6 }, { 0, 3, 7 }, { 1, 1, 4 }, { 1, 2, 7 }, { 2, 1, 5 } };
        MovieRentingSystem movieRentingSystem = new MovieRentingSystem(3, entries);
        System.out.println(movieRentingSystem.search(1)); // return [1, 0, 2], Movies of ID 1 are unrented at shops 1,
                                                          // 0, and 2. Shop 1 is
        // cheapest; shop 0 and 2 are the same price, so order by shop number.
        movieRentingSystem.rent(0, 1); // Rent movie 1 from shop 0. Unrented movies at shop 0 are now [2,3].
        movieRentingSystem.rent(1, 2); // Rent movie 2 from shop 1. Unrented movies at shop 1 are now [1].
        System.out.println(movieRentingSystem.report()); // return [[0, 1], [1, 2]]. Movie 1 from shop 0 is cheapest,
                                                         // followed by movie 2
        // from shop 1.
        movieRentingSystem.drop(1, 2); // Drop off movie 2 at shop 1. Unrented movies at shop 1 are now [1,2].
        System.out.println(movieRentingSystem.search(2)); // return [0, 1]. Movies of ID 2 are unrented at shops 0 and
                                                          // 1. Shop 0 is
        // cheapest, followed by shop 1.
    }
}
