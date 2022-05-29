package com.example.application.config;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

import net.rakugakibox.util.YamlResourceBundle;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "spring.messages")
public class MessagesProperty {

	private String basename;
	private String encoding;
	private int cacheDuration;
	private boolean alwaysUseMessageFormat;
	private boolean useCodeAsDefaultMessage;
	private boolean fallbackToSystemLocale;

	@Bean
	public MessageSource messageSource() {
		YamlMessageSource messageSource = new YamlMessageSource();
		messageSource.setBasename(this.basename);
		messageSource.setDefaultEncoding(this.encoding);
		messageSource.setCacheSeconds(this.cacheDuration);
		messageSource.setAlwaysUseMessageFormat(this.alwaysUseMessageFormat);
		messageSource.setUseCodeAsDefaultMessage(this.useCodeAsDefaultMessage);
		messageSource.setFallbackToSystemLocale(this.fallbackToSystemLocale);
		return messageSource;
	}

	private static class YamlMessageSource extends ResourceBundleMessageSource {
		@Override
		protected ResourceBundle doGetBundle(String basename, Locale locale) throws MissingResourceException {
			return ResourceBundle.getBundle(basename, locale, YamlResourceBundle.Control.INSTANCE);
		}
	}
}
