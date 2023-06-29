package sudoku

object SudokuValidator {

  def isValidGrid(grid: Array[Array[Int]]): Boolean = {
    // Vérification des dimensions de la grille
    if (grid.length != 9 || grid.exists(row => row.length != 9)) {
      return false
    }

    // Vérification des doublons sur les lignes
    for (row <- grid) {
      val values = row.filter(_ != 0) // Filtrer les espaces nuls
      if (values.distinct.length != values.length) {
        return false
      }
    }

    // Vérification des doublons sur les colonnes
    for (col <- 0 until 9) {
      val column =
        grid.map(row => row(col)).filter(_ != 0) // Filtrer les espaces nuls
      if (column.distinct.length != column.length) {
        return false
      }
    }

    // Vérification des doublons dans chaque sous-grille (3 par 3)
    for (boxRow <- 0 until 3; boxCol <- 0 until 3) {
      val box = for {
        row <- boxRow * 3 until (boxRow * 3 + 3)
        col <- boxCol * 3 until (boxCol * 3 + 3)
      } yield grid(row)(col)

      val nonZeroValues = box.filter(_ != 0) // Filtrer les espaces nuls
      if (nonZeroValues.distinct.length != nonZeroValues.length) {
        return false
      }
    }

    // La grille est valide
    true
  }

}
