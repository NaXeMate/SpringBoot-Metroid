Metroid is a science-fiction action-adventure series by Nintendo where you play as the bounty hunter Samus Aran, exploring alien planets and uncovering secrets. The games focus on non-linear exploration, gradually unlocking areas as you acquire suit upgrades and abilities. Combat against hostile creatures, Space Pirates and Metroids is combined with platforming and puzzle-solving. Across the saga, Samus investigates threats like the parasitic Metroids and the mutagenic substance Phazon. The HUD of her Power Suit shows health, weapons and scanners, which is the inspiration for this project.

***

# Metroid Power Suit Management System (EN)

## Overview

This project is a Spring Boot REST API that simulates Samus Aran’s Power Suit logbook and field data across several planets of the Metroid universe. The application manages suit upgrades, explored regions and known enemies, storing everything in a MySQL database that is initialized from a `data.sql` file each time the application starts.

The focus is on:

- The configuration and status of Samus’s Power Suit.

- The upgrades she has installed and their dependencies.

- The different regions of planets like Zebes, Tallon IV and SR388.

- The enemies encountered in each area, with basic combat statistics.

All interaction with the project is done through HTTP endpoints (REST API), so you can use tools like curl, Postman or a browser for requests.

***

## Main Features

- Power Suit logbook with energy and defense status.

- Detailed upgrade system, including requirements between upgrades.

- Multi-planet region system with biomes, difficulty and exploration percentage.

- Enemy registry with combat statistics (health, damage, speed, danger level).

- Endpoints that return both stored data and calculated information (for example, tactical info or energy percentage).

- Use of DTOs, mappers and Value Objects to keep the code organized and clear.

***

## Data Model (High Level)

- **PowerSuit**
Represents Samus’s suit configuration (energy tanks, reserve tanks, heat and radiation resistance, etc.). It has:

    - An embedded `EnergyStatus` (energy tanks, reserve tanks).

    - An embedded `DefenseRating` (damage reduction, heat resistance, radiation resistance).

    - A list of **Upgrade** entities installed on the suit.

- **Upgrade**
Represents a specific improvement (Morph Ball, Charge Beam, Varia Suit, Gravity Suit, etc.). Each upgrade has:

    - A type/class (SUIT, BEAM, MORPH_BALL, VISOR, MISC).

    - An energy type and technological origin.

    - An optional `requiredUpgrade` (another upgrade that must be installed first).

    - A relation to the **PowerSuit** it belongs to (or `null` if it is not installed yet).

- **Region**
Represents an area on a planet (Brinstar, Norfair, Chozo Ruins, Phazon Mines, etc.). Each region has:

    - Planet, biome, difficulty level, climate and exploration percentage.

    - Embedded `PlanetaryCoordinates` (latitude, longitude, altitude).

    - A N:M relation with **Upgrade** (which upgrades can be found in that region).

    - A N:M relation with **Enemy**, with extra information stored in a join table.

- **Enemy**
Represents an enemy or boss (Zoomer, Metroid, Space Pirate, Ridley, Dark Samus, etc.). Each enemy has:

    - A class (COMMON, ELITE, MINI_BOSS, BOSS, FINAL_BOSS).

    - Description and base stats.

    - Embedded `CombatStats` (health points, attack power, speed, danger level).

    - A method that generates a tactical description string based on its stats.

***

## Endpoints

### PowerSuit Endpoints

- `GET /api/powersuits`
Returns a list of all Power Suits stored in the database (normally just one main suit).
Each item includes basic info about energy and defense, plus installed upgrades (via DTO).

- `GET /api/powersuits/{id}`
Returns the details of a specific suit by its ID.

- `POST /api/powersuits`
Creates a new Power Suit from a JSON body (DTO).
Useful if you want to simulate several different configurations or save states.

- `PUT /api/powersuits/{id}`
Updates an existing Power Suit with the values provided in the DTO.
It re-maps the value objects (`EnergyStatus`, `DefenseRating`) and can update the associated upgrades.

- `DELETE /api/powersuits/delete/{id}`
Deletes the suit with the given ID from the database, if it exists.

- `GET /api/powersuits/{id}/energy-percentage`
Returns the remaining energy percentage of the suit, calculated from its current and maximum energy.
This value is *not* stored in the database; it is computed at request time.

***

### Upgrade Endpoints

- `GET /api/upgrades`
Returns all available upgrades in the logbook.

- `GET /api/upgrades/{id}`
Returns the details of a specific upgrade by its ID.

- `POST /api/upgrades`
Creates a new upgrade from a DTO.

- `PUT /api/upgrades/{id}`
Updates an existing upgrade, including its requirement to another upgrade if needed.

- `DELETE /api/upgrades/delete/{id}`
Deletes an upgrade by ID.
If other upgrades depend on it as a requirement, the service prevents deletion and informs you of the conflict.

