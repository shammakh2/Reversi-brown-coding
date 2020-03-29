#Reversi
###Changelog

+ #####Version 0.0.2 || Bugfixing || Date: 23 March 2020
        Fixed all syntax errors but program crashes on `NullPointerException`, `IndexOutOfBoundException` or  doesn't display anything but continues to run. Fixing this issue.

    1. Package: `uk.ac.ncl.game`, Class: `MoveChecker`, Method: constructor

        The parameter `cells` is now assigned to field `cells`.

        When field `cells` is empty (not assigned) it causes a `NullPointerException` in the `findPotentialMoves` method.

    2. Package: `uk.ac.ncl.entity`, Class: `Cell`, Method: `isLegal`

        In the while loop, changed `d_col += dir[0];` to `d_col += dir[1];`, so the cell checks all directions in a loop.  
        This stops the program from getting stuck in the while loop and the while loop checks every direction rather 
        than just the diagonals


+ #####Version 0.0.1 || Bugfixing || Date: 23 March 2020   
        The program didn't run. Making changes to fix the issue.
        
    1. Package: `uk.ac.ncl.game`, Class: `MoveChecker`, Method: `getFinalScore`  
    
        Added missing brackets around condition of else if statement.
        
    2. Package `uk.ac.ncl.tests`, Class: `MoveCheckerTest`  
    
       Added semi-colon after line `import uk.ac.ncl.entity.Cell`
       
       
       
       
       
       CELL ISLEGAL DOCSTRING