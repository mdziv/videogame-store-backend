package rs.ac.singidunum.videogamestorebackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import rs.ac.singidunum.videogamestorebackend.entity.Order;
import rs.ac.singidunum.videogamestorebackend.repository.OrderRepository;

@RestController
@RequestMapping("/api/order")
class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @CrossOrigin(origins = "http://localhost:5180")
    @GetMapping
    public @ResponseBody Iterable<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @CrossOrigin(origins = "http://localhost:5180")
    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void saveOrder(@RequestBody Order order) {
        orderRepository.save(order);
    }

}
