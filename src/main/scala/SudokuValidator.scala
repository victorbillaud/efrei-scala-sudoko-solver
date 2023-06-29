package sudoku

object SudokuValidator {

  def isValidGrid(grid: List[List[Option[Int]]]): Boolean = {
    // Check grid dimensions
    if (grid.length != 9 || grid.exists(row => row.length != 9)) {
      return false
    }

    // Check duplicates in rows
    for (row <- grid) {
      val values = row.flatten // Filter out None values
      if (values.distinct.length != values.length) {
        return false
      }
    }

    // Check duplicates in columns
    for (col <- 0 until 9) {
      val column = grid.map(row => row(col)).flatten // Filter out None values
      if (column.distinct.length != column.length) {
        return false
      }
    }

    // Check duplicates in each sub-grid (3 by 3)
    for (boxRow <- 0 until 3; boxCol <- 0 until 3) {
      val box = for {
        row <- boxRow * 3 until (boxRow * 3 + 3)
        col <- boxCol * 3 until (boxCol * 3 + 3)
      } yield grid(row)(col)

      val nonNoneValues = box.flatten // Filter out None values
      if (nonNoneValues.distinct.length != nonNoneValues.length) {
        return false
      }
    }

    // The grid is valid
    true
  }

}
