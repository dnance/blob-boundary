/**
 * Test class used to execute individual testcases against the
 * BlobBoundaryfinder. Uses no testing frameworks only simple conditions for
 * assertions.
 * 
 * @author dnance
 *
 */
public class BlobBoundaryFinder_Test {
    public static void main(String[] args) {
        test_sample1();
        test_sample2();
        test_sample3();
        test_sample4();
        test_sample5();
        test_sample6();
        test_sample7();
        test_sample8();
        test_sample9();
        test_sample10();

    }

    /**
     * This is the sample provided in the problem.
     * 
     * 
     * Expected results: top: 1 bottom: 7 left: 2 right: 6
     * 
     */
    public static void test_sample1() {
        int[][] blob = { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 1, 1, 1, 0, 0, 0, 0, 0 },
                { 0, 0, 1, 1, 1, 1, 1, 0, 0, 0 },
                { 0, 0, 1, 0, 0, 0, 1, 0, 0, 0 },
                { 0, 0, 1, 1, 1, 1, 1, 0, 0, 0 },
                { 0, 0, 0, 0, 1, 0, 1, 0, 0, 0 },
                { 0, 0, 0, 0, 1, 0, 1, 0, 0, 0 },
                { 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };

        BlobBoundaryFinder finder = new BlobBoundaryFinder(blob);
        System.out.println("Testing Sample1...");

        if (finder.getTop() != 1 || finder.getBottom() != 7
                || finder.getLeft() != 2 || finder.getRight() != 6) {
            System.out.println("Incorrect result!");
        }
        displayResults(finder);

    }

