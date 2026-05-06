# Algunos Comandos Para Diagnostico En Instalaciones De Red

> PDF: `output/osi_tcp_ip/converted_pptx_pdf/ALGUNOS_COMANDOS_PARA_DIAGNOSTICO_EN_INSTALACIONES_DE_RED.pdf`

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

El contenido presenta un conjunto básico de comandos de diagnóstico para instalaciones de red: ipconfig, ping, traceroute, arp, netstat y nslookup. La tesis central es que una parte fundamental del diagnóstico de redes consiste en inspeccionar sistemáticamente la configuración local, verificar conectividad, seguir la ruta de los paquetes, revisar asociaciones entre direcciones IP y MAC, observar puertos activos y consultar la resolución DNS. Aunque el material original es breve, su lógica implícita sigue una metodología de resolución de problemas por capas: primero confirmar que la máquina tiene una configuración IP válida; luego comprobar si existe comunicación con otros equipos; después identificar dónde se interrumpe el trayecto; posteriormente analizar relaciones de red local mediante ARP; revisar servicios y conexiones de transporte con netstat; y, finalmente, validar si los nombres de dominio se resuelven correctamente mediante DNS.

Cada comando responde a una pregunta diagnóstica diferente. ipconfig muestra el estado de las conexiones, la dirección IP, máscara de subred, gateway y servidores DNS configurados. ping confirma conectividad básica y mide latencia mediante mensajes ICMP. traceroute permite observar los saltos intermedios por los que pasa un paquete hasta llegar a su destino. arp permite consultar o modificar la tabla que asocia direcciones IP con direcciones MAC en la red local. netstat muestra conexiones activas y puertos abiertos en la capa de transporte, ayudando a identificar servicios en escucha o sesiones establecidas. nslookup consulta registros DNS para comprobar si un nombre de dominio se traduce correctamente a una dirección IP.

La conclusión práctica es que estos comandos forman un kit esencial de primer nivel para diagnosticar problemas comunes de red. Usados en orden, permiten distinguir entre fallos de configuración local, conectividad física o lógica, enrutamiento, resolución de nombres, servicios de transporte y comunicación dentro de la LAN.

---

## Concept Map

![Concept Map](algunos-comandos-para-diagnostico-en-instalaciones-de-red-concept-map.png)

---

## Detailed Notes

## Diagnóstico básico de instalaciones de red

El diagnóstico de red consiste en identificar dónde se produce un fallo de comunicación entre dispositivos, servicios o segmentos de red. Los comandos presentados forman una caja de herramientas básica para comprobar distintos niveles del funcionamiento de una red.

### Comandos principales

- **ipconfig**: muestra la configuración IP local.
- **ping**: comprueba conectividad y latencia.
- **traceroute / tracert**: muestra la ruta que siguen los paquetes.
- **arp**: consulta o modifica la tabla de correspondencia IP-MAC.
- **netstat**: muestra conexiones, puertos y estadísticas de red.
- **nslookup**: consulta información DNS.

> Idea central: ningún comando por sí solo diagnostica toda la red; cada uno responde una pregunta concreta dentro del proceso de análisis.

---

## Metodología recomendada de diagnóstico

### 1. Revisar la configuración local con ipconfig

Antes de probar comunicación con otros equipos, se debe confirmar que el host tiene una configuración de red válida.

Preguntas que responde:

- ¿Tiene el equipo una **dirección IP** asignada?
- ¿La **máscara de subred** es correcta?
- ¿Existe un **gateway predeterminado** configurado?
- ¿Los **servidores DNS** están definidos?
- ¿El adaptador de red está activo?

Comando básico en Windows:

```text
ipconfig
```

Comando detallado:

```text
ipconfig /all
```

Información típica que muestra:

- Dirección IPv4: por ejemplo, `192.168.1.25`
- Máscara de subred: por ejemplo, `255.255.255.0`
- Puerta de enlace predeterminada: por ejemplo, `192.168.1.1`
- Servidores DNS: por ejemplo, `8.8.8.8`, `1.1.1.1` o el DNS interno de la organización
- Dirección física o MAC del adaptador
- Estado de DHCP

### Interpretación básica

| Observación | Posible significado |
|---|---|
| IP `169.254.x.x` | El equipo no recibió IP por DHCP; se asignó una dirección APIPA automática. |
| Sin gateway | Puede comunicarse localmente, pero probablemente no saldrá a otras redes o Internet. |
| Sin DNS | Puede llegar a direcciones IP, pero no resolver nombres como `google.com`. |
| Máscara incorrecta | El equipo puede creer que hosts remotos están en la red local o viceversa. |

