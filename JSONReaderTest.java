import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.*;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.RepeatedTest;

import org.junit.jupiter.api.Assumptions;


public class JSONReaderTest {
    private static JSONReader jsonReader;

    @BeforeEach
    public void setUp(){
        System.out.println("Instanciando Contact Manager");
        jsonReader = new JSONReader();
    }

    @Test
    @DisplayName("Existe JSON")
    public void existeJSON() {
        
        ClassLoader classLoader = this.getClass().getClassLoader();
        File file = new File(classLoader.getResource("actores.json").getFile());
        assertTrue(file.exists());
    }

    
}