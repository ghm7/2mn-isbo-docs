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

Genera tarjetas de estudio siguiendo este orden de prioridad:

1. Conceptos respondidos incorrectamente.
2. Conceptos en los que el usuario mostró dudas.
3. Conceptos fundamentales del tema.
4. Aplicaciones prácticas importantes.

Reglas para las tarjetas:
- Cada tarjeta debe evaluar un único concepto.
- El frente debe contener una pregunta clara y específica.
- El reverso debe contener una respuesta breve y precisa.
- Evita preguntas ambiguas.
- Evita duplicar conceptos.
- Prioriza preguntas que requieran recordar o aplicar conocimientos.
- Genera tantas tarjetas como sean necesarias para cubrir los conceptos relevantes, sin agregar contenido redundante.

## 7. Exportación JSON

Al finalizar la sesión, genera un archivo llamado `study-flashcards.json` en el directorio de trabajo actual.

El contenido debe ser un array JSON con la siguiente estructura:

```json
[
  {
    "front": "¿Qué es una función lineal?",
    "back": "Es una función de la forma f(x) = mx + b, según la convención utilizada."
  },
  {
    "front": "¿Qué representa la pendiente de una recta?",
    "back": "La variación de Y por cada unidad que aumenta X."
  }
]
```

Reglas estrictas del archivo:

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

Si puedes escribir archivos, crea el JSON directamente. Si no puedes, muestra su contenido en un bloque de código JSON para que el usuario pueda guardarlo manualmente.

## Reglas generales

- Cuando el usuario proporcione material de estudio, utiliza exclusivamente ese material.
- Señala cualquier información posiblemente incorrecta en lugar de hacer suposiciones.
- Nunca reveles respuestas de la evaluación antes de que el usuario intente responder.
- Adapta la dificultad al nivel demostrado por el usuario.
- No confundas las 5 preguntas de evaluación con las tarjetas exportadas: son actividades diferentes.
- No generes las tarjetas definitivas hasta completar la evaluación y analizar los resultados.