---

## Ping: prueba de conectividad y latencia

**ping** permite comprobar si existe comunicación entre nuestra máquina y otra máquina de la red. También mide el tiempo aproximado de ida y vuelta de los paquetes, conocido como **latencia**.

Comando básico:

```text
ping 192.168.1.1
```

Ejemplo con nombre de dominio:

```text
ping google.com
```

### Qué mide ping

Ping usa normalmente el protocolo **ICMP** para enviar una solicitud de eco y esperar una respuesta de eco.

Métricas comunes:

- **Tiempo**: latencia en milisegundos, por ejemplo `time=15ms`.
- **TTL**: tiempo de vida del paquete; indica cuántos saltos máximos puede recorrer antes de descartarse.
- **Pérdida de paquetes**: porcentaje de paquetes enviados que no recibieron respuesta.

### Interpretación de resultados

| Resultado | Interpretación probable |
|---|---|
| Respuestas constantes con baja latencia | Conectividad estable. |
| Tiempo de espera agotado | El destino no responde, hay bloqueo ICMP o existe un fallo de ruta. |
| Host de destino inaccesible | El equipo o un router cercano no sabe cómo llegar al destino. |
| Alta latencia | Congestión, distancia elevada, problemas Wi-Fi o saturación. |
| Pérdida de paquetes | Problemas de calidad de enlace, interferencias, congestión o hardware defectuoso. |

### Secuencia práctica de pruebas con ping

1. Hacer ping a la propia dirección loopback:

```text
ping 127.0.0.1
```

Comprueba que la pila TCP/IP local funciona.

2. Hacer ping a la IP propia:

```text
ping <IP_local>
```

Verifica que la interfaz local responde.

3. Hacer ping al gateway:

```text
ping <gateway>
```

Comprueba comunicación con el router local.

4. Hacer ping a una IP externa:

```text
ping 8.8.8.8
```

Comprueba salida a Internet sin depender de DNS.

5. Hacer ping a un dominio:

```text
ping google.com
```

Comprueba conectividad y resolución DNS.

---

## Traceroute / Tracert: seguimiento de la ruta de paquetes

El comando **traceroute** permite saber por dónde pasa un paquete hasta llegar a su destino. En Windows, el comando equivalente es **tracert**.

Windows:

```text
tracert google.com
```

Linux/macOS:

```text
traceroute google.com
```

### Qué muestra

Muestra una lista de **saltos** o dispositivos intermedios, normalmente routers, por los que pasa el tráfico.

Ejemplo conceptual:

```text
1   1 ms    192.168.1.1
2  10 ms    10.20.0.1
3  20 ms    proveedor.net
4  35 ms    destino.com
```

Cada salto representa un equipo de red que reenvía el paquete hacia el destino.

### Para qué sirve

- Detectar en qué punto se corta la comunicación.
- Identificar rutas inesperadas.
- Observar latencia acumulada por salto.
- Diferenciar problemas de red local, proveedor de Internet o destino remoto.

### Interpretación

| Resultado | Posible causa |
|---|---|
| Se detiene en el primer salto | Problema con el gateway local o red interna. |
| Se detiene dentro del proveedor | Posible problema del ISP o de la ruta externa. |
| Aparecen asteriscos `* * *` | El salto no responde a ICMP/TTL, hay filtrado o pérdida. |
| Latencia aumenta bruscamente | Posible congestión o ruta lejana. |

Importante: que un salto no responda no siempre significa que esté fallando; algunos routers bloquean respuestas ICMP pero siguen reenviando tráfico.

---

## ARP: relación entre dirección IP y dirección MAC

**ARP** significa **Address Resolution Protocol**. Su función es resolver qué dirección MAC corresponde a una dirección IP dentro de una red local IPv4.

El comando `arp` sirve para ver o modificar la **tabla ARP**, que recoge los mapeos entre dirección IP y dirección MAC.

Comando para ver la tabla ARP en Windows:

```text
arp -a
```

Ejemplo de salida conceptual:

```text
Dirección IP       Dirección física        Tipo
192.168.1.1        aa-bb-cc-dd-ee-ff       dinámico
192.168.1.50       11-22-33-44-55-66       dinámico
```

### Cuándo usar ARP

- Cuando hay comunicación IP aparente pero falla la comunicación dentro de la LAN.
- Para comprobar si el equipo está resolviendo correctamente la MAC del gateway.
- Para detectar conflictos o asociaciones sospechosas.
- Para diagnosticar posibles problemas de duplicidad de IP.

