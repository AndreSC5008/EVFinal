package net.codejava.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.codejava.services.RegistroImcService;

import net.codejava.entity.Usuario;
import net.codejava.entity.RegistroImc;
import net.codejava.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {

    @Autowired
    private RegistroImcService service;
    @Autowired
    private UserService Uservice;

    @RequestMapping("/")
    public String viewHomePage(HttpSession session, Model model) {

        if (session.getAttribute("mySessionAttribute") != null) {
            List<RegistroImc> listRegistroImc = service.listAll();
            model.addAttribute("listIMC", listRegistroImc);
            return "index";
        } else {
            model.addAttribute("usuario", new Usuario());
            
            return "login";
        }
        //model.addAttribute("listProducts", listProducts);
    }

    @RequestMapping("/login")
    public String login(HttpSession session,@ModelAttribute("usuario") Usuario usuario ) {
        session.setAttribute("mySessionAttribute", "sasas");
        Uservice.save(usuario);
        // model.addAttribute("listProducts", listProducts);
        return "redirect:/";
    }

    @RequestMapping("/new")
    public String showNewImcPage(Model model) {
        RegistroImc imc = new RegistroImc();
        model.addAttribute("imc", imc);
        
        return "new_RegistroImc";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveRegistroImc(@ModelAttribute("imc") RegistroImc imc) {
        imc.ImcYFecha();
        service.save(imc);
       
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditlistRegistroImcPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("edit_RegistroImc");
        RegistroImc imc = service.get(id);
        mav.addObject("imc", imc);

        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deletelistRegistroImc(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/";
    }
}
