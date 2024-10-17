import kotlin.math.PI

class Circle(var radius: Int, val centreX: Int, val centreY: Int) : Figure(0), Transforming{
    // TODO: реализовать интерфейс Transforming
    override fun area(): Float {
        return  radius * radius * PI.toFloat();
    }

    override fun resize(zoom: Int): Figure {
        this.radius += zoom
        return this
    }

    override fun rotate(direction: RotateDirection, centerX: Int, centerY: Int): Figure {
        return this
    }

    override fun toString(): String {
        return "(x, y): ($centreX, $centreY). (radius): ($radius)"
    }
}