### Conceptos clave

- **Dirección IP**: dirección lógica usada en capa de red.
- **Dirección MAC**: dirección física del adaptador de red usada en capa de enlace.
- **Tabla ARP**: caché local que evita tener que preguntar constantemente por la MAC de una IP.

### Advertencia

Modificar entradas ARP manualmente puede causar pérdida de conectividad si se introduce una asociación incorrecta. En diagnóstico básico suele bastar con consultar la tabla.

---

## Netstat: puertos y conexiones de transporte

**netstat** permite ver información relacionada con la capa de transporte, especialmente **puertos abiertos**, conexiones activas y servicios en escucha.

Comando básico:

```text
netstat
```

Comando recomendado para diagnóstico en Windows:

```text
netstat -ano
```

Opciones comunes:

| Opción | Función |
|---|---|
| `-a` | Muestra todas las conexiones y puertos en escucha. |
| `-n` | Muestra direcciones y puertos en formato numérico, sin resolver nombres. |
| `-o` | Muestra el PID del proceso asociado, útil en Windows. |
| `-r` | Muestra la tabla de rutas. |

### Estados comunes de conexión

| Estado | Significado |
|---|---|
| LISTENING | Un servicio está esperando conexiones entrantes. |
| ESTABLISHED | Existe una conexión activa entre dos equipos. |
| TIME_WAIT | La conexión fue cerrada recientemente y el sistema espera antes de liberar recursos. |
| CLOSE_WAIT | El remoto cerró la conexión, pero el proceso local aún no la cerró completamente. |

### Ejemplo conceptual

```text
TCP    0.0.0.0:80      0.0.0.0:0       LISTENING     1234
TCP    192.168.1.25:50500  93.184.216.34:443  ESTABLISHED 5678
```

Interpretación:

- `0.0.0.0:80 LISTENING`: hay un servicio escuchando en el puerto 80 en todas las interfaces.
- `:443 ESTABLISHED`: hay una conexión HTTPS activa con un servidor remoto.
- El PID permite identificar qué proceso abrió el puerto.

### Usos típicos

- Ver si un servidor está escuchando en el puerto esperado.
- Detectar conexiones sospechosas.
- Comprobar si un puerto local está ocupado.
- Diagnosticar problemas de servicios que no aceptan conexiones.

---

## Nslookup: diagnóstico DNS

**nslookup** permite acceder a entradas DNS consultando servidores de nombres de dominio. Se utiliza para comprobar si un nombre como `www.ejemplo.com` se traduce correctamente a una dirección IP.

Comando básico:

```text
nslookup google.com
```

Consultar un servidor DNS específico:

```text
nslookup google.com 8.8.8.8
```

### Qué permite comprobar

- Si el DNS configurado responde.
- Qué IP corresponde a un nombre de dominio.
- Si un dominio tiene registros específicos, como A, AAAA, MX o CNAME.
- Si el problema es de conectividad IP o de resolución de nombres.

### Registros DNS comunes

| Registro | Uso |
|---|---|
| A | Asocia un nombre con una dirección IPv4. |
| AAAA | Asocia un nombre con una dirección IPv6. |
| CNAME | Alias de otro nombre canónico. |
| MX | Servidores de correo de un dominio. |
| NS | Servidores de nombres autorizados del dominio. |
| TXT | Texto usado para verificación, SPF, DKIM, DMARC, etc. |

### Diagnóstico con nslookup

Si `ping 8.8.8.8` funciona pero `ping google.com` falla, probablemente existe un problema de DNS. En ese caso, usar:

```text
nslookup google.com
```

Si el servidor DNS no responde, revisar:

- DNS configurado en `ipconfig /all`.
- Conectividad con el servidor DNS.
- Firewall o políticas de red.
- Configuración DHCP.

---

## Relación con el modelo por capas

Aunque los comandos son simples, pueden relacionarse con capas de comunicación de red.

| Capa aproximada | Pregunta diagnóstica | Comando útil |
|---|---|---|
| Configuración local | ¿Mi equipo tiene IP, máscara, gateway y DNS? | ipconfig |
| Enlace local | ¿Qué MAC corresponde a una IP local? | arp |
| Red | ¿Puedo llegar a otro host? | ping |
| Enrutamiento | ¿Por dónde viaja el paquete? | tracert / traceroute |
| Transporte | ¿Qué puertos y conexiones existen? | netstat |
| Aplicación/DNS | ¿El nombre se resuelve a una IP? | nslookup |

