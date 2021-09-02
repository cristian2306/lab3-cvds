package edu.eci.cvds.tdd.aerodescuentos;


import edu.eci.cvds.tdd.aerodescuentos.CalculadorDescuentos;

import org.junit.Assert;
import org.junit.Test;


public class TarifasTest {
    
    /**
     * Test generado para revisar el descuento por ser menor de edad
     */
    @Test
    public void validateDiscountUnderage(){
        long proofValue = (long) CalculadorDescuentos.calculoTarifa(2500,15,15);
        Assert.assertEquals(proofValue, 2375);
    }

    /**
     * Test generado para revisar el descuento por ser adulto mayor
     */
    @Test 
    public void validateDiscountSenior(){
        long proofValue = (long) CalculadorDescuentos.calculoTarifa(2500,15,70);
        Assert.assertEquals(proofValue, 2300);
    }

    /**
     * Test generado para revisar el descuento por anticipacion de tiquete
     */
    @Test 
    public void validateAnticipationTicket(){
        long proofValue = (long) CalculadorDescuentos.calculoTarifa(2500,25,55);
        Assert.assertEquals(proofValue, 2125);
    }

    /**
     * Test generado para revisar el descuento del 20% (Descuento por anticipacion y menor de edad)
     */
    @Test
    public void validateDiscountTwenty(){
        long proofValue = (long) CalculadorDescuentos.calculoTarifa(2500,25,5);
        Assert.assertEquals(proofValue, 2000);
    }

    /**
     * Test generado para revisar el descuento del 20% (Descuento por anticipacion y menor de edad)
     */
    @Test
    public void validateDiscountTwentyThree(){
        long proofValue = (long) CalculadorDescuentos.calculoTarifa(2500,25,80);
        Assert.assertEquals(proofValue, 1925);
    }

    /**
     * Test generado para revisar que no haya descuento en el tiquete
     */ 
    @Test
    public void validateNoDiscount(){
        long proofValue = (long) CalculadorDescuentos.calculoTarifa(2500,15,55);
        Assert.assertEquals(proofValue, 2500);
    }
}
