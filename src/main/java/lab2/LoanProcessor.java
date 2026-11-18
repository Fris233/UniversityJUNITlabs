package lab2;

public class LoanProcessor {
    public boolean approveLoan(double salary, int creditScore, boolean hasDebt) {
        if (salary < 3000 || creditScore < 600) {
            return false;
        }
        if (hasDebt) {
            return false;
        }
        return true;
    }
}
/*
lab2.LoanProcessorTest.java with tests for all decision paths
Branch coverage report
Table showing def-use pairs and test coverage
CFG diagram (hand-drawn or tool-generated)
 */