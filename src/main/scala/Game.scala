import Fight._
import Utils._
import models.{Enemy, Player}

import scala.Console._
import scala.annotation.tailrec
import scala.util.Random

object Game {

  def main(args: Array[String]): Unit = {
    val player = createPlayer()
    println()

    // Initial play
    playGame(player)
  }

  def createPlayer(): Player = {
    println(YELLOW + narrator("welcome") + RESET)
    print(narrator("choose name"))

    val name = scala.io.StdIn.readLine()

    println(GREEN + narrator("greet player", name) + RESET)
    print(narrator("choose class"))
    val clazz = scala.io.StdIn.readLine()
    createPlayerModel(name, clazz)
  }

  def createPlayerModel(name: String, clazz: String): Player = {
    Player(name, clazz)
  }

  @tailrec
  def playGame(player: Player): Unit = {
    println(BLUE + narrator("enter room", player.name) + RESET)
    val enemy = selectEnemy(player.level)

    if(listOfVowels.contains(enemy.name.head.toLower)) println(YELLOW + narrator("an enemy appeared vowel", enemy.name) + RESET)
    else println(YELLOW + narrator("an enemy appeared cons", enemy.name) + RESET)

    fight(player, enemy)

    if(player.health <= 0) print(RED + narrator("you lose", player.level.toString) + RESET)
    else {
      println(GREEN + narrator("you win") + RESET)
      player.level += 1
      playGame(player)
    }
  }

  def selectEnemy(level: Int): Enemy = {
    val randomNumber = Random.nextInt(listOfEnemies.length)
    if(listOfEnemies(randomNumber) == "Orc") Enemy.Orc(level)
    else Enemy
  }



}
