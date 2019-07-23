import com.epam.newsportal.domain.News;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.util.List;

public class JaxRsClient {
    private static final String REST_URL = "http://localhost:8888/news/api/";
    private static final String REST_MANAGE_URI = "news/";

    private Client client = ClientBuilder.newClient();

    public News getNewsById(final long id){
        return client.target(REST_URL).path(REST_MANAGE_URI+id)
                .request(MediaType.APPLICATION_JSON_TYPE).get(News.class);
    }

    public List<News> getNewsByPage(final int pageNumber){
        return client.target(REST_URL).path(String.valueOf(pageNumber))
                .request(MediaType.APPLICATION_JSON_TYPE).get(new GenericType<List<News>>(){});
    }

    public void addNews(final News news){
        client.target(REST_URL).path(REST_MANAGE_URI)
                .request(MediaType.APPLICATION_JSON_TYPE)
                .post(Entity.entity(news, MediaType.APPLICATION_JSON_TYPE));
    }

    public void editNews(final News news){
        client.target(REST_URL).path(REST_MANAGE_URI+news.getId())
                .request(MediaType.APPLICATION_JSON_TYPE)
                .put(Entity.entity(news, MediaType.APPLICATION_JSON));
    }

    public void removeNews(final long id){
        client.target(REST_URL).path(REST_MANAGE_URI+id)
                .request(MediaType.APPLICATION_JSON_TYPE)
                .delete();
    }
}
