package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class AppTest {

    static Calc calc;

    @BeforeAll
    static void テスト前処理() {
        calc = new Calc();
    }

    @Test
    void addテスト_正常() {
        assertEquals(4, calc.add(1, 3));
    }

    @Test
    void subテスト_正常() {
        assertEquals(2, calc.sub(5, 3));
    }

    @Test
    void divテスト_正常() {
        assertEquals(5, calc.div(10, 2));
    }

    @Test
    void mulテスト_正常() {
        assertEquals(12, calc.mul(4, 3));
    }
}
