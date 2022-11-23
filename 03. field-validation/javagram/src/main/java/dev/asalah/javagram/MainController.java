package dev.asalah.javagram;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String getForm(Model model){
        model.addAttribute("user", new User());
        return "sign-up";
    }

    @GetMapping("/result")
    public String getResult(){
        return "result";
    }

    @PostMapping("/submitUser")
    public String handleSubmitUser(@Valid User user, BindingResult bindingResult){
        if(user.getFirstName().equalsIgnoreCase(user.getLastName())){
            bindingResult.rejectValue("lastName", "", "Last Name cannot be the same as First Name");
        }
        if(bindingResult.hasErrors()){
            return "sign-up";
        }
        return "result";
    }
}
