package com.carrent.controller;

import com.carrent.repository.BookingRepository;
import com.carrent.repository.CarRepository;
import com.carrent.service.BookingService;
import com.carrent.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Date;
import java.util.Map;

@Controller
public class MainController {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CarRepository carRepository;

    @Autowired
    CarService carService;

    @Autowired
    BookingService bookingService;

    @RequestMapping(value ={"/index","/"})
    public String index(){
        return "index";
    }

    @RequestMapping(value ={"/index/{pathVariable}"}, method = RequestMethod.GET)
    public String indexList(@RequestParam Map<String,Date> dates, Model model){
        //model.addAttribute("carList", carRepository.search(startDate.get("startDate"), endDate.get("endDate")));
        model.addAttribute("startDate", dates.get("startDate"));
        model.addAttribute("endDate", dates.get("endDate"));
        model.addAttribute("carList",carRepository.isAvailable());
        return "index";
    }

    @RequestMapping(value = {"/booking.html", "/booking"})
    public String booking(){
        return "booking";
    }

    @RequestMapping("booking/{pathVariable}")
    public String idContinue(@PathVariable("pathVariable") int pathVariable, @RequestParam Map<String,String> dates ,Model model){
        model.addAttribute("carId", pathVariable);
        model.addAttribute("carPrice", carRepository.findById(pathVariable).get().getPrice());
        model.addAttribute("startDate", dates.get("startDate"));
        model.addAttribute("endDate", dates.get("endDate"));
        return "booking";
    }

    @RequestMapping(value={"/booking.html", "/booking"}, method = RequestMethod.POST)
    public String createBooking(@RequestParam Map<String, String> createBooking) {
        try{
            bookingService.newBooking(createBooking);
        }catch (ParseException e){
            e.getMessage();
        }
        return "redirect:/index";
    }

    @RequestMapping("/admin")
    public String adminPage(Model model){
        model.addAttribute("carList", carRepository.isAvailable());
        model.addAttribute("bookingList", bookingRepository.findAll());
        return "admin";
    }

    @RequestMapping(value={"/newCar", "/newCar.html"})
    public String newCar(){
        return "newCar";
    }

    @RequestMapping(value = {"/newCar", "/newCar.html"}, method = RequestMethod.POST)
    public String createCar(@RequestParam Map<String, String> createCar){
        carService.newCar(createCar);
        return "redirect:/admin";
    }

    @RequestMapping(value="/updateCar", method = RequestMethod.POST)
    public String updateCar(@RequestParam Map<String, String> updateCar){
        carService.editCar(updateCar);
        return "redirect:/admin";
    }

    @RequestMapping("updateCar/{pathVariable}")
    public String selectedCar(@PathVariable("pathVariable") int pathVariable, Model model) {
        model.addAttribute("id", carRepository.findById(pathVariable).get().getId());
        model.addAttribute("name", carRepository.findById(pathVariable).get().getName());
        model.addAttribute("gearShift", carRepository.findById(pathVariable).get().getGearShift());
        model.addAttribute("seats", carRepository.findById(pathVariable).get().getSeats());
        model.addAttribute("price", carRepository.findById(pathVariable).get().getPrice());
        return "updateCar";
    }
}
