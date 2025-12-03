package com.example.teachersystem.Service;

import com.example.teachersystem.Api.ApiException;
import com.example.teachersystem.DTO.AddressDTO;
import com.example.teachersystem.Model.Address;
import com.example.teachersystem.Model.Teacher;
import com.example.teachersystem.Repository.AddressRepository;
import com.example.teachersystem.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;
    private final TeacherRepository teacherRepository;

    public List<Address> getAll() {
        return addressRepository.findAll();
    }

    public void add(AddressDTO dto) {
        Teacher teacher = teacherRepository.findTeacherById(dto.getTeacherId());
                if(teacher == null)
                    throw new ApiException("teacher not found");
        
        Address address = new Address();
        address.setId(teacher.getId());
        address.setArea(dto.getArea());
        address.setStreet(dto.getStreet());
        address.setBuildingNumber(dto.getBuildingNumber());
        address.setTeacher(teacher);
        addressRepository.save(address);
    }

    public void update(AddressDTO dto) {
        Address address = addressRepository.findAddressById(dto.getTeacherId());
        if(address == null)
            throw new ApiException("address not found");
        
        address.setArea(dto.getArea());
        address.setStreet(dto.getStreet());
        address.setBuildingNumber(dto.getBuildingNumber());
        addressRepository.save(address);
    }

    public void delete(Integer teacherId) {
        Address address = addressRepository.findAddressById(teacherId);
        if(address == null)
            throw new ApiException("address not found");
        addressRepository.delete(address);
    }
}
