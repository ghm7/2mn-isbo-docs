---
name: study-session
description: Usar cuando el usuario quiera estudiar, repasar, aprender, comprender un tema o prepararse para un examen. Sigue una rutina de explicación, comprobación, evaluación y exportación de tarjetas de estudio.
---

# Sesión de estudio

Sigue estos pasos en orden. Nunca omitas la evaluación.

## 1. Contexto

Pregunta al usuario:
- Para qué necesita estudiar el tema (curso, examen, fecha).
- Qué conocimientos previos tiene.
- Qué material de estudio utilizará.

No repitas preguntas que el usuario ya haya respondido.

## 2. Explicación

Explica el tema con un lenguaje sencillo, como si se lo explicaras a un niño inteligente de 12 años.

Reglas:
- Utiliza al menos un ejemplo concreto.
- No superes las 250 palabras por explicación.
- Divide los temas complejos en partes pequeñas.
- No avances hasta que el usuario comprenda la explicación.

## 3. Comprobación

Pide al usuario que explique el tema con sus propias palabras.

- Identifica los errores y conceptos faltantes.
- No repitas directamente la explicación original.
- Utiliza preguntas orientadoras para ayudarlo.
- Si demuestra dificultades, vuelve a trabajar ese concepto antes de avanzar.

## 4. Evaluación interactiva

Realiza 5 preguntas, UNA A LA VEZ.

- Espera la respuesta antes de continuar.
- Combina preguntas de conocimiento ("¿qué es...?") con preguntas de aplicación ("¿qué sucede si...?").
- No reveles las respuestas antes de que el usuario intente responder.
- Después de cada respuesta, indica si fue correcta y explica por qué en un máximo de 2 oraciones.
- Registra los errores, las dudas y los conceptos que el usuario domina.

## 5. Identificación de puntos débiles

Al terminar la evaluación:

- Enumera los conceptos que el usuario respondió incorrectamente.
- Identifica los conceptos en los que mostró dudas.
- Resume brevemente qué necesita repasar.
- Si no hubo errores, identifica los conceptos fundamentales del tema.

## 6. Generación de tarjetas de estudio

Genera DOS versiones de las tarjetas, con los mismos datos en ambas y en el mismo orden:

1. Puntos débiles identificados: conceptos respondidos incorrectamente y conceptos en los que el usuario mostró dudas.
2. Conceptos clave del tema, incluidas las aplicaciones prácticas importantes.

Reglas comunes:
- Cada tarjeta contiene UN SOLO dato (un único concepto, definición o relación).
- Evita preguntas ambiguas.
- Evita duplicar datos dentro de una misma versión.
- Prioriza lo que requiera recordar o aplicar conocimientos.
- Genera tantas tarjetas como sean necesarias para cubrir los puntos débiles y los conceptos clave, sin agregar contenido redundante.

### Versión 1: pregunta y respuesta (`qa`)

- El frente es una pregunta clara y específica.
- El reverso es una respuesta breve y precisa.

### Versión 2: espacios en blanco (`cloze`)

- Prioriza oraciones con espacios en blanco para los términos importantes.
- El frente es una oración que oculta el término clave con `{{...}}`.
- El reverso contiene solo el término oculto. Si el dato necesita dos términos, usa un `{{...}}` por cada uno y sepáralos en el reverso con `; `, en el mismo orden.
- Usa una pregunta solo cuando el dato no se pueda expresar bien como oración con espacios en blanco.

## 7. Exportación JSON

Al finalizar la sesión, genera DOS archivos, uno por cada versión de tarjetas.

### Ubicación

Guarda los archivos en la carpeta de la materia, junto con los demás archivos de esa materia (por ejemplo, `derecho/`).

Determina la carpeta así:
1. La carpeta de la materia donde está el material de estudio o las notas que el usuario indicó.
2. La carpeta de la materia que el usuario mencionó.
3. El directorio de trabajo actual, solo si ya es una carpeta de materia.

Si no puedes determinarla con certeza, pregúntale al usuario. No guardes los archivos en la raíz del repositorio.

### Nombre

`<tema>_tarjetas_qa.json` y `<tema>_tarjetas_cloze.json`

- `<tema>` es el tema estudiado en minúsculas, con guiones bajos y sin tildes ni caracteres especiales (por ejemplo, `estructura_orden_juridico`).
- Sigue la convención de los archivos de tarjetas que ya existan en esa carpeta.

### Contenido

Cada archivo es un array JSON. Ejemplo de la versión `qa`:

```json
[
  {
    "front": "¿Qué representa la pendiente de una recta?",
    "back": "La variación de Y por cada unidad que aumenta X."
  }
]
```

Ejemplo de la versión `cloze`:

```json
[
  {
    "front": "La pendiente de una recta representa la variación de {{...}} por cada unidad que aumenta {{...}}.",
    "back": "Y; X"
  }
]
```

Reglas estrictas de los archivos:

- El archivo debe ser JSON válido.
- El elemento raíz debe ser un array.
- Cada objeto debe contener exactamente dos propiedades: `front` y `back`.
- Ambas propiedades deben ser strings no vacíos.
- No agregues propiedades adicionales.
- No utilices comentarios dentro del JSON.
- No incluyas bloques Markdown dentro del archivo.
- Utiliza codificación UTF-8.
- Escapa correctamente las comillas y los caracteres especiales.
- Valida que el JSON sea correcto antes de finalizar.
- No sobrescribas archivos existentes sin autorización; utiliza un nombre alternativo si es necesario.

Si puedes escribir archivos, crea los JSON directamente. Si no puedes, muestra el contenido de cada uno en un bloque de código JSON, indicando el nombre y la carpeta sugeridos, para que el usuario pueda guardarlos manualmente.

## Reglas generales

- Cuando el usuario proporcione material de estudio, utiliza exclusivamente ese material.
- Señala cualquier información posiblemente incorrecta en lugar de hacer suposiciones.
- Nunca reveles respuestas de la evaluación antes de que el usuario intente responder.
- Adapta la dificultad al nivel demostrado por el usuario.
- No confundas las 5 preguntas de evaluación con las tarjetas exportadas: son actividades diferentes.
- No generes las tarjetas definitivas hasta completar la evaluación y analizar los resultados.
