package com.sehirefsaneleri.ws.error;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

@RestController
public class ErrorHandler implements ErrorController {

	@Autowired
	private ErrorAttributes errorAttributes;

	@RequestMapping("/error")
	ApiError handleError(WebRequest webRequest) {
		
		Map<String, Object> attribute = this.errorAttributes.getErrorAttributes(webRequest, true);

		String message = (String) attribute.get("message");
		String path = (String) attribute.get("path");
		int status = (Integer) attribute.get("status");
		ApiError error = new ApiError(status, message, path);
		if (attribute.containsKey("errors")) {
			@SuppressWarnings("unchecked") // görmezden gel warning'i
			List<FieldError> fieldErrors = (List<FieldError>) attribute.get("errors");
			Map<String, String> validationerrors = new HashMap<>();
			for (FieldError fielderror : fieldErrors) {
				validationerrors.put(fielderror.getField(), fielderror.getDefaultMessage());
				error.setValidationErros(validationerrors);
			}
		}

		return error;
	}

	@Override
	public String getErrorPath() {

		return "/error";
	}

}
