package com.softserve.academy.dreamtour.entity;

import com.softserve.academy.dreamtour.enums.RoomType;

import java.util.Objects;

public class Room {

    private int idRoom;
    private String imageUrl;
    private String roomDescription;
    private int price;
    private RoomType roomType;
    private int idHotel;

    public Room() {
    }

    public Room(int idRoom, String imageUrl, String roomDescription, int price,
                RoomType roomType, int idHotel) {
        this.idRoom = idRoom;
        this.imageUrl = imageUrl;
        this.roomDescription = roomDescription;
        this.price = price;
        this.roomType = roomType;
        this.idHotel = idHotel;
    }

    public int getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(int idRoom) {
        this.idRoom = idRoom;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getRoomDescription() {
        return roomDescription;
    }

    public void setRoomDescription(String roomDescription) {
        this.roomDescription = roomDescription;
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

    public int getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(int idHotel) {
        this.idHotel = idHotel;
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
        return idRoom == room.idRoom
            && price == room.price
            && idHotel == room.idHotel
            && Objects.equals(imageUrl, room.imageUrl)
            && Objects.equals(roomDescription, room.roomDescription)
            && roomType == room.roomType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRoom, imageUrl, roomDescription, price, roomType, idHotel);
    }

    @Override
    public String toString() {
        return "Room{"
            + "idRoom=" + idRoom
            + ", imageUrl='" + imageUrl + '\''
            + ", roomDescription='" + roomDescription + '\''
            + ", price=" + price
            + ", roomType=" + roomType
            + ", idHotel=" + idHotel
            + '}';
    }
}
