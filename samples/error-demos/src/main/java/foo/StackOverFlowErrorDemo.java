package foo;

/**
 * java foo.StackOverFlowErrorDemo -Xss1k
 */
public class StackOverFlowErrorDemo {

    private static int STEP_COUNT = 0;

    private static void outStepCount(){
        STEP_COUNT++;
        System.out.println(STEP_COUNT);
        outStepCount();
    }

    public static void main(String[] args) {
        while (true){
            outStepCount();
        }
    }
}
