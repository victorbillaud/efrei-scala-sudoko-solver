package sudoku

object SudokuSolver {

  type Board = List[List[Option[Int]]]

  def isValid(grid: Board, x: Int, y: Int, value: Int): Boolean = {
    // check if the value is already in the row
    val row = grid(y)
    val rowIsValid = !row.contains(Some(value))

    // check if the value is already in the column
    val column = grid.map(_(x))
    val columnIsValid = !column.contains(Some(value))

    val boxX = x / 3
    val boxY = y / 3
    val box = for {
      yb <- (boxY * 3) until (boxY * 3 + 3) // indices for rows in THIS box
      xb <- (boxX * 3) until (boxX * 3 + 3) // same for cols
    } yield grid(yb)(xb)
    val boxIsValid = !box.contains(Some(value))

    rowIsValid && columnIsValid && boxIsValid
  }

  def solve(sudoku: Board, x: Int = 0, y: Int = 0): Unit = {
    if (y >= 9) println(prettyString(sudoku)) // print the solution
    else if (x >= 9) solve(sudoku, 0, y + 1) // call solve for the next row
    else
      sudoku(y)(x) match {
        case Some(_) =>
          solve(
            sudoku,
            x + 1,
            y
          ) // solve for the next cell if the current one is already filled
        case None =>
          (1 to 9).filter(value => isValid(sudoku, x, y, value)).foreach {
            value =>
              // fill the sudoku board with the value
              val updatedSudoku =
                sudoku.updated(y, sudoku(y).updated(x, Some(value)))
              // try the next cell
              solve(updatedSudoku, x + 1, y)
          }
      }
  }

  def prettyString(sudoku: Board): String = {
    sudoku
      .grouped(3)
      .map { bigGroup =>
        bigGroup
          .map { row =>
            row
              .grouped(3)
              .map { smallGroup =>
                smallGroup
                  .map(opt => opt.map(_.toString).getOrElse(" "))
                  .mkString(" ", " ", " ")
              }
              .mkString("|", "|", "|")
          }
          .mkString("\n")
      }
      .mkString(
        "+-------+-------+-------+\n",
        "\n+-------+-------+-------+\n",
        "\n+-------+-------+-------+"
      )
  }

}
