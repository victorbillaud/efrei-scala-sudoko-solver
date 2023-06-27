package sudoku

import munit._

class SudokuSolverTests extends munit.FunSuite {
  val sudokuTemplate: SudokuSolver.Board = Array(
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

  test("isValid should work correctly") {
    assert(SudokuSolver.isValid(sudokuTemplate, 0, 2, 1)) // this should pass
    assert(!SudokuSolver.isValid(sudokuTemplate, 0, 2, 5)) // this should fail
  }

  test("solve should work correctly") {
    var result = SudokuSolver.solve(sudokuTemplate)
    assert(result == ())
    
  }
}
