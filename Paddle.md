# Funktion der Paddles

Die Paddles im Pong-Spiel werden durch die Paddle-Klasse repräsentiert und spielen eine wesentliche Rolle bei der Interaktion des Spielers mit dem Ball. Jedes Paddle wird durch seine Position, Größe, Geschwindigkeit und Farbe definiert und kann entweder vom Spieler oder der CPU gesteuert werden.

Beim Erstellen eines Paddle-Objekts werden seine Position und Dimensionen festgelegt. Die Position des Spieler-Paddles befindet sich auf der linken Seite des Spielfelds, während das CPU-Paddle auf der rechten Seite positioniert ist. Beide Paddles haben eine rechteckige Form und eine einheitliche Farbe.

Die Paddles bewegen sich vertikal entlang des Spielfeldrands. Das Spieler-Paddle wird durch die Tasten "W" (nach oben) und "S" (nach unten) gesteuert, während das CPU-Paddle automatisch der Position des Balls folgt. Diese Bewegung wird durch die Methode move() gesteuert, die sicherstellt, dass das Paddle nicht über die Grenzen des Spielfelds hinausgeht.

Eine besondere Eigenschaft der Paddles ist die Möglichkeit, verschiedene Effekte anzuwenden. Beispielsweise kann die Größe eines Paddles halbiert werden, wodurch es schwieriger wird, den Ball zu treffen. Dieser Effekt wird durch die Methode halvedPaddleSize() aktiviert und macht das Paddle grau. Es gibt auch eine Methode, um die ursprüngliche Größe und Farbe des Paddles wiederherzustellen, resetPaddleSize(), die nach jedem Punkt zurückgesetzt wird.

Die Paddles reagieren auch auf Kollisionen mit dem Ball. Wenn der Ball ein Paddle trifft, prallt er in die entgegengesetzte Richtung ab, was durch die Methode changeDirectionX() des Balls ermöglicht wird. Dies sorgt dafür, dass das Spiel dynamisch bleibt und der Ball ständig in Bewegung ist.
