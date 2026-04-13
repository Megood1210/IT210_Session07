package com.bai4.session7_bai4.controller;

import com.bai4.session7_bai4.model.Food;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/food")
public class FoodController {
    private static final List<Food> foodList = new ArrayList<>();
    private static int idCounter = 1;

    @GetMapping("/add")
    public String showForm(Model model) {
        model.addAttribute("categories",
                Arrays.asList("Khai vị", "Món chính", "Đồ uống", "Tráng miệng"));
        return "food-add";
    }

    @PostMapping("/add")
    public String addFood(
            @RequestParam("name") String name,
            @RequestParam("category") String category,
            @RequestParam("price") double price,
            @RequestParam("image") MultipartFile file,
            RedirectAttributes redirectAttributes
    ) {

        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("error", "Chưa chọn ảnh");
            return "redirect:/food/add";
        }

        if (price < 0) {
            redirectAttributes.addFlashAttribute("error", "Giá phải >= 0");
            return "redirect:/food/add";
        }

        try {
            String uploadDir = "C:/RikkeiFood_Temp/";
            File dir = new File(uploadDir);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            String originalName = file.getOriginalFilename();
            if (originalName == null) {
                redirectAttributes.addFlashAttribute("error", "Tên file không hợp lệ");
                return "redirect:/food/add";
            }

            String lowerName = originalName.toLowerCase();
            if (!(lowerName.endsWith(".jpg") || lowerName.endsWith(".png") || lowerName.endsWith(".jpeg"))) {
                redirectAttributes.addFlashAttribute("error", "Chỉ chấp nhận JPG, PNG, JPEG");
                return "redirect:/food/add";
            }

            String uniqueName = System.currentTimeMillis() + "_" + originalName;

            String path = uploadDir + uniqueName;

            file.transferTo(new File(path));

            Food food = new Food(idCounter++, name, category, price, path);
            foodList.add(food);

            redirectAttributes.addFlashAttribute("message", "Thêm món thành công");

            return "redirect:/food/detail?id=" + food.getId();

        } catch (Exception e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("error", "Lỗi upload file");
            return "redirect:/food/add";
        }
    }


    @GetMapping("/detail")
    public String showDetail(@RequestParam("id") int id, Model model) {

        for (Food f : foodList) {
            if (f.getId() == id) {
                model.addAttribute("food", f);
                return "food-detail";
            }
        }

        model.addAttribute("error", "Không tìm thấy món ăn");
        return "food-detail";
    }
}