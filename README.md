# blob-boundary
Solution used to find the top, left, bottom, and right most boundaries(1s) of a 10X10 grid.  Blob is represented with '1' and empty area is represented with a '0'.
===========================
BlobBoundary

There are two source files enclosed in the solution.  The first is the actual class that does all the work and the second is a testing class.
- BlobBoundaryFinder.java
- BlobBoundaryFinder_Test.java

===========================
BlobBoundaryFinder.java
This class expects a 10X10 array passed to the constructor.  It performs the initialization routine from the constructor.  After the object is created the top, bottom, left, and right boundaries can be obtained from their corresponding getter method.  For example, getTop returns the top boundary.  The total number of reads can be obtained from the getTotalReads method.
The class uses an alternating-offsetting and reducing coverage area technique to reduce the number of reads. Since all blob cells are joined by at least one other blob objects, each of the rows/columns can be offset by 1 cell during the search.  For example: When reading row 0 (0 based), cells 0, 2, 4, 6, and 8 are checked. Then when reading row 1, cells 1, 3, 5, 7 9 are checked. The process repeats...when reading row 2, cells 0, 2, 4, 6, 8 are checked. Since all blobs are joined at the top, left, right, or bottom, this strategy allows us to cut the number of reads significantly. There is one situation where cells in a previous row have to be checked, but overall number of reads is still reduced. In addition, the range is reduced as each boundary is discovered since the other boundary searches use other boundaries as range boundaries.
The code is written in Java, but could be easily ported to Python or some other language.  No Java types such as java.util.List or java.util.Map were used in the class other than the main method to load a file.  The code uses Java primitives, arrays, and typical coding constructs such as conditionals and loops.

Assumptions:
 - Input is a 10*10 array of boolean(0|1) values representing a blob shape(ie..there is only one blob shape per 10X10 cordinate space).
 - All blob cells are joine by at least one other blob cell. 
 - data is valid; no validation takes place in the code

Compile:
javac BlobBoundaryFinder.java

Execute:
java BlobBoundaryFinder sample1.txt

Sample Output:
file: sample1.txt
Cell Reads: 52
Top: 1
Left: 2
Bottom: 7
Right: 6


===========================
BlobBoundaryFinder_Test.java
This class contains a main method that will execute several testcases against the BlobBoundaryFinder object.  No testing frameworks were used such as JUnit.  Assertions are just simple conditionals.  All test data is hardcoded in each test method itself.  It is a very simple testing class.

Compile:
javac BlobBoundaryFinder_Test.java

Execute:
java BlobBoundaryFinder_Test

Sample Output:
Testing Sample1...
Cell Reads: 52
Top: 1
left: 2
Bottom: 7
right: 6
Testing Sample2...
Cell Reads: 24
Top: 0
left: 0
Bottom: 7
right: 9
...
