Juego Por Turnos
================

Descripción
-----------

Este proyecto es un juego por turnos implementado en Java. Los jugadores se turnan para realizar acciones, con el objetivo de vencer al oponente. El proyecto cuenta con la clase abstracta `Personaje`, de la cual heredan las clases `Caballero`, `Mago` y `Asesino`.

### Clases y Atributos

-   Personaje: Clase abstracta base.
    -   Atributos: Nombre, vida, daño, resistencia.
    -   Métodos: Métodos de ataque que restan vida al oponente según el ataque y armadura.
-   Caballero: Hereda de `Personaje`.
    -   Método propio: Incrementa la armadura.
-   Mago: Hereda de `Personaje`.
    -   Atributos propios: Mana.
    -   Método propio: Ataque especial.
-   Asesino: Hereda de `Personaje`.
    -   Método propio: Ataque especial.
