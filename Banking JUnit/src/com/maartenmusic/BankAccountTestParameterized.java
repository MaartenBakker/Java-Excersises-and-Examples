package com.maartenmusic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankAccountTestParameterized {

    private BankAccount account;

    @BeforeEach
    public void setup(){
        account = new BankAccount("Maarten", "Bakker", 1000.00, BankAccount.CHECKING);
    }

    public static Stream<testParameters> testConditions() {
        return Stream.of(
                new testParameters(100.00, true, 1100.00),
                new testParameters(200.00, true, 1200.00),
                new testParameters(325.14, true, 1325.14),
                new testParameters(489.33, true, 1489.33),
                new testParameters(1000.00, true, 2000.00)
        );
    }

    @ParameterizedTest
    @MethodSource("testConditions")
    void deposit(testParameters parameters) {
        account.deposit(parameters.getAmount(), parameters.isBranch());
        assertEquals(parameters.getExpected(), account.getBalance(), 0.01);
    }

    static class testParameters
    {
        private double amount;
        private boolean branch;
        private double expected;

        public testParameters(double amount, boolean branch, double expected) {
            this.amount = amount;
            this.branch = branch;
            this.expected = expected;
        }

        public double getAmount() {
            return amount;
        }

        public boolean isBranch() {
            return branch;
        }

        public double getExpected() {
            return expected;
        }
    }




}
