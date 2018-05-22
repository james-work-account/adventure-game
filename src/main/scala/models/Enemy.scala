package models

case class Enemy(var health: Int = 1, var level: Int = 1, attackModifer: Double = 1, name: String = "")

object Enemy extends Enemy(1, 1, 1, "") {
  def Orc(orcLevel: Double): Enemy = Enemy(
    ((orcLevel/2) * 7).ceil.toInt,
    orcLevel.ceil.toInt,
    1.3,
    "Orc"
  )

  def Rat(ratLevel: Double): Enemy = Enemy(
    (ratLevel * 2).ceil.toInt,
    ratLevel.ceil.toInt,
    1.1,
    "Rat"
  )
}