package com.example.blog_app;

import lombok.Getter;
import lombok.Setter;
import lombok.RequiredArgsConstructor;

@Getter
@Setter
@RequiredArgsConstructor
public class Blog {
    private int blogId;//ブログのID
    private int userId;//作成者のID、編集権限の管理
    private String title;//ブログのタイトル
    private String postContent;//ブログの内容
    private int createdAt;//作成日時
    private int updateAt;//更新日時
}
