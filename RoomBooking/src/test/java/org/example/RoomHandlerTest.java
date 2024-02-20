package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RoomHandlerTest
{
    RoomHandler roomHandler = new RoomHandler();
    Room room = new Room();

    @Test
    public  void checkFreeRooms()
    {
        List<Room> hrooms= roomHandler.showFreeRoom();
        List<Room> aRooms = Room.rooms;
        assertEquals(hrooms,aRooms);
    }

    @Test
    public  void testFreeRoomsCount()
    {
        int size = roomHandler.freeRoomList.size();
        List<Room> aRooms = Room.rooms;
        int aSize = 0;
        for(Room room : aRooms)
        {
            if (room.isStatus())
            {
                aSize++;
            }
        }

        assertEquals(aSize,size);
    }
}