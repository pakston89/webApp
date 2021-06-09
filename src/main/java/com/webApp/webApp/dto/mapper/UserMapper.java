package com.webApp.webApp.dto.mapper;

import com.webApp.webApp.dto.UserDto;
import com.webApp.webApp.model.User;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto userToUserDto(User user);

    List<UserDto> usersToUsersDto(List<User> users);

    User userDtoToUser(UserDto userDto);
}
