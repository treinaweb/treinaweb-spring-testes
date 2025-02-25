package br.com.treinaweb.twjobs.libraries;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class AssertJTest {

    @Test
    void testSomething() {
        assertThat("TEST")
            .startsWith("T")
            .endsWith("T")
            .isEqualTo("TEST")
            .isEqualToIgnoringCase("test");
    }
    
}
