package sudoku

object SudokuSolver {

  type Cell = Option[Int]
  type Grid = List[List[Cell]]

  def isValid(grid: Grid, row: Int, col: Int, num: Int): Boolean = {
    // Check if `num` is not in already present in current row / current column / current 3x3 box
    !((0 until 9).exists(i => grid(row)(i) == Some(num)) ||
      (0 until 9).exists(i => grid(i)(col) == Some(num)) ||
      (0 until 3).exists(i =>
        (0 until 3).exists(j =>
          grid(i + row - row % 3)(j + col - col % 3) == Some(num)
        )
      ))
  }

  def solve(grid: Grid): Option[Grid] = {
    // Find an empty cell
    val emptyCellOption = (for {
      row <- grid.indices
      col <- grid(row).indices
      if grid(row)(col).isEmpty
    } yield (row, col)).headOption

    emptyCellOption match {
      case Some((row, col)) =>
        // Try numbers from 1 to 9 for the empty cell
        (1 to 9).collectFirst {
          case num if isValid(grid, row, col, num) =>
            // If `num` can be placed in the current cell, call `solve` recursively
            solve(grid.updated(row, grid(row).updated(col, Some(num))))
        }.flatten

      case None =>
        // If there are no empty cells, the Sudoku puzzle has been solved
        Some(grid)
    }
  }
}
