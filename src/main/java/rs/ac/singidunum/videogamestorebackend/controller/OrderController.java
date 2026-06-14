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
    public void createOrder(@RequestBody Order order) {
        orderRepository.save(order);
    }

    @CrossOrigin(origins = "http://localhost:5180")
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateOrder(@RequestBody Order order, @PathVariable Integer id) {
        Order existing = orderRepository.findById(id).orElseThrow();
        existing.setGame(order.getGame());
        existing.setAmount(order.getAmount());
        existing.setPurchasedAt(order.getPurchasedAt());
        orderRepository.save(existing);
    }

    @CrossOrigin(origins = "http://localhost:5180")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrder(@PathVariable Integer id) {
        Order existing = orderRepository.findById(id).orElseThrow();
        orderRepository.delete(existing);
    }

}
