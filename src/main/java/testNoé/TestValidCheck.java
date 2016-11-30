package testNoé;

import java.math.BigInteger;
import java.util.Date;
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
				System.out.println(v.toString() + v.getMessage());
			}
		}
		System.out.println("Deuxième objet :");
		Item i2 = new Item();
		i2.setCreatedAt(new Date());
		i2.setDescription("406 HDI Break, 330 000 km, 2001, Gris métalisé");
		i2.setPbkey(new BigInteger("1025",10));
		i2.setTitle("406 HDI");
		i2.setUserid("id124");
		i2.setUsername("Rick Hochet");
		itv.setEntity(i2);
		if(itv.validate()){
			System.out.println("Objet Valide");
		}else{
			System.out.println("Objet Non Valide");
			Set<ConstraintViolation<Item>> violations = itv.getViolations();
			for( ConstraintViolation<Item> v : violations){
				System.out.println(v.toString() + v.getMessage());
			}
		}
		System.out.println("Fini");
	}

}
