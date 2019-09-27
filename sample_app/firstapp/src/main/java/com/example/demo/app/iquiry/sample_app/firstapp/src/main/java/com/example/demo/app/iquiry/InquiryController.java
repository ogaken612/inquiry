package com.example.demo.app.iquiry;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.service.InquiryService;

import entity.Inquiry;

@Controller
@RequestMapping("/inquiry")

public class InquiryController {
	
	private final InquiryService inquiryService;
	
	@Autowired 
	public InquiryController (InquiryService inquiryService) {
		this.inquiryService = inquiryService;
	}
	
	@GetMapping
	public String index (Model model) {
		List<Inquiry> list = inquiryService.getAll();
		
		model.addAttribute("inquiryList", list);
		model.addAttribute("title", "���e�ꗗ");
		
		return "inquiry/index_boot";
	
	}
	
	@GetMapping("/form")
	public String form(InquiryForm inuiryForm ,
			Model model,
			@ModelAttribute("complete") String complete) {
		model.addAttribute("title","���e�t�H�[��");
		return "inquiry/form_boot";
	}
	@PostMapping("/form")
	public String formGoBack(InquiryForm inuiryForm , Model model) {
		model.addAttribute("title","���e�t�H�[��");
		return "inquiry/form_boot";
	}
	
	@PostMapping("/confirm")
	public String confirm(@Validated InquiryForm inquiryForm ,
			BindingResult result ,
			Model model) {
		if(result.hasErrors()) {
			model.addAttribute("title", "���e�t�H�[��");
			return "inquiry/form_boot";
		}
		model.addAttribute("title", "�m�F�y�[�W");
		return "inquiry/confirm_boot";
	}
	
	@PostMapping("/complete")
	public String complete(@Validated InquiryForm inquiryForm,
			BindingResult result,
			Model model,
			RedirectAttributes redirectAttributes) {
		if(result.hasErrors()) {
			model.addAttribute("title", "���e�t�H�[��");
			return "inquiry/form_boot";
		}
		
		Inquiry inquiry = new Inquiry();
		inquiry.setName(inquiryForm.getName());
		inquiry.setEmail(inquiryForm.getEmail());
		inquiry.setContents(inquiryForm.getContents());
		inquiry.setCreated(LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES));
		
		inquiryService.save(inquiry);
		redirectAttributes.addFlashAttribute("complete","���e���������܂���");
		return "redirect:/inquiry/form";
	}
	

}
