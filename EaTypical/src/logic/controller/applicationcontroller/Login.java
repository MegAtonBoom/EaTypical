package logic.controller.applicationcontroller;


import logic.model.User;

import java.sql.SQLException;

import logic.engineeringclasses.bean.login.BeanUser;
import logic.engineeringclasses.dao.OwnerDAO;
import logic.engineeringclasses.dao.TouristDAO;
import logic.engineeringclasses.exceptions.AlreadyInUseUsernameException;
import logic.engineeringclasses.exceptions.GenericException;
import logic.engineeringclasses.exceptions.LoginDBException;
import logic.engineeringclasses.exceptions.WrongUsernameOrPasswordException;
import logic.engineeringclasses.factory.UserFactory;


public class Login {
	
	
	
	public User loginMethod(BeanUser loggingUser) throws  LoginDBException,SQLException,Exception
	{		
		User user;
		
		try		
		{
			if(loggingUser.isOwner())
			{
				user=OwnerDAO.selectOwner(loggingUser.getUsername(),loggingUser.getPassword());
			}
			else
			{
				user=TouristDAO.selectTourist(loggingUser.getUsername(),loggingUser.getPassword());
			}
		}
		catch(LoginDBException dbe)		//exception came from the db: the username or the password are wrong
		{
			throw new WrongUsernameOrPasswordException("Invalid Username Or Password");
		}
		catch(SQLException e)				//generic exception to handle that may occour if there is a bug or some not planned interaction
		{
			throw new SQLException("Please try again!");
		}
		return user;
	}
	
	public void registerMethod(BeanUser loggingUser) throws GenericException, AlreadyInUseUsernameException
	{
		String name=loggingUser.getName();
		String surname=loggingUser.getSurname();
		String username=loggingUser.getUsername();
		String password=loggingUser.getPassword();
		try
		{
			if(loggingUser.isOwner())
			{
				User newOwner=UserFactory.getFactory().createOwner(name, surname, null, username, null, null);
				OwnerDAO.insertOwner(newOwner, password);			
			}
			else {
				User newtourist=UserFactory.getFactory().createTourist(name, surname, username, null, null);
				TouristDAO.insertTourist(newtourist, password);
			}
		}
		catch(AlreadyInUseUsernameException ae)			//exception came form the db: the username that the user want to use is already is use by someone
		{
			throw new AlreadyInUseUsernameException(ae.getMessage());
		}
		catch(Exception e)								//generic exception to handle that may occour in caso of there's a bug or some not planned interaction
		{
			throw new GenericException("Please try again!");
		}
	}

}
