package com.example.roomwebapp.data.repository;

import com.example.roomwebapp.data.entity.StaffMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StaffRepository extends JpaRepository<StaffMember, UUID> {
}
