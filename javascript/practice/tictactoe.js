let board =Array(9)
let isGameOver = false
let play = (symbol, cellNo) => {
    
    if (isGameOver == false) {
         
        if ((symbol == 'x' || symbol == 'X') || (symbol == 'o' || symbol == 'O')) {
            
            if ((board[cellNo] == undefined||board[cellNo]== null) && cellNo <9) {
                
                board[cellNo] = symbol
            }
        }
        if(checkwinX())
        {
            console.log("Player X won")
        }
        if (checkwinY())
        {
            console.log("Player Y won ")
        }
    }
}
let checkwinX = () => {
    if ((board[0] ==  board[1] ) && (board[1] == board[2] ) && (board[2] !=undefined)) {
        isGameOver = true
    }
    if ((board[3] == 'x' || board[3] == 'X') && (board[4] == 'x' ||
        board[4] == 'X') && (board[5] == 'x' || board[5] == 'X')) {
        isGameOver = true
    }
    if ((board[6] == 'x' || board[6] == 'X') && (board[7] == 'x' ||
        board[7] == 'X') && (board[8] == 'x' || board[8] == 'X')) {
        isGameOver = true
    }
    if ((board[0] == 'x' || board[0] == 'X') && (board[3] == 'x' ||
        board[3] == 'X') && (board[6] == 'x' || board[6] == 'X')) {
        isGameOver = true
    }
    if ((board[1] == 'x' || board[1] == 'X') && (board[4] == 'x' ||
        board[4] == 'X') && (board[7] == 'x' || board[7] == 'X')) {
        isGameOver = true
    }
    if ((board[2] == 'x' || board[2] == 'X') && (board[5] == 'x' ||
        board[5] == 'X') && (board[8] == 'x' || board[8] == 'X')) {
        isGameOver = true
    }
    if ((board[0] == 'x' || board[0] == 'X') && (board[4] == 'x' ||
        board[4] == 'X') && (board[8] == 'x' || board[8] == 'X')) {
        isGameOver = true
    }
    if ((board[2] == 'x' || board[2] == 'X') && (board[4] == 'x' ||
        board[4] == 'X') && (board[6] == 'x' || board[6] == 'X')) {
        isGameOver = true
    }
}
let checkwinY = () => {
    if ((board[0] == 'o' || board[0] == 'O') && (board[1] == 'o' ||
        board[1] == 'O') && (board[2] == 'o' || board[2] == 'O')) {
        isGameOver = true
    }
    if ((board[3] == 'o' || board[3] == 'O') && (board[4] == 'o' ||
        board[4] == 'O') && (board[5] == 'o' || board[5] == 'O')) {
        isGameOver = true
    }
    if ((board[6] == 'o' || board[6] == 'O') && (board[7] == 'o' ||
        board[7] == 'O') && (board[8] == 'o' || board[8] == 'O')) {
        isGameOver = true
    }
    if ((board[0] == 'o' || board[0] == 'O') && (board[3] == 'o' ||
        board[3] == 'O') && (board[6] == 'o' || board[6] == 'O')) {
        isGameOver = true
    }
    if ((board[1] == 'o' || board[1] == 'O') && (board[4] == 'o' ||
        board[4] == 'O') && (board[7] == 'o' || board[7] == 'O')) {
        isGameOver = true
    }
    if ((board[2] == 'o' || board[2] == 'O') && (board[5] == 'o' ||
        board[5] == 'O') && (board[8] == 'o' || board[8] == 'O')) {
        isGameOver = true
    }
    if ((board[0] == 'o' || board[0] == 'O') && (board[4] == 'o' ||
        board[4] == 'O') && (board[8] == 'o' || board[8] == 'O')) {
        isGameOver = true
    }
    if ((board[2] == 'o' || board[2] == 'O') && (board[4] == 'o' ||
        board[4] == 'O') && (board[6] == 'o' || board[6] == 'O')) {
        isGameOver = true
    }
}


function playTicTacToe(){
    play()
}

for(let i=0;i<9;i++){
    play("x",i)
}