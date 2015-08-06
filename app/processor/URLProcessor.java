package processor;

import com.google.inject.ImplementedBy;

/**
 * Created by swaroop on 5/8/15.
 */
@ImplementedBy(URLProcessorImpl.class)
public interface URLProcessor {
  public StringBuffer getHTML(String url);
}
