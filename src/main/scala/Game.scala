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
    narration(narrator("welcome"), colour = YELLOW)
    narration(narrator("choose name"), newline = false)

    val name = scala.io.StdIn.readLine()

    narration(narrator("greet player", name), colour = GREEN)
    narration(narrator("choose class"), newline = false)
    val clazz = scala.io.StdIn.readLine()
    createPlayerModel(name, clazz)
  }

  def createPlayerModel(name: String, clazz: String): Player = {
    Player(name, clazz)
  }

  @tailrec
  def playGame(player: Player): Unit = {
    narration(narrator("enter room", player.name), colour = BLUE)
    val enemy = selectEnemy(player.level)

    if(listOfVowels.contains(enemy.name.head.toLower)) narration(narrator("an enemy appeared vowel", enemy.name), colour = YELLOW)
    else narration(narrator("an enemy appeared cons", enemy.name), colour = YELLOW)

    fight(player, enemy)

    if(player.health <= 0) narration(narrator("you lose", player.level.toString), colour = RED, newline = false)
    else {
      narration(narrator("you win"), colour = GREEN)
      player.level += 1
      playGame(player)
    }
  }

  def selectEnemy(level: Int): Enemy = {
    val randomNumber = Random.nextInt(listOfEnemies.length)
    if(listOfEnemies(randomNumber) == "Orc") Enemy.Orc(level)
    else if(listOfEnemies(randomNumber) == "Rat") Enemy.Rat(level)
    else Enemy
  }



}
