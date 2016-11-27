package model.factory;

import model.validator.ItemValidator;
import model.validator.MessageValidator;
import model.validator.UserValidator;

public class ValidatorFactory {
	
	public ItemValidator createItemValidator() {return new ItemValidator();}
	public UserValidator createUserValidator() {return new UserValidator();}
	public MessageValidator createMessageValidator() {return new MessageValidator();}
}
