// сочетание определения класса и конструктора одновременно объявляет переменные и задаёт их значения
class Rect(var x: Int, var y: Int, var width: Int, var height: Int) : Movable, Figure(0), Transforming {
    var color: Int = -1 // при объявлении каждое поле нужно инициализировать

    lateinit var name: String // значение на момент определения неизвестно (только для объектных типов)
    // дополнительный конструктор вызывает основной
    constructor(rect: Rect) : this(rect.x, rect.y, rect.width, rect.height)

    // нужно явно указывать, что вы переопределяете метод
    override fun move(dx: Int, dy: Int) {
        x += dx; y += dy
    }

    // для каждого класса area() определяется по-своему
    override fun area(): Float {
        return (width*height).toFloat() // требуется явное приведение к вещественному числу
    }

    override fun resize(zoom: Int): Figure {
        this.width += zoom
        this.height += zoom
        return this
    }

    override fun rotate(direction: RotateDirection, centerX: Int, centerY: Int): Figure {
        val relativeX = x - centerX
        val relativeY = y - centerY

        val (newRelativeX, newRelativeY) = when (direction) {
            RotateDirection.Clockwise -> Pair(relativeY, -relativeX)
            RotateDirection.CounterClockwise -> Pair(-relativeY, relativeX)
        }

        x = newRelativeX + centerX
        y = newRelativeY + centerY

        val temp = width
        width = height
        height = temp
        return this
    }

    override fun toString(): String {
        return "(x, y): ($x, $y). (width, height): ($width, $height)"
    }
}