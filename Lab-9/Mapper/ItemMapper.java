package com.example.demo.Lab_9.Mapper;

import com.example.demo.Lab_9.Dto.ItemDto;
import com.example.demo.Lab_9.Model.Item;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {
    ItemDto toDto(Item item);
    Item toEntity(ItemDto itemDto);

    List<ItemDto> toDtoList(List<Item> items);
}
