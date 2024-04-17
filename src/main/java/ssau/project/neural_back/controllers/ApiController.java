package ssau.project.neural_back.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ssau.project.neural_back.dto.LungDto;
import ssau.project.neural_back.dto.PredictedLungDto;
import ssau.project.neural_back.mappers.RequestMapper;
import ssau.project.neural_back.mappers.ResponseMapper;
import ssau.project.neural_back.net_objects.ImageRequest;
import ssau.project.neural_back.net_objects.ImageResponse;
import ssau.project.neural_back.services.ImageService;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class ApiController {

    private final ImageService imageService;

    public ApiController(ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping("/predict_lung")
    public ResponseEntity<PredictedLungDto> getPrediction(@RequestBody ImageRequest imageRequest){
        LungDto lungDto = RequestMapper.mapToDto(imageRequest);
        ImageResponse imageResponse = imageService.getPrediction(lungDto, imageRequest.getNeuralType());
        PredictedLungDto predictedLungDto = ResponseMapper.mapToDto(imageResponse);
        return new ResponseEntity<>(predictedLungDto, HttpStatus.OK);
    }
}
