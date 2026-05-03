package org.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;
import org.junit.Test;

public class AppTest {
    @Test
    public void printMenuShowsExerciseOptions() {
        String output = captureOutput(() -> App.PrintMenu());

        assertTrue(output.contains("Seleccione un ejercicio:"));
        assertTrue(output.contains("1. Mostrar la longitud de la cadena"));
        assertTrue(output.contains("12. Pedir otra cadena si esta vacia"));
        assertTrue(output.contains("0. Salir"));
        assertTrue(output.endsWith("Opcion: "));
    }

    @Test
    public void exercise1PrintsStringLength() {
        assertEquals("5\n", captureOutput(() -> App.Exercise1("hello")));
    }

    @Test
    public void exercise2PrintsMessageWhenStringIsEmpty() {
        assertEquals("Cadena vacia\n", captureOutput(() -> App.Exercise2("")));
    }

    @Test
    public void exercise2PrintsNothingWhenStringIsNotEmpty() {
        assertEquals("", captureOutput(() -> App.Exercise2("hello")));
    }

    @Test
    public void exercise3PrintsXdWhenStringContainsXd() {
        assertEquals("xD\n", captureOutput(() -> App.Exercise3("hola xD")));
    }

    @Test
    public void exercise3PrintsNothingWhenStringDoesNotContainXd() {
        assertEquals("", captureOutput(() -> App.Exercise3("hola")));
    }

    @Test
    public void exercise4PrintsUppercaseString() {
        assertEquals("HOLA\n", captureOutput(() -> App.Exercise4("hola")));
    }

    @Test
    public void exercise5PrintsLowercaseString() {
        assertEquals("hola\n", captureOutput(() -> App.Exercise5("HOLA")));
    }

    @Test
    public void exercise6PrintsTrimmedString() {
        assertEquals("hola\n", captureOutput(() -> App.Exercise6("  hola  ")));
    }

    @Test
    public void exercise7PrintsReplacementWhenStringMatches() {
        assertEquals("Chau mundo\n", captureOutput(() -> App.Exercise7("Hola Mundo")));
    }

    @Test
    public void exercise7PrintsNothingWhenStringDoesNotMatch() {
        assertEquals("", captureOutput(() -> App.Exercise7("Hola")));
    }

    @Test
    public void exercise8ReplacesLowercaseAWithUppercaseA() {
        assertEquals("cAsA\n", captureOutput(() -> App.Exercise8("casa")));
    }

    @Test
    public void exercise9RemovesRequestedLetter() {
        Scanner input = new Scanner("a\n");

        String output = captureOutput(() -> App.Exercise9(input, "banana"));

        assertEquals("Ingrese una letra para quitarla del string original\nbnn\n", output);
    }

    @Test
    public void exercise10PrintsAndReturnsFoundIndex() {
        Scanner input = new Scanner("n\n");
        final int[] result = new int[1];

        String output = captureOutput(() -> result[0] = App.Exercise10(input, "banana"));

        assertEquals(2, result[0]);
        assertEquals("Ingrese una letra para encontrarla en el string original\n2\n", output);
    }

    @Test
    public void exercise10PrintsNotFoundAndReturnsNegativeOne() {
        Scanner input = new Scanner("z\n");
        final int[] result = new int[1];

        String output = captureOutput(() -> result[0] = App.Exercise10(input, "banana"));

        assertEquals(-1, result[0]);
        assertEquals("Ingrese una letra para encontrarla en el string original\nNo se encontro\n", output);
    }

    @Test
    public void exercise11PrintsSubstringFromIndex() {
        assertEquals("nana\n", captureOutput(() -> App.Exercise11("banana", 2)));
    }

    @Test
    public void exercise11PrintsMessageWhenIndexIsInvalid() {
        assertEquals(
                "No hay una posicion valida para crear el substring\n",
                captureOutput(() -> App.Exercise11("banana", -1)));
    }

    @Test
    public void exercise12RequestsNewStringWhenStringIsEmpty() {
        Scanner input = new Scanner("nuevo\n");
        final String[] result = new String[1];

        String output = captureOutput(() -> result[0] = App.Exercise12(input, ""));

        assertEquals("nuevo", result[0]);
        assertEquals("Vuelve a ingresar un string\n", output);
    }

    @Test
    public void exercise12ReturnsOriginalStringWhenItIsNotEmpty() {
        Scanner input = new Scanner("");

        assertEquals("hola", App.Exercise12(input, "hola"));
    }

    private String captureOutput(Runnable action) {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        try {
            System.setOut(new PrintStream(output));
            action.run();
        } finally {
            System.setOut(originalOut);
        }

        return output.toString().replace(System.lineSeparator(), "\n");
    }
}
