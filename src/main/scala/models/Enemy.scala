package models

case class Enemy(var health: Int = 1, var level: Int = 1, name: String = "")

object Enemy extends Enemy(1, 1, "") {
  def Orc(orcLevel: Double = level): Enemy = Enemy(
    ((orcLevel/2) * 7).ceil.toInt,
    1,
    "Orc"
  )
}