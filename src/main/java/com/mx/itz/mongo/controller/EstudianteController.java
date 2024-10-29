package com.mx.itz.mongo.controller;

import com.mx.itz.mongo.dto.EstudianteDTO;
import com.mx.itz.mongo.entity.Estudiante;
import com.mx.itz.mongo.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Map;

@Controller
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    @GetMapping
    public String getAllEstudiantes(Model model) {
        List<Map> estudiantesPorCarrera = estudianteService.getEstudiantesAgrupadosPorCarrera();
        List<Estudiante> estudiantes = estudianteService.getAllEstudiantes();

        model.addAttribute("estudiantesPorCarrera", estudiantesPorCarrera);
        model.addAttribute("estudiantes", estudiantes);

        return "index";
    }

    @PostMapping("/insert")
    public String addEstudiante(@ModelAttribute EstudianteDTO estudianteDTO, Model model) {
        estudianteService.addEstudiante(estudianteDTO);
        return "redirect:/";
    }



}
