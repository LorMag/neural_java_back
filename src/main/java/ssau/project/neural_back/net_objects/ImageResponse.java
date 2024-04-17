package ssau.project.neural_back.net_objects;

import lombok.Data;

import java.util.List;

@Data
public class ImageResponse {

    private List<String> predictedMasks;

}
