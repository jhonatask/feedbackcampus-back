package br.com.jproject.feedbackcampus.mapper;


import br.com.jproject.feedbackcampus.dto.FeedbackDTO;
import br.com.jproject.feedbackcampus.entitys.Feedback;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface FeedbackMapperDTO {

    FeedbackDTO feedBackToFeedBackDTO(Feedback entity);
    Feedback feedBackDTOToFeedBack(FeedbackDTO entity);

}
