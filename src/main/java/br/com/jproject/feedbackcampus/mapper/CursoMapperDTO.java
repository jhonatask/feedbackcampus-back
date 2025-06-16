package br.com.jproject.feedbackcampus.mapper;

import br.com.jproject.feedbackcampus.dto.request.CursorRequestDTO;
import br.com.jproject.feedbackcampus.dto.response.CursorResponseDTO;
import br.com.jproject.feedbackcampus.entitys.Curso;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface CursoMapperDTO {
    CursorResponseDTO cursoToCursoDTO(Curso entity);
    Curso cursoDTOToCurso(CursorRequestDTO entity);

}
