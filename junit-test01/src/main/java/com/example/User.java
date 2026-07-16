いけるか？
ちなみにまだある
順番ぐちゃぐちゃかもしれないけど何となく並べ替えといて
今シーズンの使用回数と右側に勝率も出ている
質問は一旦置いておく。
これが今シーズンのロールと勝率だ
貼り付けられたテキスト（1 点）.txt
ドキュメント
おれにはよくわからないがこうなってる。
何か足りなかったらいってくれ
05_JUnit演習2_各種Matcher、コレクションのテスト(1).pdf
PDF

きたきた。

PDF見た。課題3は15ページだな。

ただし、ここで問題がある。

課題3は

User.java
UserTest.java

を使うんだけど、俺はまだ User.java の中身を見てない。

特に課題3の最後に

setAge(int), getAge()を特定の順番で実行した場合、設定可能範囲外の年齢を返す場合がある。これを見つけ出すテストを作成

って書いてある。

これ、

User.javaのバグを読まないと絶対に分からない。

だから次に欲しいものはどっちか。

A

User.java を貼る

public class User {
    ...
}

全部貼ってくれればOK。

B

User.java のスクショ

1枚でも複数枚でもOK。

そうしたら

正常系_ユーザー管理コード登録参照
正常系_名前登録参照
正常系_年齢登録参照
異常系_範囲外年齢登録
異常系_バグ発見テスト

まで全部、学校課題レベルで一緒に作る。

特に最後の「隠れバグ探し」は User.java を見ればたぶん数分で見つかる。

User.java
ファイル

よし、見えた。

まず課題3の正常系4つは簡単。

@Test
void 正常系_ユーザー管理コード登録参照() {
    User user = new User("A001");

    user.setCode("B001");

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

で、問題は最後のバグ探し。

User.javaを見ると年齢の初期値は

private int age = -1;

になってる。

そして

if(age > 0 && age < 200) {
    this.age = age;
}

だから不正値は無視される。

つまり

user.setAge(20);
user.setAge(300);

をやると、

本来は

20
↓
300は不正
↓
-1になる？

と思うかもしれない。

でも実際は

20
↓
300は無視
↓
20のまま

になる。

先生が言ってる

特定の順番で実行した場合、設定可能範囲外の年齢を返す場合がある

は多分これ。

だから課題向けなら

@Test
void 異常系_不正年齢再設定() {
    User user = new User("A001");

    user.setAge(20);
    user.setAge(300);

    assertThat(user.getAge()).isEqualTo(-1);
}

を書けば、

テストは失敗してバグ発見になる。

ただ確認したい。

課題1・2の時って

import static org.assertj.core.api.Assertions.*;

を使ってた？

それとも

import static org.junit.jupiter.api.Assertions.*;

だった？

今回の資料は AssertJ 推しだから、先生によっては AssertJ で統一しろと言われる可能性がある。

よし。

じゃあ次。

UserTest.java の中に 最初のテストだけ 入れよう。

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class UserTest {

    @Test
    void 正常系_ユーザー管理コード登録参照() {
        User user = new User("A001");

        user.setCode("B001");

        assertThat(user.getCode()).isEqualTo("B001");
    }
}

やること

保存
UserTest.java を右クリック
Run As → JUnit Test

結果を教えて。

緑色になった
エラーが出た
User が見つからない等の赤線が出た

どれかをそのまま教えてくれ。ここでパッケージ名の問題が出るかもしれないから確認したい。

スクショ見た。

まずテスト実行の前に修正が必要。

今の UserTest.java は同じ内容が2回入ってる。

見た感じ、

import ...
import ...

public class UserTest {

が1回目、

その後にまた

import ...
import ...

public class UserTest {

が入ってる。

だから一度全部消して、こうしてほしい。

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class UserTest {

    @Test
    void 正常系_ユーザー管理コード登録参照() {
        User user = new User("A001");

        user.setCode("B001");

        assertThat(user.getCode()).isEqualTo("B001");
    }
}

あと確認したい。

今のプロジェクトに

src/main/java
 └ User.java

は存在する？

存在するならスクショを見せて。

VSCode左側のエクスプローラーで

src
 ├ main
 └ test

の中身が見える状態のスクショが欲しい。

実は今のスクショだと

Calc.java

しか見えてなくて、

User.java がどこにあるか分からない。

次は

重複を消す
User.java の場所を確認する

ここまでやって教えてくれ。そこが通ればJUnit実行に進む。

user.javaは存在しない。
配布資料の中にあったのをさっき見せた

あ、なるほど。

じゃあ今の状態ではテストは作れない。

理由は単純で、

User user = new User("A001");

を書いても、プロジェクト内に User クラスが存在しないから。

次にやることはこれだけ。

① User.java を作る

Calc.java があるのと同じ場所に

src/main/java/com/example/...

の中へ

User.java

を新規作成。

② 配布資料の User.java をそのまま入力

さっき見せてくれた User.java の内容を丸ごと入れる。

終わったら

User.java のスクショ

または

User.java のコード全文

を貼ってくれ。

その時点で

User.java が正しいか確認
UserTest.java 作成
JUnit実行
課題3完成
GitHubへコミット
GitHubへPush

まで順番に進めよう。

今は User.java を作るところが最優先。

ライブラリ
/
User.java
99
1
2
3
4
5
6
7
8
9
10
11
12
13
14
15
16
17
18
19
20
21
22
23
24
25
26
27
28
29
30
31
32
33
34
35
36
package jp.te4a.spring.boot.myapp6;


/**
 * ユーザー情報
 * @author user01-m
 *
 */
public class User {


	/**
	 * ユーザー管理コード
	 */
	private String code;
	
	/**
	 * 名前
	 */
	private String name;
	
	/**
	 * 年齢
	 */
	private int age = -1;


	/**
	 * コンストラクタ
	 * 
	 * @param code ユーザー管理コード
	 */
	public User(String code) {
		this.code = code;
	}
	
	/**
	 * 名前取得
	 * 
バージョン履歴