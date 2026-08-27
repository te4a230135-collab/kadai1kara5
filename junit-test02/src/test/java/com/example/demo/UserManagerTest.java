package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class UserManagerTest {

    @Test
    void 正常系_ユーザー削除() {

        UserManager manager = UserManager.getInstance();
        manager.deleteAllUser();

        User user = new User("U001");
        user.setName("田中");

        manager.setUserToList(user);
        manager.setUserToMap(user);

        manager.deleteUser("U001");

        assertThat(manager.getUserList()).isEmpty();
        assertThat(manager.getUserMap()).isEmpty();
    }
}