package com.book.session7.bai2;

//Phần 1
//-Việc lặp lại đoạn code model.addAttribute("categories", ...) ở cả 3 hàm GET đang vi phạm nguyên tắc lập
//trình nổi tiếng DRY
//-Nếu sau này nhà hàng mở rộng ra 20 trang giao diện đều cần danh sách "Nhóm món ăn" này, rủi ro về mặt bảo
//trì code là
//+Phải copy-paste 20 lần
//+Khi sửa (ví dụ thêm "Món chay"):
//+Dễ quên sửa ở vài chỗ
//+Gây bug không đồng nhất dữ liệu
//Controller bị phình to, khó đọc, khó bảo trì

//Phần 2
package com.restaurant.controller;

import com.restaurant.model.Dish;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/merchant/dish")
public class DishController {
    @ModelAttribute("categories")
    public List<String> getCategories() {
        return Arrays.asList("Món chính", "Đồ uống", "Tráng miệng", "Topping");
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("dish", new Dish());
        return "dish-add";
    }

    @GetMapping("/edit")
    public String showEditForm(Model model) {
        model.addAttribute("dish", new Dish("Trà sữa", "Đồ uống"));
        return "dish-edit";
    }

    @GetMapping("/search")
    public String showSearchPage() {
        return "dish-search";
    }
}