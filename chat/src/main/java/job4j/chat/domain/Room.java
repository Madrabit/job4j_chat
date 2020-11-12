package job4j.chat.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author madrabit on 14.10.2020
 * @version 1$
 * @since 0.1
 */
@Entity
@Table(name = "room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String roomName;

    public Room() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

}
