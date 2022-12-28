package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.model.Home;
import guru.springframework.spring5webapp.repositories.HomeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class HomeController {

    private HomeRepository homeRepo;

    public HomeController(HomeRepository homeRepo) {
        this.homeRepo = homeRepo;
    }

    @RequestMapping("/getHomes")
    public String getHomes(Model model){
        Iterable<Home> homes = homeRepo.findAll();
        model.addAttribute("homes", homes);

        System.out.println("Reached getHomes");

        return "homes/list";
    }
}