- `GET /api/upgrades/class/{upgradeClass}`
Returns all upgrades of a given class (for example, `MORPH_BALL`, `SUIT`, `BEAM`, `VISOR`, `MISC`).
This uses a repository method like `findByUpgradeClass(...)`.

***

### Region Endpoints

- `GET /api/regions`
Returns all known regions on all planets.

- `GET /api/regions/{id}`
Returns the details of a specific region, including its biome, difficulty and coordinates.

- `POST /api/regions`
Creates a new region.

- `PUT /api/regions/{id}`
Updates an existing region.

- `DELETE /api/regions/delete/{id}`
Deletes a region by ID.

- `GET /api/regions/planet/{planet}`
Returns the regions that belong to a specific planet (for example, `ZEBES`, `TALLON_IV`, `SR_388`).
This typically uses a simple custom query in the repository (JPQL or method name).

- `GET /api/regions/difficulty/{min}`
Returns the regions whose difficulty level is greater than or equal to the given value.

***

### Enemy Endpoints

- `GET /api/enemies`
Returns all enemies in the logbook, with their base stats.

- `GET /api/enemies/{id}`
Returns the details of a specific enemy by ID.

- `POST /api/enemies`
Adds a new enemy to the logbook.

- `PUT /api/enemies/{id}`
Updates an existing enemy (name, description, stats, etc.).

- `DELETE /api/enemies/delete/{id}`
Deletes an enemy from the logbook and returns the DTO of the deleted enemy.

- `GET /api/enemies/class/{enemyClass}`
Returns all enemies of a given class (`COMMON`, `ELITE`, `MINI_BOSS`, `BOSS`, `FINAL_BOSS`).
This uses a repository method like `findByEnemyClass(...)`.

- `GET /api/enemies/{id}/tactical-info`
Returns a textual tactical description of the enemy, generated from its `CombatStats`.
This string is calculated in a method of the `Enemy` entity and is not stored in the database.

***

# Metroid Power Suit Management System (ES)

## Descripción general

Este proyecto es una API REST con Spring Boot que simula el registro del Traje de Poder de Samus Aran y los datos de campo en varios planetas del universo Metroid. La aplicación gestiona las mejoras del traje, las regiones exploradas y los enemigos conocidos, almacenándolo todo en una base de datos MySQL que se inicializa desde un fichero `data.sql` cada vez que se inicia la aplicación.

El enfoque principal está en:

- La configuración y el estado del Traje de Samus.

- Las mejoras que tiene instaladas y sus requisitos.

- Las distintas regiones de planetas como Zebes, Tallon IV y SR388.

- Los enemigos encontrados en cada zona, con estadísticas de combate básicas.

Toda la interacción con el proyecto se realiza mediante endpoints HTTP (API REST), por lo que puedes usar herramientas como curl, Postman o el navegador para las peticiones GET.

***

## Funcionalidades principales

- Registro del Traje de Poder con estado de energía y defensa.

- Sistema de mejoras detallado, incluyendo requisitos entre upgrades.

- Sistema de regiones multi-planeta con biomas, dificultad y porcentaje de exploración.

- Registro de enemigos con estadísticas de combate (vida, daño, velocidad, nivel de peligro).

- Endpoints que devuelven tanto datos almacenados como información calculada (por ejemplo, información táctica o porcentaje de energía).

- Uso de DTOs, mapeadores y Value Objects para mantener el código organizado y claro.

***

## Modelo de datos (vista general)

- **PowerSuit (Traje de Poder)**
Representa la configuración del traje de Samus (tanques de energía, tanques de reserva, resistencia al calor y a la radiación, etc.). Tiene:

    - Un Value Object `EnergyStatus` embebido.

    - Un Value Object `DefenseRating` embebido.

    - Una lista de entidades **Upgrade** instaladas en el traje.

- **Upgrade (Mejora)**
Representa una mejora concreta (Morfosfera, Rayo Recarga, Traje Climático, Traje Gravitatorio, etc.). Cada mejora tiene:

    - Una clase/tipo (SUIT, BEAM, MORPH_BALL, VISOR, MISC).

    - Un tipo de energía y un origen tecnológico.

    - Un `requiredUpgrade` opcional (otra mejora que debe estar instalada antes).

    - Una relación con el **PowerSuit** al que pertenece (o `null` si aún no está instalada).

- **Region (Región)**
Representa una zona de un planeta (Brinstar, Norfair, Ruinas Chozo, Minas de Phazon, etc.). Cada región tiene:

    - Planeta, bioma, nivel de dificultad, clima y porcentaje de exploración.

    - Un Value Object `PlanetaryCoordinates` (latitud, longitud, altitud).

    - Una relación N:M con **Upgrade** (qué mejoras se pueden encontrar en esa región).

    - Una relación N:M con **Enemy**, con información adicional en una tabla intermedia.

