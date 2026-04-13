package com.bai3.session7_bai3.controller;

import com.bai3.session7_bai3.model.Food;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.*;

@Controller
@RequestMapping("/food")
public class FoodController {

    private static final List<Food> foodList = new ArrayList<>();
    private static int idCounter = 1;

    @GetMapping("/add")
    public String showForm(Model model) {
        model.addAttribute("categories",
                Arrays.asList("Khai vị", "Món chính", "Đồ uống", "Tráng miệng"));
        return "food-add"; // file JSP
    }

    @PostMapping("/add")
    @ResponseBody
    public String addFood(
            @RequestParam String name,
            @RequestParam String category,
            @RequestParam double price,
            @RequestParam("image") MultipartFile file
    ) {

        if (file.isEmpty()) return "Chưa chọn ảnh";

        String fileName = file.getOriginalFilename();
        if (fileName == null) return "Tên file không hợp lệ";

        fileName = fileName.toLowerCase();
        if (!(fileName.endsWith(".jpg") || fileName.endsWith(".png") || fileName.endsWith(".jpeg")))
            return "Sai định dạng file";

        if (price < 0) return "Giá không hợp lệ";

        try {
            String uploadDir = "C:/RikkeiFood_Temp/";
            File dir = new File(uploadDir);

            if (!dir.exists()) {
                dir.mkdirs();
            }

            String path = uploadDir + fileName;
            file.transferTo(new File(path));

            Food food = new Food(idCounter++, name, category, price, path);
            foodList.add(food);

            System.out.println("Đã thêm: " + name);
            System.out.println("Tổng món: " + foodList.size());

            return "OK";

        } catch (Exception e) {
            e.printStackTrace();
            return "Lỗi upload";
        }
    }
}