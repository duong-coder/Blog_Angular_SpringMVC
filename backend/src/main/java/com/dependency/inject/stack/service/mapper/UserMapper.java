//package com.dependency.inject.stack.service.mapper;
//
//import com.dependency.inject.stack.domain.User;
//import com.dependency.inject.stack.service.dto.UserDTO;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Objects;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
///**
// * The type User mapper.
// */
//@Component
//public class UserMapper implements EntityMapper<User, UserDTO> {
//
//    @Autowired
//    private MedicalHistoryMapper medicalHistoryMapper;
//
//    @Override
//    public User toEntity(UserDTO dto) {
//        User entity = new User();
//        entity.setId(dto.getId());
//        entity.setAddress(dto.getAddress());
//        entity.setAuthorities(dto.getAuthorities());
//        entity.setBirthday(dto.getBirthday());
//        entity.setEmail(dto.getEmail());
//        entity.setFirstName(dto.getFirstName());
//        entity.setGender(dto.getGender());
//        entity.setLastName(dto.getLastName());
//        entity.setPassword(dto.getPassword());
//        entity.setPhone(dto.getPhone());
//        entity.setImageUrl(dto.getImageUrl());
//        entity.setCreatedDate(dto.getCreatedDate());
//        entity.setActivated(dto.getActivated());
////        if (Optional.ofNullable(dto.getMedicalHistories()).isPresent()) {
////            entity.setMedicalHistories(medicalHistoryMapper.toEntities(dto.getMedicalHistories()));
////        }
//        entity.setLastUpdatedDate(dto.getLastUpdatedDate());
//
//        return entity;
//    }
//
//    @Override
//    public UserDTO toDto(User entity) {
//        UserDTO dto = new UserDTO();
//        dto.setId(entity.getId());
//        dto.setAddress(entity.getAddress());
//        dto.setAuthorities(entity.getAuthorities());
//        List<String> authoritiesAsString = new ArrayList<>();
//        if(Optional.ofNullable(entity.getAuthorities()).isPresent()){
//            entity.getAuthorities().forEach(i -> {
//                authoritiesAsString.add(i.getName());
//            });
//        }
//        dto.setAuthoritiesAsString(authoritiesAsString);
//
//        List<Long> authoritiesAsLong = new ArrayList<>();
//        if(Optional.ofNullable(entity.getAuthorities()).isPresent()) {
//            entity.getAuthorities().forEach(i -> {
//                authoritiesAsLong.add(i.getId());
//            });
//        }
//        dto.setAuthoritiesAsLong(authoritiesAsLong);
//        dto.setBirthday(entity.getBirthday());
//        dto.setEmail(entity.getEmail());
//        dto.setFirstName(entity.getFirstName());
//        dto.setGender(entity.getGender());
//        dto.setLastName(entity.getLastName());
////        dto.setPassword(entity.getPassword());
//        dto.setPhone(entity.getPhone());
//        dto.setImageUrl(entity.getImageUrl());
//        dto.setActivated(entity.getActivated());
//        dto.setCreatedDate(entity.getCreatedDate());
////        if (Optional.ofNullable(entity.getMedicalHistories()).isPresent()) {
////            dto.setMedicalHistories(medicalHistoryMapper.toDTOs(entity.getMedicalHistories()));
////        }
//        dto.setLastUpdatedDate(entity.getLastUpdatedDate());
//
//        return dto;
//    }
//
//    @Override
//    public List<UserDTO> toDTOs(List<User> entities) {
//        return entities.stream()
//                .filter(Objects::nonNull)
//                .map(this::toDto)
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public List<User> toEntities(List<UserDTO> dtos) {
//        return dtos.stream()
//                .filter(Objects::nonNull)
//                .map(this::toEntity)
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public User toEntityFromId(Long id) {
//        if (id == null) {
//            return null;
//        }
//        User user = new User();
//        user.setId(id);
//
//        return user;
//    }
//}
