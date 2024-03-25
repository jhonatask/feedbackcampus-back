package br.com.jproject.feedbackcampus.services;

import br.com.jproject.feedbackcampus.core.exceptions.CursoNotFoundException;
import br.com.jproject.feedbackcampus.dto.FeedbackDTO;
import br.com.jproject.feedbackcampus.dto.request.DataFeedBackDTO;
import br.com.jproject.feedbackcampus.entitys.Aluno;
import br.com.jproject.feedbackcampus.entitys.Curso;
import br.com.jproject.feedbackcampus.entitys.Feedback;
import br.com.jproject.feedbackcampus.mapper.FeedbackMapperDTO;
import br.com.jproject.feedbackcampus.repositorys.AlunoRepository;
import br.com.jproject.feedbackcampus.repositorys.FeedbackRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService {

    private final FeedbackRepository feedbackRepository;
    private final FeedbackMapperDTO feedbackMapperDTO;

    private final CursoService cursoService;
    private final AlunoRepository alunoRepository;

    public FeedbackService(FeedbackRepository feedbackRepository, FeedbackMapperDTO feedbackMapperDTO, CursoService cursoService, AlunoRepository alunoRepository) {
        this.feedbackRepository = feedbackRepository;
        this.feedbackMapperDTO = feedbackMapperDTO;
        this.cursoService = cursoService;
        this.alunoRepository = alunoRepository;
    }

    public FeedbackDTO create(DataFeedBackDTO dataFeedBackDTO) {
        Curso curso = cursoService.findCurso(dataFeedBackDTO.getCursoId()).orElseThrow(CursoNotFoundException::new);
        Feedback feedback = new Feedback();
        feedback.setCurso(curso);
        criarAlunoIdentificado(dataFeedBackDTO, curso, feedback);
        feedback.setCritica(dataFeedBackDTO.getCritica());
        feedback.setDuvida(dataFeedBackDTO.getDuvida());
        feedback.setSugestao(dataFeedBackDTO.getSugestao());
        feedback.setFeedBackPositivo(dataFeedBackDTO.getFeedBackPositivo());
        feedbackRepository.save(feedback);
        return feedbackMapperDTO.feedBackToFeedBackDTO(feedback);
    }

    private void criarAlunoIdentificado(DataFeedBackDTO dataFeedBackDTO, Curso curso, Feedback feedback) {
        if(!dataFeedBackDTO.isIdentificado()){
           feedback.setAluno(null);
           return;
        }
        Aluno aluno = new Aluno();
        aluno.setCurso(curso);
        aluno.setNomeAluno(dataFeedBackDTO.getAluno().getNomeAluno());
        aluno.setMatricula(dataFeedBackDTO.getAluno().getMatricula());
        aluno.setTelefone(dataFeedBackDTO.getAluno().getTelefone());
        alunoRepository.save(aluno);
        feedback.setAluno(aluno);
    }

    public List<FeedbackDTO> findFeedbackCursoId(String cursoId) {
        Curso curso = cursoService.findCurso(cursoId).orElseThrow(CursoNotFoundException::new);
        List<Feedback> feedbacks = feedbackRepository.findByCurso(curso);
        return feedbacks.stream().map(feedbackMapperDTO::feedBackToFeedBackDTO).toList();
    }
}
