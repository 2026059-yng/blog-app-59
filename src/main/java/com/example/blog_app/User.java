package com.example.blog_app;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.NotEmpty;

//Getter,Setter,コンストラクタの自動生成
@Getter
@Setter
@RequiredArgsConstructor
public class User {
    private final int userId;//ユーザーID
    @NotEmpty(message = "名前を入力してください")
    private final String username;//アカウント名
    @NotEmpty(message = "パスワードを入力してください")
    private final String passWord;
}
