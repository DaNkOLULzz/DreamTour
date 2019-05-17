package com.softserve.academy.dreamtour.entity;

import com.softserve.academy.dreamtour.enums.RoomType;

import java.util.Objects;

public class Room {

    private int idRoom;
    private Integer price;
    private RoomType roomType;
    private Hotel hotel;

    public Room() {
    }

    public Room(int idRoom, int price, RoomType roomType, Hotel hotel) {
        this.idRoom = idRoom;
        this.price = price;
        this.roomType = roomType;
        this.hotel = hotel;
    }

    public int getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(int idRoom) {
        this.idRoom = idRoom;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Room)) {
            return false;
        }
        Room room = (Room) o;
        return price == room.price
            && idRoom == room.idRoom
            && roomType == room.roomType
            && Objects.equals(hotel, room.hotel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRoom, price, roomType, hotel);
    }

    @Override
    public String toString() {
        return "Room{"
            + "idRoom=" + idRoom
            + ", price=" + price
            + ", roomType=" + roomType
            + ", hotel=" + hotel
            + '}';
    }
}
