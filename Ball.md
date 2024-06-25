# Funktion des Balls

Der Ball im Pong-Spiel ist ein zentraler Bestandteil und wird durch die Ball-Klasse repräsentiert. Diese Klasse sorgt dafür, dass der Ball korrekt im Spiel angezeigt und bewegt wird. Beim Erstellen eines Ball-Objekts wird dieses in der Mitte des Spielfelds positioniert. Der Ball hat eine festgelegte Größe und beginnt mit einer anfänglichen Geschwindigkeit, die seine Bewegung im Spiel bestimmt.

Die Richtung des Balls wird zufällig festgelegt, sodass er entweder nach oben oder unten und nach links oder rechts bewegt. Diese Richtung wird durch die Eigenschaften dx und dy repräsentiert. Bei jeder Bewegung wird die aktuelle Position des Balls anhand dieser Richtungen und seiner Geschwindigkeit aktualisiert. Eine Besonderheit besteht darin, dass der Ball in den ersten Sekunden nach dem Start langsamer und grau dargestellt wird, bevor er seine normale Geschwindigkeit erreicht und weiß wird.

Wenn der Ball an die Ränder des Spielfelds stößt, ändert er seine Richtung entsprechend den physikalischen Gesetzen des Einfallswinkels, sodass er in die entgegengesetzte Richtung zurückprallt. Diese Richtungsänderungen werden durch die Methoden changeDirectionX() und changeDirectionY() gesteuert.

Der Ball kann durch verschiedene Effekte beeinflusst werden. Beispielsweise kann die Geschwindigkeit des Balls vorübergehend verdoppelt werden, wodurch er rot wird, oder er kann durch Windkräfte abgelenkt werden. Diese Effekte sorgen für zusätzliche Dynamik und Herausforderungen im Spiel.
