package DAO;

import Model.Recipe;
import Util.ConnectionSingleton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;
public class RecipeDAO {


    // user should be able to add a recipe to the database
    public Recipe addRecipe(Recipe recipe){
        return recipe;
    }

    // user should be able to request a list of all recipes with a specific ingredient.
    public List<Recipe> getRecipeByIngredient(String ingredient){
        return null;
    }

    // user should be able to request a list of all the receipes in the database
    public List<Recipe> getAllRecipes() {
        return null;
    }

    // User should be able to delete a recipe that they added to the database
    // will pass in a recipe ID
    public Recipe deleteRecipeById (int recipeId){
        return null;
    }

    // user should be able to update a recipe by its id
    public Recipe updateRecipeById(Recipe recipe, int recipeID){
        return null;
    }
}
