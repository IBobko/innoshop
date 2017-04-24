package ru.innopolis.innoshop.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Vyacheslav on 23.04.2017.
 */

@Controller
@RequestMapping("/order")
public class OrderPageController {
    private ApplicationEventPublisher publisher;

    @RequestMapping("")
    public String index() {
        return "order";
    }

    public ApplicationEventPublisher getPublisher() {
        return publisher;
    }

    @Autowired
    public void setPublisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    @RequestMapping("/confirmation")
    public String confirmation(final HttpSession session, final HttpServletRequest servletRequest, final Model model) {

        final String name = (String) servletRequest.getAttribute("Name");
        final String address = (String) servletRequest.getAttribute("Address");
        final String delivery = (String) servletRequest.getAttribute("optionsRadios");

        ConfirmOrderEvent event = new ConfirmOrderEvent(this);
        event.setSession(session);
        event.setName(name);
        event.setDelivery(delivery);
        event.setDelivery(delivery);

        getPublisher().publishEvent(event);

        model.addAttribute("name", name);
        model.addAttribute("address", address);
        model.addAttribute("delivery", delivery);

        return "confirmation";
    }

    @EventListener
    public void listener(final ConfirmOrderEvent event) {
        event.getSession().setAttribute("name", event.getName());
        event.getSession().setAttribute("address", event.getAddress());
        event.getSession().setAttribute("delivery", event.getDelivery());

    }
}
