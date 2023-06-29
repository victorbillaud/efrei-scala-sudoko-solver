package sudoku

import JSONReader._
import zio._

object Main extends ZIOAppDefault {

  var defaultPath = "grids/grid.json"

  def run: ZIO[Any, Throwable, Unit] =
    for {
      path <- promptForFilePath
      array <- JSONReader.read(path)
      _ <- Console.printLine("The Sudoku problem:")
      _ <- Console.printLine(SudokuSolver.prettyString(array))
      _ <- Console.printLine("The solution:")
      _ <- ZIO.succeed(SudokuSolver.solve(array))
    } yield ()

  def promptForFilePath: ZIO[Any, Throwable, String] =
    for {
      _ <- Console.print(
        "Enter the path to the JSON file containing the Sudoku problem (hit Enter to use default):"
      )
      pathInput <- Console.readLine
      path = if (pathInput.isEmpty) defaultPath else pathInput
      fileExistsEffect <- ZIO
        .attempt(java.nio.file.Files.exists(java.nio.file.Paths.get(path)))
        .either
      result <- fileExistsEffect match {
        case Right(true) => ZIO.succeed(path)
        case Right(false) =>
          Console.printLine(
            "File does not exist, please try again."
          ) *> promptForFilePath
        case Left(ex) =>
          Console.printLine(
            s"An error occurred: ${ex.getMessage}"
          ) *> promptForFilePath
      }
    } yield result

}