---

## Flujo práctico de diagnóstico paso a paso

### Caso: “No tengo Internet”

1. Revisar configuración:

```text
ipconfig /all
```

Confirmar IP, máscara, gateway y DNS.

2. Probar pila local:

```text
ping 127.0.0.1
```

3. Probar gateway:

```text
ping <gateway>
```

Si falla, el problema probablemente está en la red local, Wi-Fi, cable, switch, VLAN o configuración IP.

4. Probar una IP externa:

```text
ping 8.8.8.8
```

Si funciona, hay salida a Internet.

5. Probar nombre de dominio:

```text
ping google.com
```

Si falla pero `ping 8.8.8.8` funciona, sospechar DNS.

6. Consultar DNS:

```text
nslookup google.com
```

7. Ver ruta:

```text
tracert google.com
```

Identificar dónde se detiene la comunicación.

8. Revisar servicios y puertos si el problema afecta una aplicación específica:

```text
netstat -ano
```

9. Revisar ARP si el problema es local:

```text
arp -a
```

Confirmar que el gateway o servidor local aparece con una MAC válida.

---

## Errores comunes al interpretar estos comandos

- Pensar que **ping fallido siempre significa host caído**: puede estar bloqueado por firewall.
- Confundir **latencia** con velocidad total de descarga: ping mide tiempo de respuesta, no ancho de banda.
- Creer que los asteriscos en traceroute siempre indican un fallo: pueden indicar filtrado de ICMP.
- Asumir que DNS funciona solo porque hay Internet: puede haber conectividad IP sin resolución de nombres.
- Modificar ARP sin necesidad: una entrada ARP incorrecta puede romper comunicación local.
- Ver un puerto abierto en netstat y no identificar el proceso responsable: se debe revisar el PID.

---

## Conclusión operativa

Estos comandos permiten construir una imagen rápida del estado de una red. La clave no es memorizarlos de forma aislada, sino saber qué pregunta responde cada uno y en qué orden usarlos. Un diagnóstico eficaz comienza por la configuración local, avanza hacia conectividad y ruta, y termina revisando resolución de nombres, puertos y asociaciones IP-MAC.

---

## Key Concepts

**1.** Configuración IP: conjunto de parámetros locales —dirección IP, máscara, gateway y DNS— que permite a un equipo comunicarse en una red.

**2.** Dirección IP: identificador lógico asignado a un dispositivo para comunicarse en redes IP.

**3.** Máscara de subred: valor que determina qué parte de una dirección IP identifica la red y qué parte identifica el host.

**4.** Gateway predeterminado: router al que un equipo envía tráfico destinado a redes externas a su subred local.

**5.** Servidor DNS: sistema que traduce nombres de dominio legibles por humanos en direcciones IP utilizables por los equipos.

**6.** Conectividad: capacidad de un equipo para comunicarse con otro dispositivo o servicio de red.

**7.** Latencia: tiempo de ida y vuelta que tarda un paquete en viajar desde el origen al destino y regresar.

**8.** ICMP: protocolo usado por herramientas como ping para enviar mensajes de diagnóstico y control de red.

**9.** Ruta de red: secuencia de dispositivos intermedios, normalmente routers, que atraviesa un paquete hasta llegar a su destino.

**10.** Salto de red: cada router o dispositivo intermedio que reenvía un paquete en su camino hacia el destino.

**11.** Tabla ARP: caché local que asocia direcciones IPv4 con direcciones MAC dentro de la red local.

**12.** Dirección MAC: identificador físico de una interfaz de red usado para comunicación en la capa de enlace.

**13.** Puerto de transporte: número lógico usado por TCP o UDP para identificar servicios o aplicaciones concretas en un equipo.

**14.** Estado de conexión: condición actual de una sesión de red, como LISTENING, ESTABLISHED o TIME_WAIT.

**15.** Resolución de nombres: proceso mediante el cual un nombre de dominio se convierte en una dirección IP mediante DNS.

---

## Glossary

