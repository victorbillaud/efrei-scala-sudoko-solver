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
    [5, 3, none, none, 7, none, none, none, none],
    [6, none, none, 1, 9, 5, none, none, none],
    [none, 9, 8, none, none, none, none, 6, none],
    [8, none, none, none, 6, none, none, none, 3],
    [4, none, none, 8, none, 3, none, none, 1],
    [7, none, none, none, 2, none, none, none, 6],
    [none, 6, none, none, none, none, 2, 8, none],
    [none, none, none, 4, 1, 9, none, none, 5],
    [none, none, none, none, 8, none, none, 7, 9]
  ]
}
```

```none``` represents empty spots 

[Why this format ?](https://github.com/victorbillaud/efrei-scala-sudoku-solver/tree/modify-readme#grid-format)

3. Type ```sbt``` in your terminal to start the sbt console
4. Type ```run``` in the sbt console to run the solver

### Our libraries 

#### ZIO
We utilize the ZIO library, which is a powerful functional effect system for Scala, to handle errors, perform asynchronous operations, and manage the overall program flow in a composable and type-safe manner.

#### ZIO-JSON
We discovered that there are two different ways to read the JSON file: ZIO json and Circe json. 

Circe json is really interesting regarding the performance, the security or even the maintenability, because of the large user base.ZIO json use as the ZIO base for everything, like for example the security, or the documentation. It is developed to work in pair with ZIO, so it will have a great performance if its use with ZIO. 

To conclude, it seems that the decision depends on if we use ZIO. If we do use ZIO, then ZIO json is the better solution, but if not, Circe seems a way more interesting. 

This is why we finally decided to use ZIO json. 

### Explanations

#### Grid format
We chose to use a JSON file with a 2D list structure to represent the Sudoku grid. The grid is defined as an array of arrays, where each inner array represents a row of the Sudoku grid.

Each cell in the grid is represented by an integer value, with 0 for empty spots.

Using this JSON format allows for a clear and structured representation of the Sudoku grid. It preserves the spatial relationships between the cells and allows for easy access to rows and columns of the grid during the solving process.

Additionally, the JSON format is widely supported and easy to read and write. It also allows for compatibility with other systems and applications that accept JSON as a standard data exchange format.

By following this JSON format, you can easily define and provide Sudoku grids for the solver, making it convenient to solve different Sudoku puzzles by simply modifying the JSON file.
