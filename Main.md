# Funktion Main

## Initialisierung und Setup:
Es erstellt ein Fenster (JFrame) mit dem Titel "Pong+" und einer festen Größe von 850x600 Pixeln.
Initialisiert eine Instanz der [Main](Main.md)-Klasse, um das Spiel darin zu verwalten.
Fügt das Spiel (Instanz von [Main](Main.md)) dem JFrame hinzu und macht es sichtbar.

## Spielkomponenten initialisieren:
Ein [Ball](Ball.md) (Ball-Objekt) wird in der Mitte des Spielfelds platziert.
Zwei [Paddles](Paddle.md) (Paddle-Objekte) werden erstellt: Ein Paddle für den Spieler auf der linken Seite und ein CPU-gesteuertes [Paddles](Paddle.md) auf der rechten Seite des Spielfelds.
Die Punktzähler für Spieler und CPU werden initialisiert.

## Spiellogik und Update-Schleife:
Eine endlose Schleife (while (true)) aktualisiert das Spiel in regelmäßigen Abständen.
Die updateGame()-Methode wird aufgerufen, um die Bewegung des [Balls](Ball.md), Kollisionserkennungen, Punktzählung und [Paddles](Paddle.md)-Bewegung zu verwalten.
Die repaint()-Methode wird aufgerufen, um das Spielfeld nach jeder Aktualisierung neu zu zeichnen.

## Benutzerinteraktion verwalten:
Die keyPressed(KeyEvent e)-Methode erlaubt es dem Spieler, das Paddle mit den Tasten "W" (nach oben) und "S" (nach unten) zu steuern.
Das CPU-[Paddle](Paddle.md) bewegt sich automatisch entsprechend der Position des Balls, um diesen zurückzuschlagen.

## Zufällige Effekte:
Zufällige Effekte wie verdoppelte [Ball](Ball.md)geschwindigkeit, halbierte [Paddle](Paddle.md)größe oder Wind werden bei bestimmten Bedingungen aktiviert und beeinflussen das Spielgeschehen.

## Grafische Darstellung:
Die paintComponent(Graphics g)-Methode zeichnet das Spielfeld, den Ball, die [Paddles](Paddle.md) und die Punktzähler auf das Fenster.

## Zusammenfassung:
Die [Main](Main.md)-Klasse dient als Schaltzentrale für das Pong-Spiel, das die Spiellogik steuert, die Grafik verwaltet, Benutzereingaben verarbeitet und eine ansprechende Benutzeroberfläche bereitstellt. Durch die Kombination dieser Elemente bietet das Pong-Spiel ein unterhaltsames und interaktives Spielerlebnis für den Benutzer.
