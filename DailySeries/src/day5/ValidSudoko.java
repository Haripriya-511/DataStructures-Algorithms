package day5;

import java.util.HashSet;

public class ValidSudoko {
    public boolean validateRow(char[][] board,int row){
        HashSet<Character> set=new HashSet<>();
        for(int i=0;i<9;i++){
            if(set.contains(board[row][i]))
                return false;
            if(board[row][i]!='.')
            set.add(board[row][i]);
        }
        return true;
    }
    public boolean validateCol(char[][] board,int col){
        HashSet<Character> set=new HashSet<>();
        for(int i=0;i<9;i++){
            if(set.contains(board[i][col]))
                return false;
            if(board[i][col]!='.')
            set.add(board[i][col]);
        }
        return true;
    }
    public boolean validateBox(int row,int col,char[][] board){
        HashSet<Character> set=new HashSet<>();
        for(int i=row;i<row+3;i++){
            for(int j=col;j<col+3;j++){
                if(set.contains(board[i][j]))
                    return false;
                if(board[i][j]!='.')
                    set.add(board[i][j]);
            }
        }
        return true;
    }
    public boolean isValidSudoku(char[][] board) {
        int rows = 9;
        int cols = 9;
        for (int i = 0; i < rows; i++) {


            if(!validateRow(board,i)) return false;
            if(!validateCol(board,i)) return false;


        }
        for(int i=0;i<9;i+=3) {
            for (int j = 0; j < 9; j += 3) {
                if(!validateBox(i,j,board))
                    return false;
            }
        }

        return true;


    }

    public boolean vaidateSudokoOnePass(char[][] board){
        HashSet<Character>[] rows = new HashSet[9];

        HashSet<Character>[] cols = new HashSet[9];

        HashSet<Character>[] boxes = new HashSet[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
               if(board[i][j]!='.'){
                   if(rows[i].contains(board[i][j])) return false;
                   if(cols[j].contains(board[i][j])) return false;
                   int boxIndex= (i/3)*3 +(j/3);
                   if(boxes[boxIndex].contains(board[i][j])) return false;

                   rows[i].add(board[i][j]);
                   cols[j].add(board[i][j]);
                   boxes[boxIndex].add(board[i][j]);

               }
            }
        }
        return true;

    }
    public boolean isValidSudokuBitMasking(char[][] board){

        int[] rows = new int[9];
        int[] cols = new int[9];
        int[] boxes = new int[9];

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]!='.'){
                    char ch= board[i][j];
                    int digit= ch-'1';
                    int mask= 1<<digit;
                    int boxIndex= (i/3)*3+ (j/3);
                    if((rows[i] & mask)!=0 || (cols[j]&mask)!=0 ||
                            (boxes[boxIndex]&mask) !=0)
                        return false;

                    rows[i]|=mask;
                    cols[j]|=mask;
                    boxes[boxIndex]|=mask;

                }
            }
        }
        return true;

    }

    public static void main(String[] args) {
        char[][] board =
                {{'5','3','.','.','7','.','.','.','.'}
                ,{'6','.','.','1','9','5','.','.','.'}
                ,{'.','9','8','.','.','.','.','6','.'}
                ,{'8','.','.','.','6','.','.','.','3'}
                ,{'4','.','.','8','.','3','.','.','1'}
                ,{'7','.','.','.','2','.','.','.','6'}
                ,{'.','6','.','.','.','.','2','8','.'}
                ,{'.','.','.','4','1','9','.','.','5'}
                ,{'.','.','.','.','8','.','.','7','9'}};
        ValidSudoko sudoko=new ValidSudoko();
        System.out.println(sudoko.isValidSudokuBitMasking(board));

        char[][] board2={{'8','3','.','.','7','.','.','.','.'}
,{'6','.','.','1','9','5','.','.','.'}
,{'.','9','8','.','.','.','.','6','.'}
,{'8','.','.','.','6','.','.','.','3'}
,{'4','.','.','8','.','3','.','.','1'}
,{'7','.','.','.','2','.','.','.','6'}
,{'.','6','.','.','.','.','2','8','.'}
,{'.','.','.','4','1','9','.','.','5'}
,{'.','.','.','.','8','.','.','7','9'}};
        System.out.println(sudoko.vaidateSudokoOnePass(board2));
        System.out.println(sudoko.isValidSudoku(board));

    }
}
