# Funktion der Paddles

Die [Paddles](Paddle.md) im Pong-Spiel werden durch die [Paddle](Paddle.md)-Klasse repräsentiert und spielen eine wesentliche Rolle bei der Interaktion des Spielers mit dem Ball. Jedes [Paddles](Paddle.md) wird durch seine Position, Größe, Geschwindigkeit und Farbe definiert und kann entweder vom Spieler oder der CPU gesteuert werden.

Beim Erstellen eines [Paddle](Paddle.md)-Objekts werden seine Position und Dimensionen festgelegt. Die Position des Spieler-[Paddles](Paddle.md) befindet sich auf der linken Seite des Spielfelds, während das CPU-[Paddle](Paddle.md) auf der rechten Seite positioniert ist. Beide [Paddles](Paddle.md) haben eine rechteckige Form und eine einheitliche Farbe.

Die [Paddles](Paddle.md) bewegen sich vertikal entlang des Spielfeldrands. Das Spieler-[Paddle](Paddle.md) wird durch die Tasten "W" (nach oben) und "S" (nach unten) gesteuert, während das CPU-[Paddle](Paddle.md) automatisch der Position des [Balls](Ball.md) folgt. Diese Bewegung wird durch die Methode move() gesteuert, die sicherstellt, dass das Paddle nicht über die Grenzen des Spielfelds hinausgeht.

Eine besondere Eigenschaft der [Paddles](Paddle.md) ist die Möglichkeit, verschiedene Effekte anzuwenden. Beispielsweise kann die Größe eines [Paddles](Paddle.md) halbiert werden, wodurch es schwieriger wird, den Ball zu treffen. Dieser Effekt wird durch die Methode halvedPaddleSize() aktiviert und macht das [Paddle](Paddle.md) grau. Es gibt auch eine Methode, um die ursprüngliche Größe und Farbe des [Paddles](Paddle.md) wiederherzustellen, resetPaddleSize(), die nach jedem Punkt zurückgesetzt wird.

Die [Paddles](Paddle.md) reagieren auch auf Kollisionen mit dem Ball. Wenn der Ball ein [Paddle](Paddle.md) trifft, prallt er in die entgegengesetzte Richtung ab, was durch die Methode changeDirectionX() des [Balls](Ball.md) ermöglicht wird. Dies sorgt dafür, dass das Spiel dynamisch bleibt und der [Ball](Ball.md) ständig in Bewegung ist.

[Javadoc](Pong/src/ch/teko/loefflee/PaddleDoc.java)
