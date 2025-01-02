package org.example.random.controllers;

import org.example.random.service.DiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RndController {
    @Autowired
    private DiceService service;

    /**
     * Read amounts of each type of dices from URI. If any type of dice didn't specify,
     * this dice will not be added to repo. User can roll any amount of any dice types.
     * @param d4
     * @param d6
     * @param d8
     * @param d10
     * @param d12
     * @param d20
     * @param model
     * @return
     * List of random values of each dice in repo and summary roll.
     */
    @GetMapping("/random")
    public String random(@Nullable @RequestParam(value = "d4", required = false) Integer d4,
                         @Nullable @RequestParam(value = "d6", required = false) Integer d6,
                         @Nullable @RequestParam(value = "d8", required = false) Integer d8,
                         @Nullable @RequestParam(value = "d10", required = false) Integer d10,
                         @Nullable @RequestParam(value = "d12", required = false) Integer d12,
                         @Nullable @RequestParam(value = "d20", required = false) Integer d20,
                         Model model){


        d4 = (d4 == null) ? 0 : d4;
        d6 = (d6 == null) ? 0 : d6;
        d8 = (d8 == null) ? 0 : d8;
        d10 = (d10 == null) ? 0 : d10;
        d12 = (d12 == null) ? 0 : d12;
        d20 = (d20 == null) ? 0 : d20;
        service.getDiceList().clear();
        service.addCube(d4, d6, d8, d10, d12, d20);
        model.addAttribute("rnd", service.getDiceList().getDicesRolls());
        model.addAttribute("sum", service.getDiceList().getSum());
        return "random";
    }
}
