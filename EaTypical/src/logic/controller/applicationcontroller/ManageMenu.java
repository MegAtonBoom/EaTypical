package logic.controller.applicationcontroller;

import java.util.ArrayList;

import logic.engineeringclasses.bean.manageMenu.BeanAddDish;
import logic.engineeringclasses.bean.manageMenu.BeanAdvice;
import logic.engineeringclasses.bean.manageMenu.BeanDeleteDish;
import logic.engineeringclasses.dao.RecipeDAO;
import logic.engineeringclasses.exceptions.DishAlreadyExists;
import logic.engineeringclasses.exceptions.InvalidDishDelete;
import logic.engineeringclasses.exceptions.InvalidDishModify;
import logic.model.Recipe;


/**
 * 
 * @author Luca Capotombolo
 *
 */
public class ManageMenu {

	
	public void addDish(BeanAddDish beanAddDish) throws ClassNotFoundException, DishAlreadyExists
	{
		//creo la entity recipe
		Recipe recipe = new Recipe(beanAddDish.getPiatto(), beanAddDish.getContenuto(), beanAddDish.getRistorante(), beanAddDish.isVegano(), beanAddDish.isCeliaco(), beanAddDish.getPrezzo());
		
		//richiedo la persistenza nel db
		
		RecipeDAO recipeDAO = new RecipeDAO();
		recipeDAO.addDish(recipe);
		
	}
	
	public void modifyDishes(BeanAddDish beanAddDish) throws ClassNotFoundException, InvalidDishModify
	{

		//CREA LA ENTITY !! --------------------------------------------------------------------------
		//istanzio una DAO per modificare tuple della tabella
		RecipeDAO recipeDAO = new RecipeDAO();
		
		recipeDAO.updateDishes(beanAddDish);
	}
	
	public void deleteDish(BeanDeleteDish beanDeleteDish) throws ClassNotFoundException, InvalidDishDelete {
		
		//istanzio una DAO per eliminare la tupla richiesta dalla tabella
		RecipeDAO recipeDAO = new RecipeDAO();
		
		recipeDAO.deleteRecipe(beanDeleteDish.getRistorante(), beanDeleteDish.getPiatto());
	}
	
	public BeanAdvice advice(String username) throws ClassNotFoundException {
		
		// istanzio la DAO affinchÃ¨ possa ottenere i piatti tipici che il ristorante non offre ai clienti
		RecipeDAO recipeDAO = new RecipeDAO();
		ArrayList<String> piattiMancanti = (ArrayList<String>) recipeDAO.selectNoRecipe(username);
		
		//impacchetto i piatti 'mancanti' all'interno di una Bean che verrÃ  passata al controller grafico chiamante
		new BeanAdvice(piattiMancanti);
		
		
		return new BeanAdvice(piattiMancanti);
		
	}
	
}
