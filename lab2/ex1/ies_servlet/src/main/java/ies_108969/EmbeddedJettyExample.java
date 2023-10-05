package ies_108969;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletHandler;
import java.net.URLDecoder;

public class EmbeddedJettyExample {

    public static void main(String[] args) throws Exception {

        Server server = new Server(8680);

        ServletHandler servletHandler = new ServletHandler();
        server.setHandler(servletHandler);

        servletHandler.addServletWithMapping(HelloServlet.class, "/");

        server.start();
        server.join();

    }

    public static class HelloServlet extends HttpServlet {
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            String msg = null;
            if (request.getQueryString() != null) {
                msg = request.getQueryString().split("msg=")[1];
                msg = URLDecoder.decode(msg, "UTF-8");
            }
            String msg_to_send;
            if (msg != null) {
                msg = URLDecoder.decode(msg, "UTF-8");
                msg_to_send = "<h1>" + msg + "</h1>";
            } else {
                msg_to_send = "<h1>Default message zzzzzzzzzzzzzzzzz</h1>";
            }
            response.setContentType("text/html");
            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().println(msg_to_send);
        }
    }
}