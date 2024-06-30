# PONG+

## Einleitung:
Pong+ ist eine erweiterte Version des klassischen Pong-Spiels. Der Schwerpunkt dieses Spiels liegt auf der Integration des [Wind](Wind.md)-Elements, das dem traditionellen Pong eine innovative und unterhaltsame Dimension hinzufügt. Diese Dokumentation soll einen Überblick über das Projekt Pong+ geben, einschliesslich seiner Funktionalitäten, der Implementierung und der Spielmechanik.

## Spielbeschreibung:
Pong+ ist ein Arcade-Spiel, das auf dem klassischen Pong basiert, bei dem ein Spieler gegen den CPU antritt. Der Zweck des Spiels ist es, den [Ball](Ball.md) mit einem sich bewegenden «Balken» zurückzuschlagen.

## Funktionalitäten:
Alles wird vom [Main](Main.md) aus gesteuert.
[Wind](Wind.md)-Element: Der [Wind](Wind.md) beeinflusst die Flugbahn des [Balls](Ball.md), indem er ihn in verschiedene Richtungen drückt oder zieht. Die Stärke und Richtung des [Winds](Wind.md) soll sich während des Spiels ändern. Pong+ wird in 2D erstellt.

## Implementierung:
Pong+ wurde mit Java entwickelt und verwendet grundlegende Konzepte der Spieleentwicklung und Objektorientierung. Die Implementierung umfasst die folgenden Hauptkomponenten:

## Spielfeld: 
Das Spielfeld ist die zentrale Komponente des Spiels und enthält die Schläger der Spieler sowie den [Ball](Ball.md). Es verwaltet die Kollisionen zwischen den Objekten und die Bewegung des [Balls](Ball.md) entsprechend den Spielregeln und dem Einfluss des [Windes](Wind.md).
Schläger: Der Spieler (mit W, S) und der CPU steuern jeweils einen Schläger, der verwendet wird, um den [Ball](Ball.md) zurückzuschlagen. Die Schläger bewegen sich vertikal auf dem Bildschirm.
[Ball](Ball.md): Der [Ball](Ball.md) bewegt sich innerhalb des Spielfelds und prallt von den Schlägern und den Spielfeldrändern ab. Die Bewegung des [Balls](Ball.md) wird durch die [Wind](Wind.md)stärke und -richtung beeinflusst.

## Wind-Engine: 
Die [Wind](Wind.md)-Engine ist verantwortlich für die Berechnung und Anwendung der [Windes](Wind.md)effekte auf den [Ball](Ball.md). Sie simuliert die Veränderungen der [Windes](Wind.md)stärke und -richtung im Spielverlauf.

