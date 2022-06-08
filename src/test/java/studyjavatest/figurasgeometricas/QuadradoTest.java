package studyjavatest.figurasgeometricas;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class QuadradoTest {
    
    @Test
    @DisplayName("Should initialize attributes when non-parameterized constructor is called") 
    public void shouldInitializeAttributeWhenNonParameterizedConstructorIsCalled() {
       Quadrado quadrado = new Quadrado();

       assertNotNull(quadrado);
    }

    @Test
    @DisplayName("Should initiate attributes when parameterized constructor is called")
    public void shouldInitiateAttributeWhenParameterizedConstructorIsCalled() {
        double lado = 2.0;
        Quadrado quadrado = new Quadrado(lado);

        assertNotNull(quadrado);
        assertEquals(quadrado.getLado(), lado, 0);
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException when parameterized constructor receives non-positive parameter")
    public void shouldThrowIllegalArgumentExceptionWhenParameterizedConstructorReceivesNonPositiveParameter() {
        double lado = -2.0;

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Quadrado(lado)
        );
        assertEquals("O lado precisa ser maior do que 0.", exception.getMessage());
    }

    @Test
    @DisplayName("Set Lado should set Lado attribute")
    public void setLado_ShouldSetLadoAttribute() {
        double lado = 2.0;
        double lado2 = 3.0;
        Quadrado quadrado = new Quadrado(lado);
        quadrado.setLado(lado2);

        assertEquals(quadrado.getLado(), lado2, 0);
        assertFalse(quadrado.getLado() == lado);
    }

    @Test
    @DisplayName("Set Lado should throw IllegalArgumentException when receive non-positive parameter")
    public void setLado_ShouldThrowIllegalArgumentExceptionWhenParameterizedConstructorReceiveNonPositiveParameter() {
        double lado = 2.0;
        Quadrado quadrado = new Quadrado(lado);

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> quadrado.setLado(-2.0)
        );
        assertEquals("O lado precisa ser maior do que 0.", exception.getMessage());
    }

    @Test
    @DisplayName("Get Lado should get Lado attribute")
    public void getLado_ShouldGetLadoAttribute() {
        double lado = 2.0;
        Quadrado quadrado = new Quadrado(lado);

        assertEquals(quadrado.getLado(), lado, 0);
    }

    @Test
    @DisplayName("Calcular Area should return the area of square")
    public void calcularArea_ShouldReturnAreaOfSquare() {
        double lado = 2.0;
        Quadrado quadrado = new Quadrado(lado);

        assertEquals(quadrado.calcularArea(), (lado*lado), 0);
        assertTrue(quadrado.calcularArea() > 0);
    }

    @Test
    @DisplayName("Calcular Perimetro should return the perimeter of square")
    public void calcularPerimetro_ShouldReturnPerimeterOfSquare() {
        double lado = 2.0;
        Quadrado quadrado = new Quadrado(lado);

        assertEquals(quadrado.calcularPerimetro(), (lado*4), 0);
        assertTrue(quadrado.calcularArea() > 0);
    }
}
