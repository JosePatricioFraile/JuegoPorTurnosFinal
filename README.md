# Juego Por Turnos

## Descripción
Este proyecto es un juego de combates por turnos implementado en Java. Los jugadores se turnan para realizar acciones, con el objetivo de vencer al oponente. 
El proyecto cuenta con la clase abstracta `Personaje`, de la cual heredan las clases `Caballero`, `Mago` y `Asesino`.
También tiene una interfaz con un método común para `Mago` y `Asesino`.
Hay una clase dedicada a la conexión con la base de datos. Al iniciarse comprueba la conexión y al crear y eliminar personajes se insertan y eliminan de la base de datos.
Hay una clase dedicada a crear un fichero para los logs de errores, este se crea en la dirección `"C:/Errores/logErrores.txt"`.

## Clases y Atributos principales

### `Personaje`
Clase abstracta base.

- **Atributos**: Nombre, vida, daño, resistencia.
- **Métodos**: Métodos de ataque que restan vida al oponente según el ataque y armadura.

### `MovimientoEspecial`
Interfaz

- **Métodos**: Ataque especial que resta vida al oponente.

### `Caballero`
Hereda de `Personaje`.

- **Método propio**: Incrementa la armadura.

### `Mago`
Hereda de `Personaje` e implementa `MovimientoEspecial`.

- **Atributos propios**: Mana.
- **Ataque especial**: Método de la interfaz que resta vida al oponente dependiendo también del mana del usuario.

### `Asesino`
Hereda de `Personaje` e implementa `MovimientoEspecial`.

- **Ataque especial**: Método de la interfaz que resta vida al oponente.

## Al iniciarlo sale por pantalla el siguiente menú:
1. "Crear un personaje"
2. "Mostrar personajes"
3. "Eliminar un personaje"
4. "Iniciar una pelea"
5. "Salir"

### Descripción del menú

- **Crear un personaje**: pide el nombre y la clase que quiere que sea. Al elegir la clase tiene un `try catch` de manera que si no se elige una de las opciones correctas, crea un mensaje de error y sale por el fichero. Al crear el personaje se guarda en un `ArrayList` de los personajes y se inserta en la base de datos.

- **Mostrar personajes**: muestra las estadísticas de todos los personajes que se encuentren en el `ArrayList` de los personajes.

- **Eliminar un personaje**: comprueba que el personaje esté en el `ArrayList`, si está se elimina de este y de la base de datos. Si no está, manda un mensaje de error y también se guarda en el fichero de los logs de error.

- **Iniciar una pelea**: comprueba que haya por lo menos dos personajes creados en el `ArrayList`. Si no es así, muestra un mensaje de error. Si hay dos o más personajes, muestra la lista y deja elegir en el orden que quieres que vayan. Una vez creada la pelea, se muestra un menú de los movimientos posibles del jugador 1, después los movimientos posibles del jugador 2 y se comprueba el ganador de la pelea mirando la vida de los dos jugadores. Si los dos siguen con vida, sigue la pelea.

- **Salir**: cambia el estado del booleano del menú para que sea `false` y se sale de este.
