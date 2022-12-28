package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.model.Owner;
import guru.springframework.spring5webapp.repositories.OwnerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OwnerController {

    private OwnerRepository ownerRepo;

    public OwnerController(OwnerRepository ownerRepo) {
        this.ownerRepo = ownerRepo;
    }

    @RequestMapping("/getOwners")
    public String getOwners(Model model){
        Iterable<Owner> owners = ownerRepo.findAll();
        model.addAttribute("owners", owners);

        System.out.println("Reached getOwners");

        return "owners/list";
    }
}
