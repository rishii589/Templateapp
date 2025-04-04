package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.common.Constants;
import com.example.demo.entity.Template;
import com.example.demo.form.TemplateForm;
import com.example.demo.repository.TemplateRepository;

/**
 * テンプレート関連のビジネスロジックを担当するサービスクラスです。
 * テンプレートの検索、保存、更新などの機能を提供します。
 */
@Service
public class TemplateServiceImpl implements TemplateService{

	@Autowired
	TemplateRepository templateRepository;
	
	/**
	 * テンプレート一覧を取得するメソッドです。
	 *
	 * @return List<Task> テンプレート一覧。
	 */
	@Override
	public List<Template> findAll() {
		return templateRepository.findAll();
		}

	@Override
	public List<Template> sort1() {
		return templateRepository.sort1();
		}

	@Override
	public List<Template> sort2() {
		return templateRepository.sort2();
		}

	@Override
	public List<Template> sort3() {
		return templateRepository.sort3();
		}
	
	
	/**
	 * テンプレートを保存するメソッドです。
	 *
	 * @param template テンプレートエンティティ
	 * @return String 完了メッセージ
	 * @throws OptimisticLockingFailureException 楽観ロックエラーが発生した場合
	 */
	@Override
	@Transactional
	public String save(TemplateForm templateForm) {
		
		//変換処理
		Template template = convertToTemplate(templateForm);
		
		//完了メッセージを宣言
		String completeMessage = null;
		
		if(template.getId() != 0) {
			//変更処理の場合
			
			//楽観ロック
			int updateCount =templateRepository.update(template);
			if (updateCount == 0) {
				throw new OptimisticLockingFailureException("楽観ロックエラー");
			}
			//完了メッセージをセット
			completeMessage = Constants.EDIT_COMPLETE;
			return completeMessage;
			
		}else {
			//登録処理の場合
			templateRepository.save(template);
			//完了メッセージをセット
			completeMessage = Constants.REGISTER_COMPLETE;
			return completeMessage;
		}
	}
	
	/**
	 * テンプレートIDに基づいて1件のテンプレートを取得し、対応するテンプレートフォームに変換するメソッドです。
	 *
	 * @param templateId テンプレートID
	 * @return 対応するテンプレートフォーム
	 */
	@Override
	public TemplateForm getTemplate(int id) {
		
		//テンプレートを取得
		Template template =templateRepository.getTemplate(id);
		
		//変換処理
		TemplateForm templateForm =convertToTemplateForm(template);
		
		return templateForm;
	}
	
	/**
	 * テンプレートを削除するメソッドです。
	 *
	 * @param template テンプレートエンティティ
	 * @return String 完了メッセージ
	 * @throws OptimisticLockingFailureException 楽観ロックエラーが発生した場合
	 */
	@Override
	@Transactional
	public String delete(int id) {
		
        
        //削除処理
      	templateRepository.delete(id);
		
		//完了メッセージをセット
		String completeMessage = Constants.DELETE_COMPLETE;
		return completeMessage;
		
	}
	
	
	
	/**
	 * テンプレートフォームをテンプレートエンティティに変換するメソッドです。
	 *
	 * @param templateForm テンプレートフォーム
	 * @return 変換されたテンプレートエンティティ
	 */
	@Override
	public Template convertToTemplate(TemplateForm templateForm) {
	    Template template = new Template();
	    template.setId(templateForm.getId());
	    template.setTypeId(templateForm.getTypeId());
	    template.setTemplate(templateForm.getTemplate());
	    template.setCreatedAt(templateForm.getCreatedAt());
	    template.setUpdatedAt(templateForm.getUpdatedAt());
	    return template;
	    }
	
	/**
	 * テンプレートエンティティをテンプレートフォームに変換するメソッドです。
	 *
	 * @param template テンプレートエンティティ
	 * @return 変換されたテンプレートフォーム
	 */
	@Override
	public TemplateForm convertToTemplateForm(Template template) {
		
	    TemplateForm templateForm = new TemplateForm();
	    templateForm.setId(template.getId());
	    templateForm.setTypeId(template.getTypeId());
	    templateForm.setTemplate(template.getTemplate());
	    templateForm.setCreatedAt(template.getCreatedAt());
	    templateForm.setUpdatedAt(template.getUpdatedAt());
	    return templateForm;
	    }
	
}