    /**
     * Expected results: top: 0, bottom: 7, left: 0, right: 9
     * 
     */
    public static void test_sample2() {
        int[][] blob = { { 1, 1, 0, 0, 0, 0, 0, 0, 1, 1 },
                { 0, 1, 1, 0, 0, 0, 1, 1, 1, 0 },
                { 0, 0, 1, 1, 1, 1, 1, 0, 0, 0 },
                { 0, 0, 1, 0, 0, 0, 1, 0, 0, 0 },
                { 0, 0, 1, 1, 1, 1, 1, 0, 0, 0 },
                { 0, 0, 0, 0, 1, 0, 1, 0, 0, 0 },
                { 0, 0, 0, 0, 1, 0, 1, 0, 0, 0 },
                { 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };

        BlobBoundaryFinder finder = new BlobBoundaryFinder(blob);
        System.out.println("Testing Sample2...");

        if (finder.getTop() != 0 || finder.getBottom() != 7
                || finder.getLeft() != 0 || finder.getRight() != 9) {
            System.out.println("Incorrect result!");
        }
        displayResults(finder);

    }

    /**
     * Expected results: top: 0, bottom: 9, left: 0, right: 9
     * 
     */
    public static void test_sample3() {
        int[][] blob = { { 1, 1, 0, 0, 0, 0, 0, 0, 1, 1 },
                { 0, 1, 1, 0, 0, 0, 1, 1, 1, 0 },
                { 0, 0, 1, 1, 1, 1, 1, 0, 0, 0 },
                { 0, 0, 1, 0, 0, 0, 1, 0, 0, 0 },
                { 0, 0, 1, 1, 1, 1, 1, 0, 0, 0 },
                { 0, 0, 0, 0, 1, 0, 1, 0, 0, 0 },
                { 0, 0, 0, 0, 1, 0, 1, 0, 0, 0 },
                { 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
                { 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };

        BlobBoundaryFinder finder = new BlobBoundaryFinder(blob);
        System.out.println("Testing Sample3...");
        if (finder.getTop() != 0 || finder.getBottom() != 9
                || finder.getLeft() != 0 || finder.getRight() != 9) {
            System.out.println("Incorrect result!");
        }
        displayResults(finder);

    }

    /**
     * 0 in the corners
     * 
     * Expected results: top: 0, bottom: 9, left: 0, right: 9
     * 
     */
    public static void test_sample4() {
        int[][] blob = { { 0, 1, 1, 1, 1, 1, 1, 1, 1, 0 },
                { 1, 1, 0, 0, 0, 0, 0, 0, 1, 1 },
                { 1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                { 1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                { 1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                { 1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                { 1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                { 1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                { 1, 1, 0, 0, 0, 0, 0, 0, 1, 1 },
                { 0, 1, 1, 1, 1, 1, 1, 1, 1, 0 } };

        BlobBoundaryFinder finder = new BlobBoundaryFinder(blob);
        System.out.println("Testing Sample4...");
        if (finder.getTop() != 0 || finder.getBottom() != 9
                || finder.getLeft() != 0 || finder.getRight() != 9) {
            System.out.println("Incorrect result!");
        }
        displayResults(finder);

    }

    /**
     * Verify checkPrevious functions are working
     * 
     * Expected results: top: 1, bottom: 9, left: 0, right: 9
     * 
     */
    public static void test_sample5() {
        int[][] blob = { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 1, 0, 0, 0, 0, 0, 0, 0 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                { 1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                { 1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                { 1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                { 1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                { 1, 1, 0, 0, 0, 0, 0, 0, 1, 1 },
                { 0, 1, 1, 1, 1, 1, 1, 1, 1, 0 } };

        BlobBoundaryFinder finder = new BlobBoundaryFinder(blob);
        System.out.println("Testing Sample5...");
        if (finder.getTop() != 1 || finder.getBottom() != 9
                || finder.getLeft() != 0 || finder.getRight() != 9) {
            System.out.println("Incorrect result!");
        }
        displayResults(finder);
    }

    /**
     * Verify checkPrevious functions are working for left, right,and bottom
     * Expected results: top: 0, bottom: 9, left: 0, right: 9
     * 
     */
    public static void test_sample6() {
        int[][] blob = { { 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 } };

        BlobBoundaryFinder finder = new BlobBoundaryFinder(blob);
        System.out.println("Testing Sample6...");

        if (finder.getTop() != 0 || finder.getBottom() != 9
                || finder.getLeft() != 0 || finder.getRight() != 9) {
            System.out.println("Incorrect result!");
        }
        displayResults(finder);

    }

    /**
     * No-edge boundaries inner rectangle
     * 
     * Expected results: top: 3, bottom: 5, left: 3, right: 7
     * 
     */
    public static void test_sample7() {
        int[][] blob = { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 1, 1, 1, 1, 1, 0, 0 },
                { 0, 0, 0, 1, 1, 1, 1, 1, 0, 0 },
                { 0, 0, 0, 1, 1, 1, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };

        BlobBoundaryFinder finder = new BlobBoundaryFinder(blob);
        System.out.println("Testing Sample7...");

        if (finder.getTop() != 3 || finder.getBottom() != 5
                || finder.getLeft() != 3 || finder.getRight() != 7) {
            System.out.println("Incorrect result!");
        }
        displayResults(finder);

    }

    /**
     * non-symmetrical fork
     * 
     * Expected results: top: 0, bottom: 9, left: 1, right: 9
     * 
     */
    public static void test_sample8() {
        int[][] blob = { { 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 },
                { 0, 1, 0, 0, 0, 1, 0, 0, 0, 1 },
                { 0, 1, 0, 0, 0, 1, 0, 0, 0, 1 },
                { 0, 1, 0, 0, 0, 1, 0, 0, 0, 1 },
                { 0, 1, 0, 0, 0, 1, 0, 0, 0, 1 },
                { 0, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 0, 0, 0, 0, 0, 1, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 1, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 1, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 1, 0, 0, 0, 0 } };

        BlobBoundaryFinder finder = new BlobBoundaryFinder(blob);
        System.out.println("Testing Sample8...");
        if (finder.getTop() != 0 || finder.getBottom() != 9
                || finder.getLeft() != 1 || finder.getRight() != 9) {
            System.out.println("Incorrect result!");
        }
        displayResults(finder);

    }

    /**
     * Upside down pyramid (roughly)
     * 
     * Expected results: top: 0, bottom: 7, left: 1, right: 8
     */
    public static void test_sample9() {
        int[][] blob = { { 0, 1, 1, 1, 1, 1, 1, 1, 1, 0 },
                { 0, 1, 1, 1, 1, 1, 1, 1, 1, 0 },
                { 0, 1, 1, 1, 1, 1, 1, 1, 1, 0 },
                { 0, 1, 1, 1, 1, 1, 1, 1, 1, 0 },
                { 0, 0, 1, 1, 1, 1, 1, 1, 1, 0 },
                { 0, 0, 0, 1, 1, 1, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 1, 1, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };

        BlobBoundaryFinder finder = new BlobBoundaryFinder(blob);
        System.out.println("Testing Sample9...");

        if (finder.getTop() != 0 || finder.getBottom() != 7
                || finder.getLeft() != 1 || finder.getRight() != 8) {
            System.out.println("Incorrect result!");
        }
        displayResults(finder);

    }

    /**
     * Misc blob with right boundary checkPrevious test
     * 
     * Expected results: top: 1, bottom: 7, left: 1, right: 8
     */
    public static void test_sample10() {
        int[][] blob = { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 1, 1, 1, 0, 0, 0, 0, 0, 0 },
                { 0, 1, 1, 1, 0, 0, 0, 0, 0, 0 },
                { 0, 1, 1, 1, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 1, 1, 1, 1, 1, 1, 1, 0 },
                { 0, 0, 0, 1, 1, 1, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 1, 1, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };

        BlobBoundaryFinder finder = new BlobBoundaryFinder(blob);
        System.out.println("Testing Sample10...");

        if (finder.getTop() != 1 || finder.getBottom() != 7
                || finder.getLeft() != 1 || finder.getRight() != 8) {
            System.out.println("Incorrect result!");
        }
        displayResults(finder);

    }

    public static void displayResults(BlobBoundaryFinder finder) {
        System.out.println("Cell Reads: " + finder.getTotalReads());
        System.out.println("Top: " + finder.getTop());
        System.out.println("left: " + finder.getLeft());
        System.out.println("Bottom: " + finder.getBottom());
        System.out.println("right: " + finder.getRight());

    }
}
