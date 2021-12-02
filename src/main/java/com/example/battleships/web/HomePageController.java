package com.example.battleships.web;

import com.example.battleships.model.Game;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping ("/")
@AllArgsConstructor
@Getter

public class HomePageController {
    private final Game game;


//    @GetMapping("/")
//    public String displayHomePage() {
////        ModelAndView mav = new ModelAndView("home");
//        if (game.getGamePlay() == null) {
//            game.startNewGame();
//        }
//        return "home";
//    }

    @GetMapping("/")
    public ModelAndView displayAreaStatus () {
        if (game.getGamePlay() == null) {
            game.startNewGame();
        }
        ModelAndView maw = new ModelAndView("home");
        maw.addObject("game", game);
        return maw;
    }

//    @PostMapping("/")
//    public String getAreaValue(@RequestParam int x, @RequestParam int y) {
//        return game.getAreaValue(x,y);
//    }

    @PostMapping ("/")
    public boolean checkHit(int x, int y) {
        return game.isShipHitted(x, y);
    }
}
