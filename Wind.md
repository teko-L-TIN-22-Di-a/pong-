# Funktion des Windes

Die [Wind](Wind.md)-Klasse im Pong-Spiel simuliert zufällige [Wind](Wind.md)stärken, die die Bewegung des [Balls](Ball.md) beeinflussen und so für zusätzliche Herausforderungen und unvorhersehbare Momente im Spiel sorgen. Der [Wind](Wind.md) kann die Richtung des [Balls](Ball.md) verändern.

Die [Wind](Wind.md)-Klasse hat zwei wesentliche Eigenschaften:
x: Die [Wind](Wind.md)stärke auf der X-Achse.
y: Die [Wind](Wind.md)stärke auf der Y-Achse.
Diese Eigenschaften repräsentieren die Stärke und Richtung des [Windes](Wind.md) auf den jeweiligen Achsen und können positive oder negative Werte annehmen, um [Wind](Wind.md)stöße in verschiedene Richtungen zu simulieren.

randomWind(): 
Diese Methode generiert zufällige [Wind](Wind.md)stärken für die X- und Y-Achse. Die [Wind](Wind.md)stärke variiert, was bedeutet, dass der [Wind](Wind.md) den Ball in jede Richtung mit unterschiedlicher Stärke beeinflussen kann. Dazu wird ein Zufallsgenerator verwendet.
Wenn die randomWind()-Methode aufgerufen wird, ändert sich die [Wind](Wind.md)stärke zufällig. Diese Werte werden dann genutzt, um die Bewegung des [Balls](Ball.md) zu beeinflussen.

Im Spiel wird der [Wind](Wind.md) angewendet, indem die Methode applyWind(int windX, int windY) des [Ball](Ball.md)-Objekts aufgerufen wird. Diese Methode addiert die Windstärken zu den aktuellen Bewegungsrichtungen des [Balls](Ball.md) (dx und dy), wodurch der [Ball](Ball.md) eine zusätzliche Bewegungskomponente erhält, die durch den [Wind](Wind.md) verursacht wird. Dies macht das Spiel unvorhersehbarer und schwieriger, da der Spieler die Bewegung des [Balls](Ball.md) noch genauer einschätzen muss.

Die vier ersten Ideen für die Implementation des [Windes](Wind.md):

[1. Idee](Pong/src/ch/teko/loefflee/docs/Wind1.jpg): Wind blässt von links unten nach rechts oben.

[2. Idee](Pong/src/ch/teko/loefflee/docs/Wind2.jpg): Wind blässe von rechts unten nach links oben mit intervalls.

[3. Idee](Pong/src/ch/teko/loefflee/docs/Wind3.jpg): Ein Objekt, welches den [Balls](Ball.md) abprallen lässt.

[4. Idee](Pong/src/ch/teko/loefflee/docs/Wind4.jpg): Ein Objekt, welches nur in einem bestimmten Bereich wirkt.

[Javadoc](Pong/src/ch/teko/loefflee/WindDoc.java)


[Wie funktioniert der Wind jetzt genau?](WindErklärung.md)
