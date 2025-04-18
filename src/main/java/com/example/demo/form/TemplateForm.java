package com.example.demo.form;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import com.example.demo.enums.TemplateType; 

public class TemplateForm {
	// テンプレートID
	private int id;

    /**
     * テンプレートの種別ID。
     */
<<<<<<< HEAD
<<<<<<< HEAD
=======
	@NotNull
    private TemplateType typeId;
=======
>>>>>>> ログイン機能実装
    @NotNull
    @Min(value = 0)
    @Max(value = 3)
    private int typeId;
<<<<<<< HEAD
=======
	@NotNull
    private TemplateType typeId;
>>>>>>> parent of 3039d4f (Merge branch 'master' into ログイン機能実装)
=======
>>>>>>> master
>>>>>>> ログイン機能実装

    /**
     * テンプレート本体。
     */
	@NotBlank
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