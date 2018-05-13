package com.oradouane.host.gui.ui.util;

import com.vaadin.server.*;
import org.jsoup.nodes.Element;

import java.util.Random;
import java.util.UUID;

public class ResponsivenessListener implements SessionInitListener {

    private static final StringBuilder JS = new StringBuilder();
    private final String FUNCTION_NAME = getSaltString();
    private String NEWLINE = System.lineSeparator();

    {
        // @formatter:off
        JS.append("function ").append(FUNCTION_NAME).append("(u) {").append(NEWLINE)
                .append("document.getElementById('contentFrame').firstChild.src = u;").append(NEWLINE)
                .append("};").append(NEWLINE)
                .append("function ").append("enableCO() {").append(NEWLINE)
                .append("var eventMethod = window.addEventListener ? 'addEventListener' : 'attachEvent'; ").append(NEWLINE)
                .append("var eventer = window[eventMethod];").append(NEWLINE)
                .append("var messageEvent = eventMethod == 'attachEvent' ? 'onmessage' : 'message'; ").append(NEWLINE)
                .append("eventer(messageEvent,function(e) { ").append(NEWLINE)
                .append("console.log('parent received message!:  ',e.data); ").append(NEWLINE)
                .append("if(~e.origin.indexOf('http://localhost:8001')) { ").append(NEWLINE)
                .append("console.log('parent received message from origin !:  ',e.origin); ").append(NEWLINE)
                .append(FUNCTION_NAME).append("(e.data); ").append(NEWLINE)
                .append("}").append(NEWLINE)
                .append("}, false);")
                .append("};");
        // @formatter:on
    }

    private String getSaltString() {
        final String SALTCHARS = "abcdefghijklmnopqrstuvwxyz_";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 18) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        return salt.toString();

    }
    @Override
    public void sessionInit(SessionInitEvent event) throws ServiceException {

        event.getService().setSystemMessagesProvider(systemMessagesInfo -> {
            CustomizedSystemMessages csm = new CustomizedSystemMessages();
            csm.setSessionExpiredNotificationEnabled(false);
            return csm;
        });

        event.getSession().addBootstrapListener(new CustomBootstrapListener());
    }

    private class CustomBootstrapListener implements BootstrapListener {


        @Override
        public void modifyBootstrapPage(final BootstrapPageResponse response) {
            final Element head = response.getDocument().head();
            head.appendElement("meta")
                    .attr("name", "viewport")
                    .attr("content", "width=device-width, initial-scale=1");
            head.appendElement("meta")
                    .attr("name", "apple-mobile-web-app-capable")
                    .attr("content", "yes");
            head.appendElement("meta")
                    .attr("name", "apple-mobile-web-app-status-bar-style")
                    .attr("content", "black");
            head.appendElement("script")
                    .attr("type", "text/javascript")
                    .appendText(JS.toString());
        }

        @Override
        public void modifyBootstrapFragment(
                final BootstrapFragmentResponse response) {
            // Nothing for now
        }
    }


}
