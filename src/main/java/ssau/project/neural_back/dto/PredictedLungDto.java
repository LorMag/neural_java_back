package ssau.project.neural_back.dto;

import lombok.Data;

import java.util.List;

@Data
public class PredictedLungDto {

    private List<String> predictedMasks;

}
