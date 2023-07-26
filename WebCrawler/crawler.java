import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class crawler {
  private static final int MAX_PAGES = 1000;
  private HashSet<String> titles = new HashSet<>();
  private HashSet<String> sitesVisited = new HashSet<>();
  private HashMap<String, Integer> map = new HashMap<>();

  public void getLinks(String startURL) {
    if ((titles.size() < MAX_PAGES) && !sitesVisited.contains(startURL)) {
      sitesVisited.add(startURL);

      try {
        Document doc = Jsoup.connect(startURL).get();
        Elements linksFromPage = doc.select("a[href]");
        String title = doc.select("title").first().text();
        titles.add(title);
        String text = doc.body().text();
        CountWords(text);

        for (Element link : linksFromPage) {
          if (titles.size() <= MAX_PAGES) {
            Thread.sleep(50);
            getLinks(link.attr("abs:href"));
          } else {
            System.out.println("URL could not be visited");
            System.out.println(startURL + ", " + sitesVisited.size());
          }
        }
      } catch (IOException e) {
        e.printStackTrace();
      } catch (InterruptedException e) {
        e.printStackTrace();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  public void PrintAllTitles() {
    for (String t : titles) {
      System.out.println(t);
    }
  }

  public void PrintAllWordsAndCount() {
    for (String key : map.keySet()) {
      System.out.println(key + " : " + map.get(key));
    }
  }

  private void CountWords(String text) {
    String[] lines = text.split(" ");
    for (String word : lines) {
      if (map.containsKey(word)) {
        int val = map.get(word);
        val += 1;
        map.remove(word);
        map.put(word, val);
      } else {
        map.put(word, 1);
      }
    }
  }
}