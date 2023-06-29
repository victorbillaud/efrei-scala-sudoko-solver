package sudoku

import munit._

class SudokoValidatorTests extends munit.FunSuite {
  test("valid grid should return true") {
    val validGrid = List(
      List(Some(5), Some(3), None, None, Some(7), None, None, None, None),
      List(Some(6), None, None, Some(1), Some(9), Some(5), None, None, None),
      List(None, Some(9), Some(8), None, None, None, None, Some(6), None),
      List(Some(8), None, None, None, Some(6), None, None, None, Some(3)),
      List(Some(4), None, None, Some(8), None, Some(3), None, None, Some(1)),
      List(Some(7), None, None, None, Some(2), None, None, None, Some(6)),
      List(None, Some(6), None, None, None, None, Some(2), Some(8), None),
      List(None, None, None, Some(4), Some(1), Some(9), None, None, Some(5)),
      List(None, None, None, None, Some(8), None, None, Some(7), Some(9))
    )

    assert(SudokuValidator.isValidGrid(validGrid))
  }

  test("invalid (dimensions) grid should return false") {
    val invalidGrid = List(
      List(Some(5), Some(3), None, None, Some(7), None, None, None),
      List(Some(6), None, None, Some(1), Some(9), Some(5), None, None, None),
      List(None, Some(9), Some(8), None, None, None, None, Some(6), None),
      List(Some(8), None, None, None, Some(6), None, None, None, Some(3)),
      List(Some(4), None, None, Some(8), None, Some(3), None, None, Some(1)),
      List(Some(7), None, None, None, Some(2), None, None, None, Some(6)),
      List(None, Some(6), None, None, None, None, Some(2), Some(8), None),
      List(None, None, None, Some(4), Some(1), Some(9), None, None, Some(5)),
      List(None, None, None, None, Some(8), None, None, Some(7), Some(9))
    )

    assert(!SudokuValidator.isValidGrid(invalidGrid))
  }

  test("invalid (doublon column) grid should return false") {
    val invalidGrid = List(
      List(Some(5), Some(3), None, None, Some(7), None, None, None, None),
      List(Some(6), None, None, Some(1), Some(9), Some(5), None, None, None),
      List(None, Some(9), Some(8), None, None, None, None, Some(6), None),
      List(Some(8), None, None, None, Some(6), None, None, None, Some(3)),
      List(Some(4), None, None, Some(8), None, Some(3), None, None, Some(1)),
      List(Some(7), None, None, None, Some(2), None, None, None, Some(6)),
      List(None, Some(6), None, None, None, None, Some(2), Some(8), None),
      List(None, None, None, Some(4), Some(1), Some(9), None, None, Some(5)),
      List(Some(9), None, None, None, Some(8), None, None, Some(7), Some(9))
    )

    assert(!SudokuValidator.isValidGrid(invalidGrid))
  }

  test("invalid (doublon sous-grille) grid should return false") {
    val invalidGrid = List(
      List(Some(5), Some(3), None, None, Some(7), None, None, None, None),
      List(Some(6), Some(3), None, Some(1), Some(9), Some(5), None, None, None),
      List(None, Some(9), Some(8), None, None, None, None, Some(6), None),
      List(Some(8), None, None, None, Some(6), None, None, None, Some(3)),
      List(Some(4), None, None, Some(8), None, Some(3), None, None, Some(1)),
      List(Some(7), None, None, None, Some(2), None, None, None, Some(6)),
      List(None, Some(6), None, None, None, None, Some(2), Some(8), None),
      List(None, None, None, Some(4), Some(1), Some(9), None, None, Some(5)),
      List(None, None, None, None, Some(8), None, None, Some(7), Some(9))
    )

    assert(!SudokuValidator.isValidGrid(invalidGrid))
  }
}
