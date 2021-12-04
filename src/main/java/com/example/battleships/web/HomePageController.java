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
@RequestMapping("/")
@AllArgsConstructor
@Getter

public class HomePageController {
    private final Game game;


    @GetMapping("/")
    public ModelAndView displayGamePage() {
        if (game.getGamePlay() == null) {
            game.startNewGame();
        }
        ModelAndView maw = new ModelAndView("home");
        maw.addObject("game", game);
        return maw;
    }

    @PutMapping("/hit")
    public ModelAndView checkHit(@RequestParam(name = "row") Integer row, @RequestParam(name = "column") Integer column) {
        ModelAndView maw = new ModelAndView("home");
        maw.addObject("game", game);
        game.checkHit(row, column);
        return maw;
    }

    @GetMapping("/end")
    public String displayGameEndPage() {
        return "gameOver";
    }

    @PutMapping("/new")
        public ModelAndView loadNewGame () {
        ModelAndView maw = new ModelAndView("gameOver");
        maw.addObject("game", game);
        game.startNewGame();
        return maw;
        }
    }


