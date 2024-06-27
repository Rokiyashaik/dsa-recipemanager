package reciepemanager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;

public class ReciepeManager {
    static ArrayList<Recipe> recipes = new ArrayList<>();

    static void addRecipe(Scanner input) {
        Recipe recipe = new Recipe();
        recipe.addTitle(input);
        recipe.addIngredients(input);
        recipe.addProcedure(input);
        recipes.add(recipe);
    }

    static void removeRecipe(int index) {
        if (index >= 0 && index < recipes.size()) {
            recipes.remove(index);
            System.out.println("Recipe removed successfully.");
        } else {
            System.out.println("Invalid index. Please try again.");
        }
    }

    static void sortRecipes() {
        Collections.sort(recipes, Comparator.comparing(Recipe::getTitle));
    }

    static void viewRecipes() {
        sortRecipes();
        if (!recipes.isEmpty()) {
            for (int i = 0; i < recipes.size(); i++) {
                System.out.println((i + 1) + ". " + recipes.get(i).recipeToString());
            }
        } else {
            System.out.println("No recipes to display.");
        }
    }

    static String search(String item) {
        for (Recipe recipe : recipes) {
            if (recipe.recipeToString().toLowerCase().contains(item.toLowerCase())) {
                return recipe.recipeToString();
            }
        }
        return "We can't find what you are looking for.";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            System.out.println("Welcome to our Recipe Manager App");
            System.out.println("1. Add Recipes");
            System.out.println("2. Delete Recipes");
            System.out.println("3. View Recipes");
            System.out.println("4. Search Recipes");
            System.out.println("5. Exit");
            System.out.print("Enter the number of the task you want to do: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume the leftover newline character

            switch (choice) {
                case 1:
                    System.out.println("Add your recipe!");
                    addRecipe(sc);
                    break;
                case 2:
                    System.out.print("Enter the number of the recipe you want to delete: ");
                    int delete = sc.nextInt();
                    sc.nextLine(); // Consume the leftover newline character
                    removeRecipe(delete - 1);
                    break;
                case 3:
                    viewRecipes();
                    break;
                case 4:
                    System.out.print("Enter what you want to search in recipes: ");
                    String searching = sc.nextLine();
                    System.out.println(search(searching));
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Please choose numbers from 1 to 5");
            }
        }
        sc.close();
    }
}
