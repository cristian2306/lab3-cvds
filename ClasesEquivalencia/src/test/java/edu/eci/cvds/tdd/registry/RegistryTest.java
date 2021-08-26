package edu.eci.cvds.tdd.registry;

import org.junit.Assert;
import org.junit.Test;

public class RegistryTest {

    private Registry registry = new Registry();


    @Test

    public void validateDead(){
        //Test para persona que esté muerta
        Person person = new Person("Diego Gonzalez", 1007196603, 21, Gender.MALE, false);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.DEAD, result);
    }

    @Test
   public void validateUnderage(){
        //Test para persona que sea menor de edad
        Person person = new Person("Cristian Castelanos", 1008596603, 13, Gender.MALE, true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.UNDERAGE, result);
    }

    @Test
    public void validateInvalidAge(){
         //Test para persona que sea menor de edad
         Person person = new Person("Cristian Forero", 1008596852, -48, Gender.MALE, true);
         RegisterResult result = registry.registerVoter(person);
         Assert.assertEquals(RegisterResult.UNDERAGE, result);
     }

     @Test
    public void validateDuplicate(){
         //Test para persona que sea menor de edad
         Person person = new Person("Cristian Forero", 1008596852, 45, Gender.MALE, true);
         Person person1 = new Person("Santiago Fetecua", 1008596852, 22, Gender.MALE, true);
         RegisterResult result = registry.registerVoter(person);
         RegisterResult result1 = registry.registerVoter(person1);
         Assert.assertEquals(RegisterResult.DUPLICATED, result1);
     }

     @Test
    public void validateValidPerson(){
         //Test para persona que sea menor de edad
         Person person = new Person("Santiago Pascagaza", 1005896625, 23, Gender.MALE, true);
         RegisterResult result = registry.registerVoter(person);
         Assert.assertEquals(RegisterResult.VALID, result);
     }

    // TODO Complete with more test cases
}