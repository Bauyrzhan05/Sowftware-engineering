package com.example.demo.Lab_9.Controller;

import com.example.demo.Lab_9.Dto.ItemDto;
import com.example.demo.Lab_9.Service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/items")
public class ItemController {
    private final ItemService itemService;

    @GetMapping
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(itemService.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody ItemDto itemDto){
        return new ResponseEntity<>(itemService.add(itemDto), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody ItemDto itemDto){
        return new ResponseEntity<>(itemService.update(id, itemDto), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return new ResponseEntity<>(itemService.delete(id), HttpStatus.OK);
    }


}
