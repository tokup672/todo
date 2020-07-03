package jp.kobespiral.todo.dto;

import java.util.Date;

import jp.kobespiral.todo.entity.User;
import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String uid;
    private String name;
    private Date createdAt;

    public static UserDto build(User user){
        UserDto dto = new UserDto();
        dto.uid = user.getUid();
        dto.name= user.getName();
        dto.createdAt = user.getCreatedAt();
        
        return dto;
    }
}