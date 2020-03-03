package projects.trees.game_tree;

import base.fundamental.TicTacToe;
import base.trees.Position;
import projects.trees.LinkedTree;

/**
 * A program that play Tic-Tac-Toe effectively. Constructs the entire game tree and picks the optimal move by using
 * minimax evaluation function for performance
 */
public class GameTree {
    /**
     * Takes the current game state, finds and returns an optimal game stage for the current player
     *
     * @param gameState Current TicTacToe game state
     * @return TicTacToe game state with the optimal move
     * @throws IllegalArgumentException If the given game state does not have any more moves left
     */
    public static TicTacToe findBestMove(TicTacToe gameState) throws IllegalArgumentException {
        if (!isMoveLeft(gameState)) throw new IllegalArgumentException("Given game state is already finished");
        LinkedTree<TicTacToe> gameTree = makeGameTree(gameState);
        TicTacToe best = null;
        int bestScore = 0;
        for (Position<TicTacToe> child : gameTree.children(gameTree.root())) {
            if (minimax(child, gameTree, 1, gameState.getPlayer()) * gameState.getPlayer() > bestScore) {
                best = child.getElement();
                bestScore = best.winner() * gameState.getPlayer();
            }
        }
        return best;
    }

    private static float minimax(Position<TicTacToe> child, LinkedTree<TicTacToe> gameTree, int depth, int player) {
        if (!isMoveLeft(child.getElement())) return ((float) child.getElement().winner()) / depth;
        float bestVal = 0;
        for (Position<TicTacToe> position : gameTree.children(child)) {
            bestVal = (player == 1) ?
                    Math.max(bestVal, minimax(position, gameTree, depth++, player)) :
                    Math.min(bestVal, minimax(position, gameTree, depth++, player));
        }
        return bestVal;
    }

    /**
     * Creates a game tree for the given TicTacToe game state that includes all possible game states
     *
     * @param gameState TicTacToe current game state
     * @return LinkedTree that includes all possible game states for the given position
     */
    private static LinkedTree<TicTacToe> makeGameTree(TicTacToe gameState) {
        LinkedTree<TicTacToe> gameTree = new LinkedTree<>();
        gameTree.addRoot(gameState);
        gameTree = addChildPositions(gameTree, gameTree.root());
        return gameTree;
    }

    /**
     * Adds children game states to the given position until no possible move is left
     *
     * @param gameTree LinkedTree that has previous possible game states
     * @param position Tree position that includes the current TicTacToe position
     * @return LinkedTree that has all possible game states in the future
     */
    private static LinkedTree<TicTacToe> addChildPositions(
            LinkedTree<TicTacToe> gameTree,
            Position<TicTacToe> position) {
        if (!isMoveLeft(position.getElement())) return gameTree;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (position.getElement().getPosition(i, j) == 0) {
                    TicTacToe copy = position.getElement().copy();
                    copy.putMark(i, j);
                    gameTree.addChild(copy, position);
                }
            }
        }
        for (Position<TicTacToe> child : gameTree.children(position)) gameTree = addChildPositions(gameTree, child);
        return gameTree;
    }

    /**
     * Checks if the given state has any more moves left
     *
     * @param gameState
     * @return True if the game is in win/lose condition or it has no more moves left
     */
    private static boolean isMoveLeft(TicTacToe gameState) {
        if (gameState.winner() == 0) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (gameState.getPosition(i, j) == 0) return true;
                }
            }
            return false;
        }
        return false;
    }


}
