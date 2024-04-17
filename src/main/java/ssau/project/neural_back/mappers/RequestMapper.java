package ssau.project.neural_back.mappers;

import ssau.project.neural_back.dto.LungDto;
import ssau.project.neural_back.net_objects.ImageRequest;

public class RequestMapper {

    public static LungDto mapToDto(ImageRequest imageRequest){
        LungDto lungDto = new LungDto();
        lungDto.setLungImage(imageRequest.getLungImage());
        return lungDto;
    }

}
