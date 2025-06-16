package br.com.jproject.feedbackcampus.controller;


import br.com.jproject.feedbackcampus.dto.request.CursorRequestDTO;
import br.com.jproject.feedbackcampus.dto.response.CursorResponseDTO;
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
    public ResponseEntity<CursorResponseDTO> createCurso(@RequestBody CursorRequestDTO cursorRequestDTO){
        CursorResponseDTO curso = cursoService.create(cursorRequestDTO);
        return ResponseEntity.ok().body(curso);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<CursorResponseDTO>> findCursos(){
        List<CursorResponseDTO> cursos = cursoService.findAll();
        return ResponseEntity.ok().body(cursos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CursorResponseDTO> updateCurso(@PathVariable String id, @RequestBody CursorResponseDTO cursoData){
        CursorResponseDTO curso = cursoService.updateCurso(id, cursoData);
        return ResponseEntity.ok().body(curso);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCurso(@PathVariable String id){
        cursoService.deleteCurso(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}
