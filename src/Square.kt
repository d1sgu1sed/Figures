// TODO: дополнить определение класса размерами и позицией
class Square(var side_len: Int, var centreX: Int, var centreY: Int):Figure(0), Transforming  {
    // TODO: унаследовать от Figure, реализовать area()
    // TODO: реализовать интерфейс Transforming
    override fun area(): Float {
        return side_len * side_len.toFloat()
    }

    override fun resize(zoom: Int): Figure {
        this.side_len += zoom
        return this
    }

    override fun rotate(direction: RotateDirection, centerX: Int, centerY: Int): Figure {
        val relativeX = centreX - centerX
        val relativeY = centreY - centerY

        val (newRelativeX, newRelativeY) = when (direction) {
            RotateDirection.Clockwise -> Pair(relativeY, -relativeX)
            RotateDirection.CounterClockwise -> Pair(-relativeY, relativeX)
        }

        val newCentreX = newRelativeX + centerX
        val newCentreY = newRelativeY + centerY

        centreX = newCentreX
        centreY = newCentreY

        return this
    }

    override fun toString(): String {
        return "(x, y): ($centreX, $centreY). (side_len): ($side_len)"
    }
}