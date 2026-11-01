package java_proplems;
import java.io.*;
import java.util.*;

enum GameStatus {
    IN_PROGRESS, WHITE_WIN, BLACE_WIN;
}

public class ChessGame {
    Board board;
    Player whitePlayer;
    Player blackPlayer;
    Player currPlayer;
    Stack<Move> undo;
    Stack<Move> redo;
    GameStatus gameStatus;

    public ChessGame(Board board, Player whitePlayer, Player blackPlayer, Player currPlayer, GameStatus gameStatus) {
        this.board = board;
        this.whitePlayer = whitePlayer;
        this.blackPlayer = blackPlayer;
        this.currPlayer = currPlayer;
        this.undo = new Stack<>();
        this.redo = new Stack<>();
        this.gameStatus = gameStatus;
    }

    public boolean move(Position from, Position to) {
        if (gameStatus != GameStatus.IN_PROGRESS) {
            return false;
        }

        if (!board.isInsideBoard(to) || !board.isInsideBoard(from)) {
            return false;
        }

        if (from.row == to.row && from.column == to.column) {
            return false;
        }

        Piece piece = board.getPiece(from);

        if (piece == null || piece.color != currPlayer.color) {
            return false;
        }
        Piece distinationPiece = board.getPiece(to);

        if (distinationPiece != null && distinationPiece.color == currPlayer.color) {
            return false;
        }

        if (!piece.isValidMove(from, to, board)) {
            return false;
        }

        Move move = new Move(from, to, piece, distinationPiece);

        board.setPiece(to, piece);
        board.setPiece(from, null);

        undo.push(move);
        redo.clear();

        if (distinationPiece instanceof King) {
            if (piece.color == Color.WHITE) {
                gameStatus = GameStatus.WHITE_WIN;
            } else {
                gameStatus = GameStatus.BLACE_WIN;
            }

            return true;
        }

        switchPlayer();
        return true;
    }

    public void switchPlayer() {
        if (currPlayer == whitePlayer) {
            currPlayer = blackPlayer;
        } else {
            currPlayer = whitePlayer;
        }
    }

    public boolean undo() {
        if (undo.isEmpty()) {
            return false;
        }
        Move move = undo.pop();
        board.setPiece(move.from, move.movedPiece);
        board.setPiece(move.to, move.capturedPiece);

        redo.push(move);
        switchPlayer();

        gameStatus = GameStatus.IN_PROGRESS;
        return true;
    }

    public boolean redo() {
        if (redo.isEmpty()) {
            return false;
        }
        Move move = redo.pop();
        board.setPiece(move.from, null);
        board.setPiece(move.to, move.movedPiece);

        undo.push(move);

        if (move.capturedPiece instanceof King) {
            if (move.movedPiece.color == Color.WHITE) {
                gameStatus = GameStatus.WHITE_WIN;
            } else {
                gameStatus = GameStatus.BLACE_WIN;
            }
        } else {
            switchPlayer();
        }

        return true;
    }

    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("Hello, World!");
        strings.add("Welcome to CoderPad.");
        strings.add("This pad is running Java " + Runtime.version().feature());

        for (String string : strings) {
            System.out.println(string);
        }
    }
}

enum Color {
    WHITE, BLACK;
}

class Position {
    int row;
    int column;

    Position(int row, int column) {
        this.row = row;
        this.column = column;
    }
}

abstract class Piece {
    Color color;

    Piece(Color color) {
        this.color = color;
    }

    public abstract boolean isValidMove(Position form, Position to, Board board);
}

class Rook extends Piece {
    Rook(Color color) {
        super(color);
    }

    @Override
    public boolean isValidMove(Position from, Position to, Board board) {
        if (from.row != to.row && from.column != to.column) {
            return false;
        }
        return board.isPathClear(from, to);
    }
}

class King extends Piece {
    King(Color color) {
        super(color);
    }

    @Override
    public boolean isValidMove(Position from, Position to, Board board) {
        if (Math.abs(from.row - to.row) > 1 || Math.abs(from.column - to.column) > 1) {
            return false;
        }
        return true;
    }
}

class Board {
    Piece[][] board;

    Board() {
        this.board = new Piece[8][8];
    }

    public Piece getPiece(Position position) {
        return board[position.row][position.column];
    }

    public void setPiece(Position p, Piece piece) {
        board[p.row][p.column] = piece;
    }

    public boolean isPathClear(Position from, Position to) {
        int dx = Integer.compare(to.row, from.row);
        int dy = Integer.compare(to.column, from.column);

        int row = from.row + dx;
        int column = from.column + dy;

        while (row != to.row || column != to.column) {
            if (board[row][column] != null) {
                return false;
            }
            row += dx;
            column += dy;
        }
        return true;
    }

    public boolean isInsideBoard(Position p) {
        if (p.row >= 8 || p.column >= 8) {
            return false;
        }
        return true;
    }
}

class Player {
    String name;
    Color color;

    Player(String name, Color color) {
        this.name = name;
        this.color = color;
    }
}

class Move {
    Position from;
    Position to;
    Piece movedPiece;
    Piece capturedPiece;

    public Move(Position from, Position to, Piece movedPiece, Piece capturedPiece) {
        this.from = from;
        this.to = to;
        this.movedPiece = movedPiece;
        this.capturedPiece = capturedPiece;
    }
}



