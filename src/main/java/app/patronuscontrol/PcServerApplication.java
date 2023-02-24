package app.patronuscontrol;

import org.apache.catalina.connector.Connector;
import org.apache.coyote.ajp.AbstractAjpProtocol;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;

import javax.swing.*;

@SpringBootApplication
public class PcServerApplication extends JFrame {



    public static RayCastingCanvas display;
    public PcServerApplication() {

        initUI();
    }


    public static void main(String[] args) {

        new SpringApplicationBuilder(PcServerApplication.class)
                .headless(false).run(args);



    }

    public static void initUI() {
        display = new RayCastingCanvas();
        JFrame f = new JFrame();
        f.add(display);
        f.setSize(800, 800);
        f.setVisible(true);
    }

    @Bean
    public TomcatServletWebServerFactory servletContainer() {
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
        Connector ajpConnector = new Connector("AJP/1.3");
        ajpConnector.setPort(9090);
        ajpConnector.setSecure(false);
        ajpConnector.setAllowTrace(false);
        ajpConnector.setScheme("http");
        ((AbstractAjpProtocol<?>) ajpConnector.getProtocolHandler()).setSecretRequired(false);
        tomcat.addAdditionalTomcatConnectors(ajpConnector);
        return tomcat;
    }


}

