
package umg.edu.gt.test.EjerciciosLinkedList;

import java.util.Arrays;
import java.util.LinkedList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import umg.edu.gt.desarrollo.estructuradedatos2025.ejercicios.EjercicioLinkedList;

/**
 *
 * @author Fernando
 */
public class ClaseLinkedList {
    
    EjercicioLinkedList ejercicioLinkedList = new EjercicioLinkedList();
    
    @Test
    void eliminarDuplicados_Correcto() {
        LinkedList<Integer> lista = new LinkedList<>(Arrays.asList(1, 2, 3, 2, 1));
        LinkedList<Integer> esperado = new LinkedList<>(Arrays.asList(1, 2, 3));

        ejercicioLinkedList.eliminarDuplicados(lista);
        assertEquals(esperado, lista);
    }

    @Test
    void eliminarDuplicados_Falla() {
        LinkedList<Integer> lista = new LinkedList<>(Arrays.asList(1, 2, 2));
        LinkedList<Integer> incorrecto = new LinkedList<>(Arrays.asList(1, 2, 2)); 
        
        ejercicioLinkedList.eliminarDuplicados(lista);
        assertEquals(incorrecto, lista);
    }
    
    @Test
    void invertirLista_Correcto() {
        LinkedList<String> lista = new LinkedList<>(Arrays.asList("A", "B", "C"));
        LinkedList<String> esperado = new LinkedList<>(Arrays.asList("C", "B", "A"));

        ejercicioLinkedList.invertirLista(lista);
        assertEquals(esperado, lista);
    }

    @Test
    void invertirLista_Falla() {
        LinkedList<String> lista = new LinkedList<>(Arrays.asList("A", "B", "C"));
        LinkedList<String> incorrecto = new LinkedList<>(Arrays.asList("A", "B", "C"));

        ejercicioLinkedList.invertirLista(lista);
        assertEquals(incorrecto, lista);
    }

    @Test
    void intercalarListas_Correcto() {
        LinkedList<Integer> l1 = new LinkedList<>(Arrays.asList(1, 3));
        LinkedList<Integer> l2 = new LinkedList<>(Arrays.asList(2, 4, 6));

        LinkedList<Integer> esperado = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 6));
        LinkedList<Integer> resultado = ejercicioLinkedList.intercalarListas(l1, l2);

        assertEquals(esperado, resultado);
    }
    
    @Test
    void intercalarListas_Falla() {
        LinkedList<Integer> l1 = new LinkedList<>(Arrays.asList(1));
        LinkedList<Integer> l2 = new LinkedList<>(Arrays.asList(2));

        LinkedList<Integer> incorrecto = new LinkedList<>(Arrays.asList(2, 1)); // Orden incorrecto

        LinkedList<Integer> resultado = ejercicioLinkedList.intercalarListas(l1, l2);

        assertEquals(incorrecto, resultado); // Esto debe fallar
    }

}
