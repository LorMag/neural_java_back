package ssau.project.neural_back.clients;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ssau.project.neural_back.dto.LungDto;
import ssau.project.neural_back.net_objects.ImageResponse;

import java.util.Collections;

@Service
public class NeuralSender {

    private static final String BASE_URL = "http://localhost:3000/api";
    private static final String LINK_NET_URL = "/link_net_processing";
    private static final String U_NET_URL = "/u_net_processing";
    private static final String FPN_URL = "/FPN_processing";

    private final RestTemplate restTemplate;

    public NeuralSender(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }



    public ImageResponse getLinkNetPrediction(LungDto lung){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<LungDto> entity = new HttpEntity<>(lung, headers);
        ResponseEntity<ImageResponse> response = this.restTemplate.postForEntity(BASE_URL + LINK_NET_URL, entity, ImageResponse.class);
        return response.getBody();

    }
    public ImageResponse getUNetPrediction(LungDto lung){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<LungDto> entity = new HttpEntity<>(lung, headers);
        ResponseEntity<ImageResponse> response = this.restTemplate.postForEntity(BASE_URL + U_NET_URL, entity, ImageResponse.class);
        return response.getBody();
    }
    public ImageResponse getFPNPrediction(LungDto lung){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<LungDto> entity = new HttpEntity<>(lung, headers);
        ResponseEntity<ImageResponse> response = this.restTemplate.postForEntity(BASE_URL + FPN_URL, entity, ImageResponse.class);
        return response.getBody();
    }

}
