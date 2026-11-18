package lab2;

import org.junit.Test;
import static org.junit.Assert.*;

public class LoanProcessorTest {
    LoanProcessor loanProcessor = new LoanProcessor();

    @Test
    public void SalaryTrueTest() { //this should evaluate to false because salary is too low
        assertFalse(loanProcessor.approveLoan(100,1000,true) );
    }
    @Test
    public void CreditScoreTrueTest() { //this should evaluate to false because crediscore is too low
        assertFalse(loanProcessor.approveLoan(10000,100,true) );
    }
    @Test
    public void FalseTrueTest() {
        assertFalse(loanProcessor.approveLoan(10000,10000,true) );
    }
    @Test
    public void FalseFalseTest() { //only true case
        assertTrue(loanProcessor.approveLoan(10000,10000,false) );
    }

}
