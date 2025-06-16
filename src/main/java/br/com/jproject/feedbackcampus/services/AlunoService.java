package br.com.jproject.feedbackcampus.services;

import br.com.jproject.feedbackcampus.dto.AlunoDTO;
import br.com.jproject.feedbackcampus.entitys.Aluno;
import br.com.jproject.feedbackcampus.entitys.Curso;
import br.com.jproject.feedbackcampus.repositorys.AlunoRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public Optional<Aluno> findAluno(String id){
        return alunoRepository.findById(id);
    }

    public Aluno createAluno(AlunoDTO alunoDTO, Curso curso){
        Aluno aluno = new Aluno();
        aluno.setCurso(curso);
        aluno.setNomeAluno(alunoDTO.getNomeAluno());
        aluno.setMatricula(alunoDTO.getMatricula());
        aluno.setTelefone(alunoDTO.getTelefone());
        alunoRepository.save(aluno);
        return aluno;
    }
}
