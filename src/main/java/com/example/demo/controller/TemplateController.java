package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.Template;
import com.example.demo.form.TemplateForm;
import com.example.demo.service.TemplateService;


/**
 * Webアプリケーションのテンプレート関連機能を担当するControllerクラスです。
 * テンプレートの一覧表示、登録、変更などの機能が含まれています。
 *
 */
@Controller
public class TemplateController {

    private final TemplateService templateService;

    public TemplateController(TemplateService templateService) {
        this.templateService = templateService;
    }

    /**
     * テンプレートの一覧を表示するメソッドです。
     * 
     * @param model テンプレート一覧をViewに渡すためのSpringのModelオブジェクト
     * @return "template/index" - テンプレート一覧表示用のHTMLテンプレートのパス
     */
	@RequestMapping(value = "/template/list", method = RequestMethod.GET)
	public String getTemplateList(Model model) {
		
		//テンプレートの一覧を取得
		List<Template> templateList = templateService.findAll();		
		model.addAttribute("templateList", templateList);
		
		return "template/index";
	}

	/**
	 * 種別「受注時」のみを表示するメソッド
	 * 
	 * @param model テンプレート一覧をViewに渡すためのSpringのModelオブジェクト
     * @return "template/index" - テンプレート一覧表示用のHTMLテンプレートのパス
     */
	@RequestMapping(value = "/template/contract", method = RequestMethod.GET)
	public String getContractTemplates(Model model) {
		
		//テンプレートの一覧を取得
		List<Template> templateList = templateService.contract();		
		model.addAttribute("templateList", templateList);
		
		return "template/index";
	}

	/**
	 * 種別「契約後」のみを表示するメソッド
	 * 
	 * @param model テンプレート一覧をViewに渡すためのSpringのModelオブジェクト
     * @return "template/index" - テンプレート一覧表示用のHTMLテンプレートのパス
     */
	@RequestMapping(value = "/template/afterContract", method = RequestMethod.GET)
	public String getAfetrContractTemplates(Model model) {
		
		//テンプレートの一覧を取得
		List<Template> templateList = templateService.afterContract();		
		model.addAttribute("templateList", templateList);
		
		return "template/index";
	}

	/**
	 * 種別「その他」のみを表示するメソッド
	 * 
	 * @param model テンプレート一覧をViewに渡すためのSpringのModelオブジェクト
     * @return "template/index" - テンプレート一覧表示用のHTMLテンプレートのパス
     */
	@RequestMapping(value = "/template/others", method = RequestMethod.GET)
	public String getOthers(Model model) {
		
		//テンプレートの一覧を取得
		List<Template> templateList = templateService.others();		
		model.addAttribute("templateList", templateList);
		
		return "template/index";
	}
	
	/**
	 * テンプレートの新規登録画面を表示するメソッドです。
	 * 
	 * @param model テンプレート一覧をViewに渡すためのSpringのModelオブジェクト
	 * @return "template/edit" - テンプレート新規登録画面のHTMLテンプレートのパス
	 */
	@GetMapping(value = "/template/add")
	public String newAddForm(Model model) {
	    // テンプレートフォームを作成
	    TemplateForm templateForm = new TemplateForm();
	    
	    model.addAttribute("templateForm", templateForm);
	    return "template/edit";
	}
	
	/**
	 * テンプレートの変更画面を表示するメソッドです。
	 * 
	 * @param templateId テンプレートのID
	 * @param model テンプレート一覧をViewに渡すためのSpringのModelオブジェクト
	 * @return "template/edit" - テンプレート変更画面のHTMLテンプレートのパス
	 */
	@GetMapping(value = "/template/edit")
	public String getEditForm(@RequestParam("id") int id,Model model) {
		
	    // テンプレートIDに基づいてテンプレートを取得
		TemplateForm templateForm = templateService.getTemplate(id);
		
		model.addAttribute("templateForm", templateForm);
		return "template/edit";
	}
	
	
	/**
	 * テンプレートの確認画面を表示するメソッドです。
	 * 
	 * @param templateForm テンプレートのフォームデータ
	 * @param bindingResult バリデーション結果を保持するオブジェクト
	 * @param model テンプレート一覧をViewに渡すためのSpringのModelオブジェクト
	 * @return "template/confirm" - テンプレート確認画面のHTMLテンプレートのパス
	 */
	@GetMapping(value = "/template/confirm")
	public String showConfirmForm(@Validated TemplateForm templateForm, BindingResult bindingResult, Model model) {
		
		// バリデーションチェックでエラーがある場合は変更画面に戻る
		if (bindingResult.hasErrors()) {
			return "template/edit";
		}
		
		model.addAttribute("templateForm", templateForm);
		return "template/confirm";
	}
	
