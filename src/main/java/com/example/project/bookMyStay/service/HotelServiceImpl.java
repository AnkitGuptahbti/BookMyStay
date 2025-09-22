package com.example.project.bookMyStay.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.project.bookMyStay.dto.HotelDto;
import com.example.project.bookMyStay.dto.HotelInfoDto;
import com.example.project.bookMyStay.dto.RoomDto;
import com.example.project.bookMyStay.entity.Hotel;
import com.example.project.bookMyStay.entity.Room;
import com.example.project.bookMyStay.exceptions.ResourceNotFoundException;
import com.example.project.bookMyStay.repository.HotelRepository;
import com.example.project.bookMyStay.repository.RoomRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {

    private final HotelRepository hotelRepository;
    private final ModelMapper modelMapper;
    private final InventoryService inventoryService;
    private final RoomRepository roomRepository;

    @Override 
    public HotelDto createNewHotel(HotelDto hotelDto) {

        log.info("Creating a new hotel with name :{}", hotelDto.getName());
        Hotel hotel =modelMapper.map(hotelDto, Hotel.class);
        hotel.setActive(false);
        hotel=hotelRepository.save(hotel);
        log.info("Created a new hotel with name :{}", hotel.getId());
        return modelMapper.map(hotel, HotelDto.class);
    }

    @Override
    public HotelDto getHotelById(Long id) {
        log.info("Getting the hotel with ID :{}", id);
        Hotel hotel = hotelRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("hotel not found with :"+id));
        return modelMapper.map(hotel, HotelDto.class);
    }

    @Override
    public HotelDto updateHotelById(Long id,HotelDto hotelDto) {
        log.info("update the hotel with ID :{}", id);
        Hotel hotel = hotelRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("hotel not found with :"+id));
        modelMapper.map(hotelDto, hotel);
        hotel.setId(id);
        hotel=hotelRepository.save(hotel);
        return modelMapper.map(hotel, HotelDto.class);
    }

    @Override
    @Transactional
    public void deleteHotelById(Long id){
        Hotel hotel = hotelRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("hotel not found with :"+id));

        
        for( Room room : hotel.getRooms()){
            inventoryService.deleteAllInventories(room);
            roomRepository.deleteById(room.getId());

        }
        hotelRepository.deleteById(id);
    }
    @Override
    @Transactional
    public void activateHotel(Long hotelid){
        log.info("Activatiing  the hotel with ID :{}", hotelid);
        Hotel hotel = hotelRepository.findById(hotelid).orElseThrow(()-> new ResourceNotFoundException("hotel not found with :"+hotelid));
        hotel.setActive(true);
        
        for( Room room : hotel.getRooms()){
            inventoryService.initializeRoomForAYear(room);
        }
        
    }    

    @Override
    public HotelInfoDto getHotelInfoById(Long hotelId) {
        Hotel hotel = hotelRepository
                .findById(hotelId)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel not found with ID: "+hotelId));

        List<RoomDto> rooms = hotel.getRooms()
                .stream()
                .map((element) -> modelMapper.map(element, RoomDto.class))
                .toList();

        return new HotelInfoDto(modelMapper.map(hotel, HotelDto.class), rooms);
    }
}
