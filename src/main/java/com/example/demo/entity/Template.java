package com.example.demo.entity;

import java.time.LocalDateTime;
import com.example.demo.enums.TemplateType; 

/**
 * テンプレートエンティティクラス
 */
public class Template {
    /**
     * テンプレートID（自動インクリメントされる一意の識別子）。
     */
    private int id;

    /**
     * テンプレートの種別ID。
     */
    private TemplateType typeId;

    /**
     * テンプレート本体。
     */
    private String template;

    /**
     * テンプレートの作成日時（デフォルトは現在の日時）。
     */
    private LocalDateTime createdAt;

    /**
     * テンプレートの更新日時（更新時に現在の日時に自動設定）。
     */
    private LocalDateTime updatedAt;

    private short deleteFlg;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TemplateType getTypeId() {
        return typeId;
    }

    public void setTypeId(TemplateType typeId) {
        this.typeId = typeId;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public short deleteFlg() {
        return deleteFlg;
    }

    public void deleteFlg(short deleteFlg) {
        this.deleteFlg = deleteFlg;
    }

}