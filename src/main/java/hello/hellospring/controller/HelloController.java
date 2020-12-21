package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController  {

    // url/hello -> 에 mapping 되는지 확인
    @GetMapping("hello")
    public String hello(Model model){
        // Spring이 모델이라는 것을 만들어서 인자로 넘겨줌!!
        model.addAttribute("data", "hello!!!");
        // resources의 hello를 찾아 렌더링해라 == return hello
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
