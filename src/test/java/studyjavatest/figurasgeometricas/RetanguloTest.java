package studyjavatest.figurasgeometricas;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RetanguloTest {
    @Test
    @DisplayName("Should initialize attributes when non-parameterized constructor is called")
    public void shouldInitializeAttributesWhenNonParameterizedConstructorIsCalled() {
        Retangulo retangulo = new Retangulo();

        assertNotNull(retangulo);
    }

    @Test
    @DisplayName("Should initiate attributes when parameterized constructor is called")
    public void shouldInitiateAttributeWhenParameterizedConstructorIsCalled() {
        double base = 2.0;
        double altura = 3.0;
        Retangulo retangulo = new Retangulo(base, altura);

        assertNotNull(retangulo);
        assertEquals(retangulo.getBase(), base, 0);
        assertEquals(retangulo.getAltura(), altura, 0);
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException when parameterized constructor receive negative Base parameter")
    public void shouldThrowIllegalArgumentExceptionWhenParameterizedConstructorReceiveNegativeBaseParameter() {
        double base = -2.0;
        double altura = 3.0;

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Retangulo(base, altura)
        );

        assertEquals("A base precisa ser maior do que 0.", exception.getMessage());
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException when parameterized constructor receive Base parameter equals zero")
    public void shouldThrowIllegalArgumentExceptionWhenParameterizedConstructorReceiveBaseParameterEqualsZero() {
        double base = 0.0;
        double altura = 3.0;

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Retangulo(base, altura)
        );

        assertEquals("A base precisa ser maior do que 0.", exception.getMessage());
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException when parameterized constructor receive negative Altura parameter")
    public void shouldThrowIllegalArgumentExceptionWhenParameterizedConstructorReceiveNegativeAlturaParameter() {
        double base = 2.0;
        double altura = -3.0;

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Retangulo(base, altura)
        );

        assertEquals("A altura precisa ser maior do que 0.", exception.getMessage());
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException when parameterized constructor receive Altura parameter equals zero")
    public void shouldThrowIllegalArgumentExceptionWhenParameterizedConstructorReceiveAlturaParameterEqualsZero() {
        double base = 2.0;
        double altura = 0.0;

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Retangulo(base, altura)
        );

        assertEquals("A altura precisa ser maior do que 0.", exception.getMessage());
    }

    @Test
    @DisplayName("Set Base should set Base attribute")
    public void setBase_ShouldSetBaseAttribute() {
        double base = 2.0;
        double novaBase = 3.0;
        double altura = 5.0;
        Retangulo retangulo = new Retangulo(base, altura);
        retangulo.setBase(novaBase);

        assertEquals(retangulo.getBase(), novaBase, 0);
        assertEquals(retangulo.getAltura(), altura, 0);
    }

    @Test
    @DisplayName("Set Base should throw IllegalArgumentException when receive negative Base parameter")
    public void setBase_ShouldThrowIllegalArgumentExceptionWhenReceiveNegativeBaseParameter() {
        double base = 2.0;
        double novaBase = -3.0;
        double altura = 5.0;
        Retangulo retangulo = new Retangulo(base, altura);

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> retangulo.setBase(novaBase)
        );
        assertEquals("A base precisa ser maior do que 0.", exception.getMessage());
    }

    @Test
    @DisplayName("Set Base should throw IllegalArgumentException when receive Base parameter equals zero")
    public void setBase_ShouldThrowIllegalArgumentExceptionWhenReceiveBaseParameterEqualsZero() {
        double base = 2.0;
        double novaBase = 0;
        double altura = 5.0;
        Retangulo retangulo = new Retangulo(base, altura);

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> retangulo.setBase(novaBase)
        );
        assertEquals("A base precisa ser maior do que 0.", exception.getMessage());
    }

    @Test
    @DisplayName("Get Base should get Base attribute")
    public void getBase_ShouldGetBaseAttribute() {
        double base = 2.0;
        double altura = 3.0;
        Retangulo retangulo = new Retangulo(base, altura);

        assertEquals(retangulo.getBase(), base, 0);
    }

    @Test
    @DisplayName("Set Altura should set Altura attribute")
    public void setAltura_ShouldSetAlturaAttribute() {
        double base = 2.0;
        double altura = 5.0;
        double novaAltura = 3.0;

        Retangulo retangulo = new Retangulo(base, altura);
        retangulo.setAltura(novaAltura);

        assertEquals(retangulo.getAltura(), novaAltura, 0);
        assertEquals(retangulo.getBase(), base, 0);
    }

    @Test
    @DisplayName("Set Altura should throw IllegalArgumentException when receive negative Altura parameter")
    public void setAltura_ShouldThrowIllegalArgumentExceptionWhenReceiveNegativeAlturaParameter() {
        double base = 2.0;
        double altura = 5.0;
        double novaAltura = -3.0;

        Retangulo retangulo = new Retangulo(base, altura);

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> retangulo.setAltura(novaAltura)
        );
        assertEquals("A altura precisa ser maior do que 0.", exception.getMessage());
    }

    @Test
    @DisplayName("Set Altura should throw IllegalArgumentException when receive Altura parameter equals zero")
    public void setAltura_ShouldThrowIllegalArgumentExceptionWhenReceiveAlturaParameterEqualsZero() {
        double base = 2.0;
        double altura = 5.0;
        double novaAltura = 0;

        Retangulo retangulo = new Retangulo(base, altura);

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> retangulo.setAltura(novaAltura)
        );
        assertEquals("A altura precisa ser maior do que 0.", exception.getMessage());
    }

    @Test
    @DisplayName("Get Altura should get base attribute")
    public void getAltura_ShouldGetAlturaAttribute() {
        double base = 2.0;
        double altura = 3.0;
        Retangulo retangulo = new Retangulo(base, altura);

        assertEquals(retangulo.getAltura(), altura, 0);
    }


    @Test
    @DisplayName("Calcular Area should return the area of rectangle")
    public void calcularArea_ShouldReturnAreaOfRectangle() {
        double base = 2.0;
        double altura = 3.0;
        Retangulo retangulo = new Retangulo(base, altura);

        assertEquals(retangulo.calcularArea(), (base*altura), 0);
        assertTrue(retangulo.calcularArea() > 0);
    }

    @Test
    @DisplayName("Calcular Perimetro should return the perimeter of rectangle")
    public void calcularPerimetro_ShouldReturnPerimeterOfRectangle() {
        double base = 2.0;
        double altura = 3.0;
        Retangulo retangulo = new Retangulo(base, altura);

        assertEquals(retangulo.calcularPerimetro(), (2*base + 2*altura), 0);
        assertTrue(retangulo.calcularArea() > 0);
    }

}
