package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.Template;

/**
 * テンプレートエンティティにアクセスするための MyBatis マッパーインターフェースです。
 */
@Mapper
public interface TemplateMapper {
	
    /**
     * 全てのテンプレートを取得します。
     *
     * @return テンプレートのリスト
     */
    List<Template> findAll();

    List<Template> contract();

    List<Template> afterContract();

    List<Template> others();
    
    /**
     * テンプレートを保存します。
     *
     * @param template 保存するテンプレート
     */
    void save(Template template);
    
    /**
     * 指定されたテンプレートIDに対応するテンプレートを取得します。
     *
     * @param templateId テンプレートID
     * @return テンプレート
     */
    Template getTemplate(int id);

    /**
     * テンプレートを更新します。
     *
     * @param template 更新するテンプレート
     * @return 更新された行数
     */
    int update(Template template);
    
    /**
     * テンプレートを削除します。
     *
     * @param template 削除するテンプレート
     * @return 削除された行数
     */
    int delete(int id);
}

