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
        @Test
    void 正常系_List追加取得() {

        UserManager manager = UserManager.getInstance();
        manager.deleteAllUser();

        User user = new User("U001");

        manager.setUserToList(user);

        assertThat(manager.getUserList()).hasSize(1);
        assertThat(manager.getUserList().get(0).getCode()).isEqualTo("U001");
    }

    @Test
    void 正常系_Map追加取得() {

        UserManager manager = UserManager.getInstance();
        manager.deleteAllUser();

        User user = new User("U001");

        manager.setUserToMap(user);

        assertThat(manager.getUserMap()).hasSize(1);
        assertThat(manager.getUserMap().get("U001")).isEqualTo(user);
    }

    @Test
    void 正常系_全削除() {

        UserManager manager = UserManager.getInstance();
        manager.deleteAllUser();

        User user1 = new User("U001");
        User user2 = new User("U002");

        manager.setUserToList(user1);
        manager.setUserToList(user2);

        manager.setUserToMap(user1);
        manager.setUserToMap(user2);

        manager.deleteAllUser();

        assertThat(manager.getUserList()).isEmpty();
        assertThat(manager.getUserMap()).isEmpty();
    }
}