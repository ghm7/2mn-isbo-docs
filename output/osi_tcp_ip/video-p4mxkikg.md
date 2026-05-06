# Video p4mXkikG

> Video: `https://www.youtube.com/watch?v=p4mXkikGxlk`

---

## Table of Contents

1. [Overview](#overview)
2. [Concept Map](#concept-map)
3. [Detailed Notes](#detailed-notes)
4. [Key Concepts](#key-concepts)
5. [Glossary](#glossary)
6. [Cheat Sheet](#cheat-sheet)
7. [Takeaways](#takeaways)
8. [Quiz (4q)](#quiz)
9. [Flashcards (5)](#flashcards)
10. [Exercises (1)](#exercises)
11. [Learning Path](#learning-path)

---

## Overview

El contenido presenta una introducción práctica a los comandos de red más comunes para diagnosticar, verificar y comprender el estado de una conexión en sistemas tipo Windows. La tesis central es que, antes de modificar o instalar equipos en una red, conviene observar la configuración local, comprobar la conectividad, identificar rutas, revisar puertos y validar la resolución DNS mediante herramientas de línea de comandos. La metodología propuesta es exploratoria y diagnóstica: ejecutar comandos, consultar su ayuda con el signo de interrogación o modificadores disponibles, observar los resultados y practicar su interpretación en entornos reales o simuladores.

El recorrido comienza con ipconfig, que permite conocer la configuración IP del equipo: dirección IP, máscara de subred, puerta de enlace, configuración DHCP y servidores DNS. Su variante ipconfig /all ofrece información más profunda, útil para ubicar un equipo dentro de una red y replicar parámetros válidos al instalar una máquina nueva o configurar una IP estática. Luego se aborda netstat, orientado a observar conexiones y puertos abiertos en la capa de transporte, lo que ayuda a comprobar si existen comunicaciones activas con otros equipos o servicios externos.

El comando arp permite ver la relación entre direcciones IP y direcciones físicas MAC con las que el equipo se ha comunicado, aportando una visión de capa 2. Ping se presenta como una herramienta esencial para verificar conectividad mediante mensajes ICMP; sus modificadores permiten realizar pruebas continuas, aumentar el tamaño del paquete o ajustar el tiempo de espera. Tracert amplía esta verificación mostrando la ruta y los saltos intermedios hasta un destino. Finalmente, nslookup permite comprobar si el DNS resuelve correctamente nombres de dominio a direcciones IP.

La conclusión es que estos comandos forman una caja básica de diagnóstico de red. Su valor no está solo en ejecutarlos, sino en interpretar sus resultados para localizar fallas, validar configuraciones y comprender el comportamiento de una red.

---

## Concept Map

![Concept Map](video-p4mxkikg-concept-map.png)

---

## Detailed Notes

## 1. Propósito general de los comandos de red

Los comandos presentados sirven para **diagnosticar, verificar y comprender el estado de una red** desde un equipo cliente. Permiten responder preguntas como:

- ¿Qué dirección IP tiene mi equipo?
- ¿La IP fue asignada automáticamente por DHCP o configurada manualmente?
- ¿Cuál es la puerta de enlace predeterminada?
- ¿Qué máscara de subred se está usando?
- ¿Existe conectividad con otro equipo?
- ¿Qué puertos o conexiones están activos?
- ¿Qué dirección MAC corresponde a una IP conocida?
- ¿Por qué ruta viajan los paquetes hasta un destino?
- ¿El servidor DNS resuelve nombres correctamente?

Una idea clave del contenido es que **los comandos no solo se ejecutan: se interpretan**. El aprendizaje real ocurre al observar resultados, compararlos con lo esperado y deducir el estado de la red.

## 2. Ayuda y modificadores de comandos

Muchos comandos de red admiten **modificadores**, también llamados opciones o parámetros. Estos amplían su comportamiento.

### Cómo pedir ayuda

En Windows, normalmente se puede consultar la ayuda de un comando con:

```text
comando /?
```

Ejemplos:

```text
ipconfig /?
ping /?
netstat /?
arp /?
tracert /?
nslookup /?
```

La ayuda muestra:

- Sintaxis del comando.
- Modificadores disponibles.
- Ejemplos de uso.
- Explicación de los campos de salida.

## 3. ipconfig: ver la configuración IP local

### Función principal

`ipconfig` muestra el estado de las interfaces de red del equipo. Permite saber cómo está configurado el host dentro de la red.

Comando básico:

```text
ipconfig
```

### Información que entrega

Entre los datos más importantes se encuentran:

- **Dirección IPv4**: IP asignada al equipo.
- **Máscara de subred**: define el tamaño de la red local.
- **Puerta de enlace predeterminada**: router o gateway usado para salir a otras redes.
- **Adaptador de red**: interfaz física o virtual usada para conectarse.

Ejemplo conceptual:

```text
Dirección IPv4 . . . . . . . . . . : 192.168.1.25
Máscara de subred . . . . . . . . : 255.255.255.0
Puerta de enlace predeterminada . : 192.168.1.1
```

### Interpretación

Con esos datos se puede deducir:

- El equipo pertenece a la red `192.168.1.0/24`.
- Puede comunicarse directamente con hosts como `192.168.1.10` o `192.168.1.50`.
- Para salir hacia Internet u otras redes usará el gateway `192.168.1.1`.

### Uso para instalar una máquina nueva

El contenido menciona una práctica común: si se instala un equipo nuevo, puede observarse la configuración de una máquina vecina para inferir los parámetros de red.

Por ejemplo, si una PC vecina tiene:

```text
IP: 192.168.1.20
Máscara: 255.255.255.0
Gateway: 192.168.1.1
DNS: 8.8.8.8
```

Entonces una nueva máquina podría configurarse con una IP libre del mismo rango, por ejemplo:

```text
IP: 192.168.1.30
Máscara: 255.255.255.0
Gateway: 192.168.1.1
DNS: 8.8.8.8
```

Advertencia importante: antes de asignar una IP estática hay que verificar que no esté en uso para evitar conflictos.

## 4. ipconfig /all: información detallada de red

Comando:

```text
ipconfig /all
```

### Qué agrega respecto de ipconfig

`ipconfig /all` muestra información más completa, como:

- Dirección física o **MAC address**.
- Estado de DHCP.
- Servidor DHCP usado.
- Servidores DNS configurados.
- Sufijo DNS.
- Fecha de concesión DHCP.
- Fecha de expiración de la concesión DHCP.

### DHCP

Si el equipo obtiene su IP automáticamente, aparecerá información relacionada con **DHCP**. DHCP asigna automáticamente parámetros como:

- Dirección IP.
- Máscara de subred.
- Gateway.
- DNS.

Esto permite determinar si el equipo está configurado manualmente o si depende de un servidor DHCP.

### DNS

Si hay servidores DNS configurados, también aparecen en la salida de `ipconfig /all`. Esto es importante porque un equipo puede tener conectividad IP pero no resolver nombres de dominio.

Ejemplo de problema:

- `ping 8.8.8.8` funciona.
- `ping google.com` no funciona.

Interpretación probable: hay conectividad IP, pero falla la resolución DNS.

## 5. netstat: conexiones y puertos activos

### Función principal

`netstat` permite observar conexiones de red activas y puertos abiertos en la **capa de transporte**, principalmente TCP y UDP.

Comando básico:

```text
netstat
```

Comando frecuente:

```text
netstat -an
```

### Qué permite observar

- Conexiones locales y remotas.
- Puertos abiertos o en escucha.
- Estados de conexiones TCP.
- Servicios que podrían estar comunicándose con el exterior.

### Conceptos clave

Una conexión de red suele identificarse por:

```text
IP local : puerto local  ->  IP remota : puerto remoto
```

Ejemplo conceptual:

```text
TCP 192.168.1.25:51532 142.250.78.14:443 ESTABLISHED
```

Interpretación:

- El equipo local `192.168.1.25` está conectado desde el puerto local `51532`.
- El destino remoto es `142.250.78.14`.
- El puerto remoto `443` corresponde normalmente a HTTPS.
- El estado `ESTABLISHED` indica conexión activa.

### Estados comunes en TCP

- **LISTENING**: un servicio está esperando conexiones entrantes.
- **ESTABLISHED**: conexión activa entre dos equipos.
- **TIME_WAIT**: conexión cerrada recientemente, esperando limpieza.
- **CLOSE_WAIT**: el extremo remoto cerró la conexión y el local aún no terminó.

### Utilidad diagnóstica

`netstat` ayuda a responder:

- ¿Hay servicios escuchando en el equipo?
- ¿Existe comunicación activa con otro host?
- ¿Qué puertos están siendo usados?
- ¿Se detectan conexiones inesperadas?

## 6. arp: relación entre direcciones IP y direcciones físicas

### Función principal

`arp` muestra la tabla ARP del equipo. Esta tabla relaciona direcciones IP con direcciones físicas MAC.

Comando habitual:

```text
arp -a
```

### Capa de red relacionada

ARP trabaja entre:

- **Capa 2**: direcciones MAC.
- **Capa 3**: direcciones IP.

Permite que un host sepa a qué dirección MAC debe enviar una trama Ethernet cuando quiere comunicarse con una IP dentro de la misma red local.

### Ejemplo conceptual

```text
Interfaz: 192.168.1.25 --- 0x6
  Dirección de Internet      Dirección física        Tipo
  192.168.1.1                aa-bb-cc-dd-ee-ff       dinámico
  192.168.1.20               11-22-33-44-55-66       dinámico
```

Interpretación:

- El equipo conoce la MAC asociada a `192.168.1.1`, probablemente el gateway.
- También conoce la MAC de `192.168.1.20`, un host con el que se comunicó.

### Qué revela la tabla ARP

La tabla ARP permite ver:

- Con qué equipos de la red local se comunicó el host.
- Qué IP corresponde a qué MAC.
- Si hay entradas dinámicas aprendidas automáticamente.
- Si existen entradas estáticas configuradas manualmente.

### Direcciones broadcast

El contenido menciona direcciones lógicas como broadcast. En redes IPv4, una dirección de broadcast permite enviar un paquete a todos los hosts de una subred.

Ejemplo para red `192.168.1.0/24`:

```text
Dirección de red:      192.168.1.0
Hosts válidos:         192.168.1.1 - 192.168.1.254
Broadcast:             192.168.1.255
Máscara:               255.255.255.0
```

## 7. ping: prueba básica de conectividad

### Función principal

`ping` permite comprobar si un equipo responde en la red mediante mensajes ICMP.

Comando básico:

```text
ping destino
```

Ejemplos:

```text
ping 192.168.1.1
ping 8.8.8.8
ping google.com
```

### Qué mide ping

Normalmente muestra:

- Si hubo respuesta del destino.
- Tiempo de ida y vuelta en milisegundos.
- Cantidad de paquetes enviados y recibidos.
- Porcentaje de pérdida.
- TTL del paquete recibido.

Ejemplo conceptual:

```text
Respuesta desde 8.8.8.8: bytes=32 tiempo=18ms TTL=118
Paquetes: enviados = 4, recibidos = 4, perdidos = 0 (0% perdidos)
```

### Interpretación básica

- **0% de pérdida**: conectividad estable durante la prueba.
- **Pérdida parcial**: posible congestión, interferencia, mala conexión o filtrado.
- **100% de pérdida**: no hay respuesta; puede ser falla de red, firewall o destino apagado.
- **Tiempo alto**: latencia elevada.

### Modificador -t: ping continuo

Comando:

```text
ping -t destino
```

Uso:

- Envía paquetes continuamente hasta detenerlo manualmente.
- En Windows se detiene con `Ctrl + C`.

Aplicaciones:

- Verificar cuándo vuelve una conexión después de repararla.
- Detectar cortes intermitentes.
- Observar pérdida de paquetes en el tiempo.

Ejemplo:

```text
ping -t 192.168.1.1
```

Si el gateway no responde y luego se repara el enlace, se verá el cambio de mensajes fallidos a respuestas exitosas.

### Modificador -w: tiempo de espera

Comando:

```text
ping -w tiempo_en_ms destino
```

Ejemplo:

```text
ping -w 3000 192.168.1.1
```

Aumenta el tiempo de espera antes de considerar que no hubo respuesta. Es útil en conexiones lentas, saturadas o inestables.

### Modificador -l: tamaño del paquete

Comando:

```text
ping -l tamaño_en_bytes destino
```

Ejemplo:

```text
ping -l 1000 192.168.1.1
```

Permite enviar paquetes más grandes para probar comportamiento bajo mayor carga o detectar problemas relacionados con MTU.

### Secuencia recomendada de pruebas con ping

Para diagnosticar conectividad, conviene probar en este orden:

1. `ping 127.0.0.1` para comprobar la pila TCP/IP local.
2. `ping IP_local` para comprobar la interfaz del equipo.
3. `ping gateway` para comprobar salida a la red local.
4. `ping IP_externa` para comprobar salida a Internet sin depender de DNS.
5. `ping dominio` para comprobar conectividad más resolución DNS.

## 8. tracert: ruta y saltos hasta un destino

### Función principal

`tracert` muestra por dónde pasa un paquete antes de llegar a su destino. Permite ver la ruta en términos de saltos intermedios.

Comando:

```text
tracert destino
```

Ejemplos:

```text
tracert 8.8.8.8
tracert google.com
```

### Qué es un salto

Un **salto** es un router o equipo intermedio por el que pasa el tráfico. En redes grandes, el paquete puede atravesar varios routers antes de llegar al destino.

### Ejemplo conceptual

```text
  1     1 ms     1 ms     1 ms  192.168.1.1
  2    10 ms    12 ms    11 ms  10.20.0.1
  3    18 ms    17 ms    19 ms  200.45.10.1
  4    25 ms    24 ms    26 ms  8.8.8.8
```

Interpretación:

- El primer salto suele ser el gateway local.
- Los saltos siguientes son routers intermedios.
- Si la ruta se corta en un salto, el problema puede estar a partir de ese punto.

### Relación con ping

- `ping` responde si hay conectividad con el destino.
- `tracert` muestra el camino que sigue el tráfico.

Por eso, si `ping` falla, `tracert` ayuda a ubicar dónde podría estar el corte.

## 9. nslookup: resolución DNS

### Función principal

`nslookup` consulta servidores DNS para resolver nombres de dominio a direcciones IP.

Comando básico:

```text
nslookup dominio
```

Ejemplo:

```text
nslookup google.com
```

### Qué permite verificar

- Si el equipo tiene configurado un servidor DNS.
- Si ese DNS responde.
- Qué IP corresponde a un nombre de dominio.
- Si un problema de navegación se debe a DNS o a conectividad.

### Ejemplo conceptual

```text
Servidor:  dns.local
Address:   192.168.1.1

Nombre:    google.com
Addresses: 142.250.78.14
```

Interpretación:

- El servidor DNS usado es `192.168.1.1`.
- El dominio `google.com` fue resuelto a una IP.

### Diagnóstico típico

Caso 1:

```text
ping 8.8.8.8 funciona
nslookup google.com falla
```

Interpretación: la conexión IP existe, pero hay problema DNS.

Caso 2:

```text
ping 8.8.8.8 falla
nslookup google.com falla
```

Interpretación: puede haber un problema de conectividad general, gateway, enlace o firewall.

## 10. Relación de comandos con capas de red

| Comando | Capa principal | Qué diagnostica |
|---|---:|---|
| `ipconfig` | Capa 3 | Configuración IP local |
| `ipconfig /all` | Capas 2/3 | IP, MAC, DHCP, DNS |
| `arp -a` | Capas 2/3 | Relación IP-MAC en red local |
| `ping` | Capa 3 | Conectividad mediante ICMP |
| `tracert` | Capa 3 | Ruta y saltos hasta destino |
| `netstat` | Capa 4 | Puertos y conexiones TCP/UDP |
| `nslookup` | Capa 7 | Resolución de nombres DNS |

## 11. Flujo práctico de diagnóstico de red

Un procedimiento ordenado podría ser:

### Paso 1: Ver configuración local

```text
ipconfig /all
```

Comprobar:

- IP válida.
- Máscara correcta.
- Gateway configurado.
- DNS configurado.
- DHCP activo o IP estática esperada.

### Paso 2: Probar pila local

```text
ping 127.0.0.1
```

Si falla, el problema está en la configuración TCP/IP local.

### Paso 3: Probar gateway

```text
ping IP_del_gateway
```

Si falla, revisar:

- Cableado o Wi-Fi.
- VLAN o switch.
- Máscara incorrecta.
- IP duplicada.
- Gateway apagado o filtrando ICMP.

### Paso 4: Ver vecinos conocidos

```text
arp -a
```

Comprobar si aparece la MAC del gateway u otros hosts.

### Paso 5: Probar salida externa

```text
ping 8.8.8.8
```

Si funciona, hay salida IP hacia Internet.

### Paso 6: Probar DNS

```text
nslookup google.com
```

Si falla, revisar configuración DNS.

### Paso 7: Ver ruta

```text
tracert 8.8.8.8
```

Ayuda a localizar en qué salto se interrumpe la comunicación.

### Paso 8: Revisar conexiones y puertos

```text
netstat -an
```

Permite detectar conexiones activas, servicios en escucha o tráfico inesperado.

## 12. Conclusión operativa

Estos comandos forman una caja básica de herramientas para administración y diagnóstico de red. La clave está en practicar en distintos escenarios y aprender a interpretar patrones:

- Configuración correcta pero sin conectividad.
- Conectividad local sin Internet.
- Internet por IP pero sin DNS.
- Pérdida intermitente de paquetes.
- Puertos abiertos inesperados.
- Rutas incompletas o saltos que no responden.

Dominar estos comandos permite resolver problemas de red con método, en lugar de hacerlo por prueba y error.

---

## Key Concepts

**1.** Configuración IP: conjunto de parámetros de red de un host, incluyendo dirección IP, máscara, gateway y DNS.

**2.** Dirección IP: identificador lógico que permite ubicar un equipo dentro de una red IPv4 o IPv6.

**3.** Máscara de subred: valor que determina qué parte de una dirección IP corresponde a la red y qué parte al host.

**4.** Puerta de enlace predeterminada: router usado por un equipo para enviar tráfico hacia redes externas.

**5.** DHCP: servicio que asigna automáticamente parámetros de red a los equipos de una red.

**6.** DNS: sistema que traduce nombres de dominio legibles por humanos en direcciones IP utilizables por los equipos.

**7.** Dirección MAC: identificador físico de una interfaz de red usado en comunicaciones de capa 2.

**8.** Tabla ARP: registro local que asocia direcciones IP con direcciones MAC dentro de la red local.

**9.** Puerto de red: número lógico usado por TCP o UDP para identificar aplicaciones o servicios en un host.

**10.** Conectividad: capacidad de un equipo para comunicarse correctamente con otro destino de red.

**11.** ICMP: protocolo usado por herramientas como ping para enviar mensajes de prueba y diagnóstico.

**12.** Latencia: tiempo que tarda un paquete en ir hasta un destino y volver al origen.

**13.** Pérdida de paquetes: porcentaje de mensajes enviados que no reciben respuesta, indicador de fallas o inestabilidad.

**14.** Salto de red: router o dispositivo intermedio atravesado por un paquete hasta llegar a su destino.

**15.** Resolución de nombres: proceso por el cual un dominio como example.com se convierte en una dirección IP.

---

## Glossary

| Term | Definition | Related |
|:-----|:-----------|:--------|
| **ipconfig** | Comando de Windows que muestra la configuración IP de los adaptadores de red del equipo, incluyendo dirección IP, máscara y gateway. | IP, máscara de subred, gateway, DHCP |
| **ipconfig /all** | Variante detallada de ipconfig que muestra información extendida como dirección MAC, servidores DNS, estado DHCP y concesiones de red. | ipconfig, MAC, DNS, DHCP |
| **Dirección IP** | Dirección lógica asignada a un dispositivo para identificarlo y permitir su comunicación en una red. | IPv4, subred, gateway |
| **IPv4** | Versión del protocolo IP que usa direcciones de 32 bits, comúnmente escritas como cuatro números decimales separados por puntos. | dirección IP, máscara de subred, broadcast |
| **Máscara de subred** | Parámetro que indica qué porción de una dirección IP pertenece a la red y qué porción identifica al host. | subred, CIDR, broadcast |
| **Gateway** | Dispositivo, normalmente un router, que permite a un host comunicarse con redes diferentes a la red local. | router, ipconfig, tracert |
| **DHCP** | Protocolo que asigna automáticamente direcciones IP y otros parámetros de red a los dispositivos clientes. | ipconfig /all, concesión DHCP, IP dinámica |
| **DNS** | Sistema de nombres de dominio que traduce nombres como google.com en direcciones IP. | nslookup, dominio, resolución de nombres |
| **netstat** | Comando que muestra conexiones de red, puertos abiertos y estados de comunicación TCP/UDP. | TCP, UDP, puerto, socket |
| **Puerto** | Número lógico usado por TCP o UDP para dirigir tráfico hacia una aplicación o servicio específico. | TCP, UDP, netstat |
| **TCP** | Protocolo de transporte orientado a conexión que garantiza entrega ordenada y confiable de datos. | netstat, puerto, ESTABLISHED |
| **UDP** | Protocolo de transporte sin conexión, usado cuando se prioriza rapidez o simplicidad sobre confirmación de entrega. | netstat, DNS, puerto |
| **ARP** | Protocolo que permite obtener la dirección MAC asociada a una dirección IP dentro de la misma red local. | arp -a, MAC, capa 2, IP |
| **arp -a** | Comando que muestra la tabla ARP local, es decir, asociaciones conocidas entre direcciones IP y direcciones MAC. | ARP, tabla ARP, dirección MAC |
| **Dirección MAC** | Identificador físico de una interfaz de red usado para comunicación en redes Ethernet o Wi-Fi. | ARP, capa 2, adaptador de red |
| **ping** | Comando que envía mensajes ICMP a un destino para comprobar si responde y medir latencia y pérdida. | ICMP, latencia, pérdida de paquetes |
| **ICMP** | Protocolo de control usado para enviar mensajes de diagnóstico, errores y pruebas de conectividad. | ping, tracert, TTL |
| **ping -t** | Modificador de ping en Windows que envía solicitudes de manera continua hasta que el usuario detiene la ejecución. | ping, conectividad, pérdida intermitente |
| **ping -w** | Modificador que ajusta el tiempo máximo de espera de respuesta en milisegundos para cada solicitud ping. | ping, timeout, latencia |
| **ping -l** | Modificador que define el tamaño del paquete ICMP enviado, útil para probar comportamiento con cargas mayores. | ping, MTU, paquete |
| **tracert** | Comando de Windows que muestra los saltos o routers intermedios atravesados hasta alcanzar un destino. | ruta, salto, TTL, ping |
| **Salto** | Cada router o dispositivo intermedio por el que pasa un paquete en su camino hacia el destino. | tracert, router, ruta |
| **nslookup** | Herramienta de consulta DNS que permite comprobar la resolución de nombres de dominio a direcciones IP. | DNS, dominio, servidor DNS |
| **Broadcast** | Dirección usada para enviar un mensaje a todos los hosts de una subred local. | subred, máscara de subred, ARP |
| **Capa de transporte** | Nivel del modelo de red donde operan TCP y UDP, responsable de la comunicación entre procesos mediante puertos. | TCP, UDP, netstat, puerto |

---

## Cheat Sheet

## Referencia rápida de comandos de red

### Comandos esenciales

| Comando | Uso principal | Qué mirar |
|---|---|---|
| `ipconfig` | Ver configuración IP básica | IP, máscara, gateway |
| `ipconfig /all` | Ver configuración completa | MAC, DHCP, DNS, concesión |
| `netstat -an` | Ver conexiones y puertos | LISTENING, ESTABLISHED, puertos |
| `arp -a` | Ver tabla IP-MAC | MAC del gateway y vecinos |
| `ping destino` | Probar conectividad | Respuestas, latencia, pérdida |
| `ping -t destino` | Probar continuamente | Cortes intermitentes |
| `ping -w 3000 destino` | Aumentar espera | Enlaces lentos o inestables |
| `ping -l 1000 destino` | Cambiar tamaño de paquete | Problemas de carga o MTU |
| `tracert destino` | Ver ruta al destino | Saltos y dónde se corta |
| `nslookup dominio` | Probar DNS | Servidor DNS y respuesta |

### Diagnóstico en orden recomendado

```text
1. ipconfig /all              Ver IP, máscara, gateway, DNS
2. ping 127.0.0.1             Probar pila TCP/IP local
3. ping IP_local              Probar interfaz propia
4. ping gateway               Probar red local
5. arp -a                     Ver vecinos IP-MAC
6. ping 8.8.8.8               Probar salida a Internet por IP
7. nslookup google.com        Probar resolución DNS
8. tracert 8.8.8.8            Ver ruta y saltos
9. netstat -an                Revisar conexiones y puertos
```

### Interpretación rápida

| Síntoma | Posible causa |
|---|---|
| Sin IP válida | DHCP fallando o interfaz desconectada |
| IP 169.254.x.x | No se obtuvo IP por DHCP |
| Ping al gateway falla | Problema local, cable, Wi-Fi, VLAN, máscara o gateway |
| Ping a IP externa funciona pero dominio falla | Problema DNS |
| Ping con pérdida parcial | Ruido, congestión, enlace inestable o filtrado |
| Tracert se corta en un salto | Posible falla o bloqueo desde ese punto |
| Puertos LISTENING inesperados | Servicio activo que debe investigarse |

### Capas de red

| Capa | Comandos relacionados |
|---|---|
| Capa 2 | `arp -a`, dirección MAC |
| Capa 3 | `ipconfig`, `ping`, `tracert` |
| Capa 4 | `netstat`, TCP, UDP, puertos |
| Capa 7 | `nslookup`, DNS |

---

## Takeaways

- Ejecuta `ipconfig /all` en tu equipo y documenta IP, máscara, gateway, DNS, MAC y estado DHCP.
- Practica una secuencia fija de diagnóstico: configuración local, ping al gateway, ping externo, DNS, ruta y puertos.
- Compara la configuración de dos equipos de la misma red para aprender a identificar parámetros correctos e incorrectos.
- Usa `ping -t` durante reparaciones o pruebas de estabilidad para detectar el momento exacto en que vuelve o cae la conectividad.
- Consulta `arp -a` después de comunicarte con otros hosts para observar cómo se construye la relación entre IP y MAC.
- Revisa `netstat -an` y aprende a distinguir conexiones establecidas de servicios en escucha.
- Usa `tracert` cuando un destino no responda para ubicar en qué tramo de la ruta puede estar el problema.
- Verifica DNS con `nslookup` antes de concluir que una falla de navegación es un problema de Internet.
- Crea un laboratorio en simulador o máquinas virtuales para provocar fallas controladas y practicar su interpretación.

---

## Quiz

### Q1 [MCQ] (E)

**¿Qué comando usarías primero para ver la IP actual de un equipo, la máscara de red, el gateway y si la configuración fue obtenida automáticamente por DHCP?**

- A. ping
- B. ipconfig
- C. arp
- D. netstat

<details><summary>Answer</summary>

**B. ipconfig**

_El comando ipconfig muestra el estado básico de las conexiones de red del equipo: dirección IP, máscara, puerta de enlace o gateway y datos relacionados con DHCP. ping sirve para probar conectividad, arp muestra asociaciones entre direcciones IP y físicas, y netstat informa conexiones o puertos abiertos, pero ninguno de ellos da directamente la configuración IP principal del adaptador como ipconfig._

</details>

### Q2 [T/F] (M)

**Netstat y arp entregan información equivalente porque ambos muestran principalmente los puertos abiertos de la capa de transporte.**

<details><summary>Answer</summary>

**False**

_Netstat se asocia con la visualización de conexiones activas y puertos abiertos en la capa de transporte, por ejemplo TCP o UDP. En cambio, arp permite observar asociaciones entre direcciones lógicas IP y direcciones físicas MAC, es decir, información relacionada con la comunicación local en capa 2. Por eso no entregan información equivalente, aunque ambos sean útiles para diagnosticar redes._

</details>

### Q3 [Scenario] (H)

**Estás instalando una PC nueva en una oficina. Una computadora vecina funciona correctamente en la red y tiene acceso a internet. La nueva PC no recibe configuración automática por DHCP, pero necesitas asignarle una IP estática que le permita comunicarse con el resto de la LAN. ¿Cuál sería el mejor procedimiento inicial?**

- A. Ejecutar netstat en la PC nueva y copiar uno de los puertos abiertos como dirección IP.
- B. Ejecutar ipconfig /all en la computadora vecina, identificar su IP, máscara, gateway y DNS, y configurar en la nueva PC una IP libre del mismo rango sin duplicarla.
- C. Ejecutar ping -t a cualquier sitio de internet y esperar hasta que la PC nueva obtenga una dirección IP automáticamente.
- D. Ejecutar arp en la computadora vecina y copiar exactamente la misma dirección IP y MAC en la PC nueva.

<details><summary>Answer</summary>

**B. Ejecutar ipconfig /all en la computadora vecina, identificar su IP, máscara, gateway y DNS, y configurar en la nueva PC una IP libre del mismo rango sin duplicarla.**

_Si una máquina vecina funciona, su configuración permite inferir el rango de red, la máscara, el gateway y posiblemente los DNS. La nueva PC debe usar una dirección IP del mismo segmento, pero no la misma IP, porque duplicarla causaría conflictos. netstat no sirve para definir parámetros IP, ping no configura la red por sí mismo y copiar la IP o la MAC de otra máquina sería incorrecto y problemático._

</details>

### Q4 [Compare] (M)

**Compara el uso de ping -t con tracert cuando se diagnostica un problema de conectividad. ¿En qué situación usarías cada uno?**

<details><summary>Answer</summary>

**Usaría ping -t cuando quiero comprobar de forma continua si un destino responde, especialmente ante fallas intermitentes o mientras se repara una conexión. Usaría tracert cuando necesito saber por qué ruta viaja el paquete y en qué salto podría estar el problema antes de llegar al destino. Ping confirma continuidad o pérdida de respuesta; tracert agrega información sobre el camino y los equipos intermedios.**

_Aunque ambos comandos ayudan a diagnosticar conectividad, responden preguntas distintas. ping -t mantiene el envío de mensajes para observar caídas, demoras o recuperación de la comunicación en tiempo real. tracert, en cambio, muestra los saltos o routers intermedios, lo que resulta más útil en redes grandes donde el problema puede estar en algún punto de la ruta y no necesariamente en el destino final._

</details>

---

## Flashcards

**1. ¿Para qué sirve agregar el símbolo de interrogación (?) al final de un comando de red?** `redes` `comandos` `ayuda`
> Sirve para mostrar la ayuda del comando, incluyendo opciones y modificadores disponibles.

**2. ¿Qué información básica muestra el comando ipconfig?** `redes` `ipconfig` `configuracion`
> Muestra el estado de las conexiones de red, incluyendo dirección IP, máscara de subred, gateway y, si corresponde, servidores DNS.

**3. ¿Por qué es útil usar ipconfig /all al instalar una máquina nueva en una red?** `redes` `ipconfig` `diagnostico`
> Porque muestra información detallada de la configuración de red, lo que permite tomar como referencia datos como IP, máscara y gateway para configurar correctamente el nuevo equipo.

**4. ¿Cómo se usa ping para comprobar continuamente si un equipo remoto vuelve a responder?** `redes` `ping` `diagnostico`
> Se usa ping -t seguido de la dirección destino; el comando seguirá enviando mensajes hasta que se interrumpa manualmente.

**5. ¿Cuál es la diferencia entre ping y tracert?** `redes` `ping` `tracert`
> ping verifica si hay conectividad con un destino, mientras que tracert muestra la ruta y los saltos que sigue el paquete hasta llegar a ese destino.

---

## Exercises

### Exercise 1: Diagnóstico guiado de conectividad en una estación Windows (M)

Contexto: eres técnico de soporte y recibes una PC con Windows que aparentemente tiene problemas de red. Debes determinar si el problema está en la configuración IP local, la comunicación con la red local, la salida a Internet o la resolución DNS. Tarea: ejecuta y documenta una secuencia de diagnóstico usando los comandos ipconfig, ipconfig /all, ping, arp, netstat, tracert y nslookup. Puedes hacerlo en una PC real, una máquina virtual o un simulador. Entregables: 1) una tabla con cada comando ejecutado, el objetivo de la prueba y el resultado observado; 2) capturas o copias del texto de salida más relevante; 3) una conclusión indicando si la conectividad local, la puerta de enlace, Internet y DNS funcionan correctamente; 4) una recomendación de acción si detectas un problema. Debes incluir como mínimo estas pruebas: verificar IP, máscara, gateway y DNS con ipconfig /all; hacer ping a 127.0.0.1, a la IP local, al gateway, a una IP pública como 8.8.8.8 y a un dominio como google.com; revisar la tabla ARP; observar conexiones activas con netstat; trazar la ruta hacia un dominio con tracert; y resolver un dominio con nslookup.

**Hints:**
- Hint 1: Sigue un orden de diagnóstico: primero la configuración local, luego la red local, después Internet y finalmente DNS.
- Hint 2: Si ping a 8.8.8.8 funciona pero ping a google.com falla, probablemente el problema esté relacionado con DNS.
- Hint 3: Compara la IP y la máscara de tu equipo con la puerta de enlace; normalmente deben pertenecer a la misma red.

<details><summary>Solution</summary>

Una buena solución debe mostrar una secuencia lógica de diagnóstico. Puntos clave esperados: ipconfig /all identifica IP, máscara, gateway, servidores DNS, si la dirección fue asignada por DHCP y el estado del adaptador. ping 127.0.0.1 valida la pila TCP/IP local. ping a la IP propia valida la interfaz local. ping al gateway valida conectividad dentro de la LAN. ping a 8.8.8.8 valida salida a Internet sin depender de DNS. ping a un dominio valida conectividad más resolución de nombres. arp -a muestra direcciones IP con las que el equipo se comunicó y sus MAC asociadas, útil para comprobar comunicación de capa 2 con el gateway u otros hosts. netstat permite observar conexiones activas y puertos en uso. tracert muestra los saltos hasta el destino y ayuda a ubicar dónde se corta la ruta. nslookup confirma si el DNS resuelve nombres correctamente. Conclusiones posibles: si falla desde ping al gateway, revisar IP, máscara, cable/Wi-Fi, VLAN o gateway; si el gateway responde pero no 8.8.8.8, revisar salida a Internet o router; si 8.8.8.8 responde pero falla google.com/nslookup, revisar configuración DNS; si todo responde correctamente, la conectividad básica funciona y el problema podría estar en una aplicación, firewall o servicio específico.

</details>

---

## Learning Path

### Prerequisites
- Comprender qué es una red local y qué función cumple un router.
- Conocer el uso básico de la línea de comandos en Windows.
- Distinguir entre dirección IP, nombre de dominio y dirección MAC.
- Tener nociones básicas del modelo OSI o TCP/IP.
- Saber interpretar valores simples como latencia en milisegundos y porcentaje de pérdida.

### Next Steps
- Estudiar subnetting IPv4 y notación CIDR para interpretar máscaras de red con precisión.
- Aprender fundamentos de DHCP, DNS, ARP, ICMP, TCP y UDP en profundidad.
- Practicar captura de paquetes con Wireshark para ver qué ocurre detrás de ping, ARP, DNS y TCP.
- Estudiar troubleshooting estructurado de redes usando modelos por capas.
- Aprender comandos equivalentes en Linux como `ip addr`, `ss`, `ip route`, `dig`, `tracepath` y `ip neigh`.
- Configurar laboratorios con routers, switches, VLANs y servidores DHCP/DNS simulados.

### Recommended Resources
- Cisco Networking Academy: Introduction to Networks - https://www.netacad.com/
- Libro: Computer Networking: A Top-Down Approach, James Kurose y Keith Ross.
- Libro: TCP/IP Illustrated, Volume 1, W. Richard Stevens.
- Microsoft Learn: Herramientas de línea de comandos de red de Windows - https://learn.microsoft.com/windows-server/administration/windows-commands/
- Wireshark User Guide - https://www.wireshark.org/docs/wsug_html_chunked/
- Packet Tracer de Cisco para simulación de redes - https://www.netacad.com/courses/packet-tracer
- GNS3 para laboratorios de redes avanzados - https://www.gns3.com/
- Documentación de Microsoft sobre `ipconfig` - https://learn.microsoft.com/windows-server/administration/windows-commands/ipconfig
- Documentación de Microsoft sobre `ping` - https://learn.microsoft.com/windows-server/administration/windows-commands/ping
- Documentación de Microsoft sobre `tracert` - https://learn.microsoft.com/windows-server/administration/windows-commands/tracert
- Documentación de Microsoft sobre `netstat` - https://learn.microsoft.com/windows-server/administration/windows-commands/netstat
- Documentación de Microsoft sobre `nslookup` - https://learn.microsoft.com/windows-server/administration/windows-commands/nslookup

---

*Generated by [Skill-Anything](https://github.com/SYuan03/Skill-Anything)*