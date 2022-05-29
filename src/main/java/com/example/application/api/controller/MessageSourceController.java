package com.example.application.api.controller;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
public class MessageSourceController {

	private final MessageSource messageSource;

	@GetMapping("/say/hello")
	public String getMessage() {
		return getMessage("say.hello");
	}

	private String getMessage(String code) {
		return getMessage(code, null);
	}

	private String getMessage(String code, Object[] args) {
		log.info("현재 Locale 정보 : " + LocaleContextHolder.getLocale());
		return messageSource.getMessage(code, args, LocaleContextHolder.getLocale());
	}

}

