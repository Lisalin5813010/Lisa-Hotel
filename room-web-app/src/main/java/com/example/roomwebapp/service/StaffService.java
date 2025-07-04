package com.example.roomwebapp.service;

import com.example.roomwebapp.data.entity.Position;
import com.example.roomwebapp.data.entity.RoomEntity;
import com.example.roomwebapp.data.entity.StaffMember;
import com.example.roomwebapp.data.repository.StaffRepository;
import com.example.roomwebapp.web.model.Room;
import com.example.roomwebapp.web.model.Staff;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class StaffService {

    private final StaffRepository staffRepository;

    public StaffService(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    public List<Staff> getAllStaff(){
        List<StaffMember> entities = this.staffRepository.findAll();
        List<Staff> staff = new ArrayList<>(entities.size());
        entities.forEach(s -> staff.add(this.getStaffFromEntity(s)));
        return staff;
    }

    public Staff getStaffById(UUID id){
        Optional<StaffMember> entity = this.staffRepository.findById(id);
        if(entity.isEmpty()){
            return null;
        }
        return this.getStaffFromEntity(entity.get());
    }

    public Staff addStaff(Staff staff){
        StaffMember entity = this.getEntityFromStaff(staff);
        entity = this.staffRepository.save(entity);
        return this.getStaffFromEntity(entity);
    }

    public Staff updateStaff(Staff staff){
        StaffMember entity = this.getEntityFromStaff(staff);
        entity = this.staffRepository.save(entity);
        return this.getStaffFromEntity(entity);
    }

    public void deleteStaff(UUID id){
        this.staffRepository.deleteById(id);
    }


    private Staff getStaffFromEntity(StaffMember entity){
        return new Staff(entity.getEmployeeId(), entity.getFirstName(), entity.getLastName(), entity.getPosition().toString());
    }

    private StaffMember getEntityFromStaff(Staff staff){
        return new StaffMember(staff.getId(), staff.getFirstname(), staff.getLastname(), Position.valueOf(staff.getPosition()));
    }


}



