## Sudoku Solver

### Context

The purpose of this project is to solve a given Sudoku grid if it is solvable.

This project is part of our Functionnal Programming class. Here is the objective that we had to achieve : 
[Rules to follow](RULES.md)

### How to use ? 

1. Clone this repository
2. Add a JSON file that contains a Sudoku Grid in the following format in the ```grids``` folder

#### JSON file grid format : 

```json
{
  "sudoku": [
    [5, 3, null, null, 7, null, null, null, null],
    [6, null, null, 1, 9, 5, null, null, null],
    [null, 9, 8, null, null, null, null, 6, null],
    [8, null, null, null, 6, null, null, null, 3],
    [4, null, null, 8, null, 3, null, null, 1],
    [7, null, null, null, 2, null, null, null, 6],
    [null, 6, null, null, null, null, 2, 8, null],
    [null, null, null, 4, 1, 9, null, null, 5],
    [null, null, null, null, 8, null, null, 7, 9]
  ]
}

Where ```null``` represents empty spots 

3. Type ```sbt``` in your terminal to start the sbt console
4. Type ```run``` in the sbt console to run the solver
