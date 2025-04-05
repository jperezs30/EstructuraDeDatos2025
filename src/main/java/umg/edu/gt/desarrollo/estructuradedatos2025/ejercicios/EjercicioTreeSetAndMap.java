package umg.edu.gt.desarrollo.estructuradedatos2025.ejercicios;
 
import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

 public class EjercicioTreeSetAndMap {
 	
 	/* INSTRUCCIONES
  	Escriba el algoritmo que resuelve el problema en esta clase.
 	Debe crear un package llamado umg.edu.gt.test.EjercicioTree que corresponda al Test de esta clase.
 	Genere un Test por cada ejemplo y fuerce que uno de esos Test falle, puede implementar retornar un resultado
 	y compararlo con el esperado.
 	 */
 	
 	/* EJERCICIO 1: Análisis de Frecuencia de Palabras (TreeMap)
 	 * 📜 Descripción: Escriba un programa que lea un texto de un archivo y cuente la frecuencia de cada palabra, ordenándolas alfabéticamente.
 		🔹 Instrucciones:
 			Leer un archivo de texto (.txt).			
 			Dividir el texto en palabras (ignorando puntuaciones y convirtiéndolas a minúsculas).
 			Almacenar cada palabra en un TreeMap<String, Integer>, donde la clave es la palabra y el valor es el número de veces que aparece.
 			Imprimir las palabras en orden alfabético junto con su frecuencia.
 	 */
 	
         public void frecuenciaPalabras(){
            // TreeMap para almacenar palabras ordenadas alfabéticamente
           TreeMap<String, Integer> frecuencias = new TreeMap<>();

           // Leer el archivo de texto
           try (Scanner scanner = new Scanner(new File("texto.txt"))) {

               // Leer línea por línea
               while (scanner.hasNextLine()) {
                   String linea = scanner.nextLine().toLowerCase();

                   // Separar palabras, ignorando puntuación
                   String[] palabras = linea.split("[^a-záéíóúñ]+");

                   // Contar palabras
                   for (String palabra : palabras) {
                       if (!palabra.isEmpty()) {
                           frecuencias.put(palabra, frecuencias.getOrDefault(palabra, 0) + 1);
                       }
                   }
               }

           } catch (FileNotFoundException e) {
               System.err.println("Archivo no encontrado: " + e.getMessage());
               return;
           }

           // Imprimir las palabras en orden alfabético con su frecuencia
           System.out.println("Palabra : Frecuencia");
           for (Map.Entry<String, Integer> entrada : frecuencias.entrySet()) {
               System.out.printf("%-10s : %d%n", entrada.getKey(), entrada.getValue());
           }
         }
 	
 	/* EJERCICIO 2: Rastreador de Versiones de Código (TreeMap)
 		📜 Descripción: Desarrolle un programa que simule un rastreador de versiones de archivos en un sistema de control de versiones.
 		🔹 Instrucciones:
 			Utilice un TreeMap<Integer, String>, donde la clave representa el número de versión y el valor es el contenido de esa versión del código.			
 			Debe permitir:			
 			Agregar una nueva versión con una clave autoincrementada.			
 			Obtener una versión específica dada su clave.			
 			Obtener la última versión disponible.			
 			Eliminar una versión específica si es necesario.
 			
 			Salida:
 				Agregar versión 1: "System.out.println('Hola Mundo');"
 				Agregar versión 2: "System.out.println('Hola Java');"
 				Última versión: "System.out.println('Hola Java');"
 				Versión 1: "System.out.println('Hola Mundo');"
 
 	 * 
 	 */
         
        private TreeMap<Integer, String> versiones;
        private int versionActual;
 	public void inicializarVersion() {
            versiones = new TreeMap<>();
            versionActual = 0;
        }

        // Agrega una nueva versión autoincrementada
        public void agregarVersion(String contenido) {
            versionActual++;
            versiones.put(versionActual, contenido);
            System.out.printf("Versión %d agregada: %s%n", versionActual, contenido);
        }

        // Obtiene una versión específica por clave
        public String obtenerVersion(int numeroVersion) {
            return versiones.getOrDefault(numeroVersion, "Versión no encontrada.");
        }

        // Obtiene la última versión agregada
        public String obtenerUltimaVersion() {
            if (versiones.isEmpty()) {
                return "No hay versiones disponibles.";
            }
            return versiones.lastEntry().getValue();
        }

        // Elimina una versión específica
        public boolean eliminarVersion(int numeroVersion) {
            if (versiones.containsKey(numeroVersion)) {
                versiones.remove(numeroVersion);
                System.out.printf("Versión %d eliminada.%n", numeroVersion);
                return true;
            } else {
                System.out.println("La versión no existe.");
                return false;
            }
        }
        
        
 	/* EJERCICIO 3: Sistema de Gestión de Eventos (TreeSet)
 		📜 Descripción: Implemente un sistema para administrar eventos ordenados cronológicamente.		
 		🔹 Instrucciones:		
 			Utilice un TreeSet<Evento>, donde cada Evento debe contener:		
 			fecha (LocalDateTime)		
 			nombre (String)		
 			ubicación (String)		
 			Los eventos deben ordenarse automáticamente por fecha y hora.		
 			Debe permitir:		
 				Agregar un nuevo evento.		
 				Mostrar la lista de eventos en orden cronológico.		
 				Obtener el próximo evento a ocurrir.		
 				Eliminar un evento pasado automáticamente después de una consulta.
 				
 			Salida:
 				Próximo evento: "Conferencia de Java", 2025-05-10 10:00, Auditorio A  
 				Lista de eventos:  
 				1. "Taller de Machine Learning", 2025-04-15 14:00, Sala 3  
 				2. "Conferencia de Java", 2025-05-10 10:00, Auditorio A  
 
 	 */
 	
        static class Evento implements Comparable<Evento> {
            LocalDateTime fecha;
            String nombre;
            String ubicacion;

            public Evento(LocalDateTime fecha, String nombre, String ubicacion) {
                this.fecha = fecha;
                this.nombre = nombre;
                this.ubicacion = ubicacion;
            }
            
            @Override
            public int compareTo(Evento evento) {
                int cmp = this.fecha.compareTo(evento.fecha);
                if (cmp == 0) {
                    cmp = this.nombre.compareTo(evento.nombre);
                    if (cmp == 0) {
                        cmp = this.ubicacion.compareTo(evento.ubicacion);
                    }
                }
                return cmp;
            }
            
            @Override
            public String toString() {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                return "\"" + nombre + "\", " + fecha.format(formatter) + ", " + ubicacion;
            }
        }
	
        private static void imprimirEventos(TreeSet<Evento> eventos) {
            int count = 1;
            for (Evento e : eventos) {
                System.out.println(count + ". " + e);
                count++;
            }
        }
        
        private static Evento obtenerProximoEvento(TreeSet<Evento> eventos, LocalDateTime fechaActual) {
            // Se recorre el conjunto y se retorna el primer evento que no sea pasado.
            for (Evento e : eventos) {
                if (!e.fecha.isBefore(fechaActual)) {
                    return e;
                }
            }
            return null;
        }

        private static void limpiarEventosPasados(TreeSet<Evento> eventos, LocalDateTime fechaActual) {
            Iterator<Evento> iterator = eventos.iterator();
            while (iterator.hasNext()) {
                Evento e = iterator.next();
                if (e.fecha.isBefore(fechaActual)) {
                    iterator.remove();
                }
            }
        }

 }