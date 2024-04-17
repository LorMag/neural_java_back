package ssau.project.neural_back.mappers;

import ssau.project.neural_back.dto.PredictedLungDto;
import ssau.project.neural_back.net_objects.ImageResponse;

public class ResponseMapper {

    public static PredictedLungDto mapToDto(ImageResponse imageResponse){
        PredictedLungDto predictedLungDto = new PredictedLungDto();
        predictedLungDto.setPredictedMasks(imageResponse.getPredictedMasks());
        return predictedLungDto;
    }


}
