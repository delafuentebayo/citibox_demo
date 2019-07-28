Citibox hiring exercise
====================================

El API pública [The Rick and Morty API](https://rickandmortyapi.com/) permite consultar gran cantidad de información sobre la serie Rick y Morty.
Esta prueba técnica se basa en entender el funcionamiento de dicha API y construir una sencilla pero elegante aplicación en Android o en iOS que tenga las siguientes pantallas y funcionalidades.

## Primera pantalla

La primera pantalla de la aplicación mostrará todos los episodios de Rick y Morty publicados hasta la fecha.
Los episodios deberán estar agrupados por temporadas en diferentes secciones, conteniendo la siguiente información:

 - Información:
    - para cada temporada, un título identificativo (por ejemplo, “Temporada 1”, “Temporada 2”, etc.).
    - para cada episodio, el código y el título de dicho episodio.

## Segunda pantalla

Al pulsar en cualquiera de los episodios de la primera pantalla, se transitará a la segunda pantalla.
Esta contendrá, de nuevo, el código y el título del episodio, además de todos aquellos personajes que aparezcan en dicho episodio.

- Para cada personaje se mostrará la siguiente información:
	- imagen del personaje
	- nombre del personaje
	- especie a la que pertenece
	- status actual, es decir: vivo, muerto o desconocido

Además, en esta segunda pantalla se deberá ofrecer al usuario algún mecanismo de  filtrado de personajes de acuerdo a su status.
Los valores para filtrar personajes serán: vivos, muertos, desconocido o todos, que será valor por defecto y mostrará todos los personajes del episodio, independientemente de su status.

## Tests unitarios

Se elegirá un módulo cualquiera de la aplicación (primera pantalla, segunda pantalla, el API, etc.) para implementar un lote de tests unitarios básicos.
Para ello se podrá utilizar cualquier framework de testing que se desee. Tests de UI no son necesarios para esta prueba.


## Normas generales

- Aunque no existe un límite de tiempo para la prueba, se recomiendo no demorar la entrega más de una semana desde la recepción de este enunciado.
- El repositorio debe reflejar el progreso del mismo mediante una adecuada política de commits, ramas, etc.
- El API dispone de un límite de 10.000 requests cada 12 horas. Tenerlo presente durante la prueba.
- Todas las peticiones al API deben realizarse de forma asíncrona y con el mínimo de llamadas posibles.
- Diseñar el API teniendo en cuenta su escalabilidad.
- Para cualquier duda o pregunta, escribir a andresrodrigues@citibox.com.


## Normas para iOS

- Utilizar Xcode 9.x
- Deployment target de iOS debe ser 11.0
- Lenguaje Swift 4.x
- Se pueden utilizar tanto storyboards como xibs
- Utilizar Auto Layout
- La aplicación ha de ser de tipo Universal
- Puede utilizarse cualquier librería de terceros con Cocoapods o Carthage


## Normas para Android

- Utilizar Android Studio 3.x
- El API mínimo debe ser API 17 y el target API 27
- Lenguaje Java o Kotlin, a elegir
- Puede utilizarse cualquier librería de terceros mediante gradle


## ¿Qué se valorará?

- Calidad, legibilidad y limpieza del código
- Facilidad para mantener y modificar el código generado
- Separación de responsabilidades y testeabilidad del código
- Escalabilidad de la aplicación
- Arquitectura aplicada
- Correcta utilización del SDK de la plataforma
- Uso apropiado de Git
- Construcción eficiente y adaptativa de las diferentes vistas (storyboards y xibs en iOS, layouts XML en Android)
