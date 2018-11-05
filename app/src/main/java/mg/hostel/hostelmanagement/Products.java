package mg.hostel.hostelmanagement;

public class Products {
    private String username,gender,room,mess,mobile;
    public Products(){

    }

    public Products(String username, String gender, String room, String mess, String mobile) {
        this.username = username;
        this.gender = gender;
        this.room = room;
        this.mess = mess;
        this.mobile = mobile;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public void setMess(String mess) {
        this.mess = mess;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getUsername() {
        return username;
    }

    public String getGender() {
        return gender;
    }

    public String getRoom() {
        return room;
    }

    public String getMess() {
        return mess;
    }

    public String getMobile() {
        return mobile;
    }
}
