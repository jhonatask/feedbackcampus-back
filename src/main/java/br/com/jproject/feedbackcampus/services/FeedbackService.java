package br.com.jproject.feedbackcampus.services;

import br.com.jproject.feedbackcampus.application.EmailSenderService;
import br.com.jproject.feedbackcampus.core.exceptions.CursoNotFoundException;
import br.com.jproject.feedbackcampus.core.exceptions.EmailServiceExcepetion;
import br.com.jproject.feedbackcampus.dto.FeedbackDTO;
import br.com.jproject.feedbackcampus.dto.request.DataFeedBackDTO;
import br.com.jproject.feedbackcampus.entitys.Aluno;
import br.com.jproject.feedbackcampus.entitys.Curso;
import br.com.jproject.feedbackcampus.entitys.Feedback;
import br.com.jproject.feedbackcampus.mapper.FeedbackMapperDTO;
import br.com.jproject.feedbackcampus.repositorys.FeedbackRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService {

    private final FeedbackRepository feedbackRepository;
    private final FeedbackMapperDTO feedbackMapperDTO;
    private final CursoService cursoService;
    private final AlunoService alunoService;

    private final EmailSenderService emailSenderService;

    public FeedbackService(FeedbackRepository feedbackRepository, FeedbackMapperDTO feedbackMapperDTO, CursoService cursoService, AlunoService alunoService, EmailSenderService emailSenderService) {
        this.feedbackRepository = feedbackRepository;
        this.feedbackMapperDTO = feedbackMapperDTO;
        this.cursoService = cursoService;
        this.alunoService = alunoService;
        this.emailSenderService = emailSenderService;
    }

    public FeedbackDTO create(DataFeedBackDTO dataFeedBackDTO) {
        Curso curso = cursoService.findCurso(dataFeedBackDTO.getCursoId()).orElseThrow(CursoNotFoundException::new);
        Feedback feedback = new Feedback();
        feedback.setCurso(curso);
        criarAlunoIdentificado(dataFeedBackDTO, curso, feedback);
        feedback.setCritica(dataFeedBackDTO.getCritica());
        feedback.setDuvida(dataFeedBackDTO.getDuvida());
        if(!dataFeedBackDTO.getDuvida().isEmpty()){
           enviarNotificacaoDuvida(dataFeedBackDTO.getDuvida(), curso);
        }
        if(!dataFeedBackDTO.getDenuncia().isEmpty()){
            enviarNotificacaoDenuncia(dataFeedBackDTO.getDenuncia(), curso);
        }
        feedback.setSugestao(dataFeedBackDTO.getSugestao());
        feedback.setFeedBackPositivo(dataFeedBackDTO.getFeedBackPositivo());
        feedbackRepository.save(feedback);
        return feedbackMapperDTO.feedBackToFeedBackDTO(feedback);
    }

    private void enviarNotificacaoDenuncia(String denuncia, Curso curso) {
        try {
            emailSenderService.sendEmail(curso.getEmail(),"Nova denuncia!", denuncia);
        } catch (Exception e) {
            throw new EmailServiceExcepetion("Error ao enviar email", e);
        }
    }

    private void enviarNotificacaoDuvida(String duvida, Curso curso) {
        try {
            emailSenderService.sendEmail(curso.getEmail(),"Nova Duvida !", duvida);
        } catch (Exception e) {
            throw new EmailServiceExcepetion("Error ao enviar email", e);
        }
    }

    private void criarAlunoIdentificado(DataFeedBackDTO dataFeedBackDTO, Curso curso, Feedback feedback) {
        if(!dataFeedBackDTO.isIdentificado()){
           feedback.setAluno(null);
           return;
        }
        Aluno aluno = alunoService.createAluno(dataFeedBackDTO.getAluno(), curso);
        feedback.setAluno(aluno);
    }

    public List<FeedbackDTO> findFeedbackCursoId(String cursoId) {
        Curso curso = cursoService.findCurso(cursoId).orElseThrow(CursoNotFoundException::new);
        List<Feedback> feedbacks = feedbackRepository.findByCurso(curso);
        return feedbacks.stream().map(feedbackMapperDTO::feedBackToFeedBackDTO).toList();
    }
}
