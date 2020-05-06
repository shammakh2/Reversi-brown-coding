#Reversi
###Changelog

+ #####Version 0.0.6 || Bugfixing || Date: 1st May 2020
        Fixing issues found using junit tests.

    1. Package: `uk.ac.ncl.game`, Class: `MoveChecker`, Method: `getFinalScore`

        Changed `this.cells[column][row].getValue()` to `this.cells[row][column].getValue()`
        (swapped row and column index pointers) in first `if` statement.
        
    2. Package: `uk.ac.ncl.entity`, Class: `Cell`, Method: `isLegal`
    
        Fixed javadocs, added explanation for the parameter `cells`
            
        

+ #####Version 0.0.5 || Bugfixing || Date: 2nd April 2020
        Fixing more bugs in the code.

    1. Package: `uk.ac.ncl.entity`, Class: `Cell`, Method: `isLegal`

        Added `d_row < BOARD_SIZE` as another condition of if statement in the while loop.  
        Method was giving IndexOutOfBound exception so added the condition to fix it.
    
    2. Package: `uk.ac.ncl.ui`, Class: `MainPanel`
        
        Writing code to implement skip turn rule of the game.
        
        Method: `CheckNextMove`  
        Changed if statement condition to `missedMoves > 0`.
        
        Method: `MoveOpponent`
        Put an if statement around flipPieces method call to make sure parameter isn't null
        Removed `missedMoves += 1;`
        Added code to perform second opponent move if player move not possible.
        
        Method: `MovePlayer`
        Added else if statement to see when no moves available and game ends
        Added else statement to perform second player more if opponent move not available.
        
    3. Package: `uk.ac.ncl.entity`, Class: `Cell`, Method: `isLegal`
    
        Added `break;` in the nested if statement.
        This is to stop flipping pieces after reaching closest piece that is the same color as the color playing the
        turn.
        
    4. Package: `uk.ac.ncl.ui`, Class: `MainPanel`
        
        Added pop ups for whenever turn is skipped.
        
        

+ #####Version 0.0.4 || Bugfixing || Date: 1st April 2020
        Fixing issues found using junit tests.

    1. Package: `uk.ac.ncl.tests`, Class: `MoveCheckerTest`, Method: `findPotentialMoves`

        The condition for the first `assertTrue` statement should be `grayCells.size() == 4` because there are only 
        4 possible moves at the start of the game.
        
    2. Package: `uk.ac.ncl.tests`, Class: `MoveCheckerTest`, Method: `getFinalScore`

        Added the word 'pieces' at the end of the `results` variable.
        The test gave a false because the first results variable was incomplete (missing the word 'pieces' in the end)        
        


+ #####Version 0.0.3 || Bugfixing || Date: 28 March 2020
        Fixing error given by the 'flipCheckers' test.

    1. Package: `uk.ac.ncl.game`, Class: `MoveChecker`, Method: `flipPieces`

        Changed the 'and' operator between the while loop conditions to 'or' so it runs on cells in every direction and
         not just diagonals.

    2. Package: `uk.ac.ncl.game`, Class: `MoveChecker`, Method: `flipPieces`
    
        Added line `this.cells[d_row][d_col].setValue(colour);` in the while loop.
        
        This was done because the cells were not changing color on move and flipCheckers test was giving an error.


+ #####Version 0.0.3 || Bugfixing || Date: 24 March 2020
        Fixing issues found using junit tests.

    1. Package: `uk.ac.ncl.entity`, Class: `Cell`, Method: `getRow`

        Changed the return value of `getRow` method to `return row;` from `return column`.

        Return set to  `column` gives and error in test `generateOpponentDark` because it is a getter to get rows and
        since it didn't, it caused a `NullPointerException` in the `findPotentialMoves` method.
        
    2. Package: `uk.ac.ncl.game`, Class: `MoveChecker`, Method: `generateOpponent`

        Changed the argument of the `findPotentialMoves` function call to the parameter `cellStatus`.

        This was done because in `generateOpponentLight` test the argument passed to `generateOpponent` wasn't used and
        and that caused an error at the first assert statement.
        Now it finds potential moves for the value passed to it rather than just moves for the dark status player.



+ #####Version 0.0.2 || Bugfixing || Date: 23 March 2020
        Fixed all syntax errors but program crashes on `NullPointerException`, `IndexOutOfBoundException` or  doesn't display anything but continues to run. Fixing this issue.

    1. Package: `uk.ac.ncl.game`, Class: `MoveChecker`, Method: constructor

        The parameter `cells` is now assigned to field `cells`.

        When field `cells` is empty (not assigned) it causes a `NullPointerException` in the `findPotentialMoves` method.

    2. Package: `uk.ac.ncl.entity`, Class: `Cell`, Method: `isLegal`

        In the while loop, changed `d_col += dir[0];` to `d_col += dir[1];`, so the cell checks all directions in a loop.  
        This stops the program from getting stuck in the while loop and the while loop checks every direction rather 
        than just the diagonals
        
    3. Package: `uk.ac.ncl.game`, Class: `MoveChecker`, Method: `findPotentialMoves`
    
        In both for loop conditions, changed condition from `<= BOARD_SIZE` to `< BOARD_SIZE` to fix IndexOutOfBoundException.



+ #####Version 0.0.1 || Bugfixing || Date: 23 March 2020   
        The program didn't run. Making changes to fix the issue.
        
    1. Package: `uk.ac.ncl.game`, Class: `MoveChecker`, Method: `getFinalScore`  
    
        Added missing brackets around condition of else if statement.
        
    2. Package `uk.ac.ncl.tests`, Class: `MoveCheckerTest`  
    
       Added semi-colon after line `import uk.ac.ncl.entity.Cell`
       
       
       
       
       
       CELL ISLEGAL DOCSTRING