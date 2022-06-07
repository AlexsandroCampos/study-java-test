package studyjavatest.figurasGeometricas;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import junit.framework.Assert;

public class QuadradoTest {
    
    @Test
    @DisplayName("Should initialize attributes when non-parameterized constructor is called") 
    public void ShouldInitializeAttributesWhenNonParameterizedConstructorIsCalled() {
       Quadrado quadrado = new Quadrado();
       Assert.assertNotNull(quadrado);
    }
}