| Term | Definition | Related |
|:-----|:-----------|:--------|
| **ipconfig** | Comando de Windows que muestra la configuración de red local, incluyendo dirección IP, máscara de subred, gateway predeterminado, DNS, DHCP y adaptadores de red. | Dirección IP, Gateway predeterminado, DNS, DHCP |
| **ping** | Herramienta de diagnóstico que envía solicitudes ICMP Echo para comprobar si un host responde y medir la latencia de ida y vuelta. | ICMP, Latencia, Pérdida de paquetes, Conectividad |
| **traceroute** | Comando usado en Linux y macOS para mostrar los saltos que atraviesa un paquete hasta llegar a un destino. | tracert, Ruta de red, TTL, Salto |
| **tracert** | Versión de Windows del comando traceroute, utilizada para identificar la ruta de red hacia un destino. | traceroute, Router, ICMP, TTL |
| **arp** | Comando que permite consultar o modificar la tabla ARP, donde se almacenan asociaciones entre direcciones IPv4 y direcciones MAC. | ARP, Tabla ARP, Dirección MAC, Dirección IP |
| **ARP** | Address Resolution Protocol; protocolo que permite descubrir la dirección MAC correspondiente a una dirección IPv4 dentro de una red local. | Dirección MAC, IPv4, LAN, Tabla ARP |
| **netstat** | Comando que muestra conexiones de red, puertos abiertos, servicios en escucha, estadísticas y, con ciertas opciones, procesos asociados. | Puerto, TCP, UDP, LISTENING, ESTABLISHED |
| **nslookup** | Herramienta para consultar servidores DNS y verificar la resolución de nombres de dominio y registros DNS. | DNS, Registro A, Registro MX, Servidor de nombres |
| **Dirección IP** | Identificador lógico que permite ubicar un dispositivo dentro de una red IP; puede ser IPv4 o IPv6. | IPv4, IPv6, Máscara de subred, Gateway |
| **IPv4** | Versión del protocolo IP que usa direcciones de 32 bits, normalmente escritas como cuatro números decimales separados por puntos. | Dirección IP, ARP, Máscara de subred |
| **IPv6** | Versión del protocolo IP que usa direcciones de 128 bits y fue diseñada para ampliar el espacio de direcciones disponible. | Dirección IP, AAAA, DNS |
| **Máscara de subred** | Parámetro que define qué direcciones IP pertenecen a la misma red local que el equipo. | Subred, Dirección IP, Gateway predeterminado |
| **Gateway predeterminado** | Dispositivo, normalmente un router, que recibe el tráfico dirigido a redes distintas de la red local. | Router, Subred, ipconfig, Ruta |
| **DNS** | Domain Name System; sistema distribuido que traduce nombres de dominio en direcciones IP y otros registros asociados. | nslookup, Registro A, Registro CNAME, Servidor DNS |
| **Servidor DNS** | Servidor que responde consultas de resolución de nombres y devuelve registros como A, AAAA, MX, CNAME o NS. | DNS, nslookup, Registro DNS |
| **Dirección MAC** | Identificador físico de una interfaz de red usado en la capa de enlace para entregar tramas dentro de una red local. | ARP, Tabla ARP, Adaptador de red |
| **Puerto** | Número usado por TCP o UDP para identificar una aplicación o servicio específico dentro de un host. | TCP, UDP, netstat, Socket |
| **TCP** | Protocolo de transporte orientado a conexión que proporciona entrega confiable y ordenada de datos entre aplicaciones. | Puerto, ESTABLISHED, netstat |
| **UDP** | Protocolo de transporte sin conexión que envía datagramas sin garantizar entrega, orden ni retransmisión. | Puerto, DNS, netstat |
| **ICMP** | Internet Control Message Protocol; protocolo utilizado para mensajes de control y diagnóstico, especialmente por ping y traceroute. | ping, traceroute, Latencia, TTL |
| **TTL** | Time To Live; valor de un paquete IP que limita la cantidad de saltos que puede recorrer antes de ser descartado. | traceroute, tracert, Salto, ICMP |
| **Latencia** | Tiempo que tarda un paquete en viajar desde el origen hasta el destino y volver, normalmente medido en milisegundos. | ping, ICMP, Pérdida de paquetes |
| **Pérdida de paquetes** | Porcentaje o cantidad de paquetes enviados que no reciben respuesta o no llegan correctamente al destino. | ping, Latencia, Congestión |
| **LISTENING** | Estado mostrado por netstat que indica que un servicio está esperando conexiones entrantes en un puerto. | netstat, Puerto, TCP |
| **ESTABLISHED** | Estado de conexión que indica que existe una sesión TCP activa entre dos extremos. | netstat, TCP, Conexión |

---

## Cheat Sheet

## Diagnóstico rápido de red

### Orden recomendado

