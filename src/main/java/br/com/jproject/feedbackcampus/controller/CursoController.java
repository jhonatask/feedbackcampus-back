package br.com.jproject.feedbackcampus.controller;


import br.com.jproject.feedbackcampus.dto.CursoDTO;
import br.com.jproject.feedbackcampus.services.CursoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/curso")
public class CursoController {

    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @PostMapping
    public ResponseEntity<CursoDTO> createCurso(@RequestBody CursoDTO cursoData){
        CursoDTO category = cursoService.create(cursoData);
        return ResponseEntity.ok().body(category);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<CursoDTO>> findCursos(){
        List<CursoDTO> cursos = cursoService.findAll();
        return ResponseEntity.ok().body(cursos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CursoDTO> updateCurso(@PathVariable String id, @RequestBody CursoDTO cursoData){
        CursoDTO curso = cursoService.updateCurso(id, cursoData);
        return ResponseEntity.ok().body(curso);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCurso(@PathVariable String id){
        cursoService.deleteCurso(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
