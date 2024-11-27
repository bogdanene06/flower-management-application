/*
Author: Ene Bogdan
Country: Romania
*/
package exercitii._3._2._IntroToThymeleaf.controller;

import exercitii._3._2._IntroToThymeleaf.entity.Flower;
import exercitii._3._2._IntroToThymeleaf.repository.FlowerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "index/")
@RequiredArgsConstructor
public class FlowerController {

    private final FlowerRepository flowerRepository;

    @GetMapping(value = "/add-flower")
    public String addFlower(Model model) {
        Flower flower = new Flower();
        model.addAttribute("flower", flower);
        return "add-flower";
    }

    @PostMapping(value = "/add-flower")
    public String getAllFlowers(@ModelAttribute(value = "flower") Flower flower) {
        flowerRepository.save(flower);
        return "redirect:/index";
    }

    @RequestMapping(value = "/flower/delete/{id}")
    public String deleteFlower(@PathVariable Integer id) {
        flowerRepository.deleteById(id);
        return "redirect:/index";
    }

    @RequestMapping(value = "/edit-flower/{id}")
    public String editFlower(@PathVariable Integer id, Model model) {
        model.addAttribute("flowerToBeEdited", flowerRepository.findById(id));
        return "edit-flower";
    }

    @RequestMapping("/edit-flower")
    public String editAndSaveEditedFlower(@ModelAttribute(value = "flower") Flower flower) {
        flowerRepository.save(flower);
        return "redirect:/index";

    }


}
