package sudoku

import zio._
import zio.json._

case class Sudoku(sudoku: List[List[Option[Int]]]) {
  def toList: List[List[Option[Int]]] = sudoku
}

object Sudoku {
  implicit val decoder: JsonDecoder[Sudoku] = DeriveJsonDecoder.gen[Sudoku]
}

object JSONReader {
  def read(path: String): ZIO[Any, Throwable, List[List[Option[Int]]]] =
    for {
      file <- ZIO.succeed(scala.io.Source.fromFile(path))
      lines <- ZIO.succeed(file.getLines.mkString)
      result = lines.fromJson[Sudoku]
      _ <- ZIO.succeed(file.close())
      sudoku <- result.fold(
        error => ZIO.fail(new Exception("Failed to parse JSON")),
        sudoku => ZIO.succeed(sudoku.toList)
      )
    } yield sudoku
}
