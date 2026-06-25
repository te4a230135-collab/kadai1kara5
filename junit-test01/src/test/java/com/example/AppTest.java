package com.example;

// 例外テスト用のライブラリ（AssertJ）をインポート
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
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

    // ★ここから課題2の例外テストを追加
    @Test
    void divテスト_例外() {
        // ArithmeticException（0での割り算エラー）が発生することを検証する
        assertThatExceptionOfType(ArithmeticException.class)
            .isThrownBy(() -> {
                calc.div(4, 0); // わざと0で割ってエラーを起こす
            })
            .withMessageContaining("/ by zero"); // エラーメッセージにこの文字が含まれるかチェック
    }
}