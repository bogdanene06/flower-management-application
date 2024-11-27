package exercitii._3._2._IntroToThymeleaf.controller;

import exercitii._3._2._IntroToThymeleaf.entity.Flower;
import exercitii._3._2._IntroToThymeleaf.repository.FlowerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping({"/index", "/", ""})
@RequiredArgsConstructor
public class IndexController {

    private final FlowerRepository flowerRepository;

    @GetMapping
    public String getIndex(Model model, String keyword,
                           @RequestParam(defaultValue = "1") int page,
                           @RequestParam(defaultValue = "10") int size,
                           @RequestParam(defaultValue = "id,asc") String[] sort) {

        String sortField = sort[0];
        String sortDirection = sort[1];

        Sort.Direction direction = sortDirection.equals("desc") ? Sort.Direction.DESC : Sort.Direction.ASC;
        Sort.Order order = new Sort.Order(direction, sortField);

        Pageable pageable = PageRequest.of(page - 1, size, Sort.by(order));

        Page<Flower> pageFlowers;
        if (keyword == null) {
            pageFlowers = flowerRepository.findAll(pageable);
        } else {
            pageFlowers = flowerRepository.findFlowerByKeyword(keyword, pageable);
        }

        model.addAttribute("flowers", pageFlowers.getContent());
        model.addAttribute("currentPage", pageFlowers.getNumber() + 1);
        model.addAttribute("totalItems", pageFlowers.getTotalElements());
        model.addAttribute("totalPages", pageFlowers.getTotalPages());
        model.addAttribute("pageSize", size);
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDirection", sortDirection);
        model.addAttribute("reverseSortDirection", sortDirection.equals("asc") ? "desc" : "asc");
        model.addAttribute("keyword", keyword);
        return "index";
    }

}
