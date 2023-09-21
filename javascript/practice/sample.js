// The Tic Tac Toe game code

let board = [
  ["", "", ""],
  ["", "", ""],
  ["", "", ""]
];

let currentPlayer = "X";

function printBoard() {
  console.log("Current Board:");
  for (let row = 0; row < 3; row++) {
    console.log(board[row].join(" | "));
    if (row < 2) {
      console.log("---------");
    }
  }
}

function validateSymbol(symbol) {
  return symbol === "X" || symbol === "O";
}

function validateCell(cell) {
  return cell >= 1 && cell <= 9 && board[Math.floor((cell - 1) / 3)][(cell - 1) % 3] === "";
}

function makeMove(symbol, cell) {
  if (!validateSymbol(symbol)) {
    console.log("Invalid symbol. Please use 'X' or 'O'.");
    return;
  }

  if (!validateCell(cell)) {
    console.log("Invalid cell. Please choose an empty cell between 1 and 9.");
    return;
  }

  const row = Math.floor((cell - 1) / 3);
  const col = (cell - 1) % 3;
  board[row][col] = symbol;

  printBoard();

  if (checkWin(symbol)) {
    console.log("Player ${symbol} wins!");
  } else if (checkDraw()) {
    console.log("It's a draw!");
  } else {
    currentPlayer = currentPlayer === "X" ? "O" : "X";
  }
}

function checkWin(symbol) {
  // Check rows, columns, and diagonals for a win
  for (let i = 0; i < 3; i++) {
    if (board[i][0] === symbol && board[i][1] === symbol && board[i][2] === symbol) {
      return true;
    }
    if (board[0][i] === symbol && board[1][i] === symbol && board[2][i] === symbol) {
      return true;
    }
  }

  if (board[0][0] === symbol && board[1][1] === symbol && board[2][2] === symbol) {
    return true;
  }

  if (board[0][2] === symbol && board[1][1] === symbol && board[2][0] === symbol) {
    return true;
  }

  return false;
}

function checkDraw() {
  // Check if the board is full (draw)
  for (let row = 0; row < 3; row++) {
    for (let col = 0; col < 3; col++) {
      if (board[row][col] === "") {
        return false;
      }
    }
  }
  return true;
}

// Play the game
function playTicTacToe(symbol, cellno) {
  makeMove(symbol, cellno);
}

// // Example usage:
// playTicTacToe("X", 5); // X makes a move at cell 5
// playTicTacToe("O", 1); // O makes a move at cell 1
// playTicTacToe("X", 2); // X makes a move at cell 2