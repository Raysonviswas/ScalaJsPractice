package tutorial.webapp

import org.scalajs.dom
import org.scalajs.dom.{CanvasRenderingContext2D, document}
import org.scalajs.dom.html.Canvas

abstract class Shape(var x: Int, var y: Int) {
  def move(dx: Int, dy: Int): Unit = {
    x += dx
    y += dy
  }

  def draw(): Unit = {
    println(s"Shape at $x, $y")
  }
}
class Brick(x: Int, y: Int, val width: Int, val height: Int)
  extends Shape(x, y) {
  def draw(targetNode:dom.Node): CanvasRenderingContext2D = {
    println(s"Brick at $x, $y with width $width and height $height")
    
    val brick = document.createElement("canvas").asInstanceOf[Canvas]
    brick.width = width
    brick.height = height

    val ctx = brick.getContext("2d").asInstanceOf[dom.CanvasRenderingContext2D]
    ctx.fillStyle = "#ggg"
    ctx.fillRect(0,0,width,height)
    ctx.arc(7f,7f,7f,0f,0f)


    document.createElement("p")
    targetNode.appendChild(brick)
    ctx
  }
}

class Ball(x: Int, y: Int, val width: Int, val height: Int)
  extends Shape(x, y) {
  override def draw(): Unit = {
    println(s"Brick at $x, $y with width $width and height $height")
    val brick = document.createElement("canvas").asInstanceOf[Canvas]
    brick.width = width
    brick.height = height
  }
}