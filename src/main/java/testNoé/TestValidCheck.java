package testNoé;

import java.util.Set;

import javax.validation.ConstraintViolation;

import model.api.*;
import model.entity.*;
import model.factory.*;
import model.manager.*;
import model.syncManager.*;
import model.validator.*;
public class TestValidCheck {

	public static void main(String[] args) {
		ItemValidator itv = ValidatorFactory.createItemValidator();
		System.out.println(itv);
		Item i1 = new Item();
		i1.setTitle("Un Stylo bleu");
		itv.setEntity(i1);
		if(itv.validate()){
			System.out.println("Objet Valide");
		}else{
			System.out.println("Objet Non Valide");
			Set<ConstraintViolation<Item>> violations = itv.getViolations();
			for( ConstraintViolation<Item> v : violations){
				System.out.println(v.getMessage());
			}
		}
		System.out.println("Fini");
	}

}
