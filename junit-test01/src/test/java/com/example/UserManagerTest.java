package jp.te4a.spring.boot.myapp6;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserManagerTest {

    private UserManager manager;

    @BeforeEach
    void init() {
        manager = UserManager.getInstance();
        manager.deleteAllUser();
    }

    @Test
    void 正常系_UserManagerインスタンス同一() {
        UserManager manager1 = UserManager.getInstance();
        UserManager manager2 = UserManager.getInstance();

        assertThat(manager1).isSameAs(manager2);
    }

    @Test
    void 正常系_userList登録参照() {

        User user1 = new User("A001");
        User user2 = new User("A002");

        manager.setUserToList(user1);
        manager.setUserToList(user2);

        assertThat(manager.getUserList())
                .contains(user1, user2);
    }

    @Test
    void 正常系_userMap登録参照() {

        User user1 = new User("A001");
        User user2 = new User("A002");

        manager.setUserToMap(user1);
        manager.setUserToMap(user2);

        assertThat(manager.getUserMap())
                .containsKeys("A001", "A002");
    }

    @Test
    void 正常系_user全削除() {

        User user1 = new User("A001");

        manager.setUserToList(user1);
        manager.setUserToMap(user1);

        manager.deleteAllUser();

        assertThat(manager.getUserList()).isEmpty();
        assertThat(manager.getUserMap()).isEmpty();
    }

    @Test
    void 正常系_code指定user削除() {

        User user1 = new User("A001");

        manager.setUserToList(user1);
        manager.setUserToMap(user1);

        manager.deleteUser("A001");

        assertThat(manager.getUserList())
                .doesNotContain(user1);

        assertThat(manager.getUserMap())
                .doesNotContainKey("A001");
    }
}