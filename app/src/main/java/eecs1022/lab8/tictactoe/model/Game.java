package eecs1022.lab8.tictactoe.model;

public class Game {


    //Attributes----------------------------------------------------------
    private String playerX="";
    private String playerO="";
    private String currentPlayer="";
    private String Status;
    private String winner;

    private char[][] board = null;
    private char input;

    private boolean error;
    private boolean gameOver;

    private int count;
    private int GOCounter;
    private int tT;
    private int tieCounter;


    //Constructor---------------------------------------------------------

    public Game(){
        this.input='x';
        this.count=1;
        this.GOCounter=0;
        this.gameOver=false;
        this.error=false;
        this.tT=0;
        this.tieCounter=0;

        this.board=new char[][] {
                {'_', '_', '_'},
                {'_', '_', '_'},
                {'_', '_', '_'}
        };
    }

    public Game(String playerX, String playerO) {
        this.playerX=playerX;
        this.playerO=playerO;
        this.currentPlayer=playerX;
        this.input='x';
        this.count=1;
        this.GOCounter=0;
        this.gameOver=false;
        this.error=false;
        this.tT=0;
        this.tieCounter=0;


        this.board=new char[][] {
                {'_', '_', '_'},
                {'_', '_', '_'},
                {'_', '_', '_'}
        };


    }



    //Assessor method----------------------------------------------------

    public String getCurrentPlayer() {
        return this.currentPlayer;
    }




    public String getStatus() {
        if(error==false) {
            this.Status= this.currentPlayer+ "'s turn to play...";
        }
        return this.Status;
    }

    public char[][] getBoard(){
        return this.board;
    }

    public boolean checkReset() {
        return this.gameOver;
    }

    public String boardPrint() {

        String out =

                this.getBoard()[0][0] + " , " + this.getBoard()[0][1] + " , "  + this.getBoard()[0][2] + "\n" +
                this.getBoard()[1][0] + " , " + this.getBoard()[1][1] + " , "  + this.getBoard()[1][2] + "\n" +
                this.getBoard()[2][0] + " , " + this.getBoard()[2][1] + " , "  + this.getBoard()[2][2]  + "\n" +

                getStatus();



        return out;
    }



    //Mutator method-------------------------------------------------------

    public void setWhoPlaysFirst(char xo) {
        if(xo=='x') {
            this.currentPlayer=this.playerX;
            input='x';
        }
        if(xo == 'o') {
            this.currentPlayer= playerO;
            input='o';
            count++;
        }
    }


    public void checkGameOver() {


        for(int i=0; i<3;i++) {
            if((this.board[i][0]==this.board[i][1]) && (this.board[i][1]==this.board[i][2]) && (board[i][0]!='_')) {
                this.gameOver=true;
                this.currentPlayer=null;
                if(this.board[i][0]=='x') {
                    this.winner=playerX;
                }

                if(this.board[i][0]=='o') {
                    this.winner=playerO;
                }
            }
        }


        for(int i=0; i<3;i++) {
            if((this.board[0][i]==this.board[1][i]) && (this.board[1][i]==this.board[2][i]) && (board[0][i]!='_')) {
                this.gameOver=true;
                this.currentPlayer=null;
                if(this.board[i][0]=='x') {
                    this.winner=playerX;
                }

                if(this.board[i][0]=='o') {
                    this.winner=playerO;
                }
            }
        }


        if((this.board[0][0]==this.board[1][1]) && (this.board[1][1]==this.board[2][2]) && (board[0][0]!='_')) {
            this.gameOver=true;
            this.currentPlayer=null;
            if(this.board[0][0]=='x') {
                this.winner=playerX;
            }

            if(this.board[0][0]=='o') {
                this.winner=playerO;
            }
        }


        if((this.board[0][2]==this.board[1][1]) && (this.board[1][1]==this.board[2][0]) && (board[0][2]!='_')) {
            this.gameOver=true;
            this.currentPlayer=null;
            if(this.board[0][2]=='x') {
                this.winner=playerX;
            }

            if(this.board[0][2]=='o') {
                this.winner=playerO;
            }
        }


    }






    public void move(int row, int col) {
        checkGameOver();



        if((row <1 || row>3) && (gameOver==false)) {
            error=true;
            this.Status = "Error: row " + row + " is invalid.";
        }

        else if((col <1 || col>3) && (gameOver==false)) {
            error=true;
            this.Status = "Error: col " + col + " is invalid.";
        }

        else if((gameOver == false) && ((board[row-1][col-1] == 'x')|| (board[row-1][col-1] == 'o'))) {
            error=true;
            this.Status = "Error: slot @ (" + row + ", " + col +") is already occupied.";
        }


        else {

            if(gameOver==false) {
                board[row-1][col-1] = input;
                error=false;

                if(count%2==0) {
                    this.input='x';
                    this.currentPlayer= this.playerX;
                }

                if(count%2!=0) {
                    this.input='o';
                    this.currentPlayer=this.playerO;
                }

                count++;
                tT++;


            }








            checkGameOver();

            if((gameOver == true) && (GOCounter >= 1)) {
                GOCounter++;
                error=true;
                this.Status= "Error: game is already over with a winner.";
            }

            if((gameOver == true) && (GOCounter == 0)) {
                GOCounter++;
                error=true;
                this.Status= "Game is over with " + this.winner + " being the winner.";
            }


            if(tT==9 && tieCounter>0) {
                error=true;
                this.Status="Error: game is already over with a tie.";
            }

            if(tT==9 && (tieCounter == 0)) {
                tieCounter++;
                error=true;
                gameOver=true;
                this.currentPlayer=null;
                this.Status= "Game is over with a tie between " + playerX + " and " + playerO + "." ;
            }


        }
    }


    public void reset() {

        this.currentPlayer=playerX;
        this.input='x';
        this.count=1;
        this.GOCounter=0;
        this.gameOver=false;
        this.error=false;
        this.tT=0;
        this.tieCounter=0;


        this.board=new char[][] {
                {'_', '_', '_'},
                {'_', '_', '_'},
                {'_', '_', '_'}
        };

    }
}
