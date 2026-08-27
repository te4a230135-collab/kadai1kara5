package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class UserTest {

    @Test
    void 正常系_ユーザー管理コード登録参照() {
        User user = new User("U001");

        user.setCode("U002");

        assertThat(user.getCode()).isEqualTo("U002");
    }

    @Test
    void 正常系_名前登録参照() {
        User user = new User("U001");

        user.setName("田中");

        assertThat(user.getName()).isEqualTo("田中");
    }

    @Test
    void 正常系_年齢登録参照() {
        User user = new User("U001");

        user.setAge(20);

        assertThat(user.getAge()).isEqualTo(20);
    }

    @Test
    void 異常系_範囲外年齢登録() {
        User user = new User("U001");

        user.setAge(300);

        assertThat(user.getAge()).isEqualTo(-1);
    }

    @Test
    void 異常系_負数年齢登録() {
        User user = new User("U001");

        user.setAge(-10);

        assertThat(user.getAge()).isEqualTo(-1);
    }
}