package com.thymeleaf.mercury;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
@Slf4j
public class HomeController {
    @GetMapping("/message")
    public String getMessage(Model model) {
        var user = User.builder().name("홍길동").phone("010-1111-1111").address("서울시 강남구 대치동").build();
        model.addAttribute("customer", user);
        model.addAttribute("messageKey", "home.welcome.two");
        return "message";
    }

    @GetMapping("/expression")
    public String getExpression(Model model) {

        // put String
        model.addAttribute("name", "홍길동");
        model.addAttribute("address", "서울시 강남구");

        // put Object
        var user = User.builder().name("홍길동").phone("010-1111-1111").address("서울시 강남구 대치동").build();
        model.addAttribute("member", user);

        // put today
        SimpleDateFormat format = new SimpleDateFormat("yyyy년 MM월 dd일");
        Date date = Calendar.getInstance().getTime();
        model.addAttribute("today", format.format(date));
        model.addAttribute("date", date);

        // put List
        var users = List.of(User.builder().name("홍길순").phone("010-1111-1111").address("서울시 영등포").build(),
                User.builder().name("홍길철").phone("010-1111-1111").address("서울시 영등포").build(),
                User.builder().name("홍길동").phone("010-1111-1111").address("서울시 영등포").build());
        model.addAttribute("customers", users);

        model.addAttribute("productPrice", 345620.5226);
        model.addAttribute("productCount", 3502340);

        // put boolean
        model.addAttribute("showHelloOne", true);
        model.addAttribute("showHelloTwo", false);

        // set any attribute
        model.addAttribute("productButton", "제품수정");

        // for switch statements
        model.addAttribute("role", "admin role");

        return "expression";
    }

    @GetMapping("/product/list")
    public String getProductList(Integer id, String category, Model model) {
        model.addAttribute("id", id);
        model.addAttribute("category", category);
        return "product";
    }

    @GetMapping("/product/{category}/list")
    public String getProductCategoryList(Integer id, @PathVariable String category, Model model) {
        model.addAttribute("id", id);
        model.addAttribute("category", category);
        return "product";
    }

    // fragment, base-fragment
    @GetMapping("/fragment")
    public String getFragment() {
        return "fragment";
    }

    // flexible, base-flexible
    // https://css.gg/
    @GetMapping("/flexible")
    public String getFlexible(Model model) {
        // put List
        var users = List.of(User.builder().name("홍길순").phone("010-1111-1111").address("서울시 영등포").build(),
                User.builder().name("홍길철").phone("010-1111-1111").address("서울시 영등포").build(),
                User.builder().name("홍길동").phone("010-1111-1111").address("서울시 영등포").build());
        model.addAttribute("customers", users);
        return "flexible";
    }
}
