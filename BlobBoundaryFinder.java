import java.io.File;
import java.util.Scanner;

/**
 * This class is used to find the boundaries of a blob object. It uses a
 * alternating-offsetting and reducing coverage area technique to attempt to reduce the
 * number of reads. Since all blob cells are joined by at least one other blob
 * objects, each of the rows/columns can be offset by 1 cell during the search.
 * 
 * For example: When reading row 0, cells 0, 2, 4, 6, and 8 are checked. Then
 * when reading row 1, cells 1, 3, 5, 7 9 are checked. The process
 * repeats...when reading row 2, cells 0, 2, 4, 6, 8 are checked. Since all
 * blobs are joined at the top, left, right, or bottom, this strategy allows us
 * to cut the number of reads significantly. There is one situation where cells
 * in a previous row have to be checked, but overall number of reads is still
 * reduced. In addition, the range is reduced as each boundary is discovered.
 * 
 * 
 * @author dnance
 *
 */
public class BlobBoundaryFinder {
    private int totalReads = 0;
    private int top = 0;
    private int bottom = 9;
    private int left = 0;
    private int right = 9;
    private int[][] blob;

    public BlobBoundaryFinder(int[][] blob) {
        this.blob = blob;
        init();
    }

    private int readBlobValue(int i, int j) {
        // Obviously question here as to what is a 'read' for counting
        // purposes..Does ArrayOutOfBoundException count?
        // option is to add boundary check prior to calling

        int value = 0;

        try {
            value = blob[i][j];
            totalReads++;
        } catch (ArrayIndexOutOfBoundsException e) {
        }

        return value;
    }

    /**
     * Used to check the previous columns cells starting at the current column's
     * cell position downward.
     * 
     * @param i
     * @param j
     * @return
     */
    private boolean checkPreviousColumn(int i, int j) {
        boolean previous = false;

        for (; i <= bottom; i = i + 2) {
            if (readBlobValue(i, j) == 1) {
                previous = true;
                break;
            }
        }

        return previous;
    }

    /**
     * Used to check the previous rows cells starting at the current row's cell
     * position to the right.
     * 
     * @param i
     * @param j
     * @return
     */
    private boolean checkPreviousRow(int i, int j) {
        boolean previous = false;

        for (; j <= right; j = j + 2) {
            if (readBlobValue(i, j) == 1) {
                previous = true;
                break;
            }
        }

        return previous;
    }

    /**
     * Used to find the right most boundary beginning at far right edge assumes
     * top and bottom as ranges and uses offsetting
     * 
     */
    private void findRight() {
        int offset = 0;

        BoundarySearch: for (int j = 9; j >= left; j--) {
            offset = top + j % 2;

            for (int i = offset; i <= bottom; i = i + 2) {
                int value = readBlobValue(i, j);

                if (value == 1) {
                    right = ((checkPreviousColumn(i, j + 1)) ? j + 1 : j);
                    break BoundarySearch;
                }
            }
        }

        return;
    }

    /**
     * Used to find the left most boundary beginning at far left edge assumes
     * top and bottom as ranges and uses offsetting
     * 
     */
    private void findLeft() {
        int offset = 0;

        BoundarySearch: for (int j = 0; j <= right; j++) {
            offset = top + j % 2;

            for (int i = offset; i <= bottom; i = i + 2) {
                int value = readBlobValue(i, j);

                if (value == 1) {
                    left = ((checkPreviousColumn(i, j - 1)) ? j - 1 : j);
                    break BoundarySearch;
                }
            }
        }

        return;
    }

    private void findTop() {
        int offset = 0;

        BoundarySearch: for (int i = 0; i <= bottom; i++) {
            offset = left + i % 2;

            for (int j = offset; j <= right; j = j + 2) {
                int value = readBlobValue(i, j);

                if (value == 1) {
                    top = ((checkPreviousRow(i - 1, j)) ? i - 1 : i);
                    break BoundarySearch;
                }
            }
        }

        return;
    }

    private void findBottom() {
        int offset = 0;

        BoundarySearch: for (int i = 9; i >= top; i--) {
            offset = left + i % 2;

            for (int j = offset; j <= right; j = j + 2) {
                int value = readBlobValue(i, j);
                if (value == 1) {
                    bottom = ((checkPreviousRow(i + 1, j)) ? i + 1 : i);
                    break BoundarySearch;
                }
            }
        }

        return;
    }

    public void init() {
        findLeft();
        findBottom();
        findRight();
        findTop();

    }

    public int getTotalReads() {
        return totalReads;
    }

    public int getTop() {
        return top;
    }

    public int getBottom() {
        return bottom;
    }

    public int getLeft() {
        return left;
    }

    public int getRight() {
        return right;
    }

    public static void main(String[] args) {
        File file = null;
        int[][] blob = new int[10][10];
        Scanner scanner = null;
    
        try {
            if (args.length < 1) {
                System.out.println("usage: java BlobBoundaryFinder <filename>");
                System.exit(0);
            }
            file = new File(args[0]);
            scanner = new Scanner(file);
    
            int i = 0;
            while (scanner.hasNext()) {
                char[] row = scanner.next().toCharArray();
                for (int j = 0; j < 10; j++) {
                    blob[i][j] = row[j] - 48; // numeric equation caste
                }
                i++;
    
            }
    
            BlobBoundaryFinder finder = new BlobBoundaryFinder(blob);
            System.out.println("file: " + file);
            System.out.println("Cell Reads: " + finder.getTotalReads());
            System.out.println("Top: " + finder.getTop());
            System.out.println("Left: " + finder.getLeft());
            System.out.println("Bottom: " + finder.getBottom());
            System.out.println("Right: " + finder.getRight());
    
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (scanner != null)
                scanner.close();
    
        }
    
    }
}
