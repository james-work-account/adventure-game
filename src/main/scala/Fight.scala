import Utils._
import models.{Enemy, Player}

import scala.Console.{print, _}
import scala.annotation.tailrec
import scala.util.Random

object Fight {

  @tailrec
  def fight(player: Player, enemy: Enemy): Unit = {
    if(player.health > 0) {
      playerAttack(player, enemy)
    }

    if(enemy.health > 0) {
      enemyAttack(player, enemy)
    }

    if(player.health > 0 && enemy.health > 0) fight(player, enemy)
  }

  private def playerAttack(player: Player, enemy: Enemy): Unit = {
    print(narrator("choose attack type"))

    val attackType: String = scala.io.StdIn.readLine()
    val playerAttack: String = {
      if(mapOfAttackTypes.seq.contains(attackType)) mapOfAttackTypes(attackType) else "fast"
    }

    narration(narrator("player attack", playerAttack), colour = CYAN, newline = false)

    val damage: Int = calcDamage(player.level, attackType, player.attackModifier)
    if(enemy.health - damage < 0) enemy.health = 0 else enemy.health -= damage

    narration(narrator("enemy health", enemy.health.toString), colour = RED)
  }

  private def enemyAttack(player: Player, enemy: Enemy): Unit = {
    val enemyAttack: String = listOfAttackTypes(Random.nextInt(2))

    narration(narrator("enemy attack", enemyAttack), colour = CYAN, newline = false)

    val damage: Int = calcDamage(enemy.level, enemyAttack, enemy.attackModifer)
    if(player.health - damage < 0) player.health = 0 else player.health -= damage

    narration(narrator("your health", player.health.toString), RED)
  }

  private def calcDamage(level: Int, attackType: String, modifier: Double = 1): Int = {
    val chanceToHit: Int = Random.nextInt(20)
    attackType.toLowerCase match {
      case "slow" | "s" => if(chanceToHit > 15) (level * 1.4 * modifier).ceil.toInt else 0
      case "medium" | "m" => if(chanceToHit > 8) (level * 1.2 * modifier).ceil.toInt else 0
      case _ => if(chanceToHit > 3) (level * modifier).ceil.toInt else 0
    }
  }
}
