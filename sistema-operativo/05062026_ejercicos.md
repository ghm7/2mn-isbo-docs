EJERCICIOS: RECONOCER PERMISOS DE ARCHIVOS EN LINUX
=====================================================

Referencia rápida:
  r = lectura   w = escritura   x = ejecución   - = sin permiso
  Formato: [propietario][grupo][otros]
  Ejemplo: rw-r--r--  →  propietario: rw-  /  grupo: r--  /  otros: r--


-----------------------------------------------------
EJERCICIO 1 — ¿Qué puede hacer cada usuario?
-----------------------------------------------------

El archivo "informe.txt" tiene los siguientes permisos:

  -rw-r-----
   ^^^         propietario
      ^^^      grupo
         ^^^   otros

Marcá con una X la afirmación correcta:

  [ ] A. El propietario puede ejecutar el archivo como programa.
  [x] B. El grupo puede leer el archivo pero no modificarlo.
  [ ] C. Otros usuarios pueden leer el archivo.
  [ ] D. El propietario no puede leer el archivo.


-----------------------------------------------------
EJERCICIO 2 — Identificá la combinación correcta
-----------------------------------------------------

El directorio "proyectos/" tiene los siguientes permisos:

  drwxr-x--x
  ^            indica que es un directorio
   ^^^          propietario
      ^^^       grupo
         ^^^    otros

¿Cuál de estas tablas describe correctamente los permisos?
Marcá con una X la opción correcta:

  [x] Opción A:
        Permiso | Propietario | Grupo | Otros
        --------|-------------|-------|------
        r       |     SI      |  SI   |  NO
        w       |     SI      |  NO   |  NO
        x       |     SI      |  SI   |  SI

  [ ] Opción B:
        Permiso | Propietario | Grupo | Otros
        --------|-------------|-------|------
        r       |     SI      |  SI   |  SI
        w       |     SI      |  NO   |  NO
        x       |     NO      |  SI   |  SI

  [ ] Opción C:
        Permiso | Propietario | Grupo | Otros
        --------|-------------|-------|------
        r       |     SI      |  SI   |  NO
        w       |     SI      |  NO   |  NO
        x       |     SI      |  SI   |  SI

  [ ] Opción D:
        Permiso | Propietario | Grupo | Otros
        --------|-------------|-------|------
        r       |     SI      |  NO   |  NO
        w       |     SI      |  NO   |  NO
        x       |     SI      |  SI   |  SI


-----------------------------------------------------
EJERCICIO 3 — ¿Está activo o inactivo?
-----------------------------------------------------
 
Los permisos se escriben en tres bloques de tres letras:
 
  r w x | r w x | r w x
  ------+-------+------
  propietario  grupo  otros
 
Cada letra indica un permiso activo. Si en su lugar aparece un guión ( - ),
ese permiso está INACTIVO para esa categoría.
 
Ejemplo resuelto:
  Archivo: datos.txt   Permisos: rw-r--r--
 
    rw-  r--  r--
    ^^^  ^^^  ^^^
    |    |    otros
    |    grupo
    propietario
 
  Pregunta: ¿Tiene el GRUPO permiso de ESCRITURA (w)?
  - No
  
  Pregunta: ¿Tiene el PROPIETARIO permiso de LECTURA (r)?
  - Si  

- - - - - - - - - - - - - - - - - - - - - - - - - - -
Ahora respondé vos. Para cada fila, fijate en el bloque
de la categoría indicada y buscá el permiso señalado.
Escribí ACTIVO o INACTIVO en el espacio.
- - - - - - - - - - - - - - - - - - - - - - - - - - -
 
1. Archivo: script.sh   Permisos: rwx r-- r--

   ¿Tiene el GRUPO permiso de ESCRITURA (w)?  →  No
 
2. Archivo: notas.txt   Permisos: rw- rw- r--
 
   ¿Tiene el PROPIETARIO permiso de EJECUCIÓN (x)?  →  No
 
3. Archivo: index         Permisos: --x r-x rwx
 
   ¿Tienen OTROS permiso de ESCRITURA (w)?  →  Si
 
4. Directorio: docs/    Permisos: rwx r-x ---

   ¿Tienen OTROS permiso de LECTURA (r)?  →  No
 
5. Archivo: config.cfg  Permisos: rw- r-- r--
 
   ¿Tiene el PROPIETARIO permiso de LECTURA (r)?  →  Si
