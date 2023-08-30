package org.example;

import org.example.services.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValidatorTest {
    @Test
    void toValidateTestTrue1(){
        boolean real = Validator.toValidate("2*x+5=17");
        Assertions.assertTrue(real);
    }
    @Test
    void toValidateTestTrue2(){
        boolean real = Validator.toValidate("-1.3*5/x=1.2");
        Assertions.assertTrue(real);
    }
    @Test
    void toValidateTestTrue3(){
        boolean real = Validator.toValidate("2*x=10");
        Assertions.assertTrue(real);
    }
    @Test
    void toValidateTestTrue4(){
        boolean real = Validator.toValidate("2*x+5+x+5=10");
        Assertions.assertTrue(real);
    }
    @Test
    void toValidateTestTrue5(){
        boolean real = Validator.toValidate("17=2*x+5");
        Assertions.assertTrue(real);
    }
    @Test
    void toValidateTestTrue6(){
        boolean real = Validator.toValidate("(2*x)+5=17");
        Assertions.assertTrue(real);
    }
    @Test
    void toValidateTestTrue7(){
        boolean real = Validator.toValidate("(2*x+5)=17");
        Assertions.assertTrue(real);
    }
    @Test
    void toValidateTestTrue8(){
        boolean real = Validator.toValidate("2*x+5=-17");
        Assertions.assertTrue(real);
    }
    @Test
    void toValidateTestTrue9(){
        boolean real = Validator.toValidate("-2*x+5=17");
        Assertions.assertTrue(real);
    }

    @Test
    void toValidateTestFalse1(){
        boolean real = Validator.toValidate("(2*x+5=17");
        Assertions.assertFalse(real);
    }
    @Test
    void toValidateTestFalse2(){
        boolean real = Validator.toValidate("(2*x+5=17)");
        Assertions.assertFalse(real);
    }
    @Test
    void toValidateTestFalse3(){
        boolean real = Validator.toValidate("2*x+5)=17");
        Assertions.assertFalse(real);
    }
    @Test
    void toValidateTestFalse4(){
        boolean real = Validator.toValidate("(2*x+(5=1)7");
        Assertions.assertFalse(real);
    }
    @Test
    void toValidateTestFalse5(){
        boolean real = Validator.toValidate("2*y+5=17");
        Assertions.assertFalse(real);
    }
    @Test
    void toValidateTestFalse6(){
        boolean real = Validator.toValidate("(-)=");
        Assertions.assertFalse(real);
    }
    @Test
    void toValidateTestFalse7(){
        boolean real = Validator.toValidate("+x+2=4");
        Assertions.assertFalse(real);
    }
    @Test
    void toValidateTestFalse8(){
        boolean real = Validator.toValidate("x+2+=4");
        Assertions.assertFalse(real);
    }
    @Test
    void toValidateTestFalse9(){
        boolean real = Validator.toValidate("x+2=+4");
        Assertions.assertFalse(real);
    }
    @Test
    void toValidateTestFalse10(){
        boolean real = Validator.toValidate("x+2=4+");
        Assertions.assertFalse(real);
    }

}
