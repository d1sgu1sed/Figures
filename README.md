При запуске:

```
fun main() {

    val movable: Movable = Rect(0,0,1,1)
    movable.move(1,1)

    val f: Figure = Rect(0,0,1,1)
    val f2: Figure = Circle(2, 4, 4)
    val f3: Figure = Square(3, 2, 2)
    println(f.area())
    println(f2.area())
    println(f3.area())

    val transforming1 = Rect(0, 0, 1, 1)
    val transforming2 = Square( 4, 1, 1)
    val transforming3 = Circle( 2, 4, 4)
    println(transforming1.resize(3))
    println(transforming2.resize(1))
    println(transforming3.rotate(RotateDirection.Clockwise, 3, 3))
}
```

Вывод:

```
1.0
12.566371
9.0
(x, y): (0, 0). (width, height): (4, 4)
(x, y): (1, 1). (side_len): (5)
(x, y): (4, 4). (radius): (2)
```
