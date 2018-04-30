package ru.bars.test.client.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ru.bars.test.client.dto.Credentials;
import ru.bars.test.client.dto.Person;

import java.util.List;

@Component
public class RestDataService {
    @Value("#{'${server.url}' + '/%s'}")
    private String RESOURCE_URL_TEMPLATE;

    @Autowired
    private RestTemplate restTemplate;

    public List<Person> getData(String user, int hash){
        HttpEntity<Credentials> credentials = new HttpEntity<>(new Credentials(user, hash));
        final ResponseEntity<List<Person>> answer = restTemplate.exchange(String.format(RESOURCE_URL_TEMPLATE, "get"),
                HttpMethod.POST, credentials, new ParameterizedTypeReference<List<Person>>() {});
        return answer.getBody();
    }

    public void save(Person person) {
        restTemplate.put(String.format(RESOURCE_URL_TEMPLATE, "save"), person);
    }

}
