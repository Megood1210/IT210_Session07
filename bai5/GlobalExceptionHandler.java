package com.book.session7.bai5;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public String handleMaxSizeException(Exception e, RedirectAttributes redirectAttributes) {
        if (e.getMessage() != null && e.getMessage().contains("exceeds maximum size")) {
            redirectAttributes.addFlashAttribute("error", "File quá lớn Dung lượng banner tối đa là 10MB.");
            return "redirect:/merchant/combo/add";
        }
        return "error";
    }
}
