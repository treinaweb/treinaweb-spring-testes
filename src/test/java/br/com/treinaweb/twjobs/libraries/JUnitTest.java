package br.com.treinaweb.twjobs.libraries;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class JUnitTest {

    @Test
    void testSomething() {
        var actual = "TEST";
        var expected = "TEST";
        
        assertEquals(expected, actual, "Algo deu errado");
        assertTrue(actual.startsWith("T"));
        assertNull(null);
        assertTrue(true);
    }
    
}
