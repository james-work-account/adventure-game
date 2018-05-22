package models

case class Player(name: String, clazz: String, var attackModifier: Double = 1, var health: Int = 1, var level: Int = 1) {
  if(clazz.toLowerCase == "warrior") {
    this.health = 50
    this.attackModifier = 1.5
  } else this.health = 30
}