package sudoku

import zio._
import zio.json._

case class Sudoku(sudoku: Array[Array[Option[Int]]]) {
  def toArray: Array[Array[Int]] = sudoku.map(_.map(_.getOrElse(0)))
}

object Sudoku {
  implicit val decoder: JsonDecoder[Sudoku] = DeriveJsonDecoder.gen[Sudoku]
}

class JSONReader {
  def read(path: String): ZIO[Any, Throwable, Array[Array[Int]]] =
    for {
      file <- ZIO.succeed(scala.io.Source.fromFile(path))
      lines <- ZIO.succeed(file.getLines.mkString)
      result = lines.fromJson[Sudoku]
      _ <- ZIO.succeed(file.close())
      sudoku <- result.fold(
        error => ZIO.fail(new Exception(s"Failed to parse JSON: $error")),
        sudoku => ZIO.succeed(sudoku.toArray)
      )
    } yield sudoku
}
