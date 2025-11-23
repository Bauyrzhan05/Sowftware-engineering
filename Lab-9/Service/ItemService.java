package com.example.demo.Lab_9.Service;

import com.example.demo.Lab_9.Dto.ItemDto;

import java.util.List;

public interface ItemService {
    List<ItemDto> getAll();
    ItemDto add(ItemDto itemDto);
    ItemDto update(Long id, ItemDto itemDto);
    boolean delete(Long id);
}