```text
1. ipconfig /all        -> Ver configuración local
2. ping 127.0.0.1      -> Probar pila TCP/IP local
3. ping <gateway>      -> Probar red local/router
4. ping 8.8.8.8        -> Probar salida a Internet sin DNS
5. ping dominio.com    -> Probar Internet + DNS
6. nslookup dominio.com -> Diagnosticar DNS
7. tracert dominio.com -> Ver ruta y saltos
8. arp -a              -> Ver IP-MAC en LAN
9. netstat -ano        -> Ver puertos/conexiones/procesos
```

### Comandos esenciales

| Comando | Responde a la pregunta | Uso típico |
|---|---|---|
| `ipconfig` | ¿Cuál es mi configuración IP? | IP, máscara, gateway, DNS |
| `ipconfig /all` | ¿Cuál es mi configuración completa? | DHCP, MAC, DNS, adaptadores |
| `ping <host>` | ¿Hay conectividad? | Latencia y pérdida |
| `tracert <host>` | ¿Por dónde viaja el paquete? | Ruta por saltos en Windows |
| `traceroute <host>` | ¿Por dónde viaja el paquete? | Ruta por saltos en Linux/macOS |
| `arp -a` | ¿Qué MAC corresponde a cada IP local? | Tabla ARP |
| `netstat -ano` | ¿Qué puertos/conexiones hay? | Servicios y PID |
| `nslookup <dominio>` | ¿DNS resuelve el nombre? | Consultas DNS |

### Interpretación rápida

| Síntoma | Sospecha principal | Comando clave |
|---|---|---|
| IP `169.254.x.x` | Fallo DHCP | `ipconfig /all` |
| No hay gateway | Sin salida a otras redes | `ipconfig` |
| Ping a IP externa funciona, dominio falla | Problema DNS | `nslookup` |
| Ping al gateway falla | Problema LAN/Wi-Fi/cable/VLAN | `ping <gateway>` |
| Tracert se corta al inicio | Problema local o gateway | `tracert` |
| Puerto no responde | Servicio caído o firewall | `netstat -ano` |
| IP local no comunica | Problema ARP/MAC/IP duplicada | `arp -a` |

### Estados netstat

| Estado | Significado |
|---|---|
| `LISTENING` | Servicio esperando conexiones |
| `ESTABLISHED` | Conexión activa |
| `TIME_WAIT` | Conexión cerrada recientemente |
| `CLOSE_WAIT` | El remoto cerró; el proceso local aún no terminó |

### Regla de oro

**IP externa funciona + dominio no funciona = revisar DNS.**

**Gateway no responde = revisar red local antes de culpar a Internet.**

---

## Takeaways

- Ejecuta `ipconfig /all` al inicio de cualquier diagnóstico para confirmar IP, máscara, gateway, DNS, DHCP y adaptador activo.
- Prueba conectividad en orden: loopback, IP local, gateway, IP externa y dominio, para aislar el punto exacto del fallo.
- Compara `ping 8.8.8.8` con `ping google.com` para distinguir problemas de conectividad IP frente a problemas DNS.
- Usa `tracert` o `traceroute` cuando un destino no responda para identificar en qué salto se interrumpe o degrada la ruta.
- Consulta `arp -a` cuando el problema afecte a equipos de la misma red local o sospeches conflictos IP-MAC.
- Ejecuta `netstat -ano` para verificar si un servicio está escuchando en el puerto correcto y qué proceso lo mantiene abierto.
- Documenta los resultados de cada comando con fecha, hora, destino probado y síntoma observado para facilitar comparaciones.
- Practica con escenarios controlados, como desconectar DNS, cambiar gateway o detener un servicio, para aprender a reconocer patrones de fallo.
- Evita modificar tablas ARP, rutas o configuraciones IP sin registrar previamente el estado original y comprender el impacto.

---

## Quiz

### Q1 [MCQ] (E)

**¿Qué comando usarías principalmente para consultar el estado de las conexiones de red de un equipo, incluyendo datos como gateway, máscara de red y DNS?**

- A. ipconfig
- B. netstat
- C. arp
- D. traceroute

<details><summary>Answer</summary>

**A. ipconfig**

_El comando ipconfig muestra información de configuración IP del equipo, como la dirección IP, la máscara de subred, el gateway o puerta de enlace y los servidores DNS configurados. Netstat se enfoca en puertos y conexiones de capa de transporte, ARP en asociaciones IP-MAC, y traceroute en la ruta que siguen los paquetes._

</details>

### Q2 [T/F] (M)

**Verdadero o falso: El comando arp sirve para ver o modificar la tabla que relaciona direcciones IP con direcciones MAC, pero no se usa para medir latencia ni para consultar entradas DNS.**

<details><summary>Answer</summary>

**True**

