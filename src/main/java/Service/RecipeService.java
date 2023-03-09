package Service;
 import java.util.List;
 import DAO.RecipeDAO;
 import Model.Recipe;

public class RecipeService {

    public RecipeDAO recipeDAO;

    //constructor without any parameters
    public RecipeService(){
        recipeDAO = new RecipeDAO();
    }

    //constructor when a recipeDAO is passed in.
    public RecipeService(RecipeDAO recipeDAO){
        this.recipeDAO = recipeDAO;
    }

    // return a list of all recipe suggestions in the database
    public List<Recipe> getAllRecipes(){
        return recipeDAO.getAllRecipes();
    }
    // adding a recipe
    // length has to be under 255 and cannot be null
    public Recipe addRecipe(Recipe recipe){
        if(recipe.recipe_name.length() < 256 && recipe.recipe_name !=""){
            return recipeDAO.addRecipe(recipe);
        }
        return null;
    }
    // return a recipe by its ID
    public Recipe getRecipeById(int recipeId){
        return recipeDAO.getRecipeById(recipeId);
    }
    // returns a list of recipe suggestions that have the main ingredient
    // that has been passed to it
    public List<Recipe> getRecipeByIngredient(String ingredient){
        return recipeDAO.getRecipeByIngredient(ingredient);
    }
    // returns the recipe that is being deleted
    // if that recipe is null (didn't exist) returns null
    public Recipe deleteRecipeById(int id){
        Recipe recipe = recipeDAO.getRecipeById(id);
        recipeDAO.deleteRecipeById(id);

        if(recipe==null){
            return null;
        }
        return recipe;
    }
    // this takes in a recipe and an int representing it's id
    // if the recipe doesn't exist, is name is null, or length is more than 255 characters, return null
    public Recipe updateRecipeById(Recipe recipe, int id){
        if(getRecipeById(id)==null || recipe.recipe_name == "" || recipe.recipe_name.length()>255){
            return null;
        }
        return recipeDAO.updateRecipeById(recipe,id);
    }
    // this takes in an accountID which is the referenced by posted_by
    public List<Recipe> getAllRecipesByAcctId(int accountID){
        return recipeDAO.getRecipeByAcctId(accountID);
    }


}

