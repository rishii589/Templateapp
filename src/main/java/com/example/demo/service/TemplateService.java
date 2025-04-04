package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Template;
import com.example.demo.form.TemplateForm;

/**
 * テンプレート関連のサービスを提供するインターフェースです。
 */
public interface TemplateService {
	
    /**
     * すべてのテンプレートを取得します。
     *
     * @return テンプレートのリスト
     */
	List<Template> findAll();

    List<Template> sort1();

    List<Template> sort2();

    List<Template> sort3();
	
    /**
     * テンプレートを保存します。
     *
     * @param templateForm テンプレートのフォームデータ
     * @return 保存完了メッセージ
     */
	String save(TemplateForm templateForm);
	
    /**
     * 指定されたテンプレートIDに対応するテンプレートを取得します。
     *
     * @param templateId テンプレートID
     * @return テンプレートのフォームデータ
     */
	TemplateForm getTemplate(int id);
	
    /**
     * テンプレートを削除します。
     *
     * @param templateForm テンプレートのフォームデータ
     * @return 削除完了メッセージ
     */
	String delete(int id);
	
	
    /**
     * テンプレートのフォームデータをテンプレートエンティティに変換します。
     *
     * @param templateForm テンプレートのフォームデータ
     * @return テンプレートエンティティ
     */
    Template convertToTemplate(TemplateForm templateForm);
    
    /**
     * テンプレートエンティティをテンプレートのフォームデータに変換します。
     *
     * @param template テンプレートエンティティ
     * @return テンプレートのフォームデータ
     */
    TemplateForm convertToTemplateForm(Template template);

}
