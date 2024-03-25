package br.com.jproject.feedbackcampus.mapper;

import br.com.jproject.feedbackcampus.dto.CursoDTO;
import br.com.jproject.feedbackcampus.entitys.Curso;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface CursoMapperDTO {
    CursoDTO cursoToCursoDTO(Curso entity);
    Curso cursoDTOToCurso(CursoDTO entity);

}
