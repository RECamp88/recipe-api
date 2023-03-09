package DAO;

import Model.Recipe;
import Util.ConnectionSingleton;
import jdk.jshell.execution.Util;

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
        Connection connection = ConnectionSingleton.getConnection();
        try{
            String sql = "INSERT INTO recipe (posted_by, recipe_name, main_ingredient) VALUES (?, ?, ?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setInt(1, recipe.getPostedBy());
            preparedStatement.setString(2, recipe.getRecipeName());
            preparedStatement.setString(3, recipe.getMainIngredient());
            preparedStatement.executeUpdate();

            ResultSet pkeyResultSet = preparedStatement.getGeneratedKeys();
            if(pkeyResultSet.next()){
                int generated_recipe_id = (int) pkeyResultSet.getInt("recipe_id");
                return new Recipe(generated_recipe_id, recipe.getPostedBy(), recipe.getRecipeName(), recipe.getMainIngredient());
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<Recipe> getAllRecipes(){
        Connection connection = ConnectionSingleton.getConnection();
        List<Recipe> recipes = new ArrayList<>();
        try{
            String sql= "SELECT * FROM recipe;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                Recipe recipe= new Recipe(rs.getInt("recipe_id"),
                        rs.getInt("posted_by"),
                        rs.getString("recipe_name"),
                        rs.getString("main_ingredient"));
                recipes.add(recipe);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return recipes;
    }

    public Recipe getRecipeById(int id){
       Connection connection = ConnectionSingleton.getConnection();
       try{
           String sql = "SELECT * FROM recipe WHERE recipe_id = ?;";
           PreparedStatement preparedStatement = connection.prepareStatement(sql);

           preparedStatement.setInt(1, id);
           ResultSet rs = preparedStatement.executeQuery();

           while(rs.next()){
               Recipe recipe = new Recipe(rs.getInt("recipe_id"),
                       rs.getInt("posted_by"),
                       rs.getString("recipe_name"),
                       rs.getString("main_ingredient"));
               return recipe;
           }
       }catch (SQLException e){
           System.out.println(e.getMessage());
       }
       return null;
    }
    // user should be able to request a list of all recipes with a specific ingredient.
    public List<Recipe> getRecipeByIngredient(String ingredient){
        Connection connection = ConnectionSingleton.getConnection();
        List<Recipe> recipes = new ArrayList<>();
        try{
            String sql = "SELECT * FROM recipe WHERE main_ingredient = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, ingredient);

            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Recipe recipe = new Recipe(rs.getInt("recipe_id"),
                                            rs.getInt("posted_by"),
                                            rs.getString("recipe_name"),
                                            rs.getString("main_ingredient"));
                recipes.add(recipe);
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return recipes;
    }

    // User should be able to delete a recipe that they added to the database
    // will pass in a recipe ID
    public Recipe deleteRecipeById(int recipeId){
        Connection connection = ConnectionSingleton.getConnection();
        try{
            String sql = "DELETE FROM recipe WHERE recipe_id = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, recipeId);
            preparedStatement.executeUpdate();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    // user should be able to update a recipe by its id
    public Recipe updateRecipeById(Recipe recipe, int recipeID){
        Connection connection = ConnectionSingleton.getConnection();
        try{
            String sql = "UPDATE recipe SET main_ingredient = ? WHERE recipe_id = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, recipe.getMainIngredient());
            preparedStatement.setInt(2, recipeID);
            preparedStatement.executeUpdate();

            return getRecipeById(recipeID);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    public List<Recipe> getRecipeByAcctId(int accountId){
        Connection connection = ConnectionSingleton.getConnection();
        List<Recipe> recipes = new ArrayList<>();
        try{
            String sql = "SELECT * FROM recipe WHERE posted_by = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, accountId);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Recipe recipe = new Recipe(rs.getInt("recipe_id"),
                        rs.getInt("posted_by"),
                        rs.getString("recipe_name"),
                        rs.getString("main_ingredient"));
                recipes.add(recipe);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return recipes;
    }

}
