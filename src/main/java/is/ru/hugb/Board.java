package is.ru.hugb;

public class Board {
        private static char[][] board;
        private static final int row = 3;
        private static final int col = 3;

        private static final char EMPTY = ' ';

        public Board() {
          board = new char[row][col];

          for (int i = 0; i < row; i++) {
              for (int j = 0; j < col; j++) {
                  board[i][j] = EMPTY;
              }
          }
        }

        public static char[][] getBoard() {
          return board;
        }


       public static Boolean checkLegalMove(int row, int col) {
          if((row > 2 || row < 0) || (col > 2 || col < 0))
            return false;
          else if(board[row][col] != EMPTY) {
            return false;
          }

          return true;

        }

        public void updateCell(char player, int row, int col) {
          board[row][col] = player;
        }


       public Boolean checkWin(){
          if(checkWinRow() || checkWinCol() || checkWinDiag()) {
            return true;
          }
          else {
            return false;
          }
       }


        public static Boolean isFull(){
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    // if some cell is empty the board is not full
                    if (board[i][j] == EMPTY) {
                        return false;
                    }
                }
            }
            return true;
        }

        private Boolean checkWinRow(){
          if(board[0][0] == board[1][0] && board[1][0] == board[2][0] && (board[0][0] == 'x' || board[0][0] == 'o')) {
            return true;
          }
          else if (board[0][1] == board[1][1] && board[1][1] == board[2][1] && (board[0][1] == 'x' || board[0][1] == 'o')) {
            return true;
          }
          else if (board[0][2] == board[1][2] && board[1][2] == board[2][2] && (board[0][2] == 'x' || board[0][2] == 'o')) {
            return true;
          }
          else return false;
        }

        private Boolean checkWinCol(){
          if (board[0][0] == board[0][1] && board[0][1] == board[0][2] && (board[0][0] == 'x' || board[0][0] == 'o')) {
            return true;
          }
          else if (board[1][0] == board[1][1] && board[1][1] == board[1][2] && (board[1][0] == 'x' || board[1][0] == 'o')) {
              return true;
          } else if (board[2][0] == board[2][1] && board[2][1] == board[2][2] && (board[2][0] == 'x' || board[2][0] == 'o')) {
              return true;
         }
         else return false;
       }

       private Boolean checkWinDiag(){
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && (board[0][0] == 'x' || board[0][0] == 'o')) {
            return true;
          } else if (board[2][0] == board[1][1] && board[1][1] == board[0][2] && (board[2][0] == 'x' || board[2][0] == 'o')) {
              return true;
          }
          else return false;
     }

      public static void main(String[] args) {
        
      }

}
