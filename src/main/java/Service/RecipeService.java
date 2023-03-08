package Service;
 import java.util.List;
 import DAO.RecipeDAO;
 import Model.Recipe;

public class RecipeService {

    public RecipeDAO recipeDAO;

    public RecipeService(){
        recipeDAO = new RecipeDAO();
    }

    public RecipeService(RecipeDAO recipeDAO){
        this.recipeDAO = recipeDAO;
    }

    // return a list of all recipes
    public List<Recipe> getAllRecipes(){
        return null;
    }

    // adding a recipe
    // length has to be under 255 and cannot be null
    public Recipe addRecipe(Recipe recipe){
        return null;
    }

    // return a recipe by its ID
    public Recipe getRecipeById(int recipeId){
        return null;
    }
}

