package Boardgame;

public class Board {
    
    private Integer rows;
    private Integer columns;
    private Piece[][] pieces;

    public Board(Integer rows, Integer columns) {
        if (rows < 1 || columns < 1) {
            throw new BoardException("Error creating board: There must be at least 1 row and 1 column");
        }
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }

    public Integer getRows() {
        return rows;
    }

    public Integer getColumns() {
        return columns;
    }

    public Piece piece(Integer row, Integer column) {
        if (!positionExistis(row, column)) {
            throw new BoardException("Position not on the board");
        }
        return pieces[row][column];
    }

    public Piece piece(Position position) {
        if (!positionExistis(position)) {
            throw new BoardException("Position not on the board");
        }
        return pieces[position.getRow()][position.getColumn()];  // composicao
    }

    public void placePiece(Piece piece, Position position) {
        if (ThereIsAPiece(position)) {
            throw new BoardException("There is already a piece on position " + position);
        }
        pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
    }

    private boolean positionExistis(Integer row, Integer column) {
        return row >= 0 && row < rows && column >= 0 && column < columns;
    }

    public boolean positionExistis(Position position) {
        return positionExistis(position.getRow(), position.getColumn());
    }

    public boolean ThereIsAPiece(Position position) {
        if (!positionExistis(position)) {
            throw new BoardException("Position not on the board");
        }
        return piece(position) != null;
    }
}
