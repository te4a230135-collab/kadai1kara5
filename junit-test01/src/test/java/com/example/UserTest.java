package jp.te4a.spring.boot.myapp6;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class UserTest {

    @Test
    void 正常系_ユーザー管理コード登録参照() {
        User user = new User("A001");

        user.
        setCode("B001");

        assertThat(user.getCode()).isEqualTo("B001");
    }

    @Test
    void 正常系_名前登録参照() {
        User user = new User("A001");

        user.setName("田中");

        assertThat(user.getName()).isEqualTo("田中");
    }

    @Test
    void 正常系_年齢登録参照() {
        User user = new User("A001");

        user.setAge(20);

        assertThat(user.getAge()).isEqualTo(20);
    }

    @Test
    void 異常系_範囲外年齢登録() {
        User user = new User("A001");

        user.setAge(300);

        assertThat(user.getAge()).isEqualTo(-1);
    }

    @Test
    void 異常系_不正年齢再設定() {
        User user = new User("A001");

        user.setAge(20);
        user.setAge(300);

        assertThat(user.getAge()).isEqualTo(-1);
    }
}