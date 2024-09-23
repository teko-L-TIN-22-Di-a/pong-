Erstellung des Windes:

Zu Beginn des Spiels wird ein Wind-Objekt erstellt.
Der Konstruktor der Wind-Klasse initialisiert die horizontale (x) und vertikale (y) Komponente des Windes zufällig.
Die Windstärke wird durch die Konstante maxWindStrength (0.4f) begrenzt.
Der initiale Wind könnte zum Beispiel (0.2, -0.3) sein, was einen leichten Windstoss nach rechts und oben darstellt.


Kontinuierliche Aktualisierung des Windes:

In jedem Spielzyklus wird die update()-Methode des Wind-Objekts aufgerufen.
Diese Methode ändert die Windrichtung und -stärke graduell:
a. Zu jeder Komponente (x und y) wird ein zufälliger Wert zwischen -0.015 und 0.015 addiert (windChangeRate * (random.nextFloat() - 0.5f)).
b. Die Windstärke wird dann wieder auf den Bereich [-0.4, 0.4] begrenzt.
Dies simuliert die natürliche, unvorhersehbare Veränderung des Windes.


Bewegung des Balls:

In jedem Spielzyklus wird auch die move()-Methode des Ball-Objekts aufgerufen.
Diese Methode erhält das aktuelle Wind-Objekt als Parameter.


Anwendung des Windeinflusses auf den Ball:

Innerhalb der move()-Methode des Balls wird der Windeinfluss berechnet:
a. Zur horizontalen Geschwindigkeit (dx) des Balls wird wind.getX() * windFactor addiert.
b. Zur vertikalen Geschwindigkeit (dy) des Balls wird wind.getY() * windFactor addiert.
Der windFactor (0.05f) bestimmt, wie stark der Wind den Ball beeinflusst.
Beispiel: Bei einem Wind von (0.2, -0.3) und einem Ball mit (dx=5, dy=3) würde sich die Geschwindigkeit wie folgt ändern:
Neue dx = 5 + (0.2 * 0.05) = 5.01
Neue dy = 3 + (-0.3 * 0.05) = 2.985


Anpassung der Ballgeschwindigkeit:

Nach der Windanwendung wird die Ballgeschwindigkeit weiter modifiziert:
a. Reibung: Beide Geschwindigkeitskomponenten werden mit dem Faktor 0.995 multipliziert, um den Ball leicht zu verlangsamen.
b. Minimale Geschwindigkeit: Wenn die Gesamtgeschwindigkeit unter 3 fällt, wird sie auf 3 erhöht.
c. Maximale Geschwindigkeit: Die Geschwindigkeit wird auf maximal 18 (oder 36 bei aktiviertem Doppelgeschwindigkeits-Effekt) begrenzt.


Aktualisierung der Ballposition:

Schließlich wird die Position des Balls aktualisiert:
Neue x-Position = alte x-Position + dx
Neue y-Position = alte y-Position + dy


Kontinuierlicher Effekt:

Dieser gesamte Prozess wiederholt sich in jedem Frame (etwa alle 12 Millisekunden).
Dadurch entsteht eine subtile, aber spürbare Beeinflussung der Ballbahn durch den sich ständig ändernden Wind.
