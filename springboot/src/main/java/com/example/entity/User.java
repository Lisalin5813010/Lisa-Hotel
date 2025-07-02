package com.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")// Specify the table name
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, length = 100)
  private String name;

  @Column(nullable = false, length = 255)
  private String password;

  private Integer age;

  @Column(length = 10)
  private String sex;

  @Column(length = 20)
  private String phone;

  // Constructors
  public User() {}

  public User(String name, String password, Integer age, String sex, String phone) {
    this.name = name;
    this.password = password;
    this.age = age;
    this.sex = sex;
    this.phone = phone;
  }

  // Getters and Setters
  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }

  public String getName() { return name; }
  public void setName(String name) { this.name = name; }

  public String getPassword() { return password; }
  public void setPassword(String password) { this.password = password; }

  public Integer getAge() { return age; }
  public void setAge(Integer age) { this.age = age; }

  public String getSex() { return sex; }
  public void setSex(String sex) { this.sex = sex; }

  public String getPhone() { return phone; }
  public void setPhone(String phone) { this.phone = phone; }
}
