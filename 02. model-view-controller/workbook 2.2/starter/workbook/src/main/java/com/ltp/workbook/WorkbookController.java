package com.ltp.workbook;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WorkbookController {
    
    @GetMapping("/")
    public String getShows(Model model) {
        ArrayList<Show> shows = new ArrayList<Show>(){
            {
                add(new Show("Breaking Bad", "Ozymandias", 10.0));
                add(new Show("Attack on Titan", "Hero", 9.9));
                add(new Show("Attack on Titan", "Perfect Game", 9.9));
                add(new Show("Star Wars: The Clone Wars", "Victory and Death", 9.9));
                add(new Show("Mr. Robot", "407 Proxy Authentication Required", 9.9));
            }
        };
        model.addAttribute("shows", shows);
        return "shows";
    }

}
