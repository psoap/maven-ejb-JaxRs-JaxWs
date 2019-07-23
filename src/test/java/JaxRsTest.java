import com.epam.newsportal.domain.Author;
import com.epam.newsportal.domain.News;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class JaxRsTest {
    private JaxRsClient client = new JaxRsClient();

    @Test
    public void test(){
        News existedNews = client.getNewsById(23L);

        System.out.println(existedNews);
        System.out.println("----------------------------");

        System.out.println(client.getNewsByPage(0));
        System.out.println("----------------------------");

        Author author = new Author();
        author.setId(24L);

        News newNews = new News();
        newNews.setTitle("rsTitle");
        newNews.setBrief(String.valueOf(System.currentTimeMillis()));
        newNews.setContent("rsContent");
        newNews.setAuthor(author);
        newNews.setChangeDate(new Date("22/04/2009"));
        newNews.setUri("rsUri");

//        client.addNews(newNews);

        existedNews.setTitle(String.valueOf(System.currentTimeMillis()));
//        client.editNews(existedNews);

//        client.removeNews(62L);
    }
}
