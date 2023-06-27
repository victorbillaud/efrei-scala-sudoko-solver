## Sudoku Solver

### Context

The purpose of this project is to solve a given Sudoku grid if it is solvable.

This project is part of our Functionnal Programming class. Our team is composed of 4 software engineering students : 
- Victor BILLAUD
- Nicolas CHALANT
- Maya GAWINOWSKI 
- Paul GUERRE

Here is the objective that we had to achieve : 
[Subject](RULES.md)

### How to use ? 

1. Clone this repository
2. Add a JSON file that contains a Sudoku Grid that you want to resolve in the ```grids``` folder. This grid must follow this format :

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
```

```null``` represents empty spots 

[Why this format ?](https://github.com/victorbillaud/efrei-scala-sudoku-solver/tree/modify-readme#grid-format)

3. Type ```sbt``` in your terminal to start the sbt console
4. Type ```run``` in the sbt console to run the solver

### Our libraries 

#### ZIO
We utilize the ZIO library, which is a powerful functional effect system for Scala, to handle errors, perform asynchronous operations, and manage the overall program flow in a composable and type-safe manner.

#### ZIO-JSON


### Explanations

#### Grid format
We chose to use a JSON file with a 2D list structure to represent the Sudoku grid. The grid is defined as an array of arrays, where each inner array represents a row of the Sudoku grid.

Each cell in the grid is represented by an integer value or the "null" value for empty spots.

Using this JSON format allows for a clear and structured representation of the Sudoku grid. It preserves the spatial relationships between the cells and allows for easy access to rows and columns of the grid during the solving process.

Additionally, the JSON format is widely supported and easy to read and write. It also allows for compatibility with other systems and applications that accept JSON as a standard data exchange format.

By following this JSON format, you can easily define and provide Sudoku grids for the solver, making it convenient to solve different Sudoku puzzles by simply modifying the JSON file.