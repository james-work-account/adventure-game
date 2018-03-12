import scala.collection.immutable.Map

object Utils {
  def narrator(key: String, variable: String = ""): String = {
    val text = Map(
      "welcome" -> "Welcome to this adventure!\n",
      "choose name" -> "What is your name?\n> ",
      "greet player" -> s"\nWelcome, $variable!\n",
      "choose class" -> "What kind of hero are you?\nwarrior\n> ",
      "enter room" -> s"$variable has entered a new room.\n",
      "an enemy appeared vowel" -> s"An $variable has appeared!\n",
      "an enemy appeared cons" -> s"A $variable has appeared!\n",
      "choose attack type" -> "Choose your attack type\nslow medium fast\n> ",
      "enemy attack" -> s"Enemy tries to attack with a $variable attack!\n",
      "enemy health" -> s"Enemy has $variable health remaining.\n",
      "player attack" -> s"\nYou try and hit the enemy with a $variable attack.\n",
      "your health" -> s"You have $variable health remaining.\n",
      "you lose" -> s"You have lost! You survived until level $variable.\n",
      "you win" -> "You win!\n"
    )
    text(key)
  }

  lazy val listOfEnemies: List[String] = List("Orc")
  lazy val listOfVowels: List[Char] = List('a', 'e', 'i', 'o', 'u')
  lazy val listOfAttackTypes: List[String] = List("slow", "medium", "fast")
  lazy val mapOfAttackTypes: Map[String, String] = Map(
    "s" -> "slow",
    "slow" -> "slow",
    "m" -> "medium",
    "medium" -> "medium",
    "f" -> "fast",
    "fast" -> "fast"
  )
}
