package ssau.project.neural_back.services;

import org.springframework.stereotype.Service;
import ssau.project.neural_back.clients.NeuralSender;
import ssau.project.neural_back.dto.LungDto;
import ssau.project.neural_back.net_objects.ImageResponse;

@Service
public class ImageService {

    private final NeuralSender neuralSender;

    public ImageService(NeuralSender neuralSender) {
        this.neuralSender = neuralSender;
    }

    public ImageResponse getPrediction(LungDto lung, String type){
        return switch (type) {
            case "link-net" -> neuralSender.getLinkNetPrediction(lung);
            case "u-net" -> neuralSender.getUNetPrediction(lung);
            case "FPN" -> neuralSender.getFPNPrediction(lung);
            default -> null;
        };
    }
}
