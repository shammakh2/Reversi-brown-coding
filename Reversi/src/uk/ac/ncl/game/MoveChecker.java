/**
 * @author Kostiantyn Potomkin
 * @version 0.9
 * @since 05-03-2020
 */
package uk.ac.ncl.game;

import uk.ac.ncl.entity.CellStatus;
import uk.ac.ncl.entity.DirectedMove;
import uk.ac.ncl.entity.Cell;

import java.util.ArrayList;

import static uk.ac.ncl.Constants.*;

/**
 *
 * Main logic of the game.
 *
 */
public class MoveChecker {

    private Cell[][] cells;

    public MoveChecker(Cell[][] cells) {

        this.cells = cells;  // Added this line to initialize the field and because the parameter variable wasn't used.

    }

    /**
     * Generates a move of the opponent
     *
     * @param cellStatus - colour of the opponent
     * @return a piece to make a move
     */
    public Cell generateOpponent(CellStatus cellStatus) {
        ArrayList<Cell> potentialMoves = findPotentialMoves(cellStatus); //changed the argument passed to findPotentialMoves to cellStatus. cellStatus is the color passed to it but wasn't used in the method.
        int max_score = 0;
        Cell opponentsMove = null;
        for (int i = 0; i < potentialMoves.size(); i++){
            if (potentialMoves.get(i).getMove().getScore() > max_score){
                opponentsMove = potentialMoves.get(i);
            }
        }
        return opponentsMove;
    }

    /**
     * Flips pieces between selected piece in directions of valid moves.
     *
     * @param cell - piece we have just put on the board
     * @param colour - colour of the current player
     */
    public void flipPieces(Cell cell, CellStatus colour) {
        cell.colourTemp(colour == OPPONENTS_CELL_STATUS ? OPPONENTS_COLOUR : PLAYERS_COLOUR, false);
        for (DirectedMove move : cell.getMove().getMoves()) {
            int[] dir = move.getDirection();
            int d_row = cell.getRow();
            int d_col = cell.getColumn();

            while (d_col != move.getCell().getColumn() || d_row != move.getCell().getRow()) {
                this.cells[d_row][d_col].setValue(colour);
                d_row += dir[0];
                d_col += dir[1];
            }
        }
    }

    /**
     * Returns potential moves on the board for the specified colour
     *
     * @param colour - colour of the current player
     * @return pieces for which there exist valid moves
     */
    public ArrayList<Cell> findPotentialMoves(CellStatus colour) {
        ArrayList<Cell> potentialMoves = new ArrayList<Cell>();
        for (int i = 0; i < BOARD_SIZE; i++) { // '<=' operator changed to '<'
            for (int j = 0; j < BOARD_SIZE; j++) { // '<=' operator changed to '<'
                if (this.cells[i][j].getValue() == CellStatus.EMPTY){
                    if (this.cells[i][j].isLegal(colour, cells)){
                        potentialMoves.add(this.cells[i][j]);
                    }
                }
            }
        }
        return potentialMoves;
    }

    /**
     * Updates information about pieces
     *
     * @param cells - pieces to update
     * @param colour - new colour
     */
    public void colourPieces(ArrayList<Cell> cells, CellStatus colour) {
        for (Cell cell : cells){
            cell.setValue(colour);
        }
    }

    /**
     * Sums up results of the game
     *
     * @return string with the results of the game
     */
    public String getFinalScore(){
        int lights = 0;
        int darks = 0;
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int column = 0; column < BOARD_SIZE; column++) {
                if (this.cells[row][column].getValue() == CellStatus.LIGHT){ // Swapped row and column
                    lights++;
                } else if (this.cells[row][column].getValue() == CellStatus.DARK) { //Added brackets around the condition because it wasn't present
                    darks++;
                }
            }
        }
        if (darks == lights)
            return "The game is over. It is a draw. Each player has " + darks + " pieces";
        String winner = lights > darks ? "Light" : "Dark";
        return "The game is over. "
                + winner + " has won with the result: Dark - " + darks + " Light - " + lights;
    }

    /**
     * Cleans up potential moves from the board cells
     *
     * @param grayCells - pieces with valid moves
     */
    public void removeMoves(ArrayList<Cell> grayCells){
        if (grayCells != null){
            for (int i = 0; i < grayCells.size(); i++){
                grayCells.get(i).setMove(null);
            }
        }
    }


}
