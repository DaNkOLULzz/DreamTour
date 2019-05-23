package com.softserve.academy.dreamtour.dao.implementations;

import com.softserve.academy.dreamtour.config.DBConnection;
import com.softserve.academy.dreamtour.dao.interfaces.IRoomDao;
import com.softserve.academy.dreamtour.entity.Room;
import com.softserve.academy.dreamtour.enums.RoomType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;


public class RoomDaoImpl implements IRoomDao {

    @Override
    public List<Room> getAll() throws SQLException, NamingException {
        String query = "SELECT * FROM room;";
        ArrayList<Room> roomList = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet set = statement.executeQuery();
        while (set.next()) {
            Room room = new Room();
            room.setIdRoom(set.getInt("id"));
            room.setImageUrl(set.getString("image_url"));
            room.setRoomDescription(set.getString("room_description"));
            room.setPrice(set.getInt("price"));
            room.setRoomType(RoomType.valueOf(set.getString("room_type")));
            room.setIdHotel(set.getInt("id_hotel"));
            roomList.add(room);
        }
        statement.close();

        return roomList;
    }

    @Override
    public List<Room> getFreeRoomsInHotel(String startDate, String endDate, int idHotel) throws SQLException, NamingException {
        String query = "select * from room where id not in(select id_room from booking where not\n" +
                "startDate >? or endDate<?) and id_hotel=?";
        if (endDate.equals("")) {
            endDate = "date_add(\"" + startDate + "\", INTERVAL 7 DAY)";

        }
        ArrayList<Room> roomList = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, endDate);
        statement.setString(2, startDate);
        statement.setInt(3, idHotel);
        ResultSet set = statement.executeQuery();
        while (set.next()) {
            Room room = new Room();
            room.setIdRoom(set.getInt("id"));
            room.setImageUrl(set.getString("image_url"));
            room.setRoomDescription(set.getString("room_description"));
            room.setPrice(set.getInt("price"));
            room.setRoomType(RoomType.valueOf(set.getString("room_type")));
            room.setIdHotel(set.getInt("id_hotel"));
            roomList.add(room);
        }
        statement.close();

        return roomList;
    }

    @Override
    public boolean add(Room room) throws SQLException, NamingException {
        String query = "INSERT INTO room (image_url, room_description, price, id_room_type, "
                + "id_hotel) VALUES(?, ?, ?, ?, ?)";
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(query);
        String imageUrl = room.getImageUrl();
        String roomDescription = room.getRoomDescription();
        int price = room.getPrice();
        RoomType roomType = room.getRoomType();
        int idHotel = room.getIdHotel();
        statement.setString(1, imageUrl);
        statement.setString(2, roomDescription);
        statement.setInt(3, price);
        statement.setString(4, roomType.toString());
        statement.setInt(5, idHotel);
        boolean isAdded = statement.execute();
        statement.close();

        return isAdded;
    }

    @Override
    public Room get(int id) throws SQLException, NamingException {
        String query = "SELECT * FROM room WHERE id = ?;";
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, id);
        ResultSet set = statement.executeQuery();
        Room room = new Room();
        while (set.next()) {
            room.setIdRoom(set.getInt("id"));
            room.setImageUrl(set.getString("image_url"));
            room.setRoomDescription(set.getString("room_description"));
            room.setPrice(set.getInt("price"));
            room.setRoomType(RoomType.valueOf(set.getString("room_type")));
            room.setIdHotel(set.getInt("id_hotel"));
        }
        statement.close();

        return room;
    }

    @Override
    public boolean update(Room room) throws SQLException, NamingException {
        String query = "UPDATE room SET image_url=?, room_description=?, price=?, "
                + "id_room_type=?, id_hotel=? WHERE id=?";
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(query);
        int idRoom = room.getIdRoom();
        String imageUrl = room.getImageUrl();
        String roomDescription = room.getRoomDescription();
        int price = room.getPrice();
        RoomType roomType = room.getRoomType();
        int idHotel = room.getIdHotel();
        statement.setString(1, imageUrl);
        statement.setString(2, roomDescription);
        statement.setInt(3, price);
        statement.setString(4, roomType.toString());
        statement.setInt(5, idHotel);
        statement.setInt(6, idRoom);
        boolean isUpdated = statement.execute();
        statement.close();

        return isUpdated;
    }

    @Override
    public boolean delete(int id) throws SQLException, NamingException {
        String query = "DELETE FROM room WHERE id=?";
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, id);
        boolean isDeleted = statement.execute();
        statement.close();

        return isDeleted;
    }

}