_ARP trabaja con la correspondencia entre direcciones IP y direcciones MAC, información necesaria para la comunicación dentro de una red local. Medir latencia corresponde a ping, mientras que consultar registros o entradas DNS corresponde a nslookup. Por eso la afirmación distingue correctamente la función de ARP frente a otros comandos de diagnóstico._

</details>

### Q3 [Scenario] (M)

**Un usuario informa que puede hacer ping correctamente a la dirección 8.8.8.8, pero no puede acceder a sitios escribiendo nombres como www.ejemplo.com. Sospechas que el problema está relacionado con la resolución de nombres de dominio. ¿Qué comando sería el más adecuado para comprobar las entradas o servidores DNS?**

- A. nslookup
- B. netstat
- C. arp
- D. ipconfig

<details><summary>Answer</summary>

**A. nslookup**

_Si el equipo puede comunicarse con una dirección IP pública pero falla al usar nombres de dominio, la conectividad básica probablemente existe y el problema puede estar en DNS. Nslookup permite consultar servidores de nombres de dominio y verificar si un nombre se resuelve correctamente a una dirección IP. Netstat revisa puertos y conexiones, ARP revisa IP-MAC en la red local, e ipconfig muestra configuración, pero nslookup es el comando más directo para validar resolución DNS._

</details>

### Q4 [Compare] (H)

**Compara ping y traceroute como herramientas de diagnóstico: ¿qué información aporta cada una y en qué situación sería más útil usar una en lugar de la otra?**

<details><summary>Answer</summary>

**Ping se usa para comprobar si existe conectividad entre nuestra máquina y otra, además de estimar el tiempo de latencia de la respuesta. Traceroute se usa cuando no basta con saber si hay o no conectividad, sino que se quiere identificar por dónde pasa el paquete y en qué punto de la ruta podría estar ocurriendo un problema. Por ejemplo, ping ayuda a confirmar rápidamente si un destino responde, mientras que traceroute ayuda a localizar saltos intermedios como routers por los que viaja el tráfico.**

_La diferencia clave es el nivel de detalle del diagnóstico. Ping ofrece una prueba simple de alcance y tiempo de respuesta hacia un destino, por lo que es útil como primera verificación. Traceroute analiza la ruta del paquete a través de varios dispositivos intermedios, lo que permite detectar si el fallo ocurre en algún salto específico de la red. Por eso traceroute suele ser más útil cuando ping falla o cuando se necesita entender el recorrido del tráfico._

</details>

---

## Flashcards

**1. ¿Qué información básica muestra el comando ipconfig en una instalación de red?** `redes` `diagnostico` `ipconfig`
> Ipconfig muestra el estado de las conexiones de red, incluyendo gateway, máscara de red y DNS.

**2. ¿Por qué se usa el comando ping para diagnosticar una red?** `redes` `diagnostico` `ping`
> Ping se usa para comprobar si hay conectividad entre nuestra máquina y otra, y para medir la latencia de la comunicación.

**3. ¿Cómo puedes ver o modificar los mapeos entre direcciones IP y direcciones MAC?** `redes` `arp` `direccionamiento`
> Se usa el comando arp, que permite consultar o modificar la tabla ARP.

**4. ¿En qué se diferencian netstat y nslookup?** `redes` `comparacion` `diagnostico`
> Netstat muestra puertos abiertos de la capa de transporte, mientras que nslookup permite consultar entradas DNS.

**5. Necesitas saber por qué máquinas, switches o routers pasa un paquete en la red. ¿Qué comando debes usar?** `redes` `traceroute` `diagnostico`
> Debes usar traceroute, porque muestra la ruta que sigue un paquete a través de la red.

---

## Exercises

### Exercise 1: Diagnóstico guiado de conectividad en una red local (M)

Actúa como técnico de soporte de red. Debes diagnosticar el estado de conectividad de un equipo que aparentemente tiene acceso limitado a la red. Ejecuta y analiza los comandos ipconfig, ping, tracert/traceroute, arp, netstat y nslookup en un equipo Windows o Linux. Entrega un informe técnico breve que incluya: 1) configuración IP del equipo, incluyendo dirección IP, máscara, gateway y DNS; 2) pruebas de conectividad con el gateway, una IP pública como 8.8.8.8 y un dominio como google.com; 3) ruta seguida por los paquetes hacia un destino externo; 4) revisión de la tabla ARP e identificación de al menos una relación IP-MAC; 5) revisión de puertos o conexiones activas con netstat; 6) consulta DNS de un dominio usando nslookup; 7) conclusión indicando si el problema, si existe, parece estar en la configuración local, la red local, el enrutamiento o la resolución DNS.

