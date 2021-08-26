package edu.eci.cvds.tdd.registry;
  
import java.util.ArrayList;

public class Registry {
    
    private ArrayList<Integer> baseVotantes = new ArrayList<Integer>();

    public RegisterResult registerVoter(Person p) {
        RegisterResult type = null;

        //En caso de que la persona no esté viva
        if(!p.isAlive()){
            type = RegisterResult.valueOf("DEAD");
        }

        //En caso de que la persona sea menor de edad
        else if(p.getAge() < 18){
            type = RegisterResult.valueOf("UNDERAGE");
        }

        //En caso de que la edad de la persona sea invalida (Número negativo)
         else if(p.getAge() < 0){
            type = RegisterResult.valueOf("INVALID_AGE");
        }

        //En caso de que la cédula ya haya sido ingresada para votar
        else if(baseVotantes.contains(p.getId())){
            type = RegisterResult.valueOf("DUPLICATED");
        }

        //En caso de que toda la información esté bien
        else{
            type =RegisterResult.valueOf("VALID");
            baseVotantes.add(p.getId());
        }
        return type;
    }
}