- **Enemy (Enemigo)**
Representa un enemigo o jefe (Zoomer, Metroid, Pirata Espacial, Ridley, Samus Oscura, etc.). Cada enemigo tiene:

    - Una clase (COMMON, ELITE, MINI_BOSS, BOSS, FINAL_BOSS).

    - Descripción y estadísticas base.

    - Un Value Object `CombatStats` embebido (puntos de vida, daño de ataque, velocidad, nivel de amenaza).

    - Un método que genera una descripción táctica en forma de texto, a partir de sus estadísticas.

***

## Endpoints

Las rutas base siguientes suponen controladores mapeados bajo `/api/...`.
Todos los endpoints responden en JSON por defecto.

### Endpoints de PowerSuit

- `GET /api/powersuits`
Devuelve una lista de todos los Trajes de Poder guardados en la base de datos (normalmente solo uno principal).
Cada elemento incluye información básica de energía y defensa, además de las mejoras instaladas (vía DTO).

- `GET /api/powersuits/{id}`
Devuelve los detalles de un traje concreto por su ID.

- `POST /api/powersuits`
Crea un nuevo Traje de Poder a partir de un JSON (DTO).
Útil si quieres simular varias configuraciones o “partidas guardadas”.

- `PUT /api/powersuits/{id}`
Actualiza un Traje de Poder existente con los valores proporcionados en el DTO.
Vuelve a mapear los Value Objects (`EnergyStatus`, `DefenseRating`) y puede actualizar las mejoras asociadas.

- `DELETE /api/powersuits/delete/{id}`
Elimina el traje con el ID indicado de la base de datos, si existe.

- `GET /api/powersuits/{id}/energy-percentage`
Devuelve el porcentaje de energía restante del traje, calculado a partir de la energía actual y la máxima.
Este valor **no** se almacena en la base de datos; se calcula en el momento de la petición.

***

### Endpoints de Upgrade

- `GET /api/upgrades`
Devuelve todas las mejoras disponibles en el registro.

- `GET /api/upgrades/{id}`
Devuelve los detalles de una mejora concreta por su ID.

- `POST /api/upgrades`
Crea una nueva mejora a partir de un DTO.
- `PUT /api/upgrades/{id}`
Actualiza una mejora existente, incluyendo su requisito hacia otra mejora si es necesario.

- `DELETE /api/upgrades/delete/{id}`
Elimina una mejora por ID.
Si otras mejoras dependen de ella como requisito, el servicio impide el borrado y te informa del conflicto.

- `GET /api/upgrades/class/{upgradeClass}`
Devuelve todas las mejoras de una clase determinada (por ejemplo, `MORPH_BALL`, `SUIT`, `BEAM`, `VISOR`, `MISC`).
Utiliza un método en el repositorio como `findByUpgradeClass(...)`.

***

### Endpoints de Region

- `GET /api/regions`
Devuelve todas las regiones conocidas de todos los planetas.

- `GET /api/regions/{id}`
Devuelve los detalles de una región concreta, incluyendo bioma, dificultad y coordenadas.

- `POST /api/regions`
Crea una nueva región.

- `PUT /api/regions/{id}`
Actualiza una región existente.

- `DELETE /api/regions/delete/{id}`
Elimina una región por ID.

- `GET /api/regions/planet/{planet}`
Devuelve las regiones que pertenecen a un planeta concreto (por ejemplo, `ZEBES`, `TALLON_IV`, `SR_388`).
Normalmente se implementa con una consulta JPQL sencilla o un método derivado.

- `GET /api/regions/difficulty/{min}`
Devuelve las regiones cuyo nivel de dificultad es mayor o igual que el valor indicado.

***

### Endpoints de Enemy

- `GET /api/enemies`
Devuelve todos los enemigos del registro, con sus estadísticas base.

- `GET /api/enemies/{id}`
Devuelve los detalles de un enemigo concreto por ID.

- `POST /api/enemies`
Añade un nuevo enemigo al registro.

- `PUT /api/enemies/{id}`
Actualiza un enemigo existente (nombre, descripción, estadísticas, etc.).

- `DELETE /api/enemies/delete/{id}`
Elimina un enemigo del registro y devuelve el DTO del enemigo eliminado.

- `GET /api/enemies/class/{enemyClass}`
Devuelve todos los enemigos de una clase concreta (`COMMON`, `ELITE`, `MINI_BOSS`, `BOSS`, `FINAL_BOSS`).
Usa un método en el repositorio como `findByEnemyClass(...)`.

- `GET /api/enemies/{id}/tactical-info`
Devuelve una descripción táctica en texto del enemigo, generada a partir de su `CombatStats`.
Esta cadena se calcula en un método de la entidad `Enemy` y no se almacena en la base de datos.