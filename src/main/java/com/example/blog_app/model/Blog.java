package com.example.blog_app.model;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;  // 追加：引数なしコンストラクタ
import lombok.AllArgsConstructor; // 追加：全フィールドのコンストラクタ
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Blog {
    private int id;//ブログのID
    private int userId;//作成者のID、編集権限の管理
    private String title;//ブログのタイトル
    private String content;//ブログの内容
    private LocalDateTime createdAt;//作成日時
    private LocalDateTime updatedAt;//更新日時
}
