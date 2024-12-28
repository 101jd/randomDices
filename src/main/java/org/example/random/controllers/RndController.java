package org.example.random.controllers;

import org.example.random.model.cubes.*;
import org.example.random.service.CubeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.support.NullValue;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.lang.model.type.NullType;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Controller
public class RndController {
    @Autowired
    private CubeService service;
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
        service.getCubeList().clear();
        service.addCube(d4, d6, d8, d10, d12, d20);
        model.addAttribute("rnd", service.getCubeList().getCubes());
        model.addAttribute("sum", service.getCubeList().getCubes().stream().mapToInt(i -> i).sum());
        return "random";
    }
}
