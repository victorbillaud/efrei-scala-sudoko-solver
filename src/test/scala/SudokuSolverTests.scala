package sudoku

import munit._

class SudokuSolverTests extends munit.FunSuite {
  val sudokuTemplate = List(
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

  test("isValid should work correctly") {
    assert(SudokuSolver.isValid(sudokuTemplate, 0, 2, 1)) // this should pass
    assert(!SudokuSolver.isValid(sudokuTemplate, 0, 2, 5)) // this should fail
  }

  test("solve should work correctly") {
    var result = SudokuSolver.solve(sudokuTemplate)
    assert(result == ())
    
  }
}
