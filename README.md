# ALG-I.primerProyecto
Proyecto realizado para la asignatura algorítmica I del grado de Ingeniería Informática

Problema planteado:
Dadas dos matrices de enteros, retorne un booleano indicando si son iguales, es decir, si tienen los
mismos valores en las mismas posiciones.
Para obtener su solución, debe deben implementar los siguientes métodos (usando recursividad en
ambos):
Método sonMatricesIguales: Recibe dos matrices y la fila por la que comenzar a comparar
(por defecto se recibirá siempre la última fila, de forma que se debe ir decrementando hasta llegar
al caso base). Por cada fila a comparar se usará el siguiente método sonVectoresIguales (definido a
continuación) para comparar vector a vector (es decir, fila a fila). Finalmente devolverá un valor
booleano indicando si las matrices son iguales (true) o no (false). La declaración de este método
será:
public boolean sonMatricesIguales(int [][] matriz1, int [][] matriz2, int fila)
Método sonVectoresIguales: Recibe dos vectores y devuelve un valor booleano indicando si ambos
vectores son iguales (true) o no (false). La declaración de este método será:
public boolean sonIguales(int [] vector 1, int [] vector2)
Solo puede usar los parámetros que se indican en los métodos descritos. Puede crear todos los
métodos auxiliares que estime oportuno.
Consejos:
Las matrices deben tener el mismo número de elementos para ser iguales, este debe ser uno de los
casos base.
Use el argumento fila para detectar en qué fila de la matriz se encuentra, y vaya decrementándola
hasta llegar a su caso base.
Para recorrer los vectores, debe dividirlos en trozos (de este modo no necesitará un índice para la
columna a tratar). Para trocear un vector use el siguiente método:
Arrays.copyOfRange(<VECTOR>, <INICIO>, <FIN>)
Donde:
<VECTOR> es el vector del que queremos extraer un subvector.
<INICIO> inicio del rango de los valores a obtener en el nuevo vector.
<FIN> fin del rango de los valores a obtener en el nuevo vector.
A la hora de calcular los tiempos de ejecución de su código, recuerde usar el método visto en clase para
la obtención de los nanosegundos: System.nanoTime();
