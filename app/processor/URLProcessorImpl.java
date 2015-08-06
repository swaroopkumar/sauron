package processor;

import org.springframework.stereotype.Component;

import javax.inject.Singleton;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by swaroop on 5/8/15.
 */
@Singleton
public class URLProcessorImpl implements URLProcessor {

  @Override
  public StringBuffer getHTML(String url) {
    URL oracle = null;
    try {
      oracle = new URL(url);
      BufferedReader in = null;
      in = new BufferedReader(
              new InputStreamReader(oracle.openStream()));
      String inputLine;
      StringBuffer htmlContent = new StringBuffer();
      while ((inputLine = in.readLine()) != null)
        htmlContent.append(inputLine);
      in.close();
      return htmlContent;
    } catch (MalformedURLException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }
}
