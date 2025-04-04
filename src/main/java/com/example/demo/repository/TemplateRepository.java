package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.entity.Template;
import com.example.demo.mapper.TemplateMapper;


/**
 * テンプレート情報にアクセスするためのリポジトリクラスです。
 */
@Repository
public class TemplateRepository {
	
	private final TemplateMapper templateMapper;
	
    /**
     * コンストラクタ
     *
     * @param templateMapper テンプレートデータへのマッパー
     */
    public TemplateRepository(TemplateMapper templateMapper) {
        this.templateMapper = templateMapper;
    }

    /**
     * 全てのテンプレートを取得します。
     *
     * @return テンプレートのリスト
     */
    public List<Template> findAll() {
        return templateMapper.findAll();
    }

    public List<Template> sort1() {
        return templateMapper.sort1();
    }

    public List<Template> sort2() {
        return templateMapper.sort2();
    }

    public List<Template> sort3() {
        return templateMapper.sort3();
    }
    
    /**
     * テンプレートを保存します。
     *
     * @param template 保存するテンプレート
     */
    public void save(Template template) {
        templateMapper.save(template);
    }
    
    /**
     * 指定されたテンプレートIDに対応するテンプレートを取得します。
     *
     * @param templateId テンプレートID
     * @return テンプレート
     */
    public Template getTemplate(int id) {
        return templateMapper.getTemplate(id);
    }

    /**
     * テンプレートを更新します。
     *
     * @param template 更新するテンプレート
     * @return 更新された行数
     */
    public int update(Template template) {
        return templateMapper.update(template);
    }
    
    /**
     * テンプレートを削除します。
     *
     * @param template 削除するテンプレート
     * @return 削除された行数
     */
    public int delete(int id) {
        return templateMapper.delete(id);
    }

}

