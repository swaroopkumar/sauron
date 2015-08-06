package controllers;

import play.*;
import play.mvc.*;

import play.twirl.api.Html;
import processor.URLProcessor;
import processor.URLProcessorImpl;
import views.html.*;

import javax.inject.Inject;

public class Application extends Controller {

    private String gulteUrl = "http://www.google.com";

    URLProcessor urlProcessor;

    public Result index() {
        System.out.println("Received index request");
        System.out.println("url: " + gulteUrl);
        urlProcessor = new URLProcessorImpl();
        StringBuffer html = urlProcessor.getHTML(gulteUrl);
        html = html == null ? new StringBuffer("No Content found") : html;
        Html htmlContent = new Html(html.toString());
        return ok(index.render(htmlContent));
    }
}
