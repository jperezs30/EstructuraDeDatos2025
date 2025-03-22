package umg.edu.gt.desarrollo.estructuradedatos2025.ejercicios;

import java.util.LinkedList;

public class EjercicioLinkedList {
	
	/* INSTRUCCIONES
 	Escriba el algoritmo que resuelve el problema en esta clase.
	Debe crear un package llamado umg.edu.gt.test.EjercicioLinkedList que corresponda al Test de esta clase.
	Genere un Test por cada ejemplo y fuerce que uno de esos Test falle, puede implementar retornar un resultado
	y compararlo con el esperado.
	 */
	
	// Usando LinkedList de Java Collections, resuelva los siguientes problemas
	// Problema 1: Dada una LinkedList<Integer>, escribir un método que elimine los valores duplicados, dejando solo la primera aparición de cada número.
    
        public static void eliminarDuplicados(LinkedList<Integer> lista) {
            for (int i = 0; i < lista.size(); i++) {
                Integer actual = lista.get(i);
                // Compara con los elementos siguientes
                for (int j = i + 1; j < lista.size(); j++) {
                    if (actual.equals(lista.get(j))) {
                        lista.remove(j);
                        j--; // ajusta índice porque se eliminó un elemento
                    }
                }
            }
        }


    
	// Problema 2: Implementar un método que invierta los elementos de una LinkedList<String> sin usar otra lista o ArrayList.
        public static void invertirLista(LinkedList<String> lista) {
            int tamaño = lista.size();
            for (int i = 0; i < tamaño / 2; i++) {
                String temporal = lista.get(i);
                lista.set(i, lista.get(tamaño - 1 - i));
                lista.set(tamaño - 1 - i, temporal);
            }
        }

        
	// Problema 3: Dadas dos listas enlazadas ordenadas de enteros, escribir un método que devuelva una nueva LinkedList<Integer> con los elementos de ambas listas intercalados en orden.
        public static LinkedList<Integer> intercalarListas(LinkedList<Integer> l1, LinkedList<Integer> l2) {
            LinkedList<Integer> resultado = new LinkedList<>();
            int tamañoMaximo = Math.max(l1.size(), l2.size());

            for (int i = 0; i < tamañoMaximo; i++) {
                if (i < l1.size()) {
                    resultado.add(l1.get(i));
                }
                if (i < l2.size()) {
                    resultado.add(l2.get(i));
                }
            }

            return resultado;
        }


}
