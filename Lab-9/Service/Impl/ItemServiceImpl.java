package com.example.demo.Lab_9.Service.Impl;

import com.example.demo.Lab_9.Dto.ItemDto;
import com.example.demo.Lab_9.Mapper.ItemMapper;
import com.example.demo.Lab_9.Model.Country;
import com.example.demo.Lab_9.Model.Item;
import com.example.demo.Lab_9.Repository.CountryRepository;
import com.example.demo.Lab_9.Repository.ItemRepository;
import com.example.demo.Lab_9.Service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {
    private final ItemMapper itemMapper;
    private final ItemRepository itemRepository;
    private final CountryRepository countryRepository;

    @Override
    public List<ItemDto> getAll() {
        return itemMapper.toDtoList(itemRepository.findAll());
    }

    @Override
    public ItemDto add(ItemDto itemDto) {
        Item item = itemMapper.toEntity(itemDto);

        Country country = countryRepository.findById(item.getManufacturer().getId()).orElseThrow();
        item.setManufacturer(country);

        return itemMapper.toDto(itemRepository.save(item));
    }

    @Override
    public ItemDto update(Long id, ItemDto itemDto) {
        Item item = itemRepository.findById(id).orElseThrow();
        Country country = countryRepository.findById(itemDto.getManufacturer().getId()).orElseThrow();
        item.setName(itemDto.getName());
        item.setPrice(itemDto.getPrice());
        item.setQuantity(itemDto.getQuantity());
        item.setManufacturer(country);

        return itemMapper.toDto(itemRepository.save(item));
    }

    @Override
    public boolean delete(Long id) {
        if (itemRepository.existsById(id)){
            itemRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }
}
