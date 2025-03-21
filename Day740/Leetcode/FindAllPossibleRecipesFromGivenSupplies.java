//Leetcode
//2115. Find All Possible Recipes from Given Supplies - Breadth-First Search (BFS)
//Time complexity: O((n*m)+s)
//Space complexity: O(n+s)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class FindAllPossibleRecipesFromGivenSupplies {

    public static void main(String[] args) {
        String[] recipes = { "bread", "sandwich" };
        List<List<String>> ingredients = new ArrayList<List<String>>();
        ingredients.add(new ArrayList<>(Arrays.asList("yeast", "flour")));
        ingredients.add(new ArrayList<>(Arrays.asList("bread", "meat")));
        String[] supplies = { "yeast", "flour", "meat" };
        System.out.println(findAllRecipes(recipes, ingredients, supplies));
    }

    public static List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        // Track available ingredients and recipes
        Set<String> available = new HashSet<>();
        for (String supply : supplies) {
            available.add(supply);
        }
        // Queue to process recipe indices
        Queue<Integer> recipeQueue = new LinkedList<>();
        for (int idx = 0; idx < recipes.length; ++idx) {
            recipeQueue.offer(idx);
        }

        List<String> createdRecipes = new ArrayList<>();
        int lastSize = -1;
        // Continue while we keep finding new recipes
        while (available.size() > lastSize) {
            lastSize = available.size();
            int queueSize = recipeQueue.size();
            // Process all recipes in current queue
            while (queueSize-- > 0) {
                int recipeIdx = recipeQueue.poll();
                boolean canCreate = true;
                // Check if all ingredients are available
                for (String ingredient : ingredients.get(recipeIdx)) {
                    if (!available.contains(ingredient)) {
                        canCreate = false;
                        break;
                    }
                }

                if (!canCreate) {
                    recipeQueue.offer(recipeIdx);
                } else {
                    // Recipe can be created - add to available items
                    available.add(recipes[recipeIdx]);
                    createdRecipes.add(recipes[recipeIdx]);
                }
            }
        }
        return createdRecipes;
    }
}
