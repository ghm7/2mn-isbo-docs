# Roadmap

Use the generated material in this order.

## 1. Open The Study Folder

`code output/osi_tcp_ip`
Main files to read are the .md files.
Start with these:

```
output/osi_tcp_ip/modelo-osi-vs-modelo-tcp.md
output/osi_tcp_ip/video-krx-tgy3.md
output/osi_tcp_ip/video-ze07ifky.md
output/osi_tcp_ip/algunos-comandos-para-diagnostico-en-instalaciones-de-red.md
output/osi_tcp_ip/unidad-2-altd-r2-sw.md
```

## 2. Study In This Order

### 1. modelo-osi-vs-modelo-tcp.md

Learn the OSI layers, TCP/IP model, encapsulation, and how both models compare.

### 2. video-krx-tgy3.md

Reinforces OSI vs TCP/IP and packet flow.

### 3. introduccion-a-redes-topologias-y-circuitos-7tivpsdwyhe.md

Study topologies: LAN, WAN, star, bus, mesh, etc.

### 4. video-ze07ifky.md and unidad-2-altd-r2-sw.md

Study Layer 2 devices: switches, bridges, MAC addresses, Ethernet frames.

### 5. video-gpbkdz1v.md

Study router/interface configuration and how networks connect.

### 6. algunos-comandos-para-diagnostico-en-instalaciones-de-red.md and video-p4mxkikg.md

Practice diagnostic commands: ipconfig, ping, traceroute, arp, netstat, nslookup.

## 3. Use Each Markdown File Like This

For each .md file:

1. Read the **Summary**.
2. Read the **Key Concepts**.
3. Read the **Detailed Notes**.
4. Copy the **Cheat Sheet** into your own notes.
5. Do the **Quiz** section.
6. Review the **Flashcards** section.

## 4. Practice With The CLI Quiz

Example:
`.venv/bin/sa quiz output/osi_tcp_ip/modelo-osi-vs-modelo-tcp.yaml`
Harder quiz:
`.venv/bin/sa quiz output/osi_tcp_ip/video-krx-tgy3.yaml --difficulty hard --count 10`
Flashcard review:
`.venv/bin/sa review output/osi_tcp_ip/modelo-osi-vs-modelo-tcp.yaml`

## 5. Suggested Study Plan

Day 1:

```
modelo-osi-vs-modelo-tcp.md
video-krx-tgy3.md
```

Goal: explain OSI vs TCP/IP without looking.

Day 2:

```
   introduccion-a-redes-topologias-y-circuitos-7tivpsdwyhe.md
   video-ze07ifky.md
   unidad-2-altd-r2-sw.md
```

Goal: explain LAN/WAN/topologies/switches/bridges/MAC.

Day 3:

```
video-gpbkdz1v.md
video-p4mxkikg.md
algunos-comandos-para-diagnostico-en-instalaciones-de-red.md
```

Goal: understand routers, IP config, and diagnostic commands.
Day 4:

Run quizzes and flashcards:

```
   .venv/bin/sa quiz output/osi_tcp_ip/modelo-osi-vs-modelo-tcp.yaml
   .venv/bin/sa quiz output/osi_tcp_ip/video-ze07ifky.yaml
   .venv/bin/sa quiz output/osi_tcp_ip/algunos-comandos-para-diagnostico-en-instalaciones-de-red.yaml
   .venv/bin/sa review output/osi_tcp_ip/\*.yaml
```

## 6. What You Should Be Able To Explain

Before the test, make sure you can answer:

- What are the 7 OSI layers?
- What are the TCP/IP layers?
- How does OSI map to TCP/IP?
- What is encapsulation?
- What is the difference between MAC and IP?
- What does a switch do?
- What does a router do?
- What is a LAN, MAN, and WAN?
- What are common network topologies?
- What do ping, ipconfig, traceroute, arp, netstat, and nslookup do?
  Best command to start now:
  code output/osi_tcp_ip