**Hints:**
- Empieza con ipconfig /all en Windows o ip addr e ip route en Linux para identificar IP, máscara, gateway y servidores DNS.
- Compara los resultados de ping a una IP pública con ping a un dominio: si la IP responde pero el dominio no, probablemente el problema está en DNS.
- Usa tracert en Windows o traceroute en Linux para observar en qué salto se detiene o cambia la ruta del tráfico.

<details><summary>Solution</summary>

Un informe correcto debe incluir evidencias de cada comando y una interpretación coherente. Puntos clave esperados: ipconfig debe mostrar si el equipo tiene una IP válida, máscara, gateway y DNS configurados; ping al gateway verifica conectividad local; ping a 8.8.8.8 verifica salida a Internet sin depender de DNS; ping a un dominio verifica conectividad más resolución DNS; tracert/traceroute muestra los routers o saltos por donde pasa el paquete y ayuda a detectar dónde se corta la comunicación; arp -a muestra asociaciones IP-MAC de dispositivos conocidos, como el gateway; netstat -an muestra conexiones y puertos abiertos o en escucha en la capa de transporte; nslookup permite comprobar si el servidor DNS resuelve correctamente nombres de dominio. Una conclusión sólida debe distinguir escenarios: si no hay IP válida, el problema puede ser DHCP o configuración local; si no responde el gateway, el problema está en la red local; si responde el gateway pero no 8.8.8.8, puede ser gateway, NAT o salida a Internet; si responde 8.8.8.8 pero no google.com, el problema probablemente es DNS; si traceroute se detiene en un salto específico, ese punto puede indicar una falla de enrutamiento o filtrado.

</details>

---

## Learning Path

### Prerequisites
- Conocer conceptos básicos de redes: host, router, switch, LAN, WAN e Internet.
- Entender la diferencia entre dirección IP, dirección MAC, puerto y nombre de dominio.
- Saber abrir una terminal o símbolo del sistema en Windows, Linux o macOS.
- Tener nociones iniciales del modelo OSI o TCP/IP, especialmente capas de enlace, red, transporte y aplicación.
- Comprender qué es una subred y por qué se necesita un gateway para salir de ella.

### Next Steps
- Estudiar direccionamiento IPv4, CIDR, máscaras de subred y cálculo de subredes.
- Aprender DHCP en profundidad: asignación de IP, leases, reservas y opciones de DNS/gateway.
- Profundizar en DNS: registros A, AAAA, MX, CNAME, NS, TXT, caché, recursión y autoridad.
- Practicar análisis de tráfico con Wireshark para observar ICMP, ARP, DNS, TCP y UDP en tiempo real.
- Estudiar fundamentos de routing: tablas de rutas, rutas estáticas, NAT y protocolos dinámicos.
- Aprender herramientas modernas complementarias como `ss`, `ip`, `dig`, `tcpdump`, `nmap` y PowerShell networking cmdlets.
- Construir laboratorios con máquinas virtuales o contenedores para simular fallos de red y resolverlos sistemáticamente.

### Recommended Resources
- Book: Computer Networking: A Top-Down Approach, James F. Kurose and Keith W. Ross.
- Book: TCP/IP Illustrated, Volume 1: The Protocols, W. Richard Stevens.
- Book: Network Warrior, Gary A. Donahue.
- Course: Cisco Networking Basics / CCNA introductory materials — https://www.netacad.com/
- Course: Google IT Support Professional Certificate, networking modules — https://www.coursera.org/professional-certificates/google-it-support
- Tool: Wireshark packet analyzer — https://www.wireshark.org/
- Tool: Microsoft Sysinternals TCPView for viewing active TCP/UDP endpoints — https://learn.microsoft.com/en-us/sysinternals/downloads/tcpview
- Reference: Microsoft ipconfig documentation — https://learn.microsoft.com/en-us/windows-server/administration/windows-commands/ipconfig
- Reference: Microsoft netstat documentation — https://learn.microsoft.com/en-us/windows-server/administration/windows-commands/netstat
- Reference: Microsoft nslookup documentation — https://learn.microsoft.com/en-us/windows-server/administration/windows-commands/nslookup
- Reference: Wireshark Display Filters — https://wiki.wireshark.org/DisplayFilters
- Practice platform: Cisco Packet Tracer — https://www.netacad.com/courses/packet-tracer

---

*Generated by [Skill-Anything](https://github.com/SYuan03/Skill-Anything)*