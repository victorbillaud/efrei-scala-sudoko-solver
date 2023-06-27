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
          val column = grid.map(row => row(col)).filter(_ != 0) // Filtrer les espaces nuls
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

    def main(args: Array[String]): Unit = {
     // Exemple de grille valide
    val validGrid = Array(
      Array(5, 3, 0, 0, 7, 0, 0, 0, 0),
      Array(6, 0, 0, 1, 9, 5, 0, 0, 0),
      Array(0, 9, 8, 0, 0, 0, 0, 6, 0),
      Array(8, 0, 0, 0, 6, 0, 0, 0, 3),
      Array(4, 0, 0, 8, 0, 3, 0, 0, 1),
      Array(7, 0, 0, 0, 2, 0, 0, 0, 6),
      Array(0, 6, 0, 0, 0, 0, 2, 8, 0),
      Array(0, 0, 0, 4, 1, 9, 0, 0, 5),
      Array(0, 0, 0, 0, 8, 0, 0, 7, 9)
    )

    // Vérification de la grille valide
    println("Grille valide : " + isValidGrid(validGrid))

    // Exemple de grille invalide (mauvaises dimensions)
    val invalidGrid1 = Array(
      Array(5, 3, 0, 0, 7, 0, 0, 0),
      Array(6, 0, 0, 1, 9, 5, 0, 0, 0),
      Array(0, 9, 8, 0, 0, 0, 0, 6, 0),
      Array(8, 0, 0, 0, 6, 0, 0, 0, 3),
      Array(4, 0, 0, 8, 0, 3, 0, 0, 1),
      Array(7, 0, 0, 0, 2, 0, 0, 0, 6),
      Array(0, 6, 0, 0, 0, 0, 2, 8, 0),
      Array(0, 0, 0, 4, 1, 9, 0, 0, 5),
      Array(0, 0, 0, 0, 8, 0, 0, 7, 9)
    )

    // Vérification de la grille valide
    println("Grille invalide (dimensions) : " + isValidGrid(invalidGrid1))


    // Exemple de grille invalide (doublons dans une colonne)
    val invalidGrid2 = Array(
      Array(5, 3, 0, 0, 7, 0, 0, 0, 0),
      Array(6, 0, 0, 1, 9, 5, 0, 0, 0),
      Array(0, 9, 8, 0, 0, 0, 0, 6, 0),
      Array(8, 0, 0, 0, 6, 0, 0, 0, 3),
      Array(4, 0, 0, 8, 0, 3, 0, 0, 1),
      Array(7, 0, 0, 0, 2, 0, 0, 0, 6),
      Array(0, 6, 0, 0, 0, 0, 2, 8, 0),
      Array(0, 0, 0, 4, 1, 9, 0, 0, 5),
      Array(0, 0, 0, 0, 8, 0, 0, 7, 1) 
    )

    // Vérification de la grille invalide
    println("Grille invalide (doublon colonne) : " + isValidGrid(invalidGrid2))

    // Exemple de grille invalide (doublons dans une ligne)
    val invalidGrid3 = Array(
      Array(5, 3, 0, 0, 7, 0, 0, 0, 0),
      Array(6, 0, 0, 1, 9, 5, 0, 0, 0),
      Array(0, 9, 8, 0, 0, 0, 0, 6, 0),
      Array(8, 0, 0, 0, 6, 0, 0, 0, 3),
      Array(4, 0, 0, 8, 0, 3, 0, 0, 1),
      Array(7, 0, 0, 0, 2, 0, 0, 0, 6),
      Array(0, 6, 0, 0, 0, 0, 2, 8, 0),
      Array(0, 0, 0, 4, 1, 9, 0, 0, 5),
      Array(9, 0, 0, 0, 8, 0, 0, 7, 9)
    )

    // Vérification de la grille valide
    println("Grille invalide (doublon ligne) : " + isValidGrid(invalidGrid3))

    // Exemple de grille invalide (doublons dans une sous-grille)
    val invalidGrid4 = Array(
      Array(5, 3, 0, 0, 7, 0, 0, 0, 0),
      Array(6, 3, 0, 1, 9, 5, 0, 0, 0),
      Array(0, 9, 8, 0, 0, 0, 0, 6, 0),
      Array(8, 0, 0, 0, 6, 0, 0, 0, 3),
      Array(4, 0, 0, 8, 0, 3, 0, 0, 1),
      Array(7, 0, 0, 0, 2, 0, 0, 0, 6),
      Array(0, 6, 0, 0, 0, 0, 2, 8, 0),
      Array(0, 0, 0, 4, 1, 9, 0, 0, 5),
      Array(0, 0, 0, 0, 8, 0, 0, 7, 9)
    ) // Doublon 6 dans la dernière sous-grille


    // Vérification de la grille valide
    println("Grille invalide (doublon sous-grille) : " + isValidGrid(validGrid))
  }
}