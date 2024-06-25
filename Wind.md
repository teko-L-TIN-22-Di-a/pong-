# Funktion des Windes

Die Wind-Klasse im Pong-Spiel simuliert zufällige Windstärken, die die Bewegung des Balls beeinflussen und so für zusätzliche Herausforderungen und unvorhersehbare Momente im Spiel sorgen. Der Wind kann die Richtung des Balls verändern.

## Eigenschaften
Die Wind-Klasse hat zwei wesentliche Eigenschaften:
x: Die Windstärke auf der X-Achse.
y: Die Windstärke auf der Y-Achse.
Diese Eigenschaften repräsentieren die Stärke und Richtung des Windes auf den jeweiligen Achsen und können positive oder negative Werte annehmen, um Windstöße in verschiedene Richtungen zu simulieren.

randomWind(): 
Diese Methode generiert zufällige Windstärken für die X- und Y-Achse. Die Windstärke variiert, was bedeutet, dass der Wind den Ball in jede Richtung mit unterschiedlicher Stärke beeinflussen kann. Dazu wird ein Zufallsgenerator verwendet.
Wenn die randomWind()-Methode aufgerufen wird, ändert sich die Windstärke zufällig. Diese Werte werden dann genutzt, um die Bewegung des Balls zu beeinflussen.

Im Spiel wird der Wind angewendet, indem die Methode applyWind(int windX, int windY) des Ball-Objekts aufgerufen wird. Diese Methode addiert die Windstärken zu den aktuellen Bewegungsrichtungen des Balls (dx und dy), wodurch der Ball eine zusätzliche Bewegungskomponente erhält, die durch den Wind verursacht wird. Dies macht das Spiel unvorhersehbarer und schwieriger, da der Spieler die Bewegung des Balls noch genauer einschätzen muss.
