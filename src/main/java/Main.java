import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServletRequestHttpWrapper;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.util.thread.ExecutionStrategy;

import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws Exception {
        Frontend frontend = new Frontend();

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(frontend), "/*");

        Server server = new Server(8080);
        server.setHandler(context);

        server.start();
        server.join();
    }
}
