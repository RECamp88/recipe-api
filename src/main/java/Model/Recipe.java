package Model;

public class Recipe {
    // the recipe_id will be auto generated when a recipe is added
    public int recipe_id;

    // this will be the id of the account that added the recipe
    public int posted_by;

    // this is a string that will be the name of the recipe
    // this cannot be null and has to be under 255 characters
    public String recipe_name;

    // this is a string stating the main ingredient
    // can be null, cannot be over 25 characters
    public String recipe_mainIngredient;

    // default no argument constructor
    public Recipe(){

    }

    // Constructor for when the system auto generates the recipe id when added to the database
    // main ingredient is not required for this constructor
    public Recipe (int posted_by, String recipe_name, String recipe_mainIngredient){
        this.posted_by = posted_by;
        this.recipe_name = recipe_name;
        this.recipe_mainIngredient = recipe_mainIngredient;
    }

    // Constructor for when the system auto generates the recipe id when added to the database
    // this constructor includes the main ingredient
    public Recipe (int recipe_id, int posted_by, String recipe_name, String recipe_mainIngredient){
        this.recipe_id = recipe_id;
        this.posted_by = posted_by;
        this.recipe_name = recipe_name;
        this.recipe_mainIngredient = recipe_mainIngredient;
    }
    public int getPostedBy() { return posted_by;}

    public void setPosted_by(int id){
        this.posted_by = id;
    }
    // setters and getters for the above variables
    public int getRecipeId(){
        return recipe_id;
    }

    public void setRecipe_id(int id) {
        this.recipe_id = id;
    }

    public String getRecipeName(){
        return recipe_name;
    }

    public void setRecipeName(String name){
        this.recipe_name = name;
    }

    public String getMainIngredient(){
        return recipe_mainIngredient;
    }

    public void setRecipeMainIngredient(String ingredient){
        this.recipe_mainIngredient = ingredient;
    }



}
