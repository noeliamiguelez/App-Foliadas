package com.foliadas.foliadas_api.Controller;

import com.foliadas.foliadas_api.DTO.FoliadaDTO;
import com.foliadas.foliadas_api.DTO.GrupoDTO;
import com.foliadas.foliadas_api.Service.FoliadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("foliadas")
public class FoliadaViewController {

    @Autowired
    private FoliadaService foliadaService;

    @GetMapping("/nuevo")
    public String nuevaFoliada(Model model){
        model.addAttribute("foliada", new FoliadaDTO());
        return "foliadas-form.html";
    }

    @PostMapping("/guardar")
    public String guardarFoliada(@ModelAttribute FoliadaDTO foliadaDTO){
        foliadaService.create(foliadaDTO);
        return "redirect:/foliadas/lista";
    }

    @GetMapping("/lista")
    public String listarFoliadas(Model model){
        model.addAttribute("foliada", foliadaService.getAll());
        return "foliadas-lista.html";
    }

    @GetMapping("/editar/{id}")
    public String editarFoliada(@PathVariable int id, Model model){
        FoliadaDTO foliada= foliadaService.getById(id);
        model.addAttribute("foliada", foliada);
        return "foliadas-form.html";
    }
}
