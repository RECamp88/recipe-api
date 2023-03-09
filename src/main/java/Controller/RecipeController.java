package Controller;

import Model.Account;
import Model.Recipe;
import Service.AccountService;
import Service.RecipeService;


import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.Javalin;
import io.javalin.http.Context;

public class RecipeController {
    RecipeService recipeService;
    AccountService accountService;
    public RecipeController(){
        this.accountService = new AccountService();
        this.recipeService = new RecipeService();
    }

    // create the endpoints to be used.
    public Javalin startAPI(){
        Javalin app = Javalin.create();
        // create the endpoints here

        app.post("/register", this::postAccountHandler);
        app.post("/login", this::postLoginHandler);
        app.post("/recipes", this::postRecipeHandler);
        app.get("/recipes", this::getAllRecipesHandler);
        app.get("/recipes/{recipe_id}", this::getRecipeByIdHandler);
        app.get("/recipes/{main_ingredient}", this::getRecipeByIngredientHandler);
        app.delete("/recipes/{recipe_id}", this::deleteRecipeByIdHandler);
        app.patch("/recipes/{recipe_id}", this::updateRecipeByIdHandler);
        app.get("/accounts/{account_id}/recipes", this::getRecipesByAcctIdHandler);

        return app;
    }
    private void postAccountHandler(Context ctx) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Account account = mapper.readValue(ctx.body(), Account.class);
        Account addedAccount = accountService.createAccount(account);
        if(addedAccount!=null){
            ctx.json(mapper.writeValueAsString(addedAccount));

        }else{
            ctx.status(400);
        }

    }


    private void postLoginHandler(Context ctx) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Account account = mapper.readValue(ctx.body(), Account.class);
        Account loginedAccount = accountService.loginAccount(account);
        if(loginedAccount!=null){
            ctx.json(mapper.writeValueAsString(loginedAccount));

        }else{
            ctx.status(401);
        }
    }

    //This handler will be working with adding new recipe to the database.
    private void postRecipeHandler(Context context)throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Recipe recipe = mapper.readValue(context.body(), Recipe.class);
        Recipe addedRecipe = recipeService.addRecipe(recipe);
        if(addedRecipe!=null){
            context.json(mapper.writeValueAsString(addedRecipe));
        }else {
            context.status(400);
        }
    }

    // this handler will be working with retrieving all recipes in the database
    private void getAllRecipesHandler(Context context){
        List<Recipe> recipes = recipeService.getAllRecipes();
        context.json(recipes);
    }
    // this handler will be working with retrieving a recipe suggestion via its recipe_id
    private void getRecipeByIdHandler(Context context){
        int recipeId = Integer.parseInt(context.pathParam("recipe_id"));
        Recipe recipe = recipeService.getRecipeById(recipeId);
        if(recipe !=null){
            context.json(recipe);
        }else{
            context.status(200);
        }
    }
    // this handler will be working with retrieving all recipe suggestion with the same main ingredient.
    private void getRecipeByIngredientHandler(Context context){
        String mainIngredient = context.contextPath();
        List<Recipe> recipes = recipeService.getRecipeByIngredient(mainIngredient);
        context.json(recipes);
    }
    // this handler will be working with deleting a recipe suggestion via its recipe_id
    private void deleteRecipeByIdHandler(Context context){
        int recipeId = Integer.parseInt(context.pathParam("recipe_id"));
        Recipe deletedRecipe = recipeService.deleteRecipeById(recipeId);
        if(deletedRecipe!=null){
            context.json(deletedRecipe);
        }else{
            context.status(200);
        }
    }

    // this handler will be updating the Type column of a recipe by its id
    private void updateRecipeByIdHandler(Context context) throws JsonProcessingException{
        ObjectMapper mapper = new ObjectMapper();
        Recipe recipe = mapper.readValue(context.body(), Recipe.class);
        int recipeId = Integer.parseInt(context.pathParam("recipe_id"));
        Recipe updatedRecipe = recipeService.updateRecipeById(recipe, recipeId);
        if(updatedRecipe!=null){
            context.json(mapper.writeValueAsString(updatedRecipe));
        }else{
            context.status(400);
        }
    }

    // this handles will be retrieving all recipes posted by a particular account Id
    private void getRecipesByAcctIdHandler(Context context){
        int accountId = Integer.parseInt(context.pathParam("account_id"));
        List<Recipe> recipes = recipeService.getAllRecipesByAcctId(accountId);
        context.json(recipes);
    }
}