	@GetMapping(value = "/template/copyForm")
	public String getCopyForm(@RequestParam("id") int id,Model model) {
		
	    // テンプレートIDに基づいてテンプレートを取得
		TemplateForm templateForm = templateService.getTemplate(id);
		
		model.addAttribute("templateForm", templateForm);
		return "template/copyForm";
	}
	/**
	 * テンプレートを保存するメソッドです。
	 * 
	 * @param templateForm テンプレートのフォームデータ
	 * @param bindingResult バリデーション結果を保持するオブジェクト
	 * @param redirectAttributes リダイレクト時に属性を渡すためのSpringのRedirectAttributesオブジェクト
	 * @param model テンプレート一覧をViewに渡すためのSpringのModelオブジェクト
	 * @return "redirect:/template/complete" - テンプレート確認画面へのリダイレクト
	 */
	@PostMapping(value = "/template/save")
	public String saveTemplate(@Validated TemplateForm templateForm, BindingResult bindingResult, RedirectAttributes redirectAttributes,Model model) {
		
		//バリデーションチェック
		if (bindingResult.hasErrors()) {
			// バリデーションエラーがある場合は変更画面に遷移
			return "template/edit";
		}
		
		//保存処理
		String completeMessage =templateService.save(templateForm);
		
		//redirect先に値を渡す
		redirectAttributes.addFlashAttribute("completeMessage", completeMessage);
		
		return "redirect:/template/complete";
	}
	
	/**
	 * テンプレート完了画面を表示するメソッドです。
	 * 
	 * @return "template/complete" - テンプレート完了画面のHTMLテンプレートのパス
	 */
    @GetMapping("/template/complete")
    public String getCompletePage() {
        return "template/complete";
    }
    
	/**
	 * テンプレートの削除確認画面を表示するメソッドです。
	 * 
	 * @param templateForm テンプレートのフォームデータ
	 * @param model テンプレート一覧をViewに渡すためのSpringのModelオブジェクト
	 * @return "template/confirm" - テンプレート確認画面のHTMLテンプレートのパス
	 */
	@GetMapping(value = "/template/delete")
	public String getDeleteForm(@RequestParam("id") int id, Model model) {
		
	    // テンプレートIDに基づいてテンプレートを取得
		TemplateForm templateForm = templateService.getTemplate(id);
				
		model.addAttribute("templateForm", templateForm);
		return "template/deleteConfirm";
	}
	
	/**
	 * テンプレートを削除するメソッドです。
	 * 
	 * @param templateForm テンプレートのフォームデータ
	 * @param bindingResult バリデーション結果を保持するオブジェクト
	 * @param redirectAttributes リダイレクト時に属性を渡すためのSpringのRedirectAttributesオブジェクト
	 * @param model テンプレート一覧をViewに渡すためのSpringのModelオブジェクト
	 * @return "redirect:/template/complete" - テンプレート確認画面へのリダイレクト
	 */
	@PostMapping(value = "/template/delete")
	public String deleteTemplate(@RequestParam("id") int id, RedirectAttributes redirectAttributes,Model model) {
		
		//保存処理
		String completeMessage =templateService.delete(id);
		
		//redirect先に値を渡す
		redirectAttributes.addFlashAttribute("completeMessage", completeMessage);
		
		return "redirect:/template/complete";
	}
	
    /**
     * テンプレートの確認画面から変更画面に戻るメソッドです。
     * 
     * @param templateForm テンプレートのフォームデータ
     * @param model テンプレート一覧をViewに渡すためのSpringのModelオブジェクト
     * @return "templa/edit" - テンプレート変更画面のHTMLテンプレートのパス
     */
    @GetMapping("/template/back")
    public String backToEditPage(TemplateForm templateForm,Model model) {
    	model.addAttribute("templateForm", templateForm);
    	return "template/edit";
    }
	
}
