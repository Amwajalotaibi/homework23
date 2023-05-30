package com.example.relationteacher.Service;


import com.example.relationteacher.ApiException.ApiException;
import com.example.relationteacher.DTO.AddressDTO;
import com.example.relationteacher.Model.Address;
import com.example.relationteacher.Model.Teacher;
import com.example.relationteacher.Repository.AddressRepository;
import com.example.relationteacher.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;
    private final TeacherRepository teacherRepository;

    public void addAddress(AddressDTO dto){
        Teacher teacher=teacherRepository.findTeacherById(dto.getTeacher_id());

        if (teacher==null){
            throw new ApiException("Can't add Address , Teacher not Found");
        }
        Address address=new Address(null, dto.getArea(), dto.getStreet(), dto.getBuildingNumber(), teacher);
        addressRepository.save(address);
    }

    public void updateAddress(AddressDTO dto){
        Address oldAddress=addressRepository.findAddressById(dto.getTeacher_id());
        if(oldAddress==null){
            throw new ApiException("can't update Address , Teacher not Found");
        }
        oldAddress.setArea(dto.getArea());
        oldAddress.setStreet(dto.getStreet());
        oldAddress.setBuildingNumber(dto.getBuildingNumber());
        addressRepository.save(oldAddress);
    }
}
