package br.com.jproject.feedbackcampus.mapper;

import br.com.jproject.feedbackcampus.dto.AlunoDTO;
import br.com.jproject.feedbackcampus.entitys.Aluno;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface AlunoMapperDTO {

    AlunoDTO alunoToAlunoDTO(Aluno entity);
    Aluno alunoDTOToAluno(AlunoDTO entity);
}
