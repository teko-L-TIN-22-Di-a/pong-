PONG+

Einleitung:
Pong+ ist eine erweiterte Version des klassischen Pong-Spiels. Der Schwerpunkt dieses Spiels liegt auf der Integration des Wind-Elements, das dem traditionellen Pong eine innovative und unterhaltsame Dimension hinzufügt. Diese Dokumentation soll einen Überblick über das Projekt Pong+ geben, einschliesslich seiner Funktionalitäten, der Implementierung und der Spielmechanik.

Spielbeschreibung:
Pong+ ist ein Arcade-Spiel, das auf dem klassischen Pong basiert, bei dem ein Spieler gegen den CPU antritt. Der Zweck des Spiels ist es, den Ball mit einem sich bewegenden «Balken» zurückzuschlagen.

Funktionalitäten:
Wind-Element: Der Wind beeinflusst die Flugbahn des Balls, indem er ihn in verschiedene Richtungen drückt oder zieht. Die Stärke und Richtung des Winds soll sich während des Spiels ändern. Pong+ wird in 2D erstellt.

Implementierung:
Pong+ wurde mit Java entwickelt und verwendet grundlegende Konzepte der Spieleentwicklung und Objektorientierung. Die Implementierung umfasst die folgenden Hauptkomponenten:

Spielfeld: Das Spielfeld ist die zentrale Komponente des Spiels und enthält die Schläger der Spieler sowie den Ball. Es verwaltet die Kollisionen zwischen den Objekten und die Bewegung des Balls entsprechend den Spielregeln und dem Einfluss des Windes.
Schläger: Der Spieler (mit W, S) und der CPU steuern jeweils einen Schläger, der verwendet wird, um den Ball zurückzuschlagen. Die Schläger bewegen sich vertikal auf dem Bildschirm.
Ball: Der Ball bewegt sich innerhalb des Spielfelds und prallt von den Schlägern und den Spielfeldrändern ab. Die Bewegung des Balls wird durch die Windstärke und -richtung beeinflusst.
Wind-Engine: Die Wind-Engine ist verantwortlich für die Berechnung und Anwendung der Windeffekte auf den Ball. Sie simuliert die Veränderungen der Windstärke und -richtung im Spielverlauf.
