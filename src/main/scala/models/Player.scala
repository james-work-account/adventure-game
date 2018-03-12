package models

case class Player(name: String, clazz: String, var health: Int = 1, var level: Int = 1) {
  if(clazz.toLowerCase == "warrior") {
    this.health = 50
  } else this.health = 30
}