package br.com.jproject.feedbackcampus.services;

import br.com.jproject.feedbackcampus.core.exceptions.CursoNotFoundException;
import br.com.jproject.feedbackcampus.dto.request.CursorRequestDTO;
import br.com.jproject.feedbackcampus.dto.response.CursorResponseDTO;
import br.com.jproject.feedbackcampus.entitys.Curso;
import br.com.jproject.feedbackcampus.mapper.CursoMapperDTO;
import br.com.jproject.feedbackcampus.repositorys.CursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    private final CursoRepository cursoRepository;
    private final CursoMapperDTO cursoMapperDTO;

    public CursoService(CursoRepository cursoRepository, CursoMapperDTO cursoMapperDTO) {
        this.cursoRepository = cursoRepository;
        this.cursoMapperDTO = cursoMapperDTO;
    }

    public CursorResponseDTO create(CursorRequestDTO cursoData) {
        Curso curso = cursoMapperDTO.cursoDTOToCurso(cursoData);
        curso.setNomeCurso(curso.getNomeCurso());
        curso.setEmail(curso.getEmail());
        cursoRepository.save(curso);
        return cursoMapperDTO.cursoToCursoDTO(curso);
    }

    public List<CursorResponseDTO> findAll() {
        List<Curso> cursos = cursoRepository.findAll();
        return cursos.stream().map(cursoMapperDTO::cursoToCursoDTO).toList();
    }

    public CursorResponseDTO updateCurso(String id, CursorResponseDTO cursoData) {
            Curso curso = cursoRepository.findById(id).orElseThrow(CursoNotFoundException::new);
            if(!cursoData.getNomeCurso().isEmpty()) curso.setNomeCurso(cursoData.getNomeCurso());
            if(!cursoData.getEmail().isEmpty()) curso.setEmail(cursoData.getEmail());
            cursoRepository.save(curso);
            return cursoMapperDTO.cursoToCursoDTO(curso);
    }

    public void deleteCurso(String id) {
        Curso curso = cursoRepository.findById(id).orElseThrow(CursoNotFoundException::new);
        cursoRepository.delete(curso);
    }

    public Optional<Curso> findCurso(String id){
        return cursoRepository.findById(id);
    }
}
