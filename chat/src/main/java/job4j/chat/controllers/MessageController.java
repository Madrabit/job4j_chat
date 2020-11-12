package job4j.chat.controllers;

import job4j.chat.domain.Message;
import job4j.chat.repositories.MessageRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * @author madrabit on 09.11.2020
 * @version 1$
 * @since 0.1
 */

@RestController
@RequestMapping("/message")
public class MessageController {
    private final MessageRepository messages;

    public MessageController(MessageRepository messages) {
        this.messages = messages;
    }

    @GetMapping("/")
    public List<Message> findAll() {
        return StreamSupport.stream(this.messages.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Message> findById(@PathVariable int id) {
        var Message = this.messages.findById(id);
        return new ResponseEntity<Message>(
                Message.orElse(new Message()),
                Message.isPresent() ? HttpStatus.OK : HttpStatus.NOT_FOUND
        );
    }

    @PostMapping("/")
    public ResponseEntity<Message> create(@RequestBody Message Message) {
        return new ResponseEntity<Message>(
                this.messages.save(Message),
                HttpStatus.CREATED
        );
    }

    @PutMapping("/")
    public ResponseEntity<Void> update(@RequestBody Message Message) {
        this.messages.save(Message);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        Message Message = new Message();
        Message.setId(id);
        this.messages.delete(Message);
        return ResponseEntity.ok().build();
    }

}
