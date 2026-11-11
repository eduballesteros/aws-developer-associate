package estudio.aws;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TaskRulesTest {
    @Test void normalizaTitulo() { assertEquals("estudiar IAM", TaskRules.title(" estudiar IAM ")); }
    @Test void rechazaTituloVacio() { assertThrows(IllegalArgumentException.class, () -> TaskRules.title("  ")); }
    @Test void rechazaTituloLargo() { assertThrows(IllegalArgumentException.class, () -> TaskRules.title("a".repeat(121))); }
    @Test void exigeIdCanonico() {
        assertEquals("123e4567-e89b-12d3-a456-426614174000", TaskRules.id("123E4567-E89B-12D3-A456-426614174000"));
        assertThrows(IllegalArgumentException.class, () -> TaskRules.id("1-1-1-1-1"));
        assertThrows(IllegalArgumentException.class, () -> TaskRules.id(null));
    }
}
