package ru.bars.test.client.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ru.bars.test.client.dto.Person;

import java.util.Base64;
import java.util.List;

/**
 * Spring-web, возможно излишне, но для альнейшего расширения
 */
@Component
public class RestDataService {
    private static final String CREDENTIALS_TEMPLATE = "%s:%s";

    private HttpHeaders headers = new HttpHeaders();

    @Value("#{'${server.url}' + '/%s'}")
    private String RESOURCE_URL_TEMPLATE;

    @Autowired
    private RestTemplate restTemplate;

    public List<Person> getData(String user, String password){
        String creds = String.format(CREDENTIALS_TEMPLATE, user, password);
        String encodedCreds = Base64.getEncoder().encodeToString(creds.getBytes());
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + encodedCreds);
        HttpEntity<Void> entity = new HttpEntity<>(headers);
        //по-хорошему, должен быть отдельный сервер авторизации и аутентикации, через Oauth2, например
        this.headers.add("Authorization", "Basic " + encodedCreds);
        ResponseEntity<List<Person>> answer = restTemplate.exchange(String.format(RESOURCE_URL_TEMPLATE, "get"),
                HttpMethod.GET, entity, new ParameterizedTypeReference<List<Person>>() {});
        return answer.getBody();
    }

    public List<Person> getData(){
        return restTemplate.exchange(String.format(RESOURCE_URL_TEMPLATE, "get"), HttpMethod.GET, new HttpEntity<>(headers),
                new ParameterizedTypeReference<List<Person>>() {}).getBody();
    }


    public void save(Person person) {
        HttpEntity<Person> entity = new HttpEntity<>(person, headers);
        System.out.println(entity.getBody());
        restTemplate.exchange(String.format(RESOURCE_URL_TEMPLATE, "save"), HttpMethod.PUT, entity, Void.class);
    }

}
