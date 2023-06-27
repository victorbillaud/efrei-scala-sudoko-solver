package sudoku

import zio._

object Main extends ZIOAppDefault {

  def run: ZIO[Any, Throwable, Unit] =
    for {
      _ <- Console.print("Enter the path to the JSON file containing the Sudoku problem:")
      path <- Console.readLine
      _ <-  Console.printLine(s"You entered: $path")
      jsonReader <- ZIO.succeed(new JSONReader)
      array <- jsonReader.read(path)
      _ <- Console.printLine(SudokuSolver.prettyString(array))
      // Add your Sudoku solver logic here, utilizing ZIO and interacting with the ZIO Console
    } yield ()
